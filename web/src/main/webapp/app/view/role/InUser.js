Ext.define('WebApp.view.role.InUser', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.role.InUserController' ],
	alias : 'widget.inuser',
	store : {},
	controller : 'inuser',
	title : '已分配用户',
	margin : '5 2 0 2',
	multiSelect : true,
	columns : [ {
		header : '用户编码',
		dataIndex : 'no',
		align : 'center'
	}, {
		header : '用户名',
		dataIndex : 'userName'
	}, {
		header : '主键',
		dataIndex : 'id',
		hidden : true,
		align : 'center'
	} ],
	viewConfig : {
		stripeRows : true,
		enableTextSelection : true,
		plugins : {
			ptype : 'gridviewdragdrop',
			dragText : '请拖到未分配用户视图，以完成用户规划！',
			dragGroup : 'group2',
			dropGroup : 'group1'
		},
		listeners : {
			drop : 'onDrop',
			beforedrop : 'onBeforedrop'
		}
	}
});