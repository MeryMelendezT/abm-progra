<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Bajas
</title>
</head>
<body>
<h2>
Bajas de Departamentos
</h2>
<html:form action="/bajas">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<logic:iterate id="tabla" indexId="index" name="datos" property="tabla">
<tr>
    <td><html:submit property="cod">
          <bean:write name="tabla" property="id" />
        </html:submit>
    </td>
</tr>
<tr>
    <td><bean:write name="tabla" property="name" /></td>
</tr>

</logic:iterate>
</html:form>
</table>
</body>
</html>
