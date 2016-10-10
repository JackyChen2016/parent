Ext.define('WebApp.model.authority.UserAuthority', {
	extend : 'WebApp.model.core.Model',
	alias : 'viewmodel.userAuthority',
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