package com.conexasaude.entity;

import com.conexasaude.enums.SpecialtyType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "health_professional")
public class HealthProfessionalEntity extends UserEntity {
  private String crm;
  private String rating;
  private SpecialtyType specialty;

  @OneToMany(
      mappedBy = "healthProfessional",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @ToString.Exclude
  //  @JsonIgnore
  private Set<AttendanceEntity> attendances = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    HealthProfessionalEntity that = (HealthProfessionalEntity) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
