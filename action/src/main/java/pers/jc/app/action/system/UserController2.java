package pers.jc.app.action.system;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.jc.app.service.system.UserService;
import priv.jc.app.core.action.impl.ControllerImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.system.Role;
import priv.jc.app.core.domain.system.User;
import priv.jc.app.core.model.ActionResult;
import priv.jc.app.core.model.Login;
import priv.jc.app.core.model.SessionInfo;
import priv.jc.util.json.JsonUtil;

public class UserController2 extends ControllerImpl<User> {
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(Login login, HttpSession session) {
		ActionResult result = null;
		SessionInfo sessionInfo = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		try {
			sessionInfo = ((UserService) service).login(login);
			session.setAttribute(session.getId(), sessionInfo);
		} catch (Exception e) {
			status = false;
			msg = e.getMessage();
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(sessionInfo);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "save_user", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object save(HttpServletRequest request) {
		List<User> data = null;
		try {
			data = (List<User>) JsonUtil.getList(request, User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.save((UserService) service, data);
	}

	@RequestMapping(value = "find_user", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object find(@RequestBody Filter[] filter) {
		return super.find((UserService) service, Arrays.asList(filter));
	}

	@RequestMapping(value = "in_user", method = RequestMethod.POST)
	@ResponseBody
	public Object inUser(@RequestBody Role[] role) {
		ActionResult result = null;
		List<User> list = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (role.length > 0) {
			try {
				list = ((UserService) service).inUser(role[0].getId());
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

	@RequestMapping(value = "un_user", method = RequestMethod.POST)
	@ResponseBody
	public Object unRole(@RequestBody Role[] role) {
		ActionResult result = null;
		List<User> list = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (role.length > 0) {
			try {
				list = ((UserService) service).unUser(role[0].getId());
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
