Ext.define('WebApp.view.authority.InFun', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.authority.InFunController' ],
	alias : 'widget.infun',
	store : {},
	controller : 'infun',
	title : '已分配功能',
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
			dragText : '请拖到未分配功能视图，以完成功能分配！',
			dragGroup : 'group2',
			dropGroup : 'group1'
		},
		listeners : {
			drop : 'onDrop',
			beforedrop : 'onBeforedrop'
		}
	}
});