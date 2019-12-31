/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmanagementsystem;

/**
 *
 * @author User
 */
public class Users {
    public String name;
    public String password;
    public int phoneNumber;
    public int nid;
    public String address;
    public int age;

    public Users(String name, String password, int phoneNumber, int nid, String address,int age) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nid = nid;
        this.address = address;
        this.age = age;
    }
    
}
