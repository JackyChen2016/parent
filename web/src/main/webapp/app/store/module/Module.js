Ext.define('WebApp.store.module.Module', {
	extend : 'Ext.data.TreeStore',
	requires : [ 'WebApp.model.module.Module' ],
	alias : 'store.module',
	model : 'WebApp.model.module.Module',
	proxy : {
		type : 'ajax',
		/*
		 * actionMethods : { create : "POST", read : "GET", update : "POST",
		 * destroy : "POST" },
		 */
		reader : {
			type : 'json',
			rootProperty : 'data'
		}
	},
	root : {}
});