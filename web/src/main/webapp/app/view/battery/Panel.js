Ext.define('WebApp.view.battery.Panel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.battery',
	controller : 'battery',
	layout : {
		type : 'vbox',
		align : 'center'
	},
	items : [ {
		xtype : 'panel',
		bodyStyle : 'font-weight:bold;font-size:14px;'
	} ],
	listeners : {
		afterrender : 'afterrender'
	}
});