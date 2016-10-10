Ext.define('WebApp.model.core.Model', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id',
		type : 'string'
	}/*, {
		name : 'version',
		type : 'string'
	}*/, {
		name : 'enabled',
		type : 'boolean'
	}, {
		name : 'del',
		type : 'boolean'
	}, {
		name : 'remark',
		type : 'string'
	}, {
		name : 'createUser',
		type : 'string'
	}, {
		name : 'updateUser',
		type : 'string'
	}, {
		name : 'createTime',
		type : 'string'
	}, {
		name : 'updateTime',
		type : 'string'
	}, {
		name : 'add',
		type : 'boolean'
	} ]
});