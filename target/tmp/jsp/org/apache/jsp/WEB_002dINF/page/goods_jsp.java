/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.3.7.v20160115
 * Generated at: 2017-09-12 13:52:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class goods_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/C:/Users/Administrator/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("file:/C:/Users/Administrator/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1503398078325L));
    _jspx_dependants.put("file:/C:/Users/Administrator/.m2/repository/org/springframework/spring-webmvc/4.0.3.RELEASE/spring-webmvc-4.0.3.RELEASE.jar", Long.valueOf(1503398086289L));
    _jspx_dependants.put("jar:file:/C:/Users/Administrator/.m2/repository/org/springframework/spring-webmvc/4.0.3.RELEASE/spring-webmvc-4.0.3.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1395839244000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"utf-8\" >\r\n");
      out.write("\t<title>大猿商城(dayuanit.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css4/reset.css\" type=\"text/css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css4/style.css\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"grey\">\r\n");
      out.write("<div id=\"head\">\r\n");
      out.write("\t<div class=\"head_top\">\r\n");
      out.write("\t\t<div class=\"wrap clearfix\">\r\n");
      out.write("\t\t\t<div class=\"leftArea\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" id=\"collection\">收藏大猿</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"rightArea\">欢迎");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_user_flag.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("来到大猿网\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"search\">\r\n");
      out.write("\t\t<div class=\"wrap\">\r\n");
      out.write("\t\t\t<div class=\"logo\">\r\n");
      out.write("\t\t\t\t<a href=\"#\"><img src=\"/images/logo.png\" alt=\"京西商城\"></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"shop_car\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<span class=\"car\"><a href=\"/car/toCart.do\">购物车</a></span>\r\n");
      out.write("\t\t\t\t<span class=\"num_text\">0</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"shop_car\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<span class=\"car\"><a href=\"/order/toOrder.do\">订单</a></span>\r\n");
      out.write("\t\t\t\t<span class=\"num_text\">0</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"bread wrap\"><a class=\"index\" href=\"/\">首页</a><em>&gt;</em><a href=\"#\">精品手机</a></div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"commodity_info wrap clearfix\">\r\n");
      out.write("\t\t<div class=\"info_left\">\r\n");
      out.write("\t\t\t<div class=\"commodity_img\"><img src=\"/images/sp.jpg\" alt=\"商品图片\"></div>\r\n");
      out.write("\t\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t\t<li class=\"imgOn\"><img src=\"/images/img_list.jpg\" alt=\"缩略图\"></li>\r\n");
      out.write("\t\t\t\t<li><img src=\"/images/img_list.jpg\" alt=\"缩略图\"></li>\r\n");
      out.write("\t\t\t\t<li><img src=\"/images/img_list.jpg\" alt=\"缩略图\"></li>\r\n");
      out.write("\t\t\t\t<li><img src=\"/images/img_list.jpg\" alt=\"缩略图\"></li>\r\n");
      out.write("\t\t\t\t<li><img src=\"/images/img_list.jpg\" alt=\"缩略图\"></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"info_right\" >\r\n");
      out.write("\t\t\t<h3 class=\"shop_name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h3>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<dl class=\"price\">\r\n");
      out.write("\t\t\t\t<dt>京西价</dt>\r\n");
      out.write("\t\t\t\t<dd><b>￥</b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.price }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t\t<dl class=\"favourable\">\r\n");
      out.write("\t\t\t\t<dt>优惠</dt>\r\n");
      out.write("\t\t\t\t<dd><span>满换购</span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.tips }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"selection\">\r\n");
      out.write("\t\t\t\t<dl class=\"address\">\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>数量</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"clearfix\" >\r\n");
      out.write("\t\t\t\t\t\t<div class=\"num_select\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.number }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"limit_num\">已卖<b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.soldNumber}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</b>件</span>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"buy\">\r\n");
      out.write("\t\t  \t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>购买</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"clearfix\" id=\"app\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"num_select\">\r\n");
      out.write("\t\t\t\t\t\t\t<span onclick=\"minus();\">-</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input  type=\"text\"  id=\"goodsNum\" name=\"goodsNum\" v-bind:value=\"a\">\r\n");
      out.write("\t\t\t\t\t\t\t<span onclick=\"plus();\">+</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<span class=\"limit_num\">件</span>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"buy_btn\" id=\"app2\">\r\n");
      out.write("\t\t\t\t<a onclick=\"addCar();\">加入购物车</a>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"goodsId\" name=\"goodsId\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"price\" name=\"price\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">\r\n");
      out.write("\t\t\t\t<span class=\"ver_line\"></span>\r\n");
      out.write("\t\t\t\t<a onclick=\"addOrder();\">立即购买</a>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t<p class=\"notice\">注意：此商品可提供普通发票，不提供增值税发票。</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-mini.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/vue.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("var vm = {};\r\n");
      out.write("var vm2 = {};\r\n");
      out.write("$(document).ready(function () {\r\n");
      out.write("    var data = { a: 1 };\r\n");
      out.write("\tvm = new Vue({\r\n");
      out.write("        el: '#app',\r\n");
      out.write("        data: data,\r\n");
      out.write("\t\tmethods: {\r\n");
      out.write("            plus: function () {\r\n");
      out.write("\t\t\t\tthis.a++;\r\n");
      out.write("            },\r\n");
      out.write("\r\n");
      out.write("            minus: function () {\r\n");
      out.write("\t\t\t\tthis.a--\r\n");
      out.write("            }\r\n");
      out.write("\t\t}\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\tfunction addCar() {\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t        url:'/car/addShopCar.do',\r\n");
      out.write("\t        type:'POST', //GET\r\n");
      out.write("\t        async:true,    //或false,是否异步\r\n");
      out.write("\t        data:{\r\n");
      out.write("\t        \tgoodsId:$('#goodsId').val(),\r\n");
      out.write("\t        \tgoodsNum:$('#goodsNum').val()\r\n");
      out.write("\t        },\r\n");
      out.write("\t        timeout:5000,    //超时时间\r\n");
      out.write("\t        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text\r\n");
      out.write("\t        beforeSend:function(xhr){\r\n");
      out.write("\t            console.log(xhr)\r\n");
      out.write("\t            console.log('发送前')\r\n");
      out.write("\t        },\r\n");
      out.write("\t        success:function(data,textStatus,jqXHR){\r\n");
      out.write("\t            var obj = data;\r\n");
      out.write("\t            alert(obj.success);\r\n");
      out.write("\t            \r\n");
      out.write("\t            if (!data.success) {\r\n");
      out.write("\t            \talert(data.message);\r\n");
      out.write("\t            \treturn;\r\n");
      out.write("\t            }\r\n");
      out.write("\t           /*  window.location.href='/car/toCart.do?goodsId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goodsId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'; */\r\n");
      out.write("\t        },\r\n");
      out.write("\t        error:function(xhr,textStatus){\r\n");
      out.write("\t            console.log('错误')\r\n");
      out.write("\t            console.log(xhr)\r\n");
      out.write("\t            console.log(textStatus)\r\n");
      out.write("\t        },\r\n");
      out.write("\t        complete:function(){\r\n");
      out.write("\t            console.log('结束')\r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addOrder() {\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t        url:'/order/addOrder.do',\r\n");
      out.write("\t        type:'POST', //GET\r\n");
      out.write("\t        async:true,    //或false,是否异步\r\n");
      out.write("\t        data:{\r\n");
      out.write("\t        \tgoodsId:$('#goodsId').val(),\r\n");
      out.write("\t        \tgoodsNum:$('#goodsNum').val(),\r\n");
      out.write("\t        \tprice:$('#price').val()\r\n");
      out.write("\t        },\r\n");
      out.write("\t        timeout:5000,    //超时时间\r\n");
      out.write("\t        dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text\r\n");
      out.write("\t        beforeSend:function(xhr){\r\n");
      out.write("\t            console.log(xhr)\r\n");
      out.write("\t            console.log('发送前')\r\n");
      out.write("\t        },\r\n");
      out.write("\t        success:function(data,textStatus,jqXHR){\r\n");
      out.write("\t            var obj = data;\r\n");
      out.write("\t            alert(obj.success);\r\n");
      out.write("\t            \r\n");
      out.write("\t            if (!data.success) {\r\n");
      out.write("\t            \talert(data.message);\r\n");
      out.write("\t            \treturn;\r\n");
      out.write("\t            }\r\n");
      out.write("\t           window.location.href='/order/toOrder.do?goodsId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goodsId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'; \r\n");
      out.write("\t        },\r\n");
      out.write("\t        error:function(xhr,textStatus){\r\n");
      out.write("\t            console.log('错误')\r\n");
      out.write("\t            console.log(xhr)\r\n");
      out.write("\t            console.log(textStatus)\r\n");
      out.write("\t        },\r\n");
      out.write("\t        complete:function(){\r\n");
      out.write("\t            console.log('结束')\r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction plus() {\r\n");
      out.write("\t    vm.plus();\r\n");
      out.write("\t    alert(vm.a);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("    function minus() {\r\n");
      out.write("\r\n");
      out.write("\t    if (vm.a <= 1) {\r\n");
      out.write("\t        return false;\r\n");
      out.write("\t\t}\r\n");
      out.write("        vm.minus();\r\n");
      out.write("\t    alert(vm.a);\r\n");
      out.write("    }\r\n");
      out.write("\t</script>\t\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\t<p>慕课简介|慕课公告| 招纳贤士| 联系我们|客服热线：400-675-1234</p>\r\n");
      out.write("\t<p>Copyright © 2006 - 2014 慕课版权所有   京ICP备09037834号   京ICP证B1034-8373号   某市公安局XX分局备案编号：123456789123</p>\r\n");
      out.write("\t<div class=\"credit_rating\">\r\n");
      out.write("\t\t<a href=\"#\"><img src=\"/images/pj.jpg\" alt=\"信用评价\"></a>\r\n");
      out.write("\t\t<a href=\"#\"><img src=\"/images/pj.jpg\" alt=\"信用评价\"></a>\r\n");
      out.write("\t\t<a href=\"#\"><img src=\"/images/pj.jpg\" alt=\"信用评价\"></a>\r\n");
      out.write("\t\t<a href=\"#\"><img src=\"/images/pj.jpg\" alt=\"信用评价\"></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/page/goods.jsp(22,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty login_user_flag }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<a href=\"/user/toLogin.do\">[登录]</a><a href=\"/user/toRegist.do\">[免费注册]</a>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
