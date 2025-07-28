package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Controllers;

import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Models.DTO.DTOProvider;
import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiProvider")
public class ProviderController {

    //Se inyecta la clase ProviderService para poder acceder a sus métodos
    @Autowired
    private ProviderService service;

    //Metodo GET
    //Ruta: localhost:8080/apiProvider/obtenerDatos
    //Valor de retorno: Lista de tipo DTO
    @GetMapping("/obtenerDatos")
    public List<DTOProvider> datos(){
        return service.obtenerProveedores();
    }

    //Metodo GET
    //Ruta: localhost:8080/apiProvider/obtenerPorId/id
    //Valor de retorno: ResponseEntity de tipo DTOProvider
    //Parametros de entrada: Long
    @GetMapping("/obtenerPorId/{id}")
    public ResponseEntity<DTOProvider> obtenerPorID(@PathVariable Long id){
        try{
            DTOProvider provider = service.obtenerProveedorPorId(id);
            return ResponseEntity.ok(provider);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo POST
    //Ruta: localhost:8080/apiProvider/agregarProveedor
    //Valor de retorno: String
    //Parametros de entrada: Objeto de tipo dto
    @PostMapping("/agregarProveedor")
    public String agregar(@Validated (DTOProvider.OnCreate.class) @RequestBody DTOProvider dto){
        return service.agregarProveedor(dto);
    }

    //Metodo PUT
    //Ruta: localhost:8080/apiProvider/actualizarProveedor/id
    //Valor de retorno: String
    //Parametros de entrada: Long id, Objeto de tipo dto
    @PutMapping("/actualizarProveedor/{id}")
    public String actualizar(@PathVariable Long id, @Validated (DTOProvider.OnUpdate.class) @RequestBody DTOProvider dto){
        return service.actualizarProveedor(id, dto);
    }

    //Metodo PATCH
    //Ruta: localhost:8080/apiProvider/actualizarParcialmente/id
    //Valor de retorno: String
    //Parametros de entrada: Long id, Objeto de tipo dto
    @PatchMapping("/actualizarParcialmente/{id}")
    public String patch(@PathVariable Long id, @Validated (DTOProvider.OnPatch.class) @RequestBody DTOProvider dtoProvider){
        return service.actualizarParcialmente(id, dtoProvider);
    }

    //Metodo DELETE
    //Ruta: localhost:8080/apiProvider/eliminarProveedor/id
    //Valor de retorno: String
    //Parametros de entrada: Long id
    @DeleteMapping("/eliminarProveedor/{id}")
    public String eliminar(@PathVariable Long id){
        return service.eliminarProveedor(id);
    }

}
