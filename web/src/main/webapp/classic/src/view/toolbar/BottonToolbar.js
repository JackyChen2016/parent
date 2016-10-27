Ext.define('WebApp.view.toolbar.BottonToolbar', {
	extend : 'Ext.toolbar.Toolbar',
	requires : [ 'WebApp.view.toolbar.BottonToolbarController',
			'WebApp.view.clock.Panel' ],
	alias : 'widget.bottontoolbar',
	controller : 'bottontoolbar',
	border : true,
	items : [ '->', {
		text : '天空蓝',
		listeners : {
			click : 'onHelp'
		}
	}, {
		text : '清新绿',
		listeners : {
			click : 'onHelp'
		}
	}, {
		text : '幻夜黑',
		listeners : {
			click : 'onHelp'
		}
	}, {
		text : '枫叶红',
		listeners : {
			click : 'onHelp'
		}
	}, '-', {
		text : '帮助',
		listeners : {
			click : 'onHelp'
		}
	}, '-', {
		text : '修改密码',
		listeners : {
			click : 'onModify'
		}
	}, {
		text : '注销',
		listeners : {
			click : 'onLogout'
		}
	}, '-', {
		xtype : 'battery'
	}, '-', {
		xtype : 'clock'
	} ]
});