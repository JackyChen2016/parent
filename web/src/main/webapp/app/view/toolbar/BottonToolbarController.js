Ext.define('WebApp.view.toolbar.BottonToolbarController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.bottontoolbar',
	onLogout : function(sender) {
		Ext.TaskManager.stopAll();
		home = Ext.ComponentQuery.query('app-home');
		home[0].destroy();
		Ext.create({
			xtype : 'app-main'
		});
	},
	onModify : function(sender) {
	},
	onHelp : function(sender) {
		alert(sender.text);
	}
});