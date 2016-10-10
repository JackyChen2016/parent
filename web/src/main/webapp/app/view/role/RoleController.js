Ext.define('WebApp.view.role.RoleController', {
	extend : 'WebApp.view.core.Controller',
	requires : [ 'WebApp.model.role.Role' ],
	alias : 'controller.role',
	className : 'WebApp.view.role.RoleController',
	onAdd : function(sender) {
		if (this.isEdit(sender)) {
			this.getView().getStore().insert(0, new WebApp.model.role.Role({
				add : true,
				enabled : true,
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
		var grid = this.getView();
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
					grid.getStore().setData(obj.data);
					grid.getSelectionModel().select(0, true);
				}
			}
		});
	},
	onPrint : function(sender) {
		Ext.Ajax.request({
			url : 'getLodop',
			success : function(response, opts) {
				obj = Ext.decode(response.responseText);
				if (!Ext.isEmpty(obj)) {
					LODOP = getLodop();
					script = document.createElement("script");
					script.appendChild(document
							.createTextNode("function print(){" + obj + " }"));
					document.body.appendChild(script);
					print();
					if (LODOP.CVERSION) {
						CLODOP.On_Return = function(TaskID, Value) {
							alert(Value)
						};
					}
					LODOP.PRINT_DESIGN();
				}
			}
		});
	},
	rowdblclick : function(t, record, tr, rowIndex, e, eOpts) {
		var me = this;
		if (!record.data.add) {
			var view = me.getView();
			var tab = view.ownerCt;
			tab.setActiveItem(1);
		}
	},
	getSelect : function() {
		return this.getView().getSelectionModel().getLastSelected();
	}
});