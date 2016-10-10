package pers.jc.app.service.m2m;

import java.io.IOException;
import java.util.List;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.impl.M2MDaoImpl;
import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.domain.system.M2M;
import priv.jc.app.core.service.impl.ServiceImpl;

/**
 * @author Jacky
 *
 */
public class M2MService<T extends Domain> extends ServiceImpl<T> {
	public M2MDaoImpl<T> getDao() {
		return (M2MDaoImpl<T>) super.getDao();
	}

	public int add_t_user_role(List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		return getDao().add(name, list);
	}

	public int del_t_user_role(List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		return getDao().del(name, list);
	}

	public int add_t_user_fun(List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		return getDao().add(name, list);
	}

	public int del_t_user_fun(List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		String name = Thread.currentThread().getStackTrace()[1].getMethodName();
		return getDao().del(name, list);
	}
}
