package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Repositories;

import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Entities.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Indica que hay un repositorio de métodos
@Repository
//Se extiende los métodos de JpaRepository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
}
