Ext.define('WebApp.model.serialnumber.SerialNumber', {
	extend : 'WebApp.model.core.Model',
	alias : 'viewmodel.serialnumber',
	fields : [ {
		name : 'prefix',
		type : 'string'
	}, {
		name : 'suffix',
		type : 'string'
	}, {
		name : 'serialType',
		type : 'int'
	}, {
		name : 'length',
		type : 'int'
	}, {
		name : 'serialDate',
		type : 'string'
	}, {
		name : 'serialValue',
		type : 'int'
	} ]
});