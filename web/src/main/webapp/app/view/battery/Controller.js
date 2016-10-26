Ext
		.define(
				'WebApp.view.battery.Controller',
				{
					extend : 'Ext.app.ViewController',
					alias : 'controller.battery',
					batteryInfo : function(battery) {
						var me = this;
						var view = me.getView();
						var panels = view.query('panel');
						var p = panels[0];
						var img = null;
						if (battery.charging) {
							img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_11.png"/>';
							if (battery.level < 1.0) {
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery.gif"/>';
							}
						} else {
							switch (battery.level) {
							case 1.0:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_9.png"/>';
								break;
							case 0.9:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_8.png"/>';
								break;
							case 0.8:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_7.png"/>';
								break;
							case 0.7:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_6.png"/>';
								break;
							case 0.6:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_5.png"/>';
								break;
							case 0.5:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_4.png"/>';
								break;
							case 0.4:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_3.png"/>';
								break;
							case 0.3:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_2.png"/>';
								break;
							case 0.2:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_1.png"/>';
								break;
							default:
								img = '<img src="./build/development/WebApp/classic/resources/images/battery/battery_0.png"/>';
							}
						}
						p.update(img);
					},
					afterrender : function() {
						var me = this;
						var battery = navigator.battery
								|| navigator.webkitBattery
								|| navigator.mozBattery;
						me.batteryInfo(battery);
						battery.addEventListener('chargingchange', function(e) {
							me.batteryInfo(battery);
						});
						battery.addEventListener('levelchange', function(e) {
							me.batteryInfo(battery);
						});
					}
				});