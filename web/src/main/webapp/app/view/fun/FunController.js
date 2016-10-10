Ext.define('WebApp.view.fun.FunController', {
	extend : 'WebApp.view.core.Controller',
	requires : [ 'WebApp.model.fun.Fun' ],
	alias : 'controller.fun',
	className : 'WebApp.view.fun.FunController',
	onAdd : function(sender) {
		var me = this;
		var view = me.getView().previousSibling();
		var record = view.controller.getSelect();
		if (this.isEdit(sender) && record.data.leaf) {
			this.getView().getStore().insert(0, new WebApp.model.fun.Fun({
				add : true,
				enabled : true,
				module : record.data,
				createUser : this.getSession().user.userName,
				createTime : Ext.util.Format.date(new Date(), 'Y/m/d H:i:s')
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
						me.getView().getStore().remove(r);
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
				url : 'save_fun',
				jsonData : me.getModifiedData(records),
				success : function(response, opts) {
					var obj = Ext.decode(response.responseText);
					if (obj.success) {
						me.activate();
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
	query : function(jsonData) {
		var grid = this.getView();
		Ext.Ajax.request({
			url : 'find_fun',
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
	activate : function(t, eOpts) {
		var me = this;
		me.getView().getStore().setData({});
		var view = me.getView().previousSibling();
		var record = view.controller.getSelect();
		if (record.data.leaf) {
			var jsonData = [];
			var filter = {};
			filter.logic = 'and';
			filter.field = 'ts_module_id';
			filter.type = 'string';
			filter.relation = '=';
			filter.value = record.data.id;
			jsonData.push(filter);
			me.query(jsonData);
		}
	}
});