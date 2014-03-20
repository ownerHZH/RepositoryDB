<%@ page language="java" import="java.util.*,com.zhuozhengsoft.pageoffice.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

/* PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//设置服务器页面
poCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
poCtrl.setTitlebar(false); //隐藏标题栏
poCtrl.setMenubar(false); //隐藏菜单栏
poCtrl.setOfficeToolbars(false);//隐藏Office工具条
//poCtrl.setCustomToolbar(false);//隐藏自定义工具栏
//添加自定义按钮
//poCtrl.addCustomToolButton("保存","Save",1);
poCtrl.addCustomToolButton("全屏", "SetFullScreen()", 4);
//设置保存页面
poCtrl.setSaveFilePage("SaveFile");
//打开Word文档
poCtrl.webOpen("resources/doc/test.doc",OpenModeType.docReadOnly,"owner");
poCtrl.setTagId("PageOfficeCtrl1");//此行必需 */
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

  </head>
  
<body>
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
    <form id="form1" >
    <div style=" width:auto; height:700px;">
        <po:PageOfficeCtrl id="PageOfficeCtrl1">
        </po:PageOfficeCtrl>
    </div>
    </form>
</body>
</html>
