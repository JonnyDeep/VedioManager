<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
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
<body>
    <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">精诚教育公司</a>
            </div>
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%=s.getAttribute("user") %> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <!-- <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li> -->
                        <li>
                            <a href="logout.action"><i class="fa fa-fw fa-power-off"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <!-- <li>
                        <a href="main.jsp"><i class="fa fa-fw fa-building-o"></i> xx集团</a>
                    </li> -->
                    <li>
                        <a href="upload.jsp"><i class="fa fa-fw fa-arrow-up"></i> 上传视频</a>
                    </li>
                    <li>
                        <a href="delete.jsp"><i class="fa fa-fw fa-trash-o"></i> 删除视频</a>
                    </li>
                    <li class="active">
                        <a href="browse.action"><i class="fa fa-fw fa-eye"></i> 查看视频</a>
                    </li>
                </ul>
            </div>
        </nav>


        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            	精诚教育公司视频管理
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-building-o"></i> <a href="#">精诚教育公司</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-eye"></i> <a href="browse.jsp">查看视频</a>
                            </li>
                        </ol>
                    </div>
                </div>
                
                <div class="row">
                	<ul class="list-group" id="vedioList">
                	</ul>
                </div>
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
		if(arr=="")
		{
			
			var msg="<li class=list-group-item><h2 class=list-group-item-heading>暂无视频，请联系管理员上传视频</h2></li>";
			$("#vedioList").append(msg);
		}
		var date;
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
	
	function oncheck(name){
		alert(name);
	}
</script>
</html>