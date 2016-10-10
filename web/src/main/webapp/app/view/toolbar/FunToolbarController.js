Ext.define('WebApp.view.toolbar.FunToolbarController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.funtoolbar',
	getActiveTab : function() {
		var result, tabpanels = Ext.ComponentQuery.query('tabpanel');
		if (!Ext.isEmpty(tabpanels) && !Ext.isEmpty(tabpanels[0])) {
			result = tabpanels[0].getActiveTab();
		}
		return result;
	},
	getActiveItemOnTab : function() {
		var result, activeTab = this.getActiveTab();
		if (!Ext.isEmpty(activeTab)) {
			try {
				result = activeTab.getLayout().getActiveItem();
			} catch (e) {
				result = activeTab;
			}
		}
		return result;
	},
	msg : function(sender, e) {
		Ext.Msg.show({
			title : '错误',
			message : e.message,
			buttons : Ext.Msg.OK,
			icon : Ext.Msg.ERROR,
			animateTarget : sender,
			closeAction : 'destroy'
		});
	},
	onAdd : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onAdd(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onDel : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onDel(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onEdit : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onEdit(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onSave : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onSave(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onQuery : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onQuery(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onReset : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onReset(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onExp : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onExp(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onImp : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onImp(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onPrint : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onPrint(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun0 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun0(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun1 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun1(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun2 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun2(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun3 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun3(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun4 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun4(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun5 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun5(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun6 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun6(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun7 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun7(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun8 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun8(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	},
	onFun9 : function(sender) {
		var activeItem = this.getActiveItemOnTab();
		if (!Ext.isEmpty(activeItem)) {
			try {
				activeItem.getController().onFun9(sender);
			} catch (e) {
				this.msg(sender, e);
			}
		}
	}
});