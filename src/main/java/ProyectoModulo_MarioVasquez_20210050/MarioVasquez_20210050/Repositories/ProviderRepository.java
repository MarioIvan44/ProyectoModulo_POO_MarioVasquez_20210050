package ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Repositories;

import ProyectoModulo_MarioVasquez_20210050.MarioVasquez_20210050.Entities.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
}
