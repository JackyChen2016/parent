Ext.define('WebApp.model.query.Query', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'logic',
		type : 'string'
	}, {
		name : 'field',
		type : 'string'
	}, {
		name : 'relation',
		type : 'string'
	}, {
		name : 'value',
		type : 'string'
	} ]
});