/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.19
 * Generated at: 2012-02-19 13:14:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class configure_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Diagnosis Setting</title>\r\n");
      out.write("<link href=\"css/configure.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"/favicon.ico\" />\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\"\r\n");
      out.write("\tsrc=\"js/jquery-1.6.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/JSON2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("\t$.get('FileQuery', function(data, textStatus) {\r\n");
      out.write("\t\t// this will give us an array of objects\r\n");
      out.write("\t\tvar files = JSON.parse(data);\r\n");
      out.write("\t\t$(\"#filecheck\").empty();\r\n");
      out.write("\t\t// iterate over public_tweets\r\n");
      out.write("\t\tfor ( var x = 0; x < files.length; x++) {\r\n");
      out.write("\t\t\tvar fileName = files[x];\r\n");
      out.write("\t\t\tvar file = '<input type=\"checkbox\" name=\"' + fileName +'\" />'\r\n");
      out.write("\t\t\t\t\t+ fileName + '<br>';\r\n");
      out.write("\t\t\t$(\"#filecheck\").prepend(file);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}, 'text');\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction getFiles() {\r\n");
      out.write("\t\t$.get('FileQuery', function(data, textStatus) {\r\n");
      out.write("\t\t\t// this will give us an array of objects\r\n");
      out.write("\t\t\tvar files = JSON.parse(data);\r\n");
      out.write("\t\t\t$(\"#filecheck\").empty();\r\n");
      out.write("\t\t\t// iterate over public_tweets\r\n");
      out.write("\t\t\tfor ( var x = 0; x < files.length; x++) {\r\n");
      out.write("\t\t\t\tvar fileName = files[x];\r\n");
      out.write("\t\t\t\tvar file = '<input type=\"checkbox\" name=\"' + fileName +'\" />'\r\n");
      out.write("\t\t\t\t\t\t+ fileName + '<br>';\r\n");
      out.write("\t\t\t\t$(\"#filecheck\").prepend(file);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}, 'text');\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar req;\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction ajaxFunction() {\r\n");
      out.write("\t\tvar url = \"HandleFileUpload\";\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treq = new XMLHttpRequest();\r\n");
      out.write("\t\treq.onreadystatechange = checkFileUploadStatus;\r\n");
      out.write("\r\n");
      out.write("\t\ttry {\r\n");
      out.write("\t\t\treq.open(\"GET\", url, true);\r\n");
      out.write("\t\t} catch (e) {\r\n");
      out.write("\t\t\talert(e);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treq.send(null);\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkFileUploadStatus() {\r\n");
      out.write("\t\tif (req.readyState == 4){\r\n");
      out.write("\t\t\t  if (req.status == 200){\r\n");
      out.write("\t\t\t  \tvar xml = req.responseText;\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t  \tif (xml == \"tryagain\") {\r\n");
      out.write("\t\t\t  \t\t\r\n");
      out.write("\t\t\t  \t\twindow.setTimeout(\"ajaxFunction();\", 100);\r\n");
      out.write("\t\t\t  \t}\r\n");
      out.write("\t\t\t  \telse if (xml == \"uploaddone\") {\r\n");
      out.write("\t\t\t  \t\tgetFiles();\r\n");
      out.write("\t\t\t  \t}\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <br /> \r\n");
      out.write("\t<br /> \r\n");
      out.write("\t<br /> \r\n");
      out.write("\t<br /> \r\n");
      out.write("\t<br /> \r\n");
      out.write(" \t\r\n");
      out.write(" \r\n");
      out.write("\t<div id=\"container\"> \r\n");
      out.write("\r\n");
      out.write("\t  <form id=\"form1\" action=\"Diagnoser\" method=\"post\"> \r\n");
      out.write("         \r\n");
      out.write("         \t \r\n");
      out.write("            \r\n");
      out.write("          <!-- uploaded file list -->\r\n");
      out.write("            <div id=\"uploadarea\">\r\n");
      out.write("            <h4><b>I. Upload the data files for diagnosing</b></h4> \r\n");
      out.write("            <br />\r\n");
      out.write("\t\t\t<fieldset2> \r\n");
      out.write("               <legend><b>List of data files uploaded</b> </legend>\r\n");
      out.write("               <p>Please select your data files from the list below</p>\r\n");
      out.write("\t\t\t\t<div id=\"filecheck\"></div>\r\n");
      out.write("               <p>If no files uploaded before, use the following upload button for uploading</p>      \t\t\t   \r\n");
      out.write(" \t\t\t</fieldset2> \r\n");
      out.write("        </div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <div id=\"parameterarea\">\r\n");
      out.write("            <h4><b>II. Define the parameters for diagnosing</b></h4>\r\n");
      out.write("            <br />\r\n");
      out.write("            <fieldset1> \r\n");
      out.write("            <legend><b>Course list</b></legend>\r\n");
      out.write("\t\t\t<p> \r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"course\" class=\"styled\" / value=\"1\" />\r\n");
      out.write("\t\t\t\tCourse 1 <br />\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"course\" class=\"styled\" value=\"2\" /> Course\r\n");
      out.write("\t\t\t\t2<br />\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"course\" class=\"styled\" value=\"3\" /> Course\r\n");
      out.write("\t\t\t\t3<br />\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"course\" class=\"styled\" value=\"4\" /> Course\r\n");
      out.write("\t\t\t\t4<br />\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"course\" class=\"styled\" value=\"5\" /> Course\r\n");
      out.write("\t\t\t\t5<br />\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t</p> \r\n");
      out.write("\t\t\t</fieldset1> \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("\t        <fieldset> \r\n");
      out.write("\t\t\t\t<legend><b>Diagnosing parameters</b></legend> \r\n");
      out.write("                <!--\r\n");
      out.write("\t\t\t\t<p class=\"first\"> \r\n");
      out.write("\t\t\t\t\t<label for=\"name\">Period</label> From <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tname=\"period_from\" id=\"name\" style=\"width: 70px\" /> to <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"text\" name=\"period_to\" id=\"name\" style=\"width: 70px\" /> \r\n");
      out.write("\t\t\t\t</p> \r\n");
      out.write("                -->\r\n");
      out.write("\t\t\t\t<p class=\"first\"> \r\n");
      out.write("\t\t\t\t\t<label for=\"name\">CP-5 percentage_groupsize_most:</label> \r\n");
      out.write("                  <input type=\"text\" name=\"p1\" id=\"name\" size=\"10\" /> % <br/>\r\n");
      out.write("                    <i>i.e. the percentage of the size of a group defining relative majority</i>\r\n");
      out.write("\t\t\t\t</p> \r\n");
      out.write("\t\t\t\t<p> \r\n");
      out.write("\t\t\t\t\t<label for=\"email\">CP-5 percentage_avegroupfeedback_large:</label> \r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"p2\" id=\"email\" size=\"30\" /> % <br/>\r\n");
      out.write("                    <i>i.e. the percentage of the average number of feedback by all groups for defining relatively large number of feedback produced by a group</i>\r\n");
      out.write("\t\t\t\t</p> \r\n");
      out.write("\t\t\t\t<p> \r\n");
      out.write("\t\t\t\t\t<label for=\"web\">CP-6 grouppost_few:</label> \r\n");
      out.write("                    <input type=\"text\" name=\"p3\" id=\"web\" size=\"30\" /> <br />\r\n");
      out.write("                    <i>i.e. the number of posts that can be defined as relatively few for a group project</i>\r\n");
      out.write("\t\t\t\t</p> \r\n");
      out.write("\t\t\t\t<p> \r\n");
      out.write("\t\t\t\t\t<label for=\"web\">CP-6 percentage_grouppost_most:</label> \r\n");
      out.write("                    <input type=\"text\" name=\"p4\" id=\"web\" size=\"30\" /> % <br />\r\n");
      out.write("                    <i>i.e. the percentage of the overall number of posts made by a group for defining relative majority</i>\r\n");
      out.write("\t\t\t\t</p> \r\n");
      out.write("\t\t\t\t<p> \r\n");
      out.write("\t\t\t\t\t<label for=\"web\">CP-6 percentage_groupsize_most:</label> \r\n");
      out.write("                    <input type=\"text\" name=\"p5\" id=\"web\" size=\"30\" /> % <br />\r\n");
      out.write("                    <i>i.e. the percentage of the size of a group defining relative majority of a group</i>\r\n");
      out.write("\t\t\t\t</p> \r\n");
      out.write("\t\t\t</fieldset> \r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\t        <p class=\"submit\"> \r\n");
      out.write("\t\t\t\t<button type=\"submit\">Diagnose</button> \r\n");
      out.write("\t\t\t</p> \r\n");
      out.write(" \t\t\t</div>\r\n");
      out.write("            \r\n");
      out.write("\t\t</form> \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <iframe id=\"uploadFrameID\" name=\"uploadFrame\" height=\"0\" width=\"0\"\r\n");
      out.write("\t\t\tframeborder=\"0\" scrolling=\"yes\"></iframe>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!-- file upload -->    \r\n");
      out.write("        <div id=\"uploadform\">   \r\n");
      out.write("\t\t<form id=\"myForm\" enctype=\"multipart/form-data\" method=\"post\"\r\n");
      out.write("\t\t\ttarget=\"uploadFrame\" action=\"HandleFileUpload\"\r\n");
      out.write("\t\t\tonsubmit=\"ajaxFunction()\"> \r\n");
      out.write("\t\t\t<input type=\"file\" name=\"txtFile\" id=\"txtFile\" /><br /> \r\n");
      out.write("            <input type=\"submit\" id=\"submitID\" name=\"submit\" value=\"Upload\" /> \r\n");
      out.write("\t\t</form> \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
