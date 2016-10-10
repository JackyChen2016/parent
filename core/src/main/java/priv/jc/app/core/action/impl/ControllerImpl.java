package priv.jc.app.core.action.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.action.Controller;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.model.ActionResult;
import priv.jc.app.core.service.Service;
import priv.jc.util.excel.ExcelFile;

public abstract class ControllerImpl<T extends Domain> implements Controller<T> {
	protected Service<T> service;

	public void setService(Service<T> service) {
		this.service = service;
	}

	private Class<T> clazz;

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public ActionResult save(Service<T> service, List<T> list) {
		ActionResult result = new ActionResult();
		boolean status = true;
		String msg = " 保存成功！";
		try {
			service.save(list);
		} catch (Exception e) {
			status = false;
			msg = e.getMessage();
		}
		result.setSuccess(status);
		result.setMsg(msg);
		return result;
	}

	@Override
	public ActionResult find(Service<T> service, List<Filter> filter) {
		ActionResult result = new ActionResult();
		boolean status = false;
		String msg = "";
		try {
			result.setData(service.find(filter));
			status = true;
		} catch (DataAccessException e) {
			msg = e.getMessage();
		} catch (TemplateNotFoundException e) {
			msg = e.getMessage();
		} catch (MalformedTemplateNameException e) {
			msg = e.getMessage();
		} catch (ParseException e) {
			msg = e.getMessage();
		} catch (IOException e) {
			msg = e.getMessage();
		} catch (TemplateException e) {
			msg = e.getMessage();
		}
		result.setSuccess(status);
		result.setMsg(msg);
		return result;
	}

	@Override
	public ActionResult doImport(Service<T> service, HttpServletRequest request) {
		ActionResult result = new ActionResult();
		boolean status = false;
		String msg = "";
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		List<FileItem> fileItems = null;
		try {
			fileItems = upload.parseRequest(request);
		} catch (FileUploadException e) {
			msg = e.getMessage();
		}
		if (fileItems != null && fileItems.size() > 0) {
			for (FileItem item : fileItems) {
				try {
					List<T> list = ExcelFile.read(clazz, item);
					service.save(list);
					msg = "导入成功！";
					status = true;
				} catch (Exception e) {
					msg = e.getMessage();
				}
			}
		}
		result.setSuccess(status);
		result.setMsg(msg);
		return result;
	}

	@Override
	public Object save(HttpServletRequest request) {
		return null;
	}

	@Override
	public Object find(Filter[] filter) {
		return null;
	}

	@Override
	public Object doImport(HttpServletRequest request) {
		return null;
	}
}
