package springboot.grupoextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.grupoextra.model.EmpresaModel;


@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long>{
    EmpresaModel findByEmail(String email);
}   
