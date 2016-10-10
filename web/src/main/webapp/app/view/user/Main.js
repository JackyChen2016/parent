Ext.define('WebApp.view.user.Main', {
	extend : 'Ext.tab.Panel',
	requires : [ 'WebApp.view.query.Query', 'WebApp.view.user.User',
			'WebApp.view.user.UserRole' ],
	controller : 'main',
	margin : '5 0 0 0',
	items : [ {
		xtype : 'query'
	}, {
		xtype : 'user'
	}, {
		xtype : 'userrole'
	} ],
	listeners : {
		tabchange : 'onTabchange'
	}
});