package springboot.grupoextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.grupoextra.model.DistribuidoraModel;


@Repository
public interface DistribuidoraRepository extends JpaRepository <DistribuidoraModel, Long> {
    DistribuidoraModel findByEmail(String email);
}
