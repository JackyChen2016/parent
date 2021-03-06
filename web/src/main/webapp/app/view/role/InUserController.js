Ext.define('WebApp.view.role.InUserController', {
	extend : 'WebApp.view.core.Controller',
	alias : 'controller.inuser',
	query : function(jsonData) {
		var grid = this.getView();
		Ext.Ajax.request({
			url : 'in_user',
			jsonData : jsonData,
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
					grid.getStore().sort('sort', 'ASC');
					grid.getSelectionModel().select(0, true);
				}
			}
		});
	},
	onDrop : function(node, data, dropRec, dropPosition) {
		var me = this;
		var view = me.getView().ownerCt.previousSibling();
		var ts_id = view.controller.getSelect().data.id;
		var records = data.records;
		var jsonData = [];
		records.forEach(function(r) {
			var temp = {};
			temp.tm_id = r.data.id;
			temp.ts_id = ts_id;
			jsonData.push(temp);
		});
		Ext.Ajax.request({
			url : 'add_t_user_role',
			jsonData : jsonData,
			success : function(response, opts) {
				var obj = Ext.decode(response.responseText);
				var title = "提示";
				var icon = Ext.MessageBox.info;
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
				}
			}
		});
	},
	isEdit : function(sender) {
		if (!this.pressedByEdit) {
			var view = this.getView();
			var tab = view.ownerCt;
			Ext.Msg.show({
				title : '提示',
				message : '需先激活视图编辑功能才可执行用户分配！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO,
				animateTarget : sender,
				closeAction : 'destroy'
			});
		}
		return this.pressedByEdit;
	}
});