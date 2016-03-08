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
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>物流信息</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/font-icons/entypo/css/entypo.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/font-icons/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-core.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-theme.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/neon-forms.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/common/neon/assets/css/custom.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/qrdemo/qrdemo/css/qrdemo.css">

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
		<div class="main-content gray">
			<div class="item-card">
				<div class="row">
					<div class="col-xs-3 col-md-3">
						<img src="<%=request.getContextPath()%>/pages/qrdemo/milk.png" class="img-circle"
							style="width: 100%;">
					</div>
					<div class="col-xs-9 col-md-9">
						<b>${ mer_name }</b> <span class="label label-warning float-right">即将到期</span>
						<div class="text-light space-out-m-bottom font-size-s">武汉大学计算机学院</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						
						<div class="progress progress-bar-default space-out-s-bottom space-out-s-top active">
							<div class="progress-bar" role="progressbar" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100" style="width: 43%">
								<span class="sr-only">43% Complete (success)</span>
							</div>
						</div>
						<div class="font-size-s float-left">生产: ${ mer.merchandisepatchProductingdate }</div>
						<div class="font-size-s float-right">到期: ${ mer.merchandiseShelflife }</div>
					</div>
				</div>
			</div>
			<div class="timeline-centered" style="margin-top: 30px">
				<c:forEach items="${logisticsList}" var="logistics" >
					<article class="timeline-entry ">
						<div class="timeline-entry-inner">
							<div class="timeline-icon ">
								<i class="fa fa-truck"></i>
							</div>
							<div class="timeline-label">
								<h5>
									<a href="#">${ logistics.logisticsStation }</a> <span class="font-size-ss text-light float-right">${ logistics.logisticsCreatetime }</span>
								</h5>
								<p>${ logistics.logisticsInfo }</p>
							</div>
						</div>
					</article>
				</c:forEach>
				
				<article class="timeline-entry begin">
					<div class="timeline-entry-inner">
						<div class="timeline-icon" >
							<i class="glyphicon glyphicon-home"></i>
						</div>
					</div>
				</article>
			</div>
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
<script src="<%=request.getContextPath()%>/pages/qrdemo/qrdemo/js/chart-util.js"></script>
</html>