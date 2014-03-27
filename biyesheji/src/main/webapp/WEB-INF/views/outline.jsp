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
        //课程item的点击函数       
        function menuclick(code)
        {          
           //获取点击item的详细数据
           $.ajax({
			   type: "GET",
			   dataType: "json",//返回json格式的数据
			   url: "getDataByCode",
			   data: {
			            code:code
			         },
			   success: function(data){
			      try{
			          console.log(data.filename);
			      }catch(err){
			          //工具栏隐藏
                      $("#container").css("visibility","hidden");
			          $("#pageoffice").attr("src","nofile?code="+code);
			      }
			      if(data.filename!="")			     
			      {
			         //工具栏显示
                     $("#container").css("visibility","visible");
			         //要打开的文件全路径
				     var rFile=data.location+data.filename;
				     //打开相应的文档
				     $("#pageoffice").attr("src","page-office?file="+rFile);
				     //文档名称
				     $("#name").text(data.filename+"("+data.co_name+")");
				     //编辑点击事件
				     $("#edit").toggle(function(){
				               //点击编辑
				               $(this).text("查看");
						       $("#pageoffice").attr("src","editOffice?file="+rFile);},
						 function(){
						       //点击查看
				               $(this).text("编辑");
				               $("#pageoffice").attr("src","page-office?file="+rFile);
				      });
				      $("#delete").click(function(){
				          deleteDoc(code);
				      });
				      //为下载按钮赋值 文档所在路径
				      $("#download").attr("href","${basePath}"+rFile);
			     }else
			     {
			         $("#pageoffice").attr("src","nofile?code="+code);
			     }			    
			   },
			   	error:function (XMLHttpRequest, textStatus, errorThrown)
			 	{}
		   });
        }
        
        //删除文档
        function deleteDoc(code)
        {
           $.ajax({
               type: "GET",
			   url: "deleteDoc",
			   data: {
			            code:code
			         },
			   success:function(data){
			      if(data=="true")
			      {
			        //工具栏隐藏
                    $("#container").css("visibility","hidden");
			        //跳转到上传页面 传code值
			        $("#pageoffice").attr("src","upload?code="+code);
			      }
			   }
           });
        }
    </script>
    <style type="text/css">
        body{border: 0;margin: 0;padding: 0;overflow: hidden;}
       .courselist{width: 20%;height: 100%;float: left;text-align: center; margin: 0 auto;}
       .courselist ul{list-style: none;text-align: center;}
       .courselist ul li{cursor: pointer; margin: 10px;}
       .courselist ul li:HOVER{color: blue;}
       .pageoffice{width: 80%;height: auto;float: right; background-color: #cac;}
       .pageoffice iframe{width: 100%;height: 100%;margin: 0;padding: 0;border: 0;}
       .container{width: 80%;height: auto;float: right; background-color: #cac;visibility: hidden;}
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
       <a id="name"></a><a id="edit">编辑</a><a id="delete">删除</a><a id="download" >下载</a>
    </div> 
    
    <div class="pageoffice">
       <iframe id="pageoffice" src="outlineInitial"></iframe>
    </div>
   
</body>
</html>
