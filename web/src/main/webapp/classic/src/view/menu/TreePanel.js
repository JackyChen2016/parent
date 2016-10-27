Ext.define('WebApp.view.menu.TreePanel', {
	extend : 'Ext.tree.Panel',
	requires : [ 'WebApp.view.menu.Controller' ],
	alias : 'widget.menu_tp',
	controller : 'menu_tp',
	title : '菜单',
	width : 200,
	collapsible : true,
	titleCollapse : true,
	split : true,
	rootVisible : false,
	listeners : {
		select : 'select'
	}
});