Ext.define('WebApp.model.user.User', {
	extend : 'WebApp.model.core.Model',
	alias : 'viewmodel.user',
	fields : [ {
		name : 'no',
		type : 'string'
	}, {
		name : 'userName',
		type : 'string'
	}, {
		name : 'password',
		type : 'string'
	}, {
		name : 'chName',
		type : 'string'
	}, {
		name : 'enName',
		type : 'string'
	}, {
		name : 'age',
		type : 'int'
	}, {
		name : 'sex',
		type : 'boolean'
	}, {
		name : 'telphone',
		type : 'string'
	}, {
		name : 'email',
		type : 'string'
	} ]
});