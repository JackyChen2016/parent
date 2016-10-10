Ext.define('WebApp.store.fun.Fun', {
	extend : 'Ext.data.Store',
	requires : [ 'WebApp.model.fun.Fun' ],
	alias : 'store.fun',
	model : 'WebApp.model.fun.Fun',
	proxy : {
		type : 'ajax',
		reader : {
			type : 'json',
			rootProperty : 'data'
		}
	}
});