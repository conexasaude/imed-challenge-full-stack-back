package com.conexasaude.entity;

import com.conexasaude.enums.OnlineStatus;
import com.conexasaude.enums.RoleType;

public class User {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String password;
  private String cellphone;
  private RoleType roles;
  private OnlineStatus onlineStatus;
  private Address address;

  public User() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCellphone() {
    return cellphone;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public RoleType getRoles() {
    return roles;
  }

  public void setRoles(RoleType roles) {
    this.roles = roles;
  }

  public OnlineStatus getOnlineStatus() {
    return onlineStatus;
  }

  public void setOnlineStatus(OnlineStatus onlineStatus) {
    this.onlineStatus = onlineStatus;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
