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
    @GetMapping("/obtenerDatos")
    public List<DTOProvider> datos(){
        return service.obtenerProveedores();
    }

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
    @PostMapping("/agregarProveedor")
    public String agregar(@Validated (DTOProvider.OnCreate.class) @RequestBody DTOProvider dto){
        return service.agregarProveedor(dto);
    }

    //Metodo POST
    //Ruta: localhost:8080/apiProvider/agregarProveedor



}
