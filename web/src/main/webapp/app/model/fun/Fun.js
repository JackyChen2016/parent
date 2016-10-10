Ext.define('WebApp.model.fun.Fun', {
	extend : 'WebApp.model.core.Model',
	alias : 'viewmodel.fun',
	fields : [ {
		name : 'name',
		type : 'string'
	}, {
		name : 'scale',
		type : 'string'
	}, {
		name : 'funIcon',
		type : 'string'
	}, {
		name : 'click',
		type : 'string'
	}, {
		name : 'url',
		type : 'string'
	}, {
		name : 'sort',
		type : 'int'
	}, {
		name : 'enableToggle',
		type : 'boolean'
	}]
});