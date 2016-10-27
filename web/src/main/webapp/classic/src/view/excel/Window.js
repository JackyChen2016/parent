Ext.define('WebApp.view.excel.Window', {
	extend : 'Ext.window.Window',
	requires : [ 'WebApp.view.file.Form' ],
	alias : 'widget.excel',
	title : "Excel导入",
	draggable : false,
	iconCls : 'win-excel',
	height : 140,
	width : 400,
	layout : "fit",
	modal : true,
	resizable : false,
	items : [ {
		xtype : 'file'
	} ]
});