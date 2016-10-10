Ext.define('WebApp.store.query.Logic', {
	extend : 'Ext.data.Store',
	alias : 'store.logic',
	fields : [ 'displayField', 'valueField' ],
	data : [ {
		'displayField' : '并且',
		'valueField' : 'and'
	}, {
		'displayField' : '或者',
		'valueField' : 'or'
	} ]
});