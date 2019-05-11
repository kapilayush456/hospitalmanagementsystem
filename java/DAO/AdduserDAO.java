/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class AdduserDAO {
    user s = null;
    Configuration cf = null;
    SessionFactory sf = null;
    Session session = null;
    public void add(String username,String password,String email){
        try{
            cf = new Configuration();
            cf.configure("hibernate.cfg.xml");
            sf = cf.buildSessionFactory();
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            s = new user();
            s.setUsername(username);
            s.setPassword(password);
            s.setEmail(email);
            session.save(s);
            tx.commit();
        } catch(Exception e ){
            System.out.println(e);
            e.printStackTrace();
        } finally{
            session.close();
            sf.close();
        }
    }
}
