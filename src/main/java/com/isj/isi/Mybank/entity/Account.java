package com.isj.isi.Mybank.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Entity
@Table(name = "bank_account")
@NoArgsConstructor
@EqualsAndHashCode
public class Account extends Abstract_Mybank_Entity{

    @NotEmpty
    @Column(unique = true)
    private Long accountNumber;
    @NotEmpty
    private Long balanceAccount;

    @NotEmpty
    private Long status;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "manager")
    private Manager manager;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "client")
    private Client client;



}
