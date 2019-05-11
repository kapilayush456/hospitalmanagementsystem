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
public class AddappointmentDAO {
    appointment s = null;
    Configuration cf = null;
    SessionFactory sf = null;
    Session session = null;
    public void add(String firstname,String lastname,String gender,String description){
        try{
            cf = new Configuration();
            cf.configure("appointment.cfg.xml");
            sf = cf.buildSessionFactory();
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            s = new appointment();
            s.setFirstname(firstname);
            s.setLastname(lastname);
            s.setGender(gender);
            s.setDescription(description);
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
