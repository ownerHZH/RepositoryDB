<%@ page language="java" import="java.util.* " pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="<c:url value='resources/js/jquery.js'/>"></script>
     <script type="text/javascript">       
        function menuclick(code)
        {
           $.ajax({
			   type: "GET",
			   dataType: "json",//返回json格式的数据
			   url: "getDataByCode",
			   data: {
			            code:code
			         },
			   success: function(data){
			     $("#name").text(data.filename+"("+data.co_name+")");
			     $("#edit").toggle(function(){
			               $(this).text("查看");
					       $("#pageoffice").attr("src","editOffice");},
					 function(){
			               $(this).text("编辑");
			               $("#pageoffice").attr("src","page-office");
			      });
			   }
		   });
        }
        
    </script>
    <style type="text/css">
       .courselist{width: 20%;height: 100%;float: left;text-align: center; margin: 0 auto;}
       .courselist ul{list-style: none;text-align: center;}
       .courselist ul li{cursor: pointer; margin: 10px;}
       .courselist ul li:HOVER{color: blue;}
       .pageoffice{width: 80%;height: auto;float: right; background-color: #cac;}
       .pageoffice iframe{width: 100%;height: 100%;margin: 0;padding: 0;border: 0;}
       .container{width: 80%;height: auto;float: right; background-color: #cac;}
       #name{ margin-left: 40%;padding-right: 10%;}
       #edit{text-decoration:underline; cursor: pointer;margin: 30px;}
       #edit:HOVER{color: blue;}
       #delete{text-decoration:underline;cursor: pointer;margin: 30px;}
       #delete:HOVER{color: blue;}
       #download{text-decoration:underline;cursor: pointer;margin: 30px;}
       #download:HOVER{color: blue;}
    </style>
  </head>
  
<body>
    <div id="courselist" class="courselist">
       <ul>
	       <c:forEach items="${curriculums}" var="curriculum">
	          <li onclick="menuclick(${curriculum.curriculum_code})">${curriculum.curriculum_name}</li>
	       </c:forEach>
       </ul>
    </div>
    
    <div class="container" id="container">
       <a id="name"></a><a id="edit">编辑</a><a id="delete">删除</a><a id="download">下载</a>
    </div> 
    
    <div class="pageoffice">
       <iframe id="pageoffice" src="page-office"></iframe>
    </div>
   
</body>
</html>
