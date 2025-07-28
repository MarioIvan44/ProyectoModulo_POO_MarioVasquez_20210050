package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Services;

import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Entities.ProviderEntity;
import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Models.DTO.DTOProvider;
import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repo;

    //GET POR ID
    public DTOProvider obtenerProveedorPorId(Long id){
        ProviderEntity entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con id: " + id));
        return convertirAproveedoresDTO(entity);
    }
    //Metodo HTTTP GET
    //Valor de retorno Lista de tipo DTO
    //Se pide una lista de tipo DTO ya que todo lo que se muestra en el front end debe ser de tipo DTO
    public List<DTOProvider> obtenerProveedores(){
        List<ProviderEntity> proveedores = repo.findAll();
        return proveedores.stream()
                .map(this::convertirAproveedoresDTO)
                .collect(Collectors.toList());
    }

    //Se convierten los datos de tipo entity a tipo DTO para poder mostrarse y hacer el get correctamente
    //Valor de retorno: Objeto de tipo DTO
    //Parámetros de entrada: Objeto de tipo entity
    private DTOProvider convertirAproveedoresDTO(ProviderEntity entity){
        DTOProvider dto = new DTOProvider();
        //A cada atributo de dto se le asigna el valor de tipo entity
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

    //Metodo HTTP post
    //
    public String agregarProveedor(DTOProvider dto){
        try{
            ProviderEntity entity = new ProviderEntity();
            entity.setProviderName(dto.getProviderName());
            entity.setProviderPhone(dto.getProviderPhone());
            entity.setProviderAddress(dto.getProviderAddress());
            entity.setProviderEmail(dto.getProviderEmail());
            entity.setProviderCode(dto.getProviderCode());
            entity.setProviderStatus(dto.getProviderStatus());
            entity.setProviderComments(dto.getProviderComments());
            repo.save(entity);
            return "Proveedor agregado correctamente";
        }catch (Exception e){
            return "Error al agregar el proveedor" + e.getMessage();
        }
    }

    public String actualizarProveedor(Long id, DTOProvider dto){
        try{
            Optional<ProviderEntity> proveedor = repo.findById(id);
            if (proveedor.isPresent()){
                ProviderEntity entity = proveedor.get();
                entity.setProviderName(dto.getProviderName());
                entity.setProviderPhone(dto.getProviderPhone());
                entity.setProviderAddress(dto.getProviderAddress());
                entity.setProviderEmail(dto.getProviderEmail());
                entity.setProviderCode(dto.getProviderCode());
                entity.setProviderComments(dto.getProviderComments());
                repo.save(entity);
                return "Proveedor actualizado correctamente";
            }
            else {
                return "Error: Proveedor no encontrado con id: " + id;
            }
        }catch (Exception e){
            return "Error al actualizar el proveedor: " + e.getMessage();
        }
    }

    public String actualizarParcialmente(Long id, DTOProvider dto){
        try{
            Optional<ProviderEntity> optionalProvider = repo.findById(id);
            if(optionalProvider.isPresent()){
                ProviderEntity entity = optionalProvider.get();
                if(dto.getProviderName() != null){
                    entity.setProviderName(dto.getProviderName());
                }
                if(dto.getProviderPhone() != null){
                    entity.setProviderPhone(dto.getProviderPhone());
                }
                if (dto.getProviderAddress() != null){
                    entity.setProviderAddress(dto.getProviderAddress());
                }
                if(dto.getProviderEmail() != null){
                    entity.setProviderEmail(dto.getProviderEmail());
                }
                if (dto.getProviderCode() != null){
                    entity.setProviderCode(dto.getProviderCode());
                }
                if (dto.getProviderComments() != null){
                    entity.setProviderComments(dto.getProviderComments());
                }
                repo.save(entity);
                return "El proveedor ha sido actualizado parcialmiente correctamente";
            }
            else {
                return "Error: Proveedor no encontrado";
            }
        }catch (Exception e){
            return "Error al actualizar parcialmente el proveedor: " + e.getMessage();
        }
    }
}


