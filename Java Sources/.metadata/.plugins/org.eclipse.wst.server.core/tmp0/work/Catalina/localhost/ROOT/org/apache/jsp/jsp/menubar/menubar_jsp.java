/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.15
 * Generated at: 2017-10-10 07:29:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.menubar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menubar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/resources/css/team2Style.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://fonts.googleapis.com/earlyaccess/notosanskr.css\"/> \r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".menu {cursor:pointer}\r\n");
      out.write("body {\r\n");
      out.write("\tfont-family: 'Noto Sans KR';\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div align=\"center\" style=\"width: 85%; float: left\">\r\n");
      out.write("\t\t<div style='padding-top: 10vh'>\r\n");
      out.write("\t\t\t<a class = 'menu' onclick=\"document.location.href='/jsp/main/p_main.jsp'\"><span>メーンページへ</span></a>\r\n");
      out.write("\t\t\t<a class = 'menu' style='margin-left: 3%' onclick=\"document.location.href='/action/S_post_showList'\"><span>販売掲示板へ</span></a>\r\n");
      out.write("\t\t\t<a class = 'menu' style='margin-left: 3%' onclick=\"document.location.href='/action/B_post_showList'\"><span>購買掲示板へ</span></a>\r\n");
      out.write("\t\t\t<a class = 'menu' style='margin-left: 3%' onclick=\"document.location.href='/action/QA_post_showList.action'\"><span>Q/A掲示板へ</span></a>\r\n");
      out.write("\t\t\t<a class = 'menu' style='margin-left: 3%' onclick=\"document.location.href='/jsp/marketprice/p_mp.jsp'\"><span>平均相場を見る</span></a>\r\n");
      out.write("\t\t\t");
if(session.getAttribute("userId")!=null){
      out.write("\r\n");
      out.write("\t\t\t\t<a class = 'menu' style='margin-left: 3%' onclick=\"document.location.href='/action/User_showMyList'\"><span>マイリスト</span></a>\r\n");
      out.write("\t\t\t ");
} 
      out.write("\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div align=\"center\" style=\"width: 15%; float: left; height: 10vh; \">\r\n");
      out.write("\t\t<div style='margin-top: 3vh; margin-right: 3%;'>\r\n");
      out.write("\t\t\t");
if(session.getAttribute("userId")==null){
      out.write("\r\n");
      out.write("\t\t\t\t<button onclick=\"document.location.href='/jsp/logIn/p_logIn.jsp'\">ログイン</button >\r\n");
      out.write("\t\t\t\t<button onclick=\"document.location.href='/jsp/logIn/p_join.jsp'\">加入</button>\r\n");
      out.write("\t\t\t");
} else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<a>いらっしゃいませ、");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("様!</a><br>\t\t\t\t\r\n");
      out.write("\t\t\t\t<button onclick=\"document.location.href='/action/User_logOut'\">ログアウト</button>\t\t\r\n");
      out.write("\t\t\t\t<button  onclick=\"document.location.href='/action/User_showDetail'\">個人情報</button>\r\n");
      out.write("\t\t\t\t<a href='/action/Msg_showRMsgList' style=\"margin-right: 7%;\">メール</a>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div><br>\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\t\r\n");
      out.write("\t\t$('#footer').ready(function() {\r\n");
      out.write("\t\t\tvar contentHeight = $('#content').css('height');\r\n");
      out.write("\t\t\tcontentHeight = contentHeight.split(\"px\")[0];\t\t\r\n");
      out.write("\t\t\tcontentHeight = Number(contentHeight);\r\n");
      out.write("\t\t\tcontentHeight = contentHeight+0;\r\n");
      out.write("\t\t\tcontentHeight = String(contentHeight)+\"px\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#footer').css('margin-top',contentHeight);\r\n");
      out.write("\t\t})\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(window).resize(function(){\r\n");
      out.write("\t\t\trelocateFooter();\r\n");
      out.write("\t\t\trelocateChatingApp();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t$('#footer').ready(function() {\r\n");
      out.write("\t\t\trelocateFooter();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction relocateFooter(){\r\n");
      out.write("\t\t\tvar contentHeight = $('#content').css('height');\r\n");
      out.write("\t\t\tcontentHeight = contentHeight.split(\"px\")[0];\r\n");
      out.write("\t\t\tcontentHeight = Number(contentHeight);\r\n");
      out.write("\t\t\tcontentHeight = contentHeight+0;\r\n");
      out.write("\t\t\tcontentHeight = String(contentHeight);\r\n");
      out.write("\t\t\tcontentHeight = String(contentHeight)+\"px\";\t\t\t\r\n");
      out.write("\t\t\t$('#footer').css('margin-top',contentHeight);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#receivedChat').ready(function() {\r\n");
      out.write("\t\t\trelocateChatingApp();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction relocateChatingApp(){\r\n");
      out.write("\t\t\tvar chatAppHeight = $('#chattingApp').css('height');\r\n");
      out.write("\t\t\tchatAppHeight = chatAppHeight.split(\"px\")[0];\r\n");
      out.write("\t\t\tchatAppHeight = Number(chatAppHeight);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar chatAppPaddingTop = chatAppHeight*0.1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(chatAppPaddingTop<41){\r\n");
      out.write("\t\t\t\tchatAppPaddingTop=41;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#chattingApp').css('padding-top',chatAppPaddingTop.toString()+\"px\");\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar receivedChatHeight = chatAppHeight*0.7;\r\n");
      out.write("\t\t\tif(receivedChatHeight>343){\r\n");
      out.write("\t\t\t\treceivedChatHeight=343;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treceivedChatHeight = receivedChatHeight.toString()+\"px\";\t\t\t\r\n");
      out.write("\t\t\t$('#receivedChat').css('height',receivedChatHeight);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar chatTextHeight = chatAppHeight*0.08;\r\n");
      out.write("\t\t\tchatTextHeight = chatTextHeight.toString()+\"px\";\r\n");
      out.write("\t\t\t$('#chatText').css('height',chatTextHeight);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(chatAppHeight>535){\r\n");
      out.write("\t\t\t\tchatAppHeight=535;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$('#chattingApp').css('background-size','100% '+chatAppHeight.toString()+'px');\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar chatSendBtnParentPaadingTop = chatAppHeight*0.02;\r\n");
      out.write("\t\t\tvar chatSendBtnParent = $('#chatSendBtn').parent();\r\n");
      out.write("\t\t\t$(chatSendBtnParent).css('padding-top',chatSendBtnParentPaadingTop.toString()+'px');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
