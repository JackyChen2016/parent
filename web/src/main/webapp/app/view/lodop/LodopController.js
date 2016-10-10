Ext.define('WebApp.view.lodop.LodopController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.lodop',
	className : 'WebApp.view.lodop.LodopController',
	onLogout : function(sender) {
		alert(this.className + 'onLogout');
	},
	onModify : function(sender) {
		alert(this.className + 'onModify');
	},
	onAdd : function(sender) {
		alert(this.className + 'onInsert');
	},
	onDelete : function(sender) {
		alert(this.className + 'onDelete');
	},
	onUpdte : function(sender) {
		alert(this.className + 'onUpdte');
	},
	onSave : function(sender) {
		alert(this.className + 'onSave');
	},
	onQuery : function(sender) {
	},
	onExp : function(sender) {
		alert(this.className + 'onExp');
	},
	onImp : function(sender) {
		alert(this.className + 'onImp');
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
	onHelp : function(sender) {
		alert(this.className + 'onHelp');
	}
});