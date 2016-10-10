package pers.jc.app.action.m2m;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import pers.jc.app.service.m2m.M2MService;
import priv.jc.app.core.action.impl.ControllerImpl;
import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.domain.system.M2M;
import priv.jc.app.core.model.ActionResult;

public class M2MController<T extends Domain> extends ControllerImpl<T> {
	@RequestMapping(value = "add_t_user_role", method = RequestMethod.POST)
	@ResponseBody
	public Object add_t_user_role(@RequestBody M2M[] list) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		ActionResult result = null;
		int row = 0;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (list != null && list.length > 0) {
			try {
				row = ((M2MService<?>) service).add_t_user_role(Arrays.asList(list));
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(row);
		return result;
	}

	@RequestMapping(value = "del_t_user_role", method = RequestMethod.POST)
	@ResponseBody
	public Object del_t_user_role(@RequestBody M2M[] list) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		ActionResult result = null;
		int row = 0;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (list != null && list.length > 0) {
			try {
				row = ((M2MService<?>) service).del_t_user_role(Arrays.asList(list));
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(row);
		return result;
	}

	@RequestMapping(value = "add_t_user_fun", method = RequestMethod.POST)
	@ResponseBody
	public Object add_t_user_fun(@RequestBody M2M[] list) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		ActionResult result = null;
		int row = 0;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (list != null && list.length > 0) {
			try {
				row = ((M2MService<?>) service).add_t_user_fun(Arrays.asList(list));
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(row);
		return result;
	}

	@RequestMapping(value = "del_t_user_fun", method = RequestMethod.POST)
	@ResponseBody
	public Object del_t_user_fun(@RequestBody M2M[] list) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		ActionResult result = null;
		int row = 0;
		result = new ActionResult();
		boolean status = true;
		String msg = "";
		if (list != null && list.length > 0) {
			try {
				row = ((M2MService<?>) service).del_t_user_fun(Arrays.asList(list));
			} catch (Exception e) {
				status = false;
				msg = e.getMessage();
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		result.setData(row);
		return result;
	}
}
