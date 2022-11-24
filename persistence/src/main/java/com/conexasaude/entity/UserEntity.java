package com.conexasaude.entity;

import com.conexasaude.enums.OnlineStatus;
import com.conexasaude.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(
    value = {"hibernateLazyInitializer", "handler"},
    ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@MappedSuperclass
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String username;
  private String email;
  private String password;
  private String cellphone;
  private RoleType roles;
  private OnlineStatus onlineStatus;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "address")
  private AddressEntity address;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    UserEntity that = (UserEntity) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
