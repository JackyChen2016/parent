Ext.define('WebApp.view.authority.AuthorityController', {
	extend : 'WebApp.view.core.Controller',
	alias : 'controller.authority',
	className : 'WebApp.view.authority.AuthorityController',
	onQuery : function(sender) {
		var me = this;
		var v = me.getView();
		var userController = v.items.items[0].controller;
		var moduleController = v.items.items[1].controller;
		userController.onQuery(sender);
		moduleController.onQuery(sender);
	},
	onEdit : function(sender) {
		var me = this;
		me.pressedByEdit = !me.pressedByEdit;
		var v = me.getView();
		var items = v.items.items;
		items.forEach(function(i) {
			i.controller.pressedByEdit = me.pressedByEdit;
		});
	}
});