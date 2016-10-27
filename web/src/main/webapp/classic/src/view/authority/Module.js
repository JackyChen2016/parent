Ext.define('WebApp.view.authority.Module', {
	extend : 'Ext.tree.Panel',
	requires : [ 'WebApp.store.module.TreeStore',
			'WebApp.view.authority.ModuleController' ],
	alias : 'widget.amodule',
	controller : 'amodule',
	store : {
		type : 'module'
	},
	title : '模块视图',
	margin : '0 2 0 2',
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
		xtype : 'treecolumn'
	}, {
		header : '名称',
		dataIndex : 'name',
		width : 220
	} ],
	listeners : {
		selectionchange : 'selectionchange'
	}
});