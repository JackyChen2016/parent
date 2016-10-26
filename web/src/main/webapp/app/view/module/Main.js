Ext.define('WebApp.view.module.Main', {
	extend : 'Ext.tab.Panel',
	requires : [ 'WebApp.view.module.Panel', 'WebApp.view.fun.Panel' ],
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