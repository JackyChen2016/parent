package priv.jc.util.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public final static ObjectMapper mapper = new ObjectMapper();

	/*
	 * 获取Json字符串
	 */
	public static String getJsonString(HttpServletRequest request) throws IOException {
		String result = null;
		StringBuffer sb = new StringBuffer();
		if (request != null) {
			BufferedReader reader = request.getReader();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			result = sb.toString();
		}
		return result;
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	/*
	 * 获取对象
	 */
	public static <T> T getObject(String jsonString, Class<T> c)
			throws JsonParseException, JsonMappingException, IOException {
		T result = null;

		if (jsonString != null) {

			result = (T) mapper.readValue(jsonString, c);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getList(String jsonString, Class<T> c)
			throws JsonParseException, JsonMappingException, IOException {
		T result = null;
		JavaType javaType = getCollectionType(ArrayList.class, c);
		result = (T) mapper.readValue(jsonString, javaType);
		return result;
	}

	/*
	 * 获取对象
	 */
	public static <T> T getList(HttpServletRequest request, Class<T> c) throws IOException {
		T result = null;
		String jsonString = getJsonString(request);
		result = getList(jsonString, c);
		return result;
	}
}
