Ext.application({
	name : 'WebApp',
	extend : 'WebApp.Application',
	requires : [ 'WebApp.view.home.Viewport' ],
	mainView : 'WebApp.view.main.Main'
});
