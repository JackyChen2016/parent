Ext.define('WebApp.Application', {
	extend : 'Ext.app.Application',
	name : 'WebApp',
	stores : [],
	launch : function() {
		var LODOP = getLodop();
	},
	onAppUpdate : function() {
		Ext.Msg.confirm('Application Update',
				'This application has an update, reload?', function(choice) {
					if (choice === 'yes') {
						window.location.reload();
					}
				});
	}
});
