<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Hello World
</title>
</head>
<body>
<h2>
Editar Departamento <%=(String)session.getAttribute("cod")%>
</h2>
<html:form action="/editar">
  <table  cellspacing="2" cellpadding="1" border="1" width="100%">
  <tr>
      <td colspan="2"><bean:message key="ideditar.prompt" /></td>
  </tr>
  <logic:iterate id="tabla" indexId="index" name="nn" property="tabla">
  <tr>
      <td><bean:message key="nameeditar.prompt" /></td>
      <td><html:text property="name" name="tabla" /></td>
  </tr>
  </logic:iterate>
  <tr>
      <td><bean:message key="regioneditar.prompt" /></td>
      <td><html:select property="region">
          <html:options collection="ayuda" labelProperty="name" property="id" />
      </html:select></td>
  </tr>
  <tr>
      <td colspan="2"><html:submit value="Actualizar" /></td>
  </tr>
  </table>
</html:form>
</body>
</html>
