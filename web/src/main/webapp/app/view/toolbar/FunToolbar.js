Ext.define('WebApp.view.toolbar.FunToolbar', {
	extend : 'Ext.toolbar.Toolbar',
	requires : [ 'WebApp.view.toolbar.FunToolbarController' ],
	alias : 'widget.funtoolbar',
	controller : 'funtoolbar',
	baseCls : 'fun'
});