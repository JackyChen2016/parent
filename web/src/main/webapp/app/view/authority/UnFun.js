Ext.define('WebApp.view.authority.UnFun', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.authority.UnFunController' ],
	alias : 'widget.unfun',
	store : {},
	controller : 'unfun',
	title : '未分配功能',
	margin : '0 2 0 2',
	multiSelect : true,
	columns : [ {
		header : '功能名',
		dataIndex : 'name',
		align : 'center'
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
			dragText : '请拖到已分配功能视图，以完成功能分配！',
			dragGroup : 'group1',
			dropGroup : 'group2'
		},
		listeners : {
			drop : 'onDrop',
			beforedrop : 'onBeforedrop'
		}
	}
});