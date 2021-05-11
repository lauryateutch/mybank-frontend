package com.isj.isi.Mybank.entity;



import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "bank_client")
@NoArgsConstructor
@EqualsAndHashCode
public class Client extends User {
    @NotEmpty
    private String cni;
    @NotEmpty
    private String photo;
    @NotEmpty
    private String localisation;

}
