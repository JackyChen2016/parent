Ext.define('WebApp.view.serialnumber.Main', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.serialnumber.SerialNumberController' ],
	alias : 'widget.serialnumber',
	store : {},
	controller : 'serialnumber',
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
		header : '前缀',
		dataIndex : 'prefix',
		locked : true,
		editor : 'textfield'
	}, {
		header : '后缀',
		dataIndex : 'suffix',
		locked : true,
		editor : 'textfield'
	}, {
		xtype : 'numbercolumn',
		header : '类型',
		dataIndex : 'serialType',
		locked : true,
		format : '0',
		editor : {
			xtype : 'numberfield',
			minValue : 0
		}
	}, {
		xtype : 'numbercolumn',
		header : '长度',
		dataIndex : 'length',
		locked : true,
		format : '0',
		editor : {
			xtype : 'numberfield',
			minValue : 0,
			maxValue : 10
		}
	}, {
		header : '流水日期',
		dataIndex : 'serialDate',
		locked : true,
		editor : 'textfield'
	}, {
		xtype : 'numbercolumn',
		header : '流水值',
		dataIndex : 'serialValue',
		locked : true,
		format : '0',
		editor : {
			xtype : 'numberfield',
			minValue : 0
		}
	}, {
		header : '主键',
		sortable : true,
		dataIndex : 'id',
		hidden : true
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
		beforeedit : 'onBeforeedit'
	}
});