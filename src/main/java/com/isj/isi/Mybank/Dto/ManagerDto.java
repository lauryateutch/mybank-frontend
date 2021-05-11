package com.isj.isi.Mybank.Dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.Date;



@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ManagerDto {

    private  String name;
    //@NotEmpty
    private String surname;
    //@NotEmpty
    private Date birthday;
    //@NotEmpty
    private String profession;
    //@NotEmpty
    private String matrimonial_status;
    //  @NotEmpty
    private String address;
    //@NotEmpty
    @Email
    private String email;
    // @NotEmpty
    private String phone_number;
    //@NotEmpty
    private String cni;

    private String password;

}
