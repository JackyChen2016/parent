Ext.define('WebApp.model.module.Model', {
	extend : 'WebApp.model.core.Model',
	alias : 'viewmodel.module',
	fields : [ {
		name : 'name',
		type : 'string'
	}, {
		name : 'className',
		type : 'string'
	}, {
		name : 'iconCls',
		type : 'string'
	}, {
		name : 'leaf',
		type : 'boolean'
	}, {
		name : 'sort',
		type : 'int'
	} ]
});