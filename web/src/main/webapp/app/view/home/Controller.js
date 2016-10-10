Ext
		.define(
				'WebApp.view.home.Controller',
				{
					extend : 'Ext.app.ViewController',
					alias : 'controller.home',
					tabchange : function(sender, newCard) {
						var record = newCard.record;
						if (!Ext.isEmpty(record)) {
							var component = Ext.ComponentQuery
									.query('funtoolbar');
							if (!Ext.isEmpty(component)) {
								component = component[0];
								component.removeAll();
								var funs = record.get('funList');
								for (i in funs) {
									var fun = funs[i];
									var pressed = false;
									if (fun.enableToggle) {
										try {
											pressed = newCard.getActiveTab()
													.getController().pressedByEdit;
										} catch (e) {
											pressed = newCard.getController().pressedByEdit;
										}
									}
									var btn = Ext.create('Ext.button.Button', {
										fun : fun,
										tooltip : fun.name,
										scale : fun.scale,
										iconCls : fun.icon,
										enableToggle : fun.enableToggle,
										route : fun.url,
										pressed : pressed
									});
									btn.addListener('click', fun.click,
											component.getController());
									component.add(btn);
								}
							}
						}
					},
					remove : function(sender) {
						if (sender.items.getCount() == 0) {
							component = Ext.ComponentQuery.query('funtoolbar');
							if (!Ext.isEmpty(component)) {
								component = component[0];
								component.removeAll();
							}
						}
					}
				});
