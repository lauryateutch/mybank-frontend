package com.isj.isi.Mybank.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;



@Data
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public class User extends Abstract_Mybank_Entity {

    @NotEmpty
    private  String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private Date birthday;
    @NotEmpty
    private String profession;
    @NotEmpty
    private String matrimonial_status;
    @NotEmpty
    private String address;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String phone_number;

    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "idUser"),
    inverseJoinColumns = @JoinColumn(name = "idRole"))

    private Collection<Bank_Role> bank_Role;


}
