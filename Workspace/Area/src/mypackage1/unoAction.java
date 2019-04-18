package mypackage1;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import oracle.jdbc.*;
import java.util.*;

public class unoAction extends Action 
{
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    ConnectDB conn =new ConnectDB ();
    ResultSet rsConsulta = null;
    unoForm UnoForm = (unoForm) form;
    String usu = UnoForm.getUsuario();
    String clave = UnoForm.getClave();
    request.getSession().setAttribute("usuario",usu);

    /*if(usu.equals("taller")){
      return mapping.findForward("ok");
    }else
      return mapping.findForward("nook");*/

    try
    {
    String cadena="select * from s_emp where userid='"+usu+"'";
    System.out.println(cadena);
    rsConsulta = conn.getData(cadena);
    if (rsConsulta.next())
       return mapping.findForward("ok");
    else
       return mapping.findForward("nook");
    }
	
    catch(Exception e)
    {
      e.printStackTrace();
      return (mapping.findForward("nook"));
    }
    finally
    {
      conn.closeConnection();	
    }
  }
}