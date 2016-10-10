Ext.define('WebApp.view.role.RoleUserController', {
	extend : 'WebApp.view.core.Controller',
	alias : 'controller.roleuser',
	className : 'WebApp.view.role.RoleUserController',
	activate : function(t, eOpts) {
		var me = this;
		var v = me.getView().previousSibling();
		var record = v.controller.getSelect();
		v = me.getView();
		var items = v.items.items;
		items.forEach(function(i) {
			var jsonData = [];
			var user = {};
			user.id = record.data.id;
			jsonData.push(user);
			i.controller.query(jsonData);
		});
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