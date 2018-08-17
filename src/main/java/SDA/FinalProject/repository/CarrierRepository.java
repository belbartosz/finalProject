package SDA.FinalProject.repository;

import SDA.FinalProject.model.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {


    List<Carrier> findAllByNameContaining(String name);
    boolean existsByName(String name);

}
