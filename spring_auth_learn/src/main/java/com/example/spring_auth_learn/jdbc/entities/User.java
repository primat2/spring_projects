package com.example.spring_auth_learn.jdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Table(name = "auth_user_details")
@Entity
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "user_kay")
    private String password;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "enabled")
    private boolean enabled;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "auth_user_authority",
            joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    private List<Authority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
