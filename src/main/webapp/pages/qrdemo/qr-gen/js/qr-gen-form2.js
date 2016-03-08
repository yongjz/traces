var sample = sample || {};

sample.QRGenForm = function() {
	var self = this;

	sample.QRGenForm.prototype.bindEvents = function() {
		$("#submit-button").bind("click", this.onSubmit);
	};

	sample.QRGenForm.prototype.initBeforeBind = function() {
		$("img").each(function(){
			var src = $(this).attr('src');
			$(this).attr('src',src.replace('../../', ''));
		});
		$("img").each(function(){
			var src = $(this).attr('src');
			$(this).attr('src',src.replace('..', 'pages'));
		});
	};
	
	sample.QRGenForm.prototype.initAfterBind = function() {

	};
	
	sample.QRGenForm.prototype.onSubmit = function() {
		//商品名称
		var merchandiseName = $("#product").val();
		//商品数量
		var merchandiseCount = $("#merchandiseCount").val();
		//受理机关编号
		var acceptanceauthorityCode = $("#shoulijiguan").val();
		//产品类别编号
		var merchandisepatchCatalogcode = $("#product_type").val();
		//价格区间，最小值
		var merchandisepatchMinprice = $("#min_Price").val();
		//价格区间，最大值
		var merchandisepatchMaxprice = $("#max_Price").val();
		//商品批号
		//product_approval
		//生产日期
		var merchandisepatchProductingdate = $("#product_gen").val();
		//过期日期
		var merchandiseShelflife = $("#product_exp").val();
		$.post("merchandise/saveMerchandisePatchInfo", 
			{ 
				merchandiseName: merchandiseName, 
				merchandiseCount: merchandiseCount,
				acceptanceauthorityCode: acceptanceauthorityCode,
				merchandisepatchCatalogcode: merchandisepatchCatalogcode,
				merchandisepatchMinprice: merchandisepatchMinprice,
				merchandisepatchMaxprice: merchandisepatchMaxprice,
				merchandisepatchProductingdate: merchandisepatchProductingdate,
				merchandiseShelflife: merchandiseShelflife
			}, 
			function(data){
				if(data === "success") {
					location.href = 'preview';
				}
			});
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