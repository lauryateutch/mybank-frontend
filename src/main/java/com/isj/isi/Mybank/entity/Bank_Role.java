package com.isj.isi.Mybank.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.secure.spi.GrantedPermission;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;


@Entity
@Table(name = "bank_role")

@EqualsAndHashCode

public class Bank_Role extends Abstract_Mybank_Entity {

    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties
    private Long id;

    /** The role. */

    private String role;

    /**
     * default contructor.
     */
    public Bank_Role() {

    }

    /**
     * Instantiates a new roles.
     *
     * @param role the role
     */
    public Bank_Role(@NotNull final String role) {
        this.role = role;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */

    public String getAuthority() {
        return this.role;
    }





}
