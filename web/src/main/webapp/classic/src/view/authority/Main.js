Ext.define('WebApp.view.authority.Main', {
	extend : 'Ext.panel.Panel',
	requires : [ 'WebApp.view.authority.User', 'WebApp.view.authority.Module',
			'WebApp.view.authority.InFun', 'WebApp.view.authority.UnFun',
			'WebApp.view.authority.AuthorityController' ],
	controller : 'authority',
	margin : '5 0 0 0',
	layout : {
		type : 'hbox',
		pack : 'start',
		align : 'stretch'
	},
	items : [ {
		flex : 1.8,
		xtype : 'auser'
	}, {
		flex : 1.5,
		xtype : 'amodule'
	}, {
		flex : 1,
		xtype : 'infun'
	}, {
		flex : 1,
		xtype : 'unfun'
	} ],
	listeners : {
		tabchange : 'onTabchange'
	// activate : 'activate'
	}
});