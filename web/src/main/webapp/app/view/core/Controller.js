Ext.define('WebApp.view.core.Controller', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.core',
	pressedByEdit : false,
	getSession : function() {
		return window.session;
	},
	msg : function(sender) {
		var view = this.getView();
		var tab = view.ownerCt;
		Ext.Msg.show({
			title : '提示',
			message : tab.title + '的' + sender.tooltip + '功能不支持' + view.title
					+ '，请切换到' + tab.title + '下其它视图执行' + sender.tooltip + '功能！',
			buttons : Ext.Msg.OK,
			icon : Ext.Msg.INFO,
			animateTarget : sender,
			closeAction : 'destroy'
		});
	},
	onTabchange : function(sender, newCard, oldCard) {
		var fun = sender.ownerCt.ownerCt.query('app-funtoolbar')[0];
		var items = fun.items.items;
		items.forEach(function(i) {
			if (i.enableToggle) {
				i.setPressed(newCard.controller.pressedByEdit);
			}
		});
	},
	isEdit : function(sender) {
		if (!this.pressedByEdit) {
			var view = this.getView();
			var tab = view.ownerCt;
			Ext.Msg.show({
				title : '提示',
				message : '需先激活视图编辑功能才可执行' + sender.tooltip + '！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO,
				animateTarget : sender,
				closeAction : 'destroy'
			});
		}
		return this.pressedByEdit;
	},
	getFunbtn : function(sender, click) {
		var funbtn;
		var fun = sender.ownerCt;
		var items = fun.items.items;
		items.forEach(function(i) {
			if (i.fun.click == click) {
				funbtn = i;
				return;
			}
		});
		return funbtn;
	},
	getModifiedData : function(records) {
		var me = this;
		var data = [];
		records.forEach(function(r) {
			if (!r.data.add) {
				r.data.updateUser = me.getSession().user.userName;
				r.data.updateTime = Ext.util.Format.date(new Date(),
						'Y/m/d H:i:s');
			}
			data.push(r.data);
		});
		return data;
	},
	onAdd : function(sender) {
		this.msg(sender);
	},
	onDel : function(sender) {
		this.msg(sender);
	},
	onEdit : function(sender) {
		this.msg(sender);
	},
	onSave : function(sender) {
		this.msg(sender);
	},
	onQuery : function(sender) {
		this.msg(sender);
	},
	onReset : function(sender) {
		this.msg(sender);
	},
	onExp : function(sender) {
		this.msg(sender);
	},
	onImp : function(sender) {
		this.msg(sender);
	},
	onPrint : function(sender) {
		this.msg(sender);
	},
	onFun0 : function(sender) {
		this.msg(sender);
	},
	onFun1 : function(sender) {
		this.msg(sender);
	},
	onFun2 : function(sender) {
		this.msg(sender);
	},
	onFun3 : function(sender) {
		this.msg(sender);
	},
	onFun4 : function(sender) {
		this.msg(sender);
	},
	onFun5 : function(sender) {
		this.msg(sender);
	},
	onFun6 : function(sender) {
		this.msg(sender);
	},
	onFun7 : function(sender) {
		this.msg(sender);
	},
	onFun8 : function(sender) {
		this.msg(sender);
	},
	onFun9 : function(sender) {
		this.msg(sender);
	},
	onBeforeedit : function(editor, e) {
		return this.pressedByEdit;
	},
	onBeforedrop : function(node, data, overModel, dropPosition, dropHandlers) {
		var me = this;
		dropHandlers.wait = true;
		if (me.isEdit(dropPosition)) {
			dropHandlers.processDrop();
		} else {
			dropHandlers.cancelDrop();
		}
	},
	imp : function(url) {
		var me = this;
		var win = Ext.create('WebApp.view.excel.Window');
		win.items.items[0].form.url = url;
		win.show();
	}
});