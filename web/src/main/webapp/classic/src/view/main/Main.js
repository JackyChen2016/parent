Ext.define('WebApp.view.main.Main', {
	extend : 'Ext.container.Viewport',
	alias : 'widget.main',
	requires : [ 'Ext.plugin.Viewport', 'WebApp.view.login.Panel' ],
	layout : 'fit',
	items : [ {
		xtype : 'login'
	} ]
});