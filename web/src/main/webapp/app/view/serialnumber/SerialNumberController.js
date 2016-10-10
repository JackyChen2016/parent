Ext.define('WebApp.view.serialnumber.SerialNumberController', {
	extend : 'WebApp.view.core.Controller',
	requires : [ 'WebApp.model.serialnumber.SerialNumber' ],
	alias : 'controller.serialnumber',
	className : 'WebApp.view.serialnumber.SerialNumberController',
	onAdd : function(sender) {
		if (this.isEdit(sender)) {
			this.getView().getStore().insert(
					0,
					new WebApp.model.serialnumber.SerialNumber({
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
				}
			}
		});
	},
	onImp : function(sender) {
		var me = this;
		me.imp(sender.route);
	}
});