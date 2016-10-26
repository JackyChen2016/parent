Ext.define('WebApp.store.module.TreeStore', {
	extend : 'Ext.data.TreeStore',
	requires : [ 'WebApp.model.module.Model' ],
	alias : 'store.module',
	model : 'WebApp.model.module.Model',
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