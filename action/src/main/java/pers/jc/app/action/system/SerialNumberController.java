package pers.jc.app.action.system;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.jc.app.core.action.impl.ControllerImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.system.SerialNumber;
import priv.jc.util.json.JsonUtil;

public class SerialNumberController extends ControllerImpl<SerialNumber> {
	public SerialNumberController(){
		setClazz(SerialNumber.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "save_serialNumber", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object save(HttpServletRequest request) {
		List<SerialNumber> data = null;
		try {
			data = (List<SerialNumber>) JsonUtil.getList(request, SerialNumber.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.save(service, data);
	}

	@RequestMapping(value = "find_serialNumber", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object find(@RequestBody Filter[] filter) {
		return super.find(service, Arrays.asList(filter));
	}
	
	@RequestMapping(value = "imp_serialNumber", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Object doImport(HttpServletRequest request) {
		return super.doImport(service, request);
	}
}
