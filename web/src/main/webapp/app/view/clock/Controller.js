Ext.define('WebApp.view.clock.Controller', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.clock',
	task : Ext.create('Ext.util.TaskRunner'),
	week : [ '星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
	updateClock : function(week, p_date) {
		var date = new Date();
		p_date.update('&nbsp;&nbsp;&nbsp;' + Ext.Date.format(date, 'Y/m/d')
				+ '<br>' + week[date.getDay()] + ' '
				+ Ext.Date.format(date, 'H:i:s'));
	},
	afterrender : function() {
		var me = this;
		var view = me.getView();
		var panels = view.query('panel');
		var p_date = panels[0];
		me.task.start({
			run : me.updateClock,
			args : [ me.week, p_date ],
			interval : 1000
		});
	}
});