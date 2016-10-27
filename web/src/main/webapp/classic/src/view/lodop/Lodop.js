Ext.define('WebApp.view.lodop.Lodop', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.lodop.LodopController' ],
	alias : 'widget.lodop',
	controller : 'lodop',
	store : {},
	title : '报表视图',
	margin : '5 0 0 0',
	width : '100%',
	columns : [ {
		xtype : 'rownumberer',
		text : '序号',
		width : 80,
		query : false
	}, {
		header : '主键',
		dataIndex : 'id',
		hidden : true,
		align : 'center',
		locked : true,
		query : false
	}, {
		header : '报表编码',
		dataIndex : 'no',
		align : 'center',
		locked : true,
		query : true,
		queryType : 'String'
	}, {
		header : '报表名称',
		dataIndex : 'name',
		locked : true,
		query : true,
		queryType : 'String',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	}, {
		xtype : 'checkcolumn',
		header : '默认模板',
		query : true,
		locked : true,
		dataIndex : 'def'
	}, {
		header : '备注',
		dataIndex : 'remark',
		query : true,
		editor : 'textfield'
	}, {
		header : '创建人',
		dataIndex : 'createUser',
		query : true,
		align : 'center'
	}, {
		header : '创建时间',
		width : 150,
		dataIndex : 'createTime',
		query : true,
		align : 'center'
	}, {
		header : '更新人',
		dataIndex : 'updateUser',
		query : true,
		align : 'center'
	}, {
		header : '更新时间',
		width : 150,
		dataIndex : 'updateTime',
		query : true,
		align : 'center'
	} ],
	viewConfig : {
		// 在表格中显示斑马线
		stripeRows : true,
		// 可以复制单元格文字
		enableTextSelection : true
	},
	plugins : {
		ptype : 'cellediting'
	}
});