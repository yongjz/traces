var sample = sample || {};

sample.QRDemo = function() {
	var self = this;

	function drawQRCode($sel, id, isOuter){
		var page = isOuter? "logistics.html" : "validate.html";
		$sel.qrcode({
				"text": "http://swordstream.sinaapp.com/pages/qrdemo/"+page + "?id=" + id,
				"height": 64,
				"width:": 64,
				"imgWidth": 16,
				"imgHeight": 16,
				"src": "avatar.png"	
		});
	};
	

	sample.QRDemo.prototype.run = function() {
		this.bindEvent();
		$("#qr_area_input").val("Hello World!");
	};



	sample.QRDemo.prototype.bindEvent = function(){
		var iframeDoc = $("iframe").contents()[0];
		iframeDoc.body.innerHTML = "<div id='qr_print'></div>";
		$("#qr_btn").bind("click", function(){
			var $area = $("#qr_area");
			for(var i=0; i<25; i++){
				var qrcode = document.createElement("div");
				$area.append(qrcode);
				$(qrcode).css("margin", "10px 100px");
				var outer = document.createElement("div");
				var inner = document.createElement("div");
				$(qrcode).append(outer).append(inner);
				$(inner).css("display","inline-block");
				$(outer).css("display", "inline-block");
				drawQRCode($(outer), "string"+i, true);
				drawQRCode($(inner), "string"+i, false);
				var outerCanvas = $(outer).find("canvas")[0].toDataURL("image/png");
				var innerCanvas = $(inner).find("canvas")[0].toDataURL("image/png");

				var newGroup = iframeDoc.createElement("div");
				$(newGroup).css("margin","10px 30px").css("display","inline-block");
				$(iframeDoc.body).find("#qr_print").append(newGroup);
				newGroup.innerHTML = "<img style='display:inline-block;margin-right:20px;width:64px;height:64px' src='"+outerCanvas+"'>" +
				"<img style='display:inline-block;width:64px;height:64px' src='"+innerCanvas+"'><br>ID=string"+i ; 
				console.log(i);
			}
			$("iframe")[0].contentWindow.print();
		});
	};

};

(function($) {
	$(document).ready(function() {
		var app = new sample.QRDemo();
		app.run();
	});

}(jQuery));