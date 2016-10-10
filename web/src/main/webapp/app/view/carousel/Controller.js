Ext.define('WebApp.view.carousel.Controller', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.carousel',
	task : Ext.create('Ext.util.TaskRunner'),
	navigate : function(panel, direction) {
		var me = this;
		var layout = panel.getLayout();
		try {
			layout[direction]();
		} catch (e) {
			if (direction === 'prev') {
				me.navigate_d(layout, 'next');
			} else {
				me.navigate_d(layout, 'prev');
			}
		}
	},
	navigate_d : function(layout, direction) {
		var me = this;
		layout[direction]();
		me.navigate_d(layout, direction);
	},
	click : function(btn) {
		var me = this;
		me.navigate(btn.up("panel"), btn.id);
	},
	afterrender : function() {
		var me = this;
		me.task.start({
			run : me.navigate,
			args : [ me.getView(), 'next' ],
			interval : 5000,
			onError : function() {
				me.getView().getLayout().setActiveItem(0);
			}
		});
	}
});