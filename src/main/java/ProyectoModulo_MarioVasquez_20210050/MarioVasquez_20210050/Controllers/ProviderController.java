package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Controllers;

import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Models.DTO.DTOProvider;
import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
