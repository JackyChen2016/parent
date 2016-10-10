Ext.define('WebApp.view.user.InRole', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.user.InRoleController' ],
	alias : 'widget.inrole',
	store : {},
	controller : 'inrole',
	title : '已分配角色',
	margin : '5 2 0 2',
	multiSelect : true,
	columns : [ {
		header : '角色编码',
		dataIndex : 'roleNo',
		align : 'center'
	}, {
		header : '角色名',
		dataIndex : 'roleName'
	}, {
		header : '主键',
		dataIndex : 'id',
		hidden : true,
		align : 'center'
	} ],
	viewConfig : {
		plugins : [ {
			ptype : 'gridviewdragdrop',
			dragText : '请拖到未分配角色视图，以完成角色规划！',
			dragGroup : 'group2',
			dropGroup : 'group1'
		} ],
		stripeRows : true,
		enableTextSelection : true,
		listeners : {
			drop : 'onDrop',
			beforedrop : 'onBeforedrop'
		}
	}
});