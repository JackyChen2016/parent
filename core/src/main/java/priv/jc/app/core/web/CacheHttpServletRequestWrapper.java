package priv.jc.app.core.web;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StreamUtils;

public class CacheHttpServletRequestWrapper extends HttpServletRequestWrapper {
	private byte[] body;

	public CacheHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = StreamUtils.copyToByteArray(request.getInputStream());
	}

	/**
	 * 重写 getInputStream()
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		if (body == null) {
			body = new byte[0];
		}
		final ByteArrayInputStream bais = new ByteArrayInputStream(body);
		return new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	/**
	 * 重写 getReader()
	 */
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}
}
