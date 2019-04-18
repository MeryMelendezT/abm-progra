<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Inicio Satisfactorio
</title>
</head>
<body>
<h2>
Inicio Satisfactorio <%=session.getAttribute("usuario") %>
</h2>
<html:form action="/abm">
  <table  cellspacing="2" cellpadding="1" border="1" width="100%">
  <tr>
      <td colspan=2><bean:message key="tit.abm.prompt" /></td>
  </tr>
  <tr>
      <td><html:submit property="boton" value="altas" /></td>
  </tr>
  <tr>
      <td><html:submit property="boton" value="bajas" /></td>
  </tr>
  <tr>
      <td><html:submit property="boton" value="modificaciones" /></td>
  </tr>
  </table>
</html:form>
</body>
</html>
