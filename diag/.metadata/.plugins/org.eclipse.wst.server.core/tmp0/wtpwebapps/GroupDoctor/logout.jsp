<%@ page session="true"%>

User '<%=request.getRemoteUser()%>' has been logged out.

<% session.invalidate(); %>

<br/><br/>

<%
    String redirectURL = "login.html";
    response.sendRedirect(redirectURL);
%>


