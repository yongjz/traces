<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>验证信息</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/pages/common/neon/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/pages/common/neon/assets/css/font-icons/entypo/css/entypo.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/pages/common/neon/assets/css/font-icons/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-core.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-theme.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-forms.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/custom.css">
<link rel="stylesheet" href="pages/qrdemo/qrdemo/css/qrdemo.css">

<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/jquery-1.11.0.min.js"></script>

<!--[if lt IE 9]><script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body class="page-body">
	<div class="page-container horizontal-menu">
		<!-- Top Bar 
		<header class="navbar navbar-fixed-top"></header>-->
		<!-- Main Content -->
		<div class="main-content">
				<div class="row">
					<div class="col-xs-12">
						<img src="pages/qrdemo/milk_detail.png"
							style="width: 100%;">
					</div>
				</div>
			<h3>${ mer.merchandiseName }</h3>
			<div class=" alert alert-danger hint-error"  style="display:none">
				<i class="fa fa-check"></i> 此商品已被他人启用
				<br> <span class="font-size-s start-date"> 启用时间：2014-12-31</span>
			</div>
			<div class=" alert alert-success hint-ok"  style="display:none">
				<i class="fa fa-check"></i> 此商品被您首次拆封
			</div>
			<table class="table">
				<tr>
					<th>保质期</th> <td>${ mer.merchandiseShelflife }</td>
				</tr>
				<tr>
					<th>生产日期</th> <td>${ mer.merchandisepatchProductingdate }</td>
				</tr>
				<tr>
					<th>制造商</th> <td>${ mer.merchandisepatchPro }</td>
				</tr>
				<tr>
					<th>销售商</th> <td>${ mer.merchandisepatchPro }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<!-- Bottom Scripts -->
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/joinable.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/resizeable.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/neon-api.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/rickshaw/vendor/d3.v3.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/lib/sage/sage.js"></script>
<script src="<%=request.getContextPath()%>/pages/common/neon/assets/js/qrcode/jquery.qrcode.min.js"></script>
<script src="pages/qrdemo/logistics/validate2.js"></script>
</html>