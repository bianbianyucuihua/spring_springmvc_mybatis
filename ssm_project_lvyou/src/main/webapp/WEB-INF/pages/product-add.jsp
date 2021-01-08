<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="bathpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>数据 - AdminLTE2定制版</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


<link rel="stylesheet"
	href="${bathpath}/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${bathpath}/static/css/style.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="${bathpath}/static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				产品管理 <small>产品表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${bathpath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${bathpath}/product/findAll">产品管理</a></li>
				<li class="active">产品表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form>
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">产品信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">产品编号</div>
						<div class="col-md-4 data">
							<input id="productnum" type="text" class="form-control" name="productnum"
								placeholder="产品编号" value="">
						</div>
						<div class="col-md-2 title">产品名称</div>
						<div class="col-md-4 data">
							<input id="productname" type="text" class="form-control" name="productname"
								placeholder="产品名称" value="">
						</div>
						<div class="col-md-2 title">出发时间</div>
						<div class="col-md-4 data">
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right"
									id="datepicker" name="departuretime">
							</div>
						</div>


						<div class="col-md-2 title">出发城市</div>
						<div class="col-md-4 data">
							<input id="cityname" type="text" class="form-control" name="cityname"
								placeholder="出发城市" value="">
						</div>

						<div class="col-md-2 title">产品价格</div>
						<div class="col-md-4 data">
							<input id="productprice" type="text" class="form-control" placeholder="产品价格"
								name="productprice" value="">
						</div>

						<div class="col-md-2 title">产品状态</div>
						<div class="col-md-4 data">
							<select id="productstatus" class="form-control select2" style="width: 100%"
								name="productstatus">
								<option value="0" selected="selected">关闭</option>
								<option value="1">开启</option>
							</select>
						</div>

						<div class="col-md-2 title rowHeight2x">其他信息</div>
						<div class="col-md-10 data rowHeight2x">
							<textarea id="productdesc" class="form-control" rows="3" placeholder="其他信息"
								name="productdesc"></textarea>
						</div>

					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="button" class="btn bg-maroon" id="save">保存</button>
					<button type="button" class="btn bg-default"
						onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2020 <a
			href="http://www.itcast.cn">鸿奕科技</a>.
		</strong> All rights reserved. </footer>
		<!-- 底部导航 /-->

	</div>


	<script
		src="${bathpath}/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${bathpath}/static/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="${bathpath}/static/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${bathpath}/static/plugins/raphael/raphael-min.js"></script>
	<script
		src="${bathpath}/static/plugins/morris/morris.min.js"></script>
	<script
		src="${bathpath}/static/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${bathpath}/static/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${bathpath}/static/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="${bathpath}/static/plugins/knob/jquery.knob.js"></script>
	<script
		src="${bathpath}/static/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="${bathpath}/static/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="${bathpath}/static/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="${bathpath}/static/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${bathpath}/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="${bathpath}/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="${bathpath}/static/plugins/fastclick/fastclick.js"></script>
	<script
		src="${bathpath}/static/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${bathpath}/static/plugins/adminLTE/js/app.min.js"></script>
	<script
		src="${bathpath}/static/plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="${bathpath}/static/plugins/select2/select2.full.min.js"></script>
	<script
		src="${bathpath}/static/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="${bathpath}/static/plugins/ckeditor/ckeditor.js"></script>
	<script
		src="${bathpath}/static/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="${bathpath}/static/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="${bathpath}/static/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="${bathpath}/static/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${bathpath}/static/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="${bathpath}/static/plugins/chartjs/Chart.min.js"></script>
	<script
		src="${bathpath}/static/plugins/flot/jquery.flot.min.js"></script>
	<script
		src="${bathpath}/static/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${bathpath}/static/plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="${bathpath}/static/plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="${bathpath}/static/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="${bathpath}/static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$("#save").click(function () {
			var productnum = $("#productnum").val();
			var productname = $("#productname").val();
			var date = $("#datepicker").val();
			var cityname = $("#cityname").val();
			var productprice = $("#productprice").val();
			var productstatus = $("#productstatus").val();
			var productdesc = $("#productdesc").val();
			var sendData = {
				"productNum":productnum,
				"productName":productname,
				"departureTime":date,
				"cityName":cityname,
				"productPrice":productprice,
				"productStatus":productstatus,
				"productDesc":productdesc
			};
			console.log(sendData);
			$.ajax({
				url:"${bathpath}/product/save",
				contentType:"application/json",
				type:'POST',
				data:JSON.stringify(sendData),
				success:function (msg) {
					if(msg=="true"){
						alert("添加成功");
					}else{
						alert("添加失败");
					}
				}
			});
		});

		$(document).ready(function() {
			$('#datepicker').datepicker({
				format : "yyyy-mm-dd",
				autoclose : true,
				todayBtn : true,
				language : "zh-CN"
			});
		});
	</script>


</body>

</html>