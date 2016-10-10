/**
 * 
 */
package priv.jc.util.data.encrypt.impl;

import java.security.MessageDigest;

/**
 * @author jacky_chen SHA加密
 */
public class SHA extends DataEncryptImpl {
	@Override
	public String encrypt(String data) {
		String result = null;
		data = super.encrypt(data);
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
			byte[] byteArray = data.getBytes("UTF-8");
			byte[] md5Bytes = sha.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			result = hexValue.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
