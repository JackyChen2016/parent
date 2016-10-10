/**
 * 
 */
package pers.jc.app.action.system;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.template.TemplateException;
import pers.jc.app.service.system.ModuleService;
import priv.jc.app.core.action.impl.ControllerImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.system.Module;
import priv.jc.app.core.model.ActionResult;
import priv.jc.util.json.JsonUtil;

/**
 * @author Jacky
 *
 */
public class ModuleController extends ControllerImpl<Module> {

	@RequestMapping(value = "root/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object root(@PathVariable String id) {
		Object result = null;
		// result = ((ModuleService) service).generatePermission(id);
		// result = JsonActionProcessImpl.getResult(result);
		return result;
	}

	@RequestMapping(value = "get_root", method = RequestMethod.POST)
	@ResponseBody
	public Object getModule() {
		ActionResult result = null;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		try {
			result.setData(((ModuleService) service).getRoot());
		} catch (DataAccessException | IOException | TemplateException e) {
			status = false;
			msg = e.getMessage();
		}
		result.setSuccess(status);
		result.setMsg(msg);
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "save_module", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object save(HttpServletRequest request) {
		List<Module> data = null;
		try {
			data = (List<Module>) JsonUtil.getList(request, Module.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.save(service, data);
	}
	
	@RequestMapping(value = "find_module", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object find(@RequestBody Filter[] filter) {
		return super.find(service, Arrays.asList(filter));
	}
}
