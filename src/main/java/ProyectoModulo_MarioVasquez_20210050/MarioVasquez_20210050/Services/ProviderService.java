package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Services;

import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Entities.ProviderEntity;
import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Models.DTO.DTOProvider;
import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repo;

    public List<DTOProvider> obtenerProveedores(){
        List<ProviderEntity> proveedores = repo.findAll();
        return proveedores.stream()
                .map(this::convertirAproveedoresDTO)
                .collect(Collectors.toList());
    }

    private DTOProvider convertirAproveedoresDTO(ProviderEntity entity){
        DTOProvider dto = new DTOProvider();
        dto.setProviderId(entity.getProviderId());
        dto.setProviderName(entity.getProviderName());
        dto.setProviderPhone(entity.getProviderPhone());
        dto.setProviderAddress(entity.getProviderAddress());
        dto.setProviderEmail(entity.getProviderEmail());
        dto.setProviderCode(entity.getProviderCode());
        dto.setProviderStatus(entity.getProviderStatus());
        dto.setProviderComments(entity.getProviderComments());
        return dto;
    }

    public String post(DTOProvider dto){
        try{
            ProviderEntity entity = new ProviderEntity();
            entity.setProviderId(dto.getProviderId());
            entity.setProviderName(dto.getProviderName());
            entity.setProviderPhone(dto.getProviderPhone());
            entity.setProviderAddress(dto.getProviderAddress());
            return "Proveedor agregado correctamente";
        }catch (Exception e){
            return "Error al agregar el proveedor" + e.getMessage();
        }
    }
}


