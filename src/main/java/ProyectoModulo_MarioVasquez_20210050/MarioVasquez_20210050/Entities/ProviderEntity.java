package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "TBPROVIDER")
public class ProviderEntity {

    @Id
    @Column(name = "PROVIDERID")
    private Long providerId;

    //No se puede poner un valor de nulo en este campo
    @Column(name = "PROVIDERNAME", nullable = false)
    private String providerName;

    @Column(name = "PROVIDERPHONE")
    private String providerPhone;

    @Column(name = "PROVIDERADDRESS")
    private String providerAddress;

    @Column(name = "PROVIDEREMAIL")
    private String providerEmail;

    @Column(name = "PROVIDERCODE")
    private String providerCode;

    //No se puede poner un valor de nulo en este campo
    @Column(name = "PROVIDERSTATUS", nullable = false)
    private Long providerStatus;

    @Column(name = "PROVIDERCOMMENTS")
    private String providerComments;
}
