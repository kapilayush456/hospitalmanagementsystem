/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import javax.persistence.*;
/**
 *
 * @author hp
 */

@Entity
@Table(name="doctor")
public class Doctor {
   @Id
   @GeneratedValue
   private int id;
  
   private String username;
   private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
