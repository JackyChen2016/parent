Ext.define('WebApp.view.role.Main', {
	extend : 'Ext.tab.Panel',
	requires : [ 'WebApp.view.query.Query', 'WebApp.view.role.Role',
			'WebApp.view.role.RoleUser' ],
	controller : 'main',
	margin : '5 0 0 0',
	items : [ {
		xtype : 'role'
	}, {
		xtype : 'roleuser'
	} ],
	listeners : {
		tabchange : 'onTabchange'
	}
});