Ext.define('WebApp.view.log.LogController', {
	extend : 'WebApp.view.core.Controller',
	alias : 'controller.log',
	className : 'WebApp.view.log.LogController',
	onQuery : function(sender) {
		var grid = this.getView();
		Ext.Ajax.request({
			url : sender.route,
			jsonData : [],
			success : function(response, opts) {
				obj = Ext.decode(response.responseText);
				title = "提示";
				icon = Ext.MessageBox.info;
				if (!obj.success) {
					title = "错误提示";
					icon = Ext.MessageBox.ERROR;
					Ext.Msg.show({
						title : title,
						msg : obj.msg,
						buttons : Ext.MessageBox.OK,
						animateTarget : this,
						icon : icon
					});
				} else {
					grid.getStore().setData(obj.data);
				}
			}
		});
	}
});