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

public class buenaAction extends Action 
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
    buenaForm BuenaForm = (buenaForm) form;
    String boton = BuenaForm.getBoton();
    String to="";
    request.getSession().setAttribute("boton",boton);

    if(boton.equals("altas")){
      //return mapping.findForward("altas");
      Connection cn = null;
      ConnectDB conn =new ConnectDB();
      ResultSet rsConsulta = null;
      try
      {
        cn = conn.conexion;
        String cadena = "select * from s_REGION order by 1";
        rsConsulta = conn.getData(cadena);
        ArrayList items = new ArrayList();
        while (rsConsulta.next())
        {
          ClassDep item = new ClassDep();
          item.setId(rsConsulta.getString("id"));
          item.setName(rsConsulta.getString("name"));
          items.add(item);
          System.out.println("Paso ..");
        }  
      request.getSession().setAttribute("ayuda",items);
      return mapping.findForward("altas");
      //to="codigo";
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
    }if(boton.equals("bajas")){
      //return mapping.findForward("bajas");
      Connection cn = null;
      ConnectDB conn = new ConnectDB();
      ResultSet rsConsulta = null;
      try{
        cn = conn.conexion;
        String cadena = "select id,name from s_dept order by 1";
        rsConsulta = conn.getData(cadena);
        ArrayList items = new ArrayList();
        while(rsConsulta.next()){
          ClassDep item = new ClassDep();
          item.setId(rsConsulta.getString("id"));
          item.setName(rsConsulta.getString("name"));
          items.add(item);
          System.out.println("paso..");
        }
        bajasForm BajasForm = new bajasForm();
        BajasForm.setTabla(items);
        request.getSession().setAttribute("datos",BajasForm);
        return mapping.findForward("bajas");
        //to="bajas";
      }catch(Exception e){
        e.printStackTrace();
        return(mapping.findForward("nook"));
      }finally{
        conn.closeConnection();
      }
    }if(boton.equals("modificaciones")){
      //return mapping.findForward("modificaciones");
      Connection cn = null;
      ConnectDB conn = new ConnectDB();
      ResultSet rsConsulta = null;
      try{
        cn = conn.conexion;
        String cadena = "select id,name from s_dept order by 1";
        rsConsulta = conn.getData(cadena);
        ArrayList items = new ArrayList();
        while(rsConsulta.next()){
          ClassDep item = new ClassDep();
          item.setId(rsConsulta.getString("id"));
          item.setName(rsConsulta.getString("name"));
          items.add(item);
          System.out.println("paso..");
        }
        modificacionesForm ModificacionesForm = new modificacionesForm();
        ModificacionesForm.setTabla(items);
        request.getSession().setAttribute("mod",ModificacionesForm);
        return mapping.findForward("modificaciones");
        //to="bajas";
      }catch(Exception e){
        e.printStackTrace();
        return(mapping.findForward("nook"));
      }finally{
        conn.closeConnection();
      }
    }else
      return mapping.findForward("nook");
  }
}