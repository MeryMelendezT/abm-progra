<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Modificaciones
</title>
</head>
<body>
<h2>
Modificaciones de Departamentos
</h2>
<html:form action="/modificaciones">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<logic:iterate id="tabla" indexId="index" name="mod" property="tabla">
<tr>
    <td><html:submit property="cod">
      <bean:write name="tabla" property="id" />
      </html:submit>
      </td>
    <td><bean:write name="tabla" property="name" /></td>
</tr>
</logic:iterate>
</table>
</html:form>
</body>
</html>