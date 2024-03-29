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

public class modificacionesAction extends Action 
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
    modificacionesForm ModificacionesForm = (modificacionesForm) form;
    String cod = ModificacionesForm.getCod();

    Connection cn = null;
    ConnectDB conn = new ConnectDB();
    ResultSet rsConsulta = null;
    try
    {
      cn = conn.conexion;
      String cadena = "select id,name from s_dept where id="+cod+"order by 1";
      rsConsulta = conn.getData(cadena);
      ArrayList items = new ArrayList();
      while(rsConsulta.next()){
        ClassDep item = new ClassDep();
        item.setId(rsConsulta.getString("id"));
        item.setName(rsConsulta.getString("name"));
        items.add(item);
        System.out.println("Paso...");
      }
      modificacionesForm zzz = new modificacionesForm();
      zzz.setTabla(items);
      request.getSession().setAttribute("nn",zzz);
      request.getSession().setAttribute("cod",cod);

      String region= "select * from s_region order by 1";
      rsConsulta = conn.getData(region);
      ArrayList itemsr = new ArrayList();
      while(rsConsulta.next()){
        ClassDep itemr = new ClassDep();
        itemr.setId(rsConsulta.getString("id"));
        itemr.setName(rsConsulta.getString("name"));
        itemsr.add(itemr);
        System.out.println("Paso..");
      }
      request.getSession().setAttribute("ayuda",itemsr);
      return mapping.findForward("editar");
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