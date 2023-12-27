package com.isep.acme.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Document(collection = "user")
public class User_Mongo extends User {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Indexed(unique = true)
    private Long _userId;
    private String _username;

    private String _password;

    private String _fullName;

    private Set<Role> _authorities = new HashSet<>();

    private String _nif;

    private String _morada;

/*    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> review = new ArrayList<Review>(); */

    protected User_Mongo() {
    }

    public User_Mongo(final String username, final String password) {
        this._userId = Math.abs(new Random().nextLong());
        this._username = username;
        this._password = password;
    }


    public User_Mongo(final String username, final String password, final String fullName, final String nif, final String morada) {
        this._username = username;
        this._password = password;
        this._fullName = fullName;
        setNif(nif);
        this._morada = morada;
    }

    public void addAuthority(Role r) {
        _authorities.add(r);
    }

    public void setNif(String nif) {
        if (nif.length() != 9) {
            throw new IllegalArgumentException("NIF must be 9 characters.");
        }
        this._nif = nif;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}