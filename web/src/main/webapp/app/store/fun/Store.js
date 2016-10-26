Ext.define('WebApp.store.fun.Store', {
	extend : 'Ext.data.Store',
	requires : [ 'WebApp.model.fun.Model' ],
	alias : 'store.fun',
	model : 'WebApp.model.fun.Model',
	proxy : {
		type : 'ajax',
		reader : {
			type : 'json',
			rootProperty : 'data'
		}
	}
});