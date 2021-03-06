<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>预览</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/font-icons/entypo/css/entypo.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/font-icons/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-core.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-theme.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-forms.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/custom.css">
<link rel="stylesheet" href="pages/qrdemo/qr-gen/css/qr-gen.css">

<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/jquery-1.11.0.min.js"></script>

<!--[if lt IE 9]><script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->

<script>
	$()
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="page-body">
	<div class="page-container horizontal-menu">
		<!-- Top Bar -->
		<header class="navbar navbar-fixed-top"></header>
		<!-- Main Content -->
		<div class="main-content">
			<div id="main-content-title">
				<div id="fixed-header">
					<div class="row">
						<div class="col-md-8 col-sm-4 clearfix">
							<h3>
								<span id="header-title-section">二维码制造</span> - <span id="header-title-menu">二维码确认</span>
							</h3>
						</div>
						<div class="col-md-4 col-sm-4 clearfix hidden-xs text-right header-button-bar">
							<div class="form-wizard font-size-ss space-out-s-top">
								<div class="steps-progress">
									<div class="progress-indicator" style="width: 50%;"></div>
								</div>

								<ul>
									<li class="completed"><a href="#step1" data-toggle="tab"><span>1</span>表单填写</a></li>
									<li class="active"><a href="#step2" data-toggle="tab"><span>2</span>二维码确认</a></li>
									<li><a href="#step3" data-toggle="tab"><span>3</span>成功/打印</a></li>
								</ul>
							</div>
						</div>
					</div>
					<hr>
				</div>
			</div>
			<div id="main-content-contents" class="row">
				<div class="col-sm-12">
					<div class="doc-preview-panel" id="preview">
						<div class="paper"></div>
						<div class="option">
							<h4 style="border-bottom: 1px solid #cccccc; padding-bottom: 10px" class="font-size-l">生成报告</h4>
							<div class="space-out-m-top">
								<div class="tile-stats tile-white tile-white-primary">
									<div class="icon" style="right: 15px; bottom: 45px">
										<i class="fa fa-qrcode"></i>
									</div>
									<div class="num">
										25 <span style="font-size: 12px">对</span>
									</div>
									<p>商品名称：XXXXX</p>
									<p>制造厂商：XXXXX</p>
								</div>
								<div id="preview-confirm">
									<h4>是否确定生成此套二维码？</h4>
									<button class="btn btn-primary" style="width: 100%" id="btn-generate">确定，写入二维码库</button>
									<button class="btn btn-white space-out-s-top" style="width: 100%">取消，返回上步页面</button>
								</div>
								<div id="generate-ok">
									<div class="well text-success">
										该套二维码已经成功生成 <strong style="float: right; font-size: 24px; margin-top: -5px"><i class="fa fa-check"></i></strong>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<button type="button" class="btn btn-white" style="width: 100%" id="btn-print">
												<i class="entypo-print"></i> 打印
											</button>
										</div>
										<div class="col-sm-4">
											<div class="btn-group" style="width:100%">
												<button type="button"  style="width:100%" class="btn btn-white dropdown-toggle" data-toggle="dropdown">
													<i class="entypo-export"></i> 导出  <span class="caret" style="margin-top:5px;float:right"></span>
												</button>
												<ul class="dropdown-menu" role="menu" style="width:100%;min-width:100px">
													<li><a href="#">PDF文件</a></li>
													<li><a href="#">Excel表格</a></li>
												</ul>
											</div>
										</div>
										<div class="col-sm-4">
											<button type="button" class="btn btn-danger" style="width: 100%">
												<i class="entypo-cancel"></i> 撤销
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<iframe width="794" height="1090" style="position:absolute; top: -11180px; left:-11120px; z-index:999" src="frame-print-template"></iframe>
		</div>
	</div>
</body>

<script type="text/template" id="tmpl-qr-row">
	<div class="row" style="border-bottom:1px dashed #d1d1d1">
       <div class="col-sm-4" style="border-right:1px dashed #d1d1d1">
           <div class="row group">
           		<div class="col-sm-6 in"><img src="{{in0}}" style="width:100%"></div>
           		<div class="col-sm-6 out"><img src="{{out0}}"  style="width:100%"></div>
           </div>
       </div>
       <div class="col-sm-4"  style="border-right:1px dashed #d1d1d1">
           <div class="row group">
           		<div class="col-sm-6 in"><img src="{{in1}}" style="width:100%"></div>
           		<div class="col-sm-6 out"><img src="{{out1}}"  style="width:100%"></div>
           </div>
       </div>
       <div class="col-sm-4">
           <div class="row group">
           		<div class="col-sm-6 in"><img src="{{in2}}" style="width:100%"></div>
           		<div class="col-sm-6 out"><img src="{{out2}}"  style="width:100%"></div>
           </div>
       </div>
    </div>
</script>
<!-- Bottom Scripts -->
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/gsap/main-gsap.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/joinable.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/resizeable.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/bootstrap-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/toastr.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/neon-api.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/neon-custom.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/lib/sage/sage.js"></script>
<script src="pages/qrdemo/qr-gen/js/qr-gen-preview2.js"></script>

</html>