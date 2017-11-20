<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8" import="java.net.*"%>
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
<body style="margin-top:0px">
    <!-- <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">xx集团</a>
            </div>
            <ul class="nav navbar-right top-nav"> -->
                <!-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li> -->
                <!-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li> -->
                <!-- <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%=name %> <b class="caret"></b></a>
                    <ul class="dropdown-menu"> -->
                       <!--  <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li> -->
                        <!-- <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav"> -->
                    <!-- <li>
                        <a href="main.jsp"><i class="fa fa-fw fa-building-o"></i> xx集团</a>
                    </li> -->
                    <!-- <li>
                        <a href="upload.jsp"><i class="fa fa-fw fa-arrow-up"></i> 上传视频</a>
                    </li>
                    <li>
                        <a href="delete.jsp"><i class="fa fa-fw fa-trash-o"></i> 删除视频</a>
                    </li>
                    <li>
                        <a href="browse.action"><i class="fa fa-fw fa-eye"></i> 查看视频</a>
                    </li>
                     -->
                   <!--  <li>
                        <a href="manager_count.html"><i class="fa fa-fw fa-wrench"></i> 账户管理</a>
                    </li> -->
                    
                <!-- </ul>
            </div>
        </nav>


        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            XX集团视频管理
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-film"></i> <a href="#">视频播放</a>
                            </li>
                        </ol>
                    </div>
                </div> -->
                <div style="margin-top:0px">
                	
                	<div class="page-header" style="margin-bottom:0px;padding:0px;margin-top:5px;color:white;border:0px;"><h1><center>精&nbsp;&nbsp;诚&nbsp;&nbsp;教&nbsp;&nbsp;育</center></h1></div>
                	<div id="a1" align="center" style="background-color:black"></div>
                </div>
            <!-- </div>
        </div>
    </div> -->

    
    <script src="../js/jquery-3.1.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/bootstrap-treeview.js"></script>

    <script type="text/javascript" src="../ckplayer/ckplayer.js" charset="utf8"></script>
	<script type="text/javascript">
    	$(document).ready(function(){
			
    		var height=$(window).height();
    		//alert(height);
    		$("#a1").css('height',height*0.75);
    		var v="<%=s.getAttribute("url")%>";
				
    		var flashvars={
    	    	f:v,
    	    	s:0,
    	    
    		};
    		var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always',wmode:'transparent',};
    		CKobject.embedSWF('../ckplayer/ckplayer.swf','a1','ckplayer_a1','80%','100%',flashvars,params);
    	});
    
	</script>
</body>
</html>
