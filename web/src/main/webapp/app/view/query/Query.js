Ext.define('WebApp.view.query.Query', {
	extend : 'Ext.grid.Panel',
	requires : [ 'WebApp.view.query.QueryController' ],
	alias : 'widget.query',
	controller : 'query',
	store : {},
	selType : "checkboxmodel",
	title : '查询面板',
	margin : '5 0 0 0',
	collapsible : true,
	titleCollapse : true,
	enableColumnHide : false,
	enableColumnMove : false,
	enableColumnResize : false,
	enableLocking : false,
	sortableColumns : false,
	width : '100%',
	columns : [ {
		header : '逻辑运算符',
		dataIndex : 'logic',
		align : 'center',
		width : '10%',
		editor : {
			xtype : 'combobox',
			// 开启自动匹配
			typeAhead : true,
			allowBlank : false,
			displayField : 'displayField',
			valueField : 'valueField',
			store : Ext.create('WebApp.store.query.Logic')
		}
	}, {
		header : '字段',
		dataIndex : 'field',
		width : '15%',
		editor : {
			xtype : 'combobox',
			// 开启自动匹配
			typeAhead : true,
			allowBlank : false,
			displayField : 'displayField',
			valueField : 'valueField',
			listeners : {
				select : 'onFieldSelect'
			}
		}
	}, {
		header : '类型',
		dataIndex : 'type',
		hidden : true,
		width : '15%'
	}, {
		header : '关系运算符',
		dataIndex : 'relation',
		align : 'center',
		width : '10%',
		editor : {
			xtype : 'combobox',
			// 开启自动匹配
			typeAhead : true,
			allowBlank : false,
			displayField : 'displayField',
			valueField : 'valueField',
			store : Ext.create('WebApp.store.query.Relation')
		}
	}, {
		header : '值',
		dataIndex : 'value',
		width : '45%',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	} ],
	viewConfig : {
		stripeRows : true
	},
	plugins : {
		ptype : 'cellediting',
		clicksToEdit : 1
	}
});