<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/sb-admin.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="../css/plugins/morris.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

 <%
    HttpSession s = request.getSession();
 	String name=(String)s.getAttribute("user");
 	if(name==null)
 	{
 		 response.sendRedirect("login.jsp");
 		 return;
 	}
 %>
<body style="margin-top:0px;border:0px;padding:0px;">

<div class="bg-primary" style="height:60px;text-align:center;font-size:30px;font-weight:bold;line-height:60px;text-indent:10px;">精诚教育视频列表</div>
<div style="back-ground-color:white;height:1px;"></div>
<div class="container" style="margin-top:0px;">

	<div class="row">
		<div class="col-md-12">
			
			<ul class="list-group" id="vedioList">
            </ul>
		</div>
	</div>
</div>
<script src="../js/jquery-3.1.0.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-treeview.js"></script>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		//alert(location.href);
		
		var path=window.document.location.pathname;

		
		
		var v="<%=s.getAttribute("vedioList")%>";
		var t=v.replace(/\[/g, "");
		v=t.replace(/\]/g, "");
		
		var arr=v.split(',');
		var date;
		if(arr=="")
		{
			
			var msg="<li class=list-group-item><h2 class=list-group-item-heading>暂无视频，请联系管理员上传视频</h2></li>";
			$("#vedioList").append(msg);
		}
		
		for(var i=0;i<arr.length;i++)
		{
			if(arr[i].indexOf('-')>=0)
			{
				date=arr[i];
				var temp="<a class="+"\"list-group-item active\"> <h4 class = list-group-item-heading>"+arr[i]+"</h4></a>";
			}else{
				
				
				var href="view.action?date="+encodeURI(encodeURI(date))+"&param="+encodeURI(encodeURI(arr[i]));
	
				var temp="<a class=list-group-item href="+href+">"+arr[i]+"</a>";
		
			}
			
			$("#vedioList").append(temp);
		}
		
		//var folder =fso.GetFolder("../vedio");
		//alert(folder.Files.Count);
		
		
		
	});
	
</script>
</html>