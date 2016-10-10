Ext.define('WebApp.model.role.Role', {
	extend : 'WebApp.model.core.Model',
	alias : 'viewmodel.role',
	fields : [ {
		name : 'roleNo',
		type : 'string'
	}, {
		name : 'roleName',
		type : 'string'
	} ]
});