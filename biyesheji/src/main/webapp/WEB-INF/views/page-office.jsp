<%@ page language="java" import="java.util.*,com.zhuozhengsoft.pageoffice.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page-office.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	   body{width: 100%;height: 100%;border: 0px;margin: 0;padding: 0;}
       .pageoffice{width: auto;height: 700px;}
    </style>
    
    <script type="text/javascript">
        
        function SetFullScreen() {
            document.getElementById("PageOfficeCtrl1").FullScreen = !document.getElementById("PageOfficeCtrl1").FullScreen;
        }
        
        function Save() {
            document.getElementById("PageOfficeCtrl1").WebSave();
        }
        
        //显示/隐藏标尺
        function Hidden() {
            document.getElementById("PageOfficeCtrl1").Document.ActiveWindow.ActivePane.DisplayRulers = 
            !document.getElementById("PageOfficeCtrl1").Document.ActiveWindow.ActivePane.DisplayRulers;
        }    
        
    </script>
  </head>
  
  <body>
    <div class="pageoffice" id="pageoffice">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
  </body>
</html>
