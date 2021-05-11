package com.isj.isi.Mybank.entity;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class Abstract_Mybank_Entity {
    @Id
    @GeneratedValue
    protected Long id;

    @Column(unique = true)
    protected String code;



}
