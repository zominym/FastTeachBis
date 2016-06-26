package com.epul.oeuvres.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "USER")
//@XmlRootElement
public class User// implements Serializable
{
    //    private static final long serialVersionUID = 1L;

    private int userId;
    private String surname;
    private String name;
    private String mail;
    private String pass;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Size(max = 25)
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Size(max = 25)
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(max = 50)
    @Column(name = "MAIL")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Size(max = 25)
    @Column(name = "PASS")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Size(max = 25)
    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User()
    {
    }

    public User(Integer id)
    {
        this.userId = id;
    }

    public User(Integer id, String nam)
    {
        this.userId = id;
        this.name = nam;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;

        return true;
    }

    @Override
    public String toString()
    {
        return "com.epul.oeuvres.entities.Adherent[ idAdherent=" + userId + " ]";
    }
}