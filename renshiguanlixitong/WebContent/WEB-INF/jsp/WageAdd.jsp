<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
   String path = request.getContextPath();
   String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
   /*
   @Author:Jaylan Zhou
   @Date:
   @projectName:
   @TEL:13166803607
   @QQ:764540631
   */
    
    /*
        全路径,形式如下:
        request.getScheme():获取http协议
        request.getServerName():获取本地服务器名
        request.getServerPort():获取服务器端口号
        path:访问路径
    */

%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href=" css/css/background/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="css/css/background/css/select.css" rel="stylesheet"
	type="text/css" />
<link href="js/js/background/js/laydate/need/laydate.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="js/js/background/js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/js/background/js/jquery.js"></script>
<script type="text/javascript"
	src="js/js/background/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="js/js/background/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="js/js/background/editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>

<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>


	<div class="formbody">


		<div id="usual1" class="usual">

			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">发布信息</a></li>
				</ul>
			</div>

			<div id="tab1" class="tabson">

				<div class="formtext">
					Hi，<b>${sessionScope['User']['userName']}</b>，欢迎您使用信息编辑功能！
				</div>

				<!-- form表单 -->

				<form action="wage/informationAdd" method="POST"
					onsubmit="return checkSubmit();">
					<ul class="forminfo">
						<li><label>用户姓名<b>*</b></label><div class="vocation">
							<select name="user_id" class="select3">
								<c:forEach items="${user }" var="userInfo">
									<option value="${userInfo['id'] }">${userInfo['userName'] }</option>
								</c:forEach>
							</select></div>
						</li>
						<li><label>工资月份<b>*</b></label><input id="month" 
							name="month" type="text" class="dfinput" placeholder="请填写工资月份"
							style="width: 518px;" /></li>
						<li><label>基本工资<b>*</b></label><input id="base" 
							name="base" type="text" class="dfinput" placeholder="请填写基本工资" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>
						<li><label>奖励金<b>*</b></label><input id="bonus" 
							name="bonus" type="text" class="dfinput" placeholder="请填写奖励金" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>
						<li><label>加班费<b>*</b></label><input id="overtime" 
							name="overtime" type="text" class="dfinput" placeholder="请填写加班费" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>
						<li><label>考勤扣款<b>*</b></label><input id="late" 
							name="late" type="text" class="dfinput" placeholder="请填写考勤扣款" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>
						<li><label>代扣养老金<b>*</b></label><input id="old_age" 
							name="old_age" type="text" class="dfinput" placeholder="请填写代扣养老金" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>
						<li><label>医疗保险<b>*</b></label><input id="medical" 
							name="medical" type="text" class="dfinput" placeholder="请填写医疗保险" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>
						<li><label>住房公积金<b>*</b></label><input id="house" 
							name="house" type="text" class="dfinput" placeholder="请填写住房公积金" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>
						<li><label>所得税<b>*</b></label><input id="tax" 
							name="tax" type="text" class="dfinput" placeholder="请填写所得税" onkeyup="value=value.replace(/[^\d]/g,'')"
							style="width: 518px;" /></li>	
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="添加信息" /></li>
					</ul>

				</form>
			</div>

		</div>

		<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>

		<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>





	</div>


</body>
<script type="text/javascript"> 
var time = {
		  elem: '#time',
		  format: 'YYYY-MM-DD',
		  min: '1900-01-01', //设定最小日期为当前日期
		  max: '2099-06-16', //最大日期
		  istime: true,
		  istoday: false,
		  choose: function(datas){
		     end.min = datas; //开始日选好后，重置结束日的最小日期
		     end.start = datas //将结束日的初始值设定为开始日
		  }
		};
		laydate(time);
    var checkSubmitFlg = false; 
    function checkSubmit() { 
      if (checkSubmitFlg == true) { 
         return false; 
      } 
      var month = $("#month").val();
      var base = $("#base").val();
      var bonus = $("#bonus").val();
      var overtime = $("#overtime").val();
      var late = $("#late").val();
      var oldAge = $("#oldAge").val();
      var medical = $("#medical").val();
      var house = $("#house").val();
      var tax = $("#tax").val();
		if(!$.trim(month)){
			alert('请输入工资月份!');
			return false;
		}
		if(!$.trim(base)){
			alert('请输入基本工资!');
			return false;
		}
		if(!$.trim(bonus)){
			alert('请输入奖金!');
			return false;
		}
		if(!$.trim(overtime)){
			alert('请输入加班费!');
			return false;
		}
		if(!$.trim(late)){
			alert('请输入考勤扣款!');
			return false;
		}
		if(!$.trim(old_age)){
			alert('请输入养老金!');
			return false;
		}
		if(!$.trim(medical)){
			alert('请输入医疗保险!');
			return false;
		}
		if(!$.trim(house)){
			alert('请输入住房公积金!');
			return false;
		}
		if(!$.trim(tax)){
			alert('请输入所得税!');
			return false;
		}
      checkSubmitFlg = true;
      return true; 
   } 
   document.ondblclick = function docondblclick() { 
    window.event.returnValue = false; 
   } 
   document.onclick = function doconclick() { 
       if (checkSubmitFlg) { 
         window.event.returnValue = false; 
       } 
   } 
</script>
</html>
