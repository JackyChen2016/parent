Ext.define('WebApp.view.authority.UserController', {
	extend : 'WebApp.view.core.Controller',
	requires : [ 'WebApp.model.user.User' ],
	alias : 'controller.auser',
	className : 'WebApp.view.authority.UserController',
	onQuery : function(sender) {
		var grid = this.getView();
		Ext.Ajax.request({
			url : 'find_user',
			jsonData : [],
			success : function(response, opts) {
				obj = Ext.decode(response.responseText);
				title = "提示";
				icon = Ext.MessageBox.info;
				if (!obj.success) {
					title = "错误提示";
					icon = Ext.MessageBox.ERROR;
					Ext.Msg.show({
						title : title,
						msg : obj.msg,
						buttons : Ext.MessageBox.OK,
						animateTarget : this,
						icon : icon
					});
				} else {
					grid.getStore().setData(obj.data);
					grid.getSelectionModel().select(0, true);
				}
			}
		});
	},
	getSelect : function() {
		return this.getView().getSelectionModel().getLastSelected();
	},
	selectionchange : function(t, selected, eOpts) {
		var me = this;
		var tm_id = selected[0].data.id;
		var v = me.getView().ownerCt;
		var moduleController = v.items.items[1].controller;
		var d = moduleController.getSelect();
		var ts_id = d.data.id;
		var inFunController = v.items.items[2].controller;
		var unFunController = v.items.items[3].controller;
		var jsonData = {};
		jsonData.tm_id = tm_id;
		jsonData.ts_id = ts_id;
		inFunController.query(jsonData);
		unFunController.query(jsonData);
	}
});