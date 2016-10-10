Ext.define('WebApp.ux.data.proxy.Format', {
	extend : 'Ext.data.proxy.Ajax',
	alias : 'proxy.format',
	reader : {
		type : 'json',
		root : 'data',
		messageProperty : 'msg'
	},
	writer : {
		type : 'json',
		encode : true,
		root : 'data',
		// 是否允许提交单个记录
		allowSingle : false
	}
});