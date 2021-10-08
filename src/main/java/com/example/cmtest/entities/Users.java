package com.example.cmtest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class Users implements Serializable {
    @Id
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="USERSROLES",
            joinColumns=@JoinColumn (name="USERS"),
            inverseJoinColumns=@JoinColumn(name="ROLES"))
    private List<Roles> roles;

    public Users() {
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(login, users.login) && Objects.equals(name, users.name) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, password);
    }
}
