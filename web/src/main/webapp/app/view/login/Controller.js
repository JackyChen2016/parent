Ext.define('WebApp.view.login.Controller',
		{
			extend : 'Ext.app.ViewController',
			alias : 'controller.login',
			onLoginClick : function(btn) {
				var me = this;
				var form = btn.up('form').getForm();
				var view = me.getView();
				if (form.isValid()) {
					form
							.submit({
								success : function(form, action) {
									var main = Ext.create({
										xtype : 'home'
									});
									var component = Ext.ComponentQuery
											.query('bottontoolbar');
									component = component[0];
									component.insert(0, '管理员：'
											+ action.result.data.user.chName);
									component = Ext.ComponentQuery
											.query('menu_tp');
									component = component[0];
									component.getStore().getRoot().appendChild(
											action.result.data.root);
									component.getStore().sort('sort', 'ASC');
									component.expandAll();
									var carousel = Ext.ComponentQuery
											.query('carousel');
									if (!Ext.isEmpty(carousel)) {
										carousel = carousel[0];
										if (!Ext.isEmpty(carousel)) {
											carousel.controller.task.destroy();
										}
									}
									window.session = action.result.data;
									view.destroy();
								},
								failure : function(form, action) {
									Ext.Msg.alert('错误', action.result.msg);
								}
							});
				}
			}
		});