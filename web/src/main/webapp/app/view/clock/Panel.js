Ext.define('WebApp.view.clock.Panel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.clock',
	controller : 'clock',
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