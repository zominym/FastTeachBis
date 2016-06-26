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
@XmlRootElement
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer ID;

    @Size(max = 25)
    @Column(name = "surname")
    private String surname;

    @Size(max = 25)
    @Column(name = "name")
    private String name;

    @Size(max = 50)
    @Column(name = "mail")
    private String mail;

    @Size(max = 25)
    @Column(name = "pass")
    private String pass;

    @Size(max = 25)
    @Column(name = "role")
    private String role;

    public User()
    {
    }

    public User(Integer id)
    {
        this.ID = id;
    }

    public User(Integer id, String nam)
    {
        this.ID = id;
        this.name = nam;
    }

    public Integer getID()
    {
        return ID;
    }

    public void setId(Integer id)
    {
        this.ID = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String nomAdherent)
    {
        this.name = nomAdherent;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String prenomAdherent)
    {
        this.surname = prenomAdherent;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail) { this.mail = mail; }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass) { this.pass = pass; }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role) { this.role = role; }


   @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof User))
        {
            return false;
        }
        User other = (User) object;
        if((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.epul.oeuvres.entities.Adherent[ idAdherent=" + ID + " ]";
    }
}