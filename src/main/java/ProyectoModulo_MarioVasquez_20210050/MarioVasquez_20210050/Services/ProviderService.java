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
    //Valor de retorno objeto de tipo DTO
    //Parametro de entrada: Un id de tipo Long
    public DTOProvider obtenerProveedorPorId(Long id){
        //Se busca por el id brindado
        ProviderEntity entity = repo.findById(id)
                //Si no se encuentra se muestra un mensaje de error
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con id: " + id));
        //Se devuelven el resultado de la busqueda
        return convertirAproveedoresDTO(entity);
    }
    //Metodo HTTTP GET
    //Valor de retorno Lista de tipo DTO
    //Se pide una lista de tipo DTO ya que todo lo que se muestra en el front end debe ser de tipo DTO
    public List<DTOProvider> obtenerProveedores(){
        //Se buscan todos los proveedores
        List<ProviderEntity> proveedores = repo.findAll();
        return proveedores.stream()
                //Se convierte todo a dto
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
        //Se devuelve el dto
        return dto;
    }

    //Metodo HTTP post
    //Valor de retorno: String
    //Parámetros de entrada: Objeto de tipo dto
    public String agregarProveedor(DTOProvider dto){
        try{
            //
            ProviderEntity entity = new ProviderEntity();
            //Para cada atributo de tipo entity se le asigna un atributo de tipo dto
            entity.setProviderName(dto.getProviderName());
            entity.setProviderPhone(dto.getProviderPhone());
            entity.setProviderAddress(dto.getProviderAddress());
            entity.setProviderEmail(dto.getProviderEmail());
            entity.setProviderCode(dto.getProviderCode());
            //Si el atributo de ProviderStatus viene como nulo, se asiga el atributo como true 1(true)
            if(dto.getProviderStatus() == null){
                entity.setProviderStatus(true);
            }
            else { //Si no, se guarda el valor que viene del dto
                entity.setProviderStatus(dto.getProviderStatus());
            }
            entity.setProviderComments(dto.getProviderComments());
            //Se guarda el proveedor
            repo.save(entity);
            return "Proveedor agregado correctamente";
        }catch (Exception e){
            return "Error al agregar el proveedor" + e.getMessage();
        }
    }

    //Metodo HTTP PUT
    //Valor de retorno: String
    //Parámetros de entrada: Objeto de tipo dto y un id de tipo Long
    public String actualizarProveedor(Long id, DTOProvider dto){
        try{
            Optional<ProviderEntity> proveedor = repo.findById(id);
            //Si el id del proveedor es encontrado, se asignan los valores del dto al entity
            if (proveedor.isPresent()){
                ProviderEntity entity = proveedor.get();
                //Se asigna cada valor de tipo dto a cada atributo de tipo entity
                entity.setProviderName(dto.getProviderName());
                entity.setProviderPhone(dto.getProviderPhone());
                entity.setProviderAddress(dto.getProviderAddress());
                entity.setProviderEmail(dto.getProviderEmail());
                entity.setProviderCode(dto.getProviderCode());
                //Si el atributo de ProviderStatus viene como nulo, se asiga el atributo como true 1(true)
                if(dto.getProviderStatus() == null){
                    entity.setProviderStatus(true);
                }
                else { //Si no, se guarda el valor que viene del dto
                    entity.setProviderStatus(dto.getProviderStatus());
                }
                entity.setProviderComments(dto.getProviderComments());
                //Se guardan los cambios
                repo.save(entity);
                return "Proveedor actualizado correctamente";
            }
            //Si no es encontrado se muestra un mensaje de error
            else {
                return "Error: Proveedor no encontrado con id: " + id;
            }
        }catch (Exception e){
            return "Error al actualizar el proveedor: " + e.getMessage();
        }
    }

    //Metodo HTTP PATCH
    //Valor de retorno: String
    //Parámetros de entrada: Objeto de tipo dto y un id de tipo Long
    public String actualizarParcialmente(Long id, DTOProvider dto){
        try{
            Optional<ProviderEntity> optionalProvider = repo.findById(id);
            //Si el id del proveedor es encontrado, se verifican si los valores enviados en el JSON no son nulos
            if(optionalProvider.isPresent()){
                ProviderEntity entity = optionalProvider.get();
                //Si  no es nulo, se asigna el valor del dto al atributo del entity para cada campo
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
                if(dto.getProviderStatus() != null){
                    entity.setProviderStatus(dto.getProviderStatus());
                }
                if (dto.getProviderComments() != null){
                    entity.setProviderComments(dto.getProviderComments());
                }
                //Se guardan los datos
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

    //Metodo HTTP DELETE
    //Valor de retorno: String
    //Parámetros de entrada: Id de tipo Long
    public String eliminarProveedor(Long id){
        try {
            //Se busca un registro por id
            Optional<ProviderEntity> provider = repo.findById(id);
            //Si está presente el id, se elimina el registro
            if (provider.isPresent()){
                repo.deleteById(id);
                return "Proveedor eliminado correctamente";
            }
            //Si no está presente, se muestra el mensaje de error
            else {
                return "Error: proveedor no encontrado";
            }
        }
        catch (Exception e){
            return "Error al eliminar el proveedor: " + e.getMessage();
        }
    }
}


