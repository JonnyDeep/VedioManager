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
    <link href="../css/fileinput.css" rel="stylesheet">
    
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%=name %> <b class="caret"></b></a>
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
                   <!--  <li>
                        <a href="main.jsp"><i class="fa fa-fw fa-building-o"></i> xx集团</a>
                    </li> -->
                    <li class="active">
                        <a href="upload.jsp"><i class="fa fa-fw fa-arrow-up"></i> 上传视频</a>
                    </li>
                    <li>
                        <a href="delete.jsp"><i class="fa fa-fw fa-trash-o"></i> 删除视频</a>
                    </li>
                    <li>
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
                                <i class="fa fa-arrow-up"></i> <a href="upload.jsp">视频上传</a>
                            </li>
                        </ol>
                    </div>
                </div>
                
                <div style="height:680px">
                	<form enctype="multipart/form-data">
                        <label>上传视频</label>
                        <input id="file-zh" name="uploadFile" type="file" multiple>
					</form>
				</div>
            </div>
        </div>
    </div>
	 <script src="../js/jquery-3.1.0.min.js"></script>

   
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/bootstrap-treeview.js"></script>
    <script src="../js/plugins/morris/raphael.min.js"></script>
   

    <script src="../js/fileinput.min.js"></script>
    <script src="../js/locales/zh.js"></script>
</body>


<script type="text/javascript">
  
    $(document).ready(function() {
    	 var oFileInput = new FileInput();
         oFileInput.Init("file-zh","upload.action");
        });
	 
    var FileInput = function(){
        var oFile = new Object();
        oFile.Init = function(ctrlName,uploadUrl){
            var control = $('#'+ctrlName);
            control.fileinput({
                language: 'zh',
                uploadUrl: uploadUrl,
                uploadAsync: true, //默认异步上传
                showUpload: true, //是否显示上传按钮
                showRemove : true, //显示移除按钮
                showPreview : true, //是否显示预览
                showCaption: true,//是否显示标题
                browseClass: "btn btn-primary", //按钮样式
  
               
                maxFileCount:10,
                validateInitialCount:true,
                
                allowedFileExtensions : ['mp4','flv'],
            });
            control.on("fileuploaded", function (event, data, previewId, index) { 
            	//alert(JSON.stringify(data.response));
                //alert(data.response.result);
                
                if(data.response.result=="success")
                {
                	alert("文件上传成功!");
                	//window.location.href="upload.jsp";   
                }else{
                	alert("文件已经存在，请重新上传!");
                	window.location.href="upload.jsp";
                }
                
                
                
            });
        };
        return oFile;
    }
</script>
</html>