package springboot.grupoextra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.grupoextra.model.FeedBackModel;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBackModel, Long>{

    Optional<FeedBackModel> findById(Long id);
}
