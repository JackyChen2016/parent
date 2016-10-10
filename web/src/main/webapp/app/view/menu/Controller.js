Ext.define('WebApp.view.menu.Controller', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.menu_tp',
	select : function(sender, record, index) {
		var itemId = 'item_' + index;
		var title = record.get('text');
		var className = record.get('className');
		var iconCls = record.get('iconCls');
		if (!Ext.isEmpty(className)) {
			var component = Ext.ComponentQuery.query('tabpanel');
			if (!Ext.isEmpty(component)) {
				component = component[0];
				var item = component.getComponent(itemId);
				if (Ext.isEmpty(item)) {
					item = Ext.create(className, {
						itemId : itemId,
						title : title,
						closable : true,
						iconCls : iconCls,
						record : record
					});
					component.add(item);
					component.setActiveItem(item);
					component = item.items.items[1];
					if (!Ext.isEmpty(component)) {
						var columns = component.columns;
						var a = new Array();
						Ext.each(columns, function(column) {
							if (column.isQuery) {
								var combobox = {};
								combobox.displayField = column.text;
								combobox.valueField = column.dataIndex;
								combobox.type = column.queryType;
								a.push(combobox);
							}
						});
						var query = item.query('query')[0];
						if (!Ext.isEmpty(query)) {
							Ext.each(query.columns, function(column) {
								if (column.dataIndex == 'field') {
									column.getEditor().setStore(
											Ext.create(
													'WebApp.store.query.Field',
													{
														data : a
													}));
								}
							});
						}
					}
				} else {
					component.setActiveItem(item);
				}
			}
		}
	}
});