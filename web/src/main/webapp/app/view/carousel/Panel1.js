Ext.define('WebApp.view.carousel.Panel1', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.carousel1',
	controller : 'carousel',
	width : 500,
	height : 200,
	layout : 'card',
	items : [ {
		id : 'card-0',
		baseCls : 'china'
	}, {
		id : 'card-1',
		baseCls : 'usa'
	}, {
		id : 'card-2',
		baseCls : 'italia'
	} ],
	bbar : [ '->', {
		id : 'prev',
		iconCls : 'Redo',
		handler : 'click'
	}, {
		id : 'next',
		iconCls : 'Undo',
		handler : 'click'
	} ],
	listeners : {
		afterrender : 'afterrender'
	}
});