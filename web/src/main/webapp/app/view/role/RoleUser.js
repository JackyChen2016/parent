Ext.define('WebApp.view.role.RoleUser', {
	extend : 'Ext.panel.Panel',
	requires : [ 'WebApp.view.role.RoleUserController',
			'WebApp.view.role.InUser', 'WebApp.view.role.UnUser' ],
	alias : 'widget.roleuser',
	controller : 'roleuser',
	title : '角色用户',
	layout : {
		type : 'hbox',
		pack : 'start',
		align : 'stretch'
	},
	items : [ {
		flex : 1,
		xtype : 'inuser'
	}, {
		flex : 1,
		xtype : 'unuser'
	} ],
	listeners : {
		activate : 'activate'
	}
});