Ext.define('WebApp.view.lodop.Main', {
	extend : 'Ext.tab.Panel',
	requires : [ 'WebApp.view.lodop.Lodop' ],
	margin : '5 0 0 0',
	items : [ {
		xtype : 'lodop'
	} ]
});