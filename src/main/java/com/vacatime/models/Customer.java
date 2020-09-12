package com.vacatime.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "idcustomer")
public class Customer {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;

    public Customer() {}

    Customer(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return  "Customer{" + "id=" + id 
                + ", username='" + username + '\''
                + ", email=' " + email + '\''  
                + ", password=' "+ password + '\'' 
                + '}';

    
    }
    
}
