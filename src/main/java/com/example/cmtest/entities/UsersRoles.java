package com.example.cmtest.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERSROLES")
public class UsersRoles implements Serializable {
    @Id
    @Column(name = "ID")
    Integer usersroles;

    @ManyToOne
    @JoinColumn(name = "USERS")
    Users users;

    @ManyToOne
    @JoinColumn(name = "ROLES")
    Roles roles;

    @Column(name = "ISDEL")
    Boolean isdel;

    public UsersRoles() {
    }

    public Integer getUsersroles() {
        return usersroles;
    }

    public void setUsersroles(Integer usersroles) {
        this.usersroles = usersroles;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }
}
