package com.example.ensiasea.Security.Service;

import java.util.Collection;
// import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import com.example.ensiasea.Entity.User;
// import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserDetailsImpl implements UserDetails {

  private User user;

  public UserDetailsImpl(User user) {
		this.user = user;
	}

  @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

  // @Override
  public Long getId() {
    return user.getUserId();
  }

  public String getEmail() {
    return user.getEmail();
  }
  @Override
  public String getPassword() {
    return user.getPassword();
  }
  @Override
  public String getUsername() {
    return user.getUsername();
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
 
 
 /* @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  } */
}
