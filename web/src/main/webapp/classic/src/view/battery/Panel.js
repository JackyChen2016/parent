Ext.define('WebApp.view.battery.Panel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.battery',
	controller : 'battery',
	items : [ {
		xtype : 'panel'
	} ],
	listeners : {
		afterrender : 'afterrender'
	}
});