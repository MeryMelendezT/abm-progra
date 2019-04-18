<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Iniciar Sesion
</title>
</head>
<body>
<h2>
Iniciar Sesion
</h2>
<html:form action="/inicio">
  <table  cellspacing="2" cellpadding="1" border="1" width="100%">
  <tr>
      <td colspan=2><bean:message key="tit.prompt" /></td>
  </tr>
  <tr>
      <td><bean:message key="usu.prompt" /></td>
      <td><html:text property="usuario" /></td>
  </tr>
  <tr>
      <td><bean:message key="cla.prompt" /></td>
      <td><html:password property="clave" /></td>
  </tr>
  <tr>
      <td colspan=2><html:submit value="Ingresar" /></td>
  </tr>
  </table>
</html:form>
</body>
</html>
