package SDA.FinalProject.repository;

import SDA.FinalProject.model.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {

//    List<Port> findByNameContaining(String name);
    boolean existsByName(String name);
}
