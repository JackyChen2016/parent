package priv.jc.app.core.dao.system.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.dao.impl.DaoImpl;
import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.dao.system.SerialNumberDao;
import priv.jc.app.core.domain.system.SerialNumber;

public class SerialNumberDaoImpl extends DaoImpl<SerialNumber>implements SerialNumberDao {
	public SerialNumberDaoImpl() {
		setClazz(SerialNumber.class);
	}

	@Override
	public List<SerialNumber> find(List<Filter> filter) throws DataAccessException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return find(SerialNumberEnum.serialNumber_find.toString(), filter);
	}

	@Override
	public List<SerialNumber> getSerialNumber(Integer serialType) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<SerialNumber> result = null;
		Map<String, Object> map = null;
		map = new HashMap<String, Object>();
		map.put("serialType", serialType);
		result = find(SerialNumberEnum.serialNumber_get.toString(), map);
		return result;
	}

}
