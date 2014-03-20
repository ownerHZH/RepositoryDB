<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<link rel="icon"href="<c:url value='/resources/img/biaozhi.ico'/>" type="image/x-icon">
	<title>网络资源共享平台</title>
</head>
<script type="text/javascript" src="<c:url value='resources/js/jquery.js'/>"></script>
<script type="text/javascript" src='<c:url value='/resources/js/index1.js'/>'></script>
<script type="text/javascript">

function gotoTwomenu(urlstr)
{
    $("#content_iframe").attr("src",urlstr);
}
</script>

<!-- <link rel=stylesheet href="css/index1.css" type="text/css"> -->
<style type="text/css" >
   body{ margin:0 auto;padding:0; height:100%; width:1200px; margin-top:0.3px; border:0; overflow:auto; text-align: center;}
   .header{ height:20%; width:100%; margin:0 auto; padding:0; border:1px; background-image:  url('<c:url value='/resources/img/header1.gif'/>'); background-repeat:no-repeat; background-position:center;background-size:cover;}
   .footer{height:5%;width:100%; background-color:#cccccc; text-align:center;margin:0 auto; padding:0}
   .menu{width:100%;  height: 5%; background-color:#990; margin:0 auto; padding:0}
   .menu{list-style:none;color:#fff;margin-top:3px;text-align: center;}
   .menu a{ font-size:16px; font-weight:bold;cursor:pointer;line-height:30px;background-color: gray;padding-left:6px;padding-right:6px;padding-top: 5px;padding-bottom: 5px;margin-left:2px;}
   .menu a:hover{cursor:pointer;text-decoration: underline;color:blue;}
   .body{ height:70%; width:100%; background-color:#933; margin:0 auto; padding:0}
   .content_iframe{ width:100%; height:100%;overflow:auto; margin:0 auto; padding:0}
</style>
</head>

<body >

   <div id="header" class="header"></div>
   <div id="menu" class="menu">
	<c:forEach items="${menuList}" var="menu"><a onclick="gotoTwomenu('${menu.mapping_page}')">${menu.menu_level_one_name}</a></c:forEach>
    </div> 
    
    <div id="body" class="body">
        <iframe id="content_iframe" class="content_iframe" marginheight="0" marginwidth="0" hspace="0" vspace="0" frameborder="0" src="content.html"></iframe>
    </div> 
     
   <div id="footer" class="footer">@copyright 2014 auther:owner</div>
</body>
</html>
