Ext.define('WebApp.view.module.ModuleController', {
	extend : 'WebApp.view.core.Controller',
	alias : 'controller.module',
	className : 'WebApp.view.module.ModuleController',
	onAdd : function(sender) {
		if (this.isEdit(sender)) {
			this.getView().getSelectionModel().getLastSelected().appendChild(
					new WebApp.model.module.Module({
						add : true,
						enabled : true,
						createUser : this.getSession().user.userName,
						createTime : Ext.util.Format.date(new Date(),
								'Y/m/d H:i:s')
					}));
		}
	},
	onDel : function(sender) {
		var me = this;
		if (me.isEdit(sender)) {
			var rec = me.getView().getSelection();
			if (!Ext.isEmpty(rec)) {
				rec.forEach(function(r) {
					if (r.data.add) {
						me.removeChildren(r);
						r.parentNode.removeChild(r);
					}
				});
			}
		}
	},
	onEdit : function(sender) {
		this.pressedByEdit = !this.pressedByEdit;
		this.getView().columns.forEach(function(c) {
			if (c.getXType() == 'checkcolumn')
				c.setDisabled(!c.disabled);
		});
	},
	onSave : function(sender) {
		var me = this;
		var records = me.getView().getStore().getModifiedRecords();
		if (records.length) {
			Ext.Ajax.request({
				url : sender.route,
				jsonData : me.getModifiedData(records),
				success : function(response, opts) {
					var obj = Ext.decode(response.responseText);
					if (obj.success) {
						me.onQuery(me.getFunbtn(sender, 'onQuery'));
					} else {
						Ext.Msg.show({
							title : "错误提示",
							msg : obj.msg,
							buttons : Ext.MessageBox.OK,
							animateTarget : this,
							icon : Ext.MessageBox.info
						});
					}
				}
			});
		}
	},
	onQuery : function(sender) {
		var me = this;
		Ext.Ajax.request({
			url : sender.route,
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
	rowdblclick : function(t, record, tr, rowIndex, e, eOpts) {
		var me = this;
		if (record.data.leaf && !record.data.add) {
			var view = me.getView();
			var tab = view.ownerCt;
			tab.setActiveItem(1);
		}
	},
	getSelect : function() {
		return this.getView().getSelectionModel().getLastSelected();
	}
});