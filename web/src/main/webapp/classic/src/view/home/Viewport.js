Ext.define('WebApp.view.home.Viewport', {
	extend : 'Ext.container.Viewport',
	requires : [ 'WebApp.view.top.Panel', 'WebApp.view.menu.TreePanel',
			'WebApp.view.toolbar.FunToolbar',
			'WebApp.view.toolbar.BottonToolbar' ],
	alias : 'widget.home',
	controller : 'home',
	layout : 'border',
	items : [ {
		region : 'north',
		xtype : 'top'
	}, {
		region : 'north',
		xtype : 'funtoolbar'
	}, {
		region : 'west',
		xtype : 'menu_tp'
	}, {
		region : 'south',
		xtype : 'bottontoolbar'
	}, {
		region : 'center',
		xtype : 'tabpanel',
		title : 'title',
		header : false,
		listeners : {
			tabchange : 'tabchange',
			remove : 'remove'
		}
	} ]
});