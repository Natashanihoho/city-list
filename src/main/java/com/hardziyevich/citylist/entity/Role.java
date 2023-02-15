package com.hardziyevich.citylist.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_READ_ONLY,
    ROLE_ALLOW_EDIT;

    @Override
    public String getAuthority() {
        return name();
    }
}
