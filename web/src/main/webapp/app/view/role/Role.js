Ext.define('WebApp.view.role.Role', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.role.RoleController' ],
	alias : 'widget.role',
	store : {},
	controller : 'role',
	title : '角色视图',
	margin : '5 0 0 0',
	width : '100%',
	multiSelect : true,
	plugins : {
		ptype : 'cellediting',
		clicksToEdit : 1
	},
	columns : [ {
		xtype : 'rownumberer',
		text : '序号',
		width : 80,
		isQuery : false
	}, {
		header : '角色编码',
		dataIndex : 'roleNo',
		align : 'center',
		locked : true,
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '角色名',
		dataIndex : 'roleName',
		locked : true,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '主键',
		dataIndex : 'id',
		hidden : true,
		align : 'center',
		locked : true,
		isQuery : false
	}, {
		xtype : 'checkcolumn',
		dataIndex : 'add',
		hidden : true
	}, {
		xtype : 'checkcolumn',
		header : '启用',
		dataIndex : 'enabled',
		disabled : true
	}, {
		xtype : 'checkcolumn',
		header : '删除',
		disabled : true,
		dataIndex : 'del',
		isQuery : true
	}, {
		header : '备注',
		dataIndex : 'remark',
		editor : 'textfield',
		isQuery : true
	}, {
		header : '创建人',
		dataIndex : 'createUser',
		align : 'center',
		isQuery : true
	}, {
		header : '创建时间',
		width : 150,
		dataIndex : 'createTime',
		align : 'center',
		isQuery : true
	}, {
		header : '更新人',
		dataIndex : 'updateUser',
		align : 'center',
		isQuery : true
	}, {
		header : '更新时间',
		width : 150,
		dataIndex : 'updateTime',
		align : 'center',
		isQuery : true
	} ],
	viewConfig : {
		// 在表格中显示斑马线
		stripeRows : true,
		// 可以复制单元格文字
		enableTextSelection : true
	},
	listeners : {
		beforeedit : 'onBeforeedit',
		rowdblclick : 'rowdblclick'
	}
});