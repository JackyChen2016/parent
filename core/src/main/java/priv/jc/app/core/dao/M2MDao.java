package priv.jc.app.core.dao;

import java.io.IOException;
import java.util.List;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.domain.system.M2M;

public interface M2MDao {
	public enum MtmEnum {
	}

	int add(String name, List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException;

	int del(String name, List<M2M> list) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException;
}
