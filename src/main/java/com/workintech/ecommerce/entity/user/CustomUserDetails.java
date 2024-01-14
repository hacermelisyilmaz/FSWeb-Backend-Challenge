package com.workintech.ecommerce.entity.user;

import java.io.Serializable;

public interface CustomUserDetails extends Serializable {
    Role getAuthority();

    String getPassword();

    String getUsername();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
