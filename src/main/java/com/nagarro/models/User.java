package com.nagarro.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User Domain class
 * @author Sanyam Goel created on 4/9/18
 */

@Entity
@Table(name = "User_Details")
public class User {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Full_Name")
    private String fullName;

    @Column(name = "Password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Image> images = new HashSet<>();

    public User() {
    }

    public User(String username, String fullName, String password, Set<Image> images) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.images = images;
    }

    public User(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
