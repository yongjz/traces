var sample = sample || {};

sample.QRGenPreview = function() {
	var self = this;
	var CONTROLLER_QRCODE_IN = "../../qrcode/saveMerchandiseInfo/in";
	var CONTROLLER_QRCODE_OUT = "../../qrcode/saveMerchandiseInfo/out"

	sample.QRGenPreview.prototype.bindEvents = function() {
		$("#btn-generate").bind("click", this.onCreateQR);
		$("#btn-print").bind("click", this.onPrint);
	};

	sample.QRGenPreview.prototype.initBeforeBind = function() {
		var $paper = $(".doc-preview-panel .paper");
		var template =Hogan.compile($("#tmpl-qr-row").html());
		//FIXME: Fake qrcodes
		var qrcodes = [];
		for(var i = 0 ;i<25;i++){
			qrcodes.push(i);
		}
		var iterator = 0;
		var sizeInRow = 3;
		while(iterator < qrcodes.length){
			var renderObj = {};
			for(var i = 0; i< sizeInRow; i++){
				if(iterator + i >= qrcodes.length){
					break;
				}
				renderObj["in" + i] = CONTROLLER_QRCODE_IN + "/" +qrcodes[iterator + i];
				renderObj["out" + i] = CONTROLLER_QRCODE_OUT + "/" +qrcodes[iterator + i];
			}
			iterator += sizeInRow;
			$paper.append(template.render(renderObj));
		}
	};
	
	sample.QRGenPreview.prototype.initAfterBind = function() {

	};
	
	sample.QRGenPreview.prototype.onCreateQR = function(e){
		$("#preview-confirm").fadeOut("fast", function(){
			$("#generate-ok").fadeIn();
			$("#fixed-header .form-wizard .progress-indicator").css("width", "100%");
			//Check 3
			var steps = $("#fixed-header .form-wizard ul li");
			for(var i = 0 ; i<steps.length;i++){
				$(steps[i]).addClass("completed").removeClass("active");
				if(i == 2){
					$(steps[i]).addClass("active").removeClass("completed");
				}
			}
			toastr.success("成功","二维码已经为您生成完毕");
		});
	};
	
	sample.QRGenPreview.prototype.onPrint = function(e) {
		var iframeDoc = $("iframe").contents()[0];
		var template = iframeDoc.getElementById("print-template");
		template.innerHTML = $(".doc-preview-panel .paper").html();
		
		//Replace Border Size
		var borderCells = $(iframeDoc.body).find("#print-template div[class!=row]");
		var rows = $(iframeDoc.body).find("#print-template div[class=row]");
		for(var i = 0; i<borderCells.length; i++){
			if($(borderCells[i]).css("border-right-width")!=""){
				$(borderCells[i]).css("border-right-width", "3px");
			}
		}
		for(var i=0;i<rows.length;i++){
			if($(rows[i]).css("border-bottom-width")!=""){
				$(rows[i]).css("border-bottom-width", "3px");
			}
		}
		
		//Listen to load
		var loaded = 0;
		var total = $(iframeDoc.body).find("img[src!=]").length;
		$(iframeDoc.body).find("img").on("load", function(){
			loaded ++;
			if(loaded >= total){
				$("iframe")[0].contentWindow.print();
			}
		});
	};

	sample.QRGenPreview.prototype.run = function() {
		this.initBeforeBind();
		this.bindEvents();
		this.initAfterBind();
	};
};

(function($) {
	$(document).ready(function() {
		var app = new sample.QRGenPreview();
		app.run();
	});

}(jQuery));