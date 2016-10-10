package pers.jc.app.action.system;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.jc.app.service.system.FunctionService;
import priv.jc.app.core.action.impl.ControllerImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.system.Function;
import priv.jc.app.core.domain.system.M2M;
import priv.jc.app.core.model.ActionResult;
import priv.jc.util.json.JsonUtil;

/**
 * @author Jacky
 *
 */
public class FunctionController extends ControllerImpl<Function> {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "save_fun", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object save(HttpServletRequest request) {
		List<Function> data = null;
		try {
			data = (List<Function>) JsonUtil.getList(request, Function.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.save(service, data);
	}

	@RequestMapping(value = "find_fun", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object find(@RequestBody Filter[] filter) {
		return super.find(service, Arrays.asList(filter));
	}

	@RequestMapping(value = "in_fun", method = RequestMethod.POST)
	@ResponseBody
	public Object inFun(@RequestBody M2M t_User_Module) {
		ActionResult result = null;
		List<Function> fun = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (t_User_Module != null) {
			try {
				fun = ((FunctionService) service).inFun(t_User_Module);
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(fun);
		return result;
	}

	@RequestMapping(value = "un_fun", method = RequestMethod.POST)
	@ResponseBody
	public Object unFun(@RequestBody M2M t_User_Module) {
		ActionResult result = null;
		List<Function> fun = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (t_User_Module != null) {
			try {
				fun = ((FunctionService) service).unFun(t_User_Module);
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(fun);
		return result;
	}
}
