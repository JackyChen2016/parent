Ext.define('WebApp.view.module.Main', {
	extend : 'Ext.tab.Panel',
	requires : [ 'WebApp.view.module.Module', 'WebApp.view.fun.Fun' ],
	controller : 'main',
	margin : '5 0 0 0',
	items : [ {
		xtype : 'module'
	}, {
		xtype : 'fun'
	} ],
	listeners : {
		tabchange : 'onTabchange'
	}
});