Ext.define('WebApp.store.query.Relation', {
	extend : 'Ext.data.Store',
	alias : 'store.relation',
	fields : [ 'displayField', 'valueField' ],
	data : [ {
		'displayField' : '类似',
		'valueField' : 'like'
	}, {
		'displayField' : '等于',
		'valueField' : '='
	}, {
		'displayField' : '大于',
		'valueField' : '>'
	}, {
		'displayField' : '小于',
		'valueField' : '<'
	}, {
		'displayField' : '大于等于',
		'valueField' : '>='
	}, {
		'displayField' : '小于等于',
		'valueField' : '<='
	}, {
		'displayField' : '包含',
		'valueField' : 'in'
	} ]
});