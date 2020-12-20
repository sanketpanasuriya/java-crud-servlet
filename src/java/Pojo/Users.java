/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author shani
 */
public class Users {
    
    int ID;
    String user;
    String address;
    int age;
    String gender;

    public Users(String user, String address, int age, String gender) {
        this.user = user;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }

    public Users(int ID, String user, String address, int age, String gender) {
        this.ID = ID;
        this.user = user;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }
    

    public Users() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
