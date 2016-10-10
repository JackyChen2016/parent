Ext.define('WebApp.view.file.Form', {
	extend : 'Ext.form.Panel',
	alias : 'widget.file',
	padding : 5,
	url : null,
	items : [ {
		xtype : 'filefield',
		name : 'excel',
		fieldLabel : 'Excel',
		labelWidth : 50,
		msgTarget : 'side',
		allowBlank : false,
		anchor : '100%',
		buttonText : '浏览...'
	} ],
	buttons : [ {
		text : '导入',
		handler : function() {
			var form = this.up('form').getForm();
			if (form.isValid()) {
				form.submit({
					url : form.url,
					waitMsg : '导入中，请稍后...',
					success : function(form, action) {
						Ext.Msg.alert('成功', action.result.msg);
					},
					failure : function(form, action) {
						Ext.Msg.alert('错误', action.result.msg);
					}
				});
			}
		}
	} ]
});