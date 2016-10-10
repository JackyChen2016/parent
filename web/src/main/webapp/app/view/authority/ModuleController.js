Ext.define('WebApp.view.authority.ModuleController', {
	extend : 'WebApp.view.core.Controller',
	alias : 'controller.amodule',
	className : 'WebApp.view.authority.ModuleController',
	onQuery : function(sender) {
		var me = this;
		Ext.Ajax.request({
			url : 'get_root',
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
					var grid = me.getView();
					me.removeChildren(grid.getStore().getRoot());
					grid.getStore().getRoot().appendChild(obj.data);
					grid.getStore().commitChanges();
					grid.getStore().sort('sort', 'ASC');
					grid.expandAll();
				}
			}
		});
	},
	removeChildren : function(node) {
		var me = this;
		if (!node)
			return;
		while (node.hasChildNodes()) {
			me.removeChildren(node.firstChild);
			node.removeChild(node.firstChild);
		}
	},
	getSelect : function() {
		return this.getView().getSelectionModel().getLastSelected();
	},
	selectionchange : function(t, selected, eOpts) {
		var me = this;
		var ts_id = selected[0].data.id;
		var v = me.getView().ownerCt;
		var userController = v.items.items[0].controller;
		var d = userController.getSelect();
		var tm_id = d.data.id;
		var inFunController = v.items.items[2].controller;
		var unFunController = v.items.items[3].controller;
		var jsonData = {};
		jsonData.tm_id = tm_id;
		jsonData.ts_id = ts_id;
		inFunController.query(jsonData);
		unFunController.query(jsonData);
	}
});