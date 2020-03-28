package com.exam7.food_order.model;

import com.exam7.food_order.util.GenerateData;
import com.exam7.food_order.util.Generator;
import com.exam7.food_order.util.SecurityConfig;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "clients")
@Data
@Builder
public class Client implements UserDetails {
    @Id
    private String id;
    private String name;
    private String mail;
    private String pass;

    public static Client addClient(){
        return Client.builder()
                .mail(GenerateData.randomEmail())
                .name(GenerateData.randomPersonName())
                .pass(SecurityConfig.encoder().encode(Generator.makePassword()))
                .build();
    }

    public void setPass(String pass){
        this.pass = SecurityConfig.encoder().encode(pass);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    @Override
    public String getUsername() {
        return getMail();
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
