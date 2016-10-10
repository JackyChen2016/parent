Ext.define('WebApp.view.query.QueryController', {
	extend : 'WebApp.view.core.Controller',
	alias : 'controller.query',
	onAdd : function(sender) {
		rec = Ext.create('WebApp.model.query.Query', {
			logic : null,
			field : null,
			type : null,
			relation : null,
			value : null
		});
		this.getView().getStore().add(rec);
	},
	onDel : function(sender) {
		this.getView().getStore().remove(this.getView().getSelection());
	},
	onQuery : function(sender) {
		var grid = this.getView();
		var store = grid.getStore();
		var records = store.data.items;
		var data = [];
		records.forEach(function(r) {
			data.push(r.getData());
		});
		Ext.Ajax.request({
			url : sender.route,
			jsonData : Ext.encode(data),
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
					var tab = grid.ownerCt;
					grid = grid.nextSibling();
					grid.getStore().setData(obj.data);
					grid.getSelectionModel().select(0, true);
					tab.setActiveTab(grid);
				}
			}
		});
	},
	onClear : function(sender) {
		this.getView().getStore().removeAll();
	},
	onFieldSelect : function(combo, record) {
		grid = combo.up('query');
		rec = grid.getSelectionModel().getLastSelected().getData();
		grid.getStore().findRecord('id', rec.id)
				.set('type', record.get('type'));

	}
});