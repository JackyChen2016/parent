Ext.define('WebApp.view.user.User', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.user.UserController' ],
	alias : 'widget.user',
	store : {},
	controller : 'user',
	title : '用户视图',
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
		header : '用户编码',
		dataIndex : 'no',
		align : 'center',
		locked : true,
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '用户名',
		dataIndex : 'userName',
		locked : true,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '密码',
		dataIndex : 'password',
		locked : true
	}, {
		header : '姓名',
		dataIndex : 'chName',
		locked : true,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '年龄',
		dataIndex : 'age',
		align : 'right',
		editor : {
			xtype : 'numberfield',
			allowBlank : false,
			maxValue : 65,
			minValue : 18
		},
		isQuery : true,
		isQueryType : 'Int'
	}, {
		header : '住址',
		dataIndex : 'address',
		width : 400,
		editor : 'textfield',
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '手机',
		dataIndex : 'mobile',
		align : 'center',
		editor : 'textfield',
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '座机',
		dataIndex : 'telphone',
		align : 'center',
		editor : 'textfield',
		isQuery : true
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