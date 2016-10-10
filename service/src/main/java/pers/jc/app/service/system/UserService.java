package pers.jc.app.service.system;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

import javax.security.auth.login.LoginException;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.DaoFactory.DaoFactoryEnum;
import priv.jc.app.core.dao.system.ModuleDao;
import priv.jc.app.core.dao.system.impl.UserDaoImpl;
import priv.jc.app.core.domain.system.Function;
import priv.jc.app.core.domain.system.Module;
import priv.jc.app.core.domain.system.User;
import priv.jc.app.core.model.Login;
import priv.jc.app.core.model.SessionInfo;
import priv.jc.app.core.model.system.V_Function;
import priv.jc.app.core.model.system.V_Module;
import priv.jc.app.core.model.system.V_User;
import priv.jc.app.core.service.impl.ServiceImpl;
import priv.jc.util.data.encrypt.DataEncrypt;
import priv.jc.util.date.DateTime;

/**
 * @author Jacky
 *
 */
public class UserService extends ServiceImpl<User> {
	private DataEncrypt md5;

	public void setMd5(DataEncrypt md5) {
		this.md5 = md5;
	}

	public UserDaoImpl getDao() {
		return (UserDaoImpl) super.getDao();
	}

	// 用户登录
	public SessionInfo login(Login login) throws LoginException, TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		SessionInfo result = null;
		// 根据用户名或手机号或邮箱查询用户
		List<User> uList = getDao().find(login.getKey());
		// 用户不存在
		if (uList == null || uList.size() == 0)
			throw new LoginException("用户名/手机号/邮箱不存在！");
		// 验证1：根据用户名或手机号或邮箱查询用户是否唯一
		if (uniqueCheck(uList)) {
			// 验证2：密码校验
			User user = uList.get(0);
			if (passwordCheck(user, login.getPassword())) {
				// 领域模型转视图模型
				V_User v_User = V_User.parse(user);
				Set<V_Module> root = generatePermission(v_User.getId());
				result = new SessionInfo();
				result.setLoginTime(DateTime.ToDate(new Date(), "yyyy/MM/dd HH:mm:ss"));
				result.setUser(v_User);
				result.setRoot(root);
			} else {
				throw new LoginException("密码错误！");
			}
		} else {
			throw new LoginException("用户名/手机号/邮箱存在异常情况，请联系管理员！");
		}
		return result;
	}

	// 验证1：根据用户名或手机号或邮箱查询用户是否唯一
	private Boolean uniqueCheck(List<User> uList) {
		Boolean result = false;
		if (uList != null) {
			result = uList.size() == 1;
		}
		return result;
	}

	// 验证2：密码校验
	private Boolean passwordCheck(User u, String password) {
		Boolean result = false;
		result = u.getPassword().equals(md5.encrypt(password));
		return result;
	}

	public Set<V_Module> generatePermission(String userId) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Set<V_Module> result = null;
		User user = getDao().get(userId);
		if (user != null) {
			// 获取用户模块及功能权限
			result = generatePermission(user.getFunList());
		}
		return result;
	}

	// 用户权限装配
	private Set<V_Module> generatePermission(Set<Function> funList) throws TemplateNotFoundException,
			DataAccessException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Set<V_Module> result = null;
		Set<V_Module> temp = null;

		if (funList != null && funList.size() > 0) {
			// 获得一个只包含根节点的树菜单
			result = generatePermission();

			// 根据用户与功能的对应关系装配出用户的操作权限菜单
			temp = new HashSet<V_Module>();
			for (Function f : funList) {
				if (f.getEnabled() && !f.getDel() && f.getModule().getEnabled() && !f.getModule().getDel()) {
					V_Module v_module = V_Module.parse(f.getModule(), true);
					V_Function v_function = V_Function.parse(f);
					Boolean contains = false;
					for (V_Module m : temp) {
						if (m.getId().equals(v_module.getId())) {
							contains = true;
							m.getFunList().add(v_function);
							break;
						}
					}
					if (!contains) {
						v_module.setFunList(new TreeSet<V_Function>());
						v_module.getFunList().add(v_function);
						temp.add(v_module);
					}
				}
			}
		}

		// 用户操作权限菜单寻根
		if (result != null && temp != null && result.size() > 0 && temp.size() > 0) {
			for (V_Module t : temp) {
				generatePermission(result, t);
			}
		}
		return result;
	}

	// 获得一个只包含根节点的树菜单
	private Set<V_Module> generatePermission() throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Set<V_Module> result = null;
		List<Module> moduleList = ((ModuleDao) getDao(DaoFactoryEnum.module.toString())).getRoot();
		if (moduleList != null && moduleList.size() > 0) {
			result = new HashSet<V_Module>();
			for (Module m : moduleList) {
				result.add(V_Module.parse(m, false));
			}
		}
		return result;
	}

	private void generatePermission(Set<V_Module> set, V_Module m) {
		for (V_Module r : set) {
			if (r != null) {
				if (r.isLeaf() == false) {
					if (m.getParentid().equals(r.getId())) {
						r.getChildren().add(m);
						break;
					}
					if (r.getChildren() != null && r.getChildren().size() > 0) {
						generatePermission(r.getChildren(), m);
					}
				}
			}
		}
	}

	@Override
	public void save(List<User> entity) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException {
		if (entity != null && entity.size() > 0) {
			Predicate<User> p = (v) -> v.getAdd();
			List<User> add = super.predicate(entity, p);
			p = (v) -> !v.getAdd();
			List<User> upd = super.predicate(entity, p);
			if (add != null && add.size() > 0) {
				for (User d : add) {
					d.setNo(super.getSerialNumber(0));
				}
				super.save(add);
			}
			if (upd != null && upd.size() > 0) {
				super.update(upd);
			}
		}
	}

	public List<User> inUser(String ts_role_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<User> result = null;
		result = getDao().inUser(ts_role_id);
		return result;
	}

	public List<User> unUser(String ts_role_id) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<User> result = null;
		result = getDao().unUser(ts_role_id);
		return result;
	}

	@Override
	public String getSerialNumber(int serialType) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException, java.text.ParseException {
		// TODO Auto-generated method stub
		return null;
	}
}
