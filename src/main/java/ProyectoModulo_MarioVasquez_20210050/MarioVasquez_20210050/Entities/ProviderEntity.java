package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Entities;

import jakarta.persistence.*;
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
    //Secuencia que genera el id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedor_sequencia")
    @SequenceGenerator(name = "proveedor_sequencia", sequenceName = "seq_provider", allocationSize = 1)
    private Long providerId;

    //No se puede poner un valor de nulo en este campo
    @Column(name = "PROVIDERNAME", nullable = false, unique = true)
    private String providerName;

    @Column(name = "PROVIDERPHONE")
    private String providerPhone;

    @Column(name = "PROVIDERADDRESS")
    private String providerAddress;

    @Column(name = "PROVIDEREMAIL")
    private String providerEmail;

    @Column(name = "PROVIDERCODE", unique = true)
    private String providerCode;

    @Column(name = "PROVIDERSTATUS")
    private Boolean providerStatus;

    @Column(name = "PROVIDERCOMMENTS")
    private String providerComments;
}
