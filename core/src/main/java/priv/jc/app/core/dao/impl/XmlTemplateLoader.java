/**
 * 
 */
package priv.jc.app.core.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.util.XMLErrorHandler;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import freemarker.cache.StringTemplateLoader;

/**
 * @author Jacky
 *
 */
public class XmlTemplateLoader extends StringTemplateLoader {
	private final Log logger = LogFactory.getLog(getClass());

	private final String fileSuffix = ".xml";

	private String templateConfigLocation;

	private ResourceLoader resourceLoader = new PathMatchingResourcePatternResolver();

	private Resource[] resources;

	private Resource resource;

	private List<Document> documents = new ArrayList<Document>();

	private final String[] dml = { "insert", "delete", "update", "select" };

	public String getTemplateConfigLocation() {
		return (templateConfigLocation == null || templateConfigLocation.isEmpty())
				? this.getClass().getSimpleName() + fileSuffix : templateConfigLocation;
	}

	public void setTemplateConfigLocation(String templateConfigLocation) {
		this.templateConfigLocation = templateConfigLocation;
	}

	public XmlTemplateLoader(String templateConfigLocation) {
		this.templateConfigLocation = templateConfigLocation;
		initResource();
		loadDocument(resources);
		loadDocument(resource);
		putTemplate();
	}

	private void initResource() {
		boolean flag = this.resourceLoader instanceof ResourcePatternResolver;
		if (flag) {
			try {
				resources = ((ResourcePatternResolver) this.resourceLoader).getResources(getTemplateConfigLocation());
			} catch (IOException e) {
				logger.equals(e);
			}
		} else {
			resource = resourceLoader.getResource(getTemplateConfigLocation());
		}
	}

	private void loadDocument(Resource[] resources) {
		if (resources != null) {
			for (Resource resource : resources) {
				loadDocument(resource);
			}
		}
	}

	private void loadDocument(Resource resource) {
		if (resource != null) {
			loadDocument(new EncodedResource(resource));
		}
	}

	private void loadDocument(EncodedResource encodedResource) {
		if (encodedResource != null) {
			try {
				InputStream inputStream = encodedResource.getResource().getInputStream();
				try {
					InputSource inputSource = new InputSource(inputStream);
					if (encodedResource.getEncoding() != null) {
						inputSource.setEncoding(encodedResource.getEncoding());
					}
					loadDocument(inputSource, encodedResource.getResource());
				} finally {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.equals(e);
			}
		}
	}

	private void loadDocument(InputSource inputSource, Resource resource) {
		SAXReader reader = new SAXReader();
		XMLErrorHandler errorHandler = new XMLErrorHandler();
		reader.setErrorHandler(errorHandler);
		reader.setValidation(true);
		try {
			reader.setFeature("http://xml.org/sax/features/validation", true);
			reader.setFeature("http://apache.org/xml/features/validation/schema", true);
		} catch (SAXException e) {
			logger.equals(e);
		}

		try {
			documents.add(reader.read(resource.getFile()));
		} catch (DocumentException e) {
			logger.equals(e);
		} catch (IOException e) {
			logger.equals(e);
		}

		if (errorHandler.getErrors().hasContent()) {
			logger.warn(errorHandler);
		}
	}

	private void putTemplate() {
		if (documents != null && documents.size() > 0) {
			for (Document doc : documents) {
				Element root = doc.getRootElement();
				putTemplate(root);
			}
		}
	}

	private void putTemplate(Element element) {
		for (String d : dml) {
			if (d.equals(element.getName())) {
				putTemplate(element.attributeValue("name"), element.getStringValue());
			}
		}
		for (Iterator<?> ie = element.elementIterator(); ie.hasNext();) {
			putTemplate((Element) ie.next());
		}
	}
}
