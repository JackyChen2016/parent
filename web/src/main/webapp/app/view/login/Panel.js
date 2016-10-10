Ext.define('WebApp.view.login.Panel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.login',
	requires : [ 'WebApp.view.login.Controller',
			'WebApp.view.carousel.Panel' ],
	controller : 'login',
	layout : {
		type : 'vbox',
		align : 'center',
		pack : 'center'
	},
	items : [ {
		width : 800,
		height : 202,
		baseCls : 'logo-login'
	}, {
		layout : {
			type : 'hbox',
			padding : '10 10 10 10'
		},
		items : [ {
			xtype : 'carousel'
		}, {
			xtype : 'form',
			url : 'login',
			width : 300,
			padding : '65 20 20 30',
			defaultType : 'textfield',
			items : [ {
				name : 'key',
				allowBlank : false,
				emptyText : '用户名/手机/邮箱',
				cls : 'key-text'
			}, {
				name : 'password',
				inputType : 'password',
				allowBlank : false,
				emptyText : '密码',
				cls : 'password-text'
			} ],
			buttons : [ {
				text : '登录',
				formBind : true,
				listeners : {
					click : 'onLoginClick'
				}
			} ]
		} ]
	} ]
});