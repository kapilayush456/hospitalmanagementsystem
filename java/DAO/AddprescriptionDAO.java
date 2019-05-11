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
public class AddprescriptionDAO {
    prescription s = null;
    Configuration cf = null;
    SessionFactory sf = null;
    Session session = null;
    public void add(String name,String gender,String medicine){
        try{
            cf = new Configuration();
            cf.configure("prescription.cfg.xml");
            sf = cf.buildSessionFactory();
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            s = new prescription();
            s.setName(name);
            s.setGender(gender);
            s.setMedicine(medicine);
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
