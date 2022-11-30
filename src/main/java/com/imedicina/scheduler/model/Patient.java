package com.imedicina.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "total_appointments")
    private Integer totalAppointments = 0;

    @Transient
    private Boolean onlineStatus = false;
}
