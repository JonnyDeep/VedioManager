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

<body>

                
                <div style="height:680px">
                	<form enctype="multipart/form-data">
                        <label>简体中文</label>
                        <input id="file-zh" name="uploadFile" type="file" multiple>
					</form>
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
                uploadAsync: false, //默认异步上传
                showUpload: true, //是否显示上传按钮
                showRemove : true, //显示移除按钮
                showPreview : true, //是否显示预览
                showCaption: true,//是否显示标题
                browseClass: "btn btn-primary", //按钮样式
  
        
                maxFileCount: 10, //表示允许同时上传的最大文件个数
                enctype: 'multipart/form-data',
                validateInitialCount:true,
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                allowedFileExtensions : ['jpg', 'png','gif','mp4','flv','rmvb','doc','txt'],
            });
        };
        return oFile;
    }
</script>
</html>