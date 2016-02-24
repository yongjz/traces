var sample = sample || {};

sample.Validate = function() {
	var self = this;

	sample.Validate.prototype.run = function() {
		this.initStatus();
		this.bindEvent();
	};
	
	sample.Validate.prototype.initStatus = function(){
		SAGE.Ajax.getJson("../../qrcode/validate", function(json){
			if(json.isOpen){
				$(".hint-ok").hide();
				$(".hint-error").show().find(".start-date").html("启用时间：" + json.dateTime);
			}
			else{
				$(".hint-ok").show();
				$(".hint-error").hide();
			}
		});
	}

	sample.Validate.prototype.bindEvent = function(){
		
	};

};

(function($) {
	$(document).ready(function() {
		var app = new sample.Validate();
		app.run();
	});

}(jQuery));