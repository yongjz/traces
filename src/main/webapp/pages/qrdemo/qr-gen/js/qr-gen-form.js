var sample = sample || {};

sample.QRGenForm = function() {
	var self = this;

	sample.QRGenForm.prototype.bindEvents = function() {

	};

	sample.QRGenForm.prototype.initBeforeBind = function() {
		
	};
	
	sample.QRGenForm.prototype.initAfterBind = function() {

	};

	sample.QRGenForm.prototype.run = function() {
		this.initBeforeBind();
		this.bindEvents();
		this.initAfterBind();
	};
};

(function($) {
	$(document).ready(function() {
		var app = new sample.QRGenForm();
		app.run();
	});

}(jQuery));