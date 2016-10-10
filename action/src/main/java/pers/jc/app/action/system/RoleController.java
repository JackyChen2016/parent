/**
 * 
 */
package pers.jc.app.action.system;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.jc.app.service.system.RoleService;
import priv.jc.app.core.action.impl.ControllerImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.system.Role;
import priv.jc.app.core.domain.system.User;
import priv.jc.app.core.model.ActionResult;
import priv.jc.util.json.JsonUtil;

/**
 * @author Jacky
 *
 */
public class RoleController extends ControllerImpl<Role> {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "save_role", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object save(HttpServletRequest request) {
		List<Role> data = null;
		try {
			data = (List<Role>) JsonUtil.getList(request, Role.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.save(service, data);
	}

	@RequestMapping(value = "find_role", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object find(@RequestBody Filter[] filter) {
		return super.find(service, Arrays.asList(filter));
	}

	@RequestMapping(value = "in_role", method = RequestMethod.POST)
	@ResponseBody
	public Object inRole(@RequestBody User[] user) {
		ActionResult result = null;
		List<Role> list = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (user.length > 0) {
			try {
				list = ((RoleService) service).inRole(user[0].getId());
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(list);
		return result;
	}

	@RequestMapping(value = "un_role", method = RequestMethod.POST)
	@ResponseBody
	public Object unRole(@RequestBody User[] user) {
		ActionResult result = null;
		List<Role> list = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (user.length > 0) {
			try {
				list = ((RoleService) service).unRole(user[0].getId());
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(list);
		return result;
	}
}
