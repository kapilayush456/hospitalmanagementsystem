package DAO;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class UserDAO {
    
    public user Authenticate(String uname)
    {
        Configuration cf = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction t = null;
        user u = null;
        try{ 
            cf = new Configuration();
            cf.configure("patient.cfg.xml");
            sf = cf.buildSessionFactory();
            session = sf.openSession();
            t = session.beginTransaction();
            Query q = session.createQuery("from user where username = :uname");
            q.setString("uname",uname);
            u = (user)q.uniqueResult();
            t.commit();
            return u;
           }catch(Exception e ){
             e.printStackTrace();
            }
        finally{
            session.close();
            sf.close();
        }
        return u;
    }
    
    
    public boolean checkStu(String uname , String pass){
        user u = null;
        u = Authenticate(uname);
        if(u!=null && uname.equals(u.getUsername()) && pass.equals(u.getPassword()) ){
            return true;
        }else{
            return false;
        }
    }
    
    
    //Admin Details
    
     public Doctor ad(String uname){
        
        Configuration cf = null;
        SessionFactory sf = null;
        Session s = null;
        Transaction t = null;
        Doctor a = null;
        try{
            
            cf = new Configuration();
            cf.configure("doctor.cfg.xml");
            sf = cf.buildSessionFactory();
            s = sf.openSession();
            t = s.beginTransaction();
            Query q = s.createQuery("from Doctor where username = :uname");
            q.setString("uname", uname);
            a = (Doctor)q.uniqueResult();
            t.commit();
            return a;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
    public boolean checkAdmin(String uname , String pass){
        Doctor a = null;
        a = ad(uname);
        if(a!=null && uname.equals(a.getUsername()) && pass.equals(a.getPassword()))
            return true;
        else
            return false;
    }
}