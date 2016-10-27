Ext.define('WebApp.view.user.UserRole', {
	extend : 'Ext.panel.Panel',
	requires : [ 'WebApp.view.user.UserRoleController',
			'WebApp.view.user.InRole', 'WebApp.view.user.UnRole' ],
	alias : 'widget.userrole',
	controller : 'userrole',
	title : '用户角色',
	layout : {
		type : 'hbox',
		pack : 'start',
		align : 'stretch'
	},
	items : [ {
		flex : 1,
		xtype : 'inrole'
	}, {
		flex : 1,
		xtype : 'unrole'
	} ],
	listeners : {
		activate : 'activate'
	}
});