<%@ page language="java" import="java.util.*,com.zhuozhengsoft.pageoffice.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'content.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
        
        function menuclick()
        {
           alert('string');
        }
        
    </script>
    <style type="text/css">
       .courselist{width: 20%;height: 100%;float: left;text-align: center; margin: 0 auto;}
       .courselist ul{list-style: none;text-align: center;}
       .courselist ul li{cursor: pointer; margin: 10px;}
       .courselist ul li:HOVER{color: blue;}
       .pageoffice{width: 80%;height: 700px;float: right;}
    </style>
  </head>
  
<body>
    <div id="courselist" class="courselist">
       <ul>
	       <c:forEach items="${curriculums}" var="curriculum">
	          <li onclick="menuclick()">${curriculum.curriculum_name}</li>
	       </c:forEach>
       </ul>
    </div>
    
    <div class="pageoffice">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
</body>
</html>
