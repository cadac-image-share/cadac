package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title>Search In Database</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<center>\n");
      out.write("\t\t<h1>Image Sharing Portal</h1>\n");
      out.write("\t\t<h2>Search Image</h2>\n");
      out.write("\t\t<form method=\"post\" action=\"Search\" >\n");
      out.write("\t\t\t<table border=\"0\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Search: </td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"search\" size=\"30\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("                                <td colspan=\"2\">\n");
      out.write("                                    <input type=\"submit\" value=\"Search\">\n");
      out.write("                                </td>\n");
      out.write("                                 </tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</form>\n");
      out.write("                \n");
      out.write("                <h5>Search Image results will also be stored in </h5>\n");
      out.write("                <h5>  C:\\Users\\ankursmooth\\Documents\\Netbeans projects\\Image Final Last\\web\\searchresult\\ after retrieval from ibm db2</h5> \n");
      out.write("\t</center>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
