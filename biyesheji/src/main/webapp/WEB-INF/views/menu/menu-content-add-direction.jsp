<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src='<c:url value='resources/js/jquery.js'/>'></script>
    <script type="text/javascript">
       $(document).ready(function(){
          $("#submit").click(function(){
              $.ajax({
				   type: "POST",
				   url: "addMajor",
				   data: {
				            major_code:$("#major_code").val(),
		                    major_name:$("#major_name").val(),
						    core_curriculum: $("#core_curriculum").val(),
						    occupational_direction:$("#occupational_direction").val(),
						    goal:$("#goal").val(),
						    history:$("#history").val()
				         },
				   success: function(msg,status){
				     if(status=="success"&&msg=="true")
				     {
				        alert("数据添加成功");
				        $("#major_code").val("");
	                    $("#major_name").val("");
					    $("#core_curriculum").val("");
					    $("#occupational_direction").val("");
					    $("#goal").val("");
					    $("#history").val("");
				     }
				   }
				});
          });
       });
    </script>

  </head>
  
  <body>
    <div id="content_2_1" class="item_content">
	           <div>添加方向</div>
	       <div>
	       
	          <div>
	                                      专业代码：<input type="text" id="major_code" />
	          </div>
	          
	          <div>
	                                      方向名：<input type="text" id="major_name" />
	          </div>
	          
	          <div>
	                                      核心课程：<textarea id="core_curriculum" ></textarea>
	          </div>
	          
	          <div>
	                                     就业方向：<textarea  id="occupational_direction" ></textarea>
	          </div>
	          
	          <div>
	                                     培养目标：<textarea  id="goal" ></textarea>
	          </div>
	          
	          <div>
	                                     办学历史：<textarea  id="history" ></textarea>
	          </div>
	          
	          <div>
	              <input type="button" id="submit" value="提交" />
	          </div>
	          
	       </div>
       </div>
  </body>
</html>
