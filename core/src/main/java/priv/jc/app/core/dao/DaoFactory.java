package priv.jc.app.core.dao;

/**
 * @author Jacky
 *
 */
public interface DaoFactory {
	public enum DaoFactoryEnum {
		user, module, serialNumber
	}

	Dao<?> createDao(String dao);
}
