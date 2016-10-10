Ext.define('WebApp.view.log.Main', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.log.LogController' ],
	alias : 'widget.log',
	store : {},
	controller : 'log',
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
		width : 80
	}, {
		header : 'IP地址',
		dataIndex : 'ip',
		locked : true
	}, {
		header : 'uri路径',
		dataIndex : 'uri',
		locked : true
	}, {
		header : 'url路径',
		dataIndex : 'url',
		locked : true
	}, {
		header : '客户端信息',
		dataIndex : 'agent',
		locked : true
	}, {
		header : '错误信息',
		dataIndex : 'error',
		locked : true
	}, {
		header : '主键',
		sortable : true,
		dataIndex : 'id',
		hidden : true
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
		beforeedit : 'onBeforeedit'
	}
});