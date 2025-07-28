package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Models.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
public class DTOProvider {

    private Long providerId;

    @Size(max = 50, message = "El máximo de caracteres para el nombre del proveedor es de 50", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    @NotBlank(message = "El campo 'providerName' es obligatorio", groups = {OnCreate.class, OnUpdate.class})
    private String providerName;

    @Size(max = 25, message = "El máximo de caracteres para el telefono del proveedor es de 25", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    private String providerPhone;

    @Size(max = 128, message = "El máximo de caracteres para la dirección del proveedor es de 128", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    private String providerAddress;

    @Email(message = "El correo debe ser valido", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    @Size(max = 100, message = "El máximo de caracteres para el correo del proveedor es de 100", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    private String providerEmail;

    @Size(max = 35, message = "El máximo de caracteres para el código del proveedor es de 35", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    private String providerCode;

    @Positive(message = "El estatus del proveedor no puede ser negativo", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    @Min(value = 1, message = "El mínimo de estatus del proveedor es 1", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    @NotBlank(message = "El campo 'providerStatus' es obligatorio", groups = {OnCreate.class, OnUpdate.class})
    private Long providerStatus;

    @Size(max = 128, message = "El máximo de caracteres para los comentarios del proveedor es de 256", groups = {OnCreate.class, OnUpdate.class, OnPatch.class})
    private String providerComments;

    public interface OnCreate{}
    public interface OnUpdate{}
    public interface OnPatch{}
}
