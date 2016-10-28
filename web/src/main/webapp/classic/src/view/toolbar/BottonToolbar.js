Ext.define('WebApp.view.toolbar.BottonToolbar', {
	extend : 'Ext.toolbar.Toolbar',
	requires : [ 'WebApp.view.toolbar.BottonToolbarController',
			'WebApp.view.clock.Panel' ],
	alias : 'widget.bottontoolbar',
	controller : 'bottontoolbar',
	border : true,
	items : [ '->', {
		text : '天空蓝',
		theme : 'WebApp-all',
		listeners : {
			click : 'onTheme'
		}
	}, {
		text : '清新绿',
		theme : 'theme-neptune',
		listeners : {
			click : 'onTheme'
		}
	}, {
		text : '幻夜黑',
		theme : 'theme-aria',
		listeners : {
			click : 'onTheme'
		}
	}, {
		text : '枫叶红',
		theme : 'theme-crisp',
		listeners : {
			click : 'onTheme'
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