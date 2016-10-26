Ext.define('WebApp.view.module.Panel', {
	extend : 'Ext.tree.Panel',
	requires : [ 'WebApp.store.module.TreeStore',
			'WebApp.view.module.Controller' ],
	alias : 'widget.module',
	controller : 'module',
	store : {
		type : 'module'
	},
	title : '模块视图',
	margin : '5 0 0 0',
	width : '100%',
	rootVisible : false,
	plugins : {
		ptype : 'cellediting',
		clicksToEdit : 1
	},
	columns : [ {
		header : '主键',
		sortable : true,
		dataIndex : 'id',
		hidden : true
	}, {
		xtype : 'treecolumn',
		locked : true
	}, {
		header : '名称',
		dataIndex : 'name',
		locked : true,
		width : 220,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	}, {
		header : '类名',
		dataIndex : 'className',
		locked : true,
		editor : 'textfield',
		width : 250
	}, {
		header : '图标',
		dataIndex : 'iconCls',
		locked : true,
		editor : 'textfield'
	}, {
		xtype : 'checkcolumn',
		header : '叶子节点',
		dataIndex : 'leaf',
		disabled : true,
		locked : true
	}, {
		xtype : 'checkcolumn',
		header : '启用',
		dataIndex : 'enabled',
		disabled : true
	}, {
		xtype : 'checkcolumn',
		header : '删除',
		dataIndex : 'del',
		disabled : true
	}, {
		header : '备注',
		dataIndex : 'remark',
		editor : 'textfield',
		width : 300
	}, {
		header : '创建人',
		dataIndex : 'createUser',
		align : 'center'
	}, {
		header : '创建时间',
		width : 150,
		dataIndex : 'createTime',
		align : 'center'
	}, {
		header : '更新人',
		dataIndex : 'updateUser',
		align : 'center'
	}, {
		header : '更新时间',
		width : 150,
		dataIndex : 'updateTime',
		align : 'center'
	} ],
	listeners : {
		beforeedit : 'onBeforeedit',
		rowdblclick : 'rowdblclick'
	}
});