/**
 * 
 */
package priv.jc.util.data.encrypt.impl;

import priv.jc.util.data.encrypt.DataEncrypt;

/**
 * @author Jacky
 *
 */
public abstract class DataEncryptImpl implements DataEncrypt {
	protected DataEncrypt dataEncrypt;
	
	public void setDataEncrypt(DataEncrypt dataEncrypt) {
		this.dataEncrypt = dataEncrypt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xxx.webapp.core.DataProcess#process(java.lang.String)
	 */
	@Override
	public String encrypt(String data) {
		if (dataEncrypt != null) {
			data = dataEncrypt.encrypt(data);
		}
		return data;
	}

}
