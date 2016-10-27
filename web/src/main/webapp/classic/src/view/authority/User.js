Ext.define('WebApp.view.authority.User', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.authority.UserController' ],
	alias : 'widget.auser',
	store : {},
	controller : 'auser',
	title : '用户视图',
	margin : '0 2 0 2',
	width : '100%',
	plugins : {
		ptype : 'cellediting',
		clicksToEdit : 1
	},
	columns : [ {
		header : '用户编码',
		dataIndex : 'no',
		align : 'center'
	}, {
		header : '用户名',
		dataIndex : 'userName'
	}, {
		header : '姓名',
		dataIndex : 'chName'
	}, {
		header : '主键',
		dataIndex : 'id',
		hidden : true,
		align : 'center'
	} ],
	viewConfig : {
		// 在表格中显示斑马线
		stripeRows : true,
		// 可以复制单元格文字
		enableTextSelection : true
	},
	listeners : {
		selectionchange : 'selectionchange'
	}
});