package priv.jc.app.core.dao.system;

import java.io.IOException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import priv.jc.app.core.domain.system.SerialNumber;

public interface SerialNumberDao {
	public enum SerialNumberEnum {
		serialNumber_find, serialNumber_get
	}

	public List<SerialNumber> getSerialNumber(Integer serialType) throws TemplateNotFoundException, DataAccessException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;
}
