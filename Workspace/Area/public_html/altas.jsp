<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Altas
</title>
</head>
<body>
<h2>
Altas de Departamentos
</h2>
<html:form action="/altas">
  <table  cellspacing="2" cellpadding="1" border="1" width="100%">
  <tr>
      <td colspan=2><bean:message key="tit.altas.prompt" /></td>
  </tr>
  <tr>
      <td><bean:message key="id.prompt" /></td>
      <td><html:text property="id" /></td>
  </tr>
  <tr>
      <td><bean:message key="name.prompt" /></td>
      <td><html:text property="name" /></td>
  </tr>
  <tr>
      <td><bean:message key="region.prompt" /></td>
      <td><html:select property="region">
          <html:options collection="ayuda" labelProperty="name" property="id" />
      </html:select></td>
  </tr>
  <tr>
      <td colspan=2><html:submit value="Registrar" /></td>
  </tr>
  </table>
</html:form>
</body>
</html>
