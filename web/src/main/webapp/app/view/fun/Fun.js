Ext.define('WebApp.view.fun.Fun', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.fun.FunController', 'WebApp.store.fun.Fun' ],
	alias : 'widget.fun',
	store : {
		type : 'fun'
	},
	controller : 'fun',
	title : '功能视图',
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
		header : '模块名',
		dataIndex : 'module',
		align : 'center',
		locked : true,
		isQuery : true,
		isQueryType : 'String',
		renderer : function(value) {
			return value.name;
		}
	}, {
		header : '功能名',
		dataIndex : 'name',
		align : 'center',
		locked : true,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		isQuery : true,
		isQueryType : 'String'
	}, {
		header : '事件',
		dataIndex : 'click',
		align : 'center',
		locked : true,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	}, {
		header : '路径',
		dataIndex : 'url',
		align : 'left',
		locked : true,
		editor : {
			xtype : 'textfield'
		}
	}, {
		header : '图标',
		dataIndex : 'funIcon',
		align : 'center',
		locked : true,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	}, {
		header : '图标大小',
		dataIndex : 'scale',
		align : 'center',
		locked : true,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	}, {
		header : '排序',
		dataIndex : 'sort',
		align : 'center',
		format : '0',
		editor : {
			xtype : 'numberfield',
			minValue : 0
		}
	}, {
		xtype : 'checkcolumn',
		header : '开关按钮',
		dataIndex : 'enableToggle',
		align : 'center',
		disabled : true
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
		activate : 'activate'
	}
});