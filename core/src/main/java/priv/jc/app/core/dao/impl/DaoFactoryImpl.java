package priv.jc.app.core.dao.impl;

import priv.jc.app.core.dao.Dao;
import priv.jc.app.core.dao.DaoFactory;

/**
 * @author Jacky
 *
 */
public class DaoFactoryImpl implements DaoFactory {
	private Dao<?> userDao;
	private Dao<?> moduleDao;
	private Dao<?> serialNumberDao;

	public void setUserDao(Dao<?> userDao) {
		this.userDao = userDao;
	}

	public void setModuleDao(Dao<?> moduleDao) {
		this.moduleDao = moduleDao;
	}

	public void setSerialNumberDao(Dao<?> serialNumberDao) {
		this.serialNumberDao = serialNumberDao;
	}

	@Override
	public Dao<?> createDao(String dao) {
		Dao<?> result = null;
		switch (dao) {
		case "user": {
			result = userDao;
			break;
		}
		case "module": {
			result = moduleDao;
			break;
		}
		case "serialNumber": {
			result = serialNumberDao;
			break;
		}
		}
		return result;
	}

}
