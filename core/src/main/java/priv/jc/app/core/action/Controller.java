package priv.jc.app.core.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import priv.jc.app.core.dao.impl.Filter;
import priv.jc.app.core.domain.Domain;
import priv.jc.app.core.model.ActionResult;
import priv.jc.app.core.service.Service;

public interface Controller<T extends Domain> {
	Object save(HttpServletRequest request);

	ActionResult save(Service<T> service, List<T> list);

	Object find(Filter[] filter);

	ActionResult find(Service<T> service, List<Filter> filter);

	Object doImport(HttpServletRequest request);

	ActionResult doImport(Service<T> service, HttpServletRequest request);
}
