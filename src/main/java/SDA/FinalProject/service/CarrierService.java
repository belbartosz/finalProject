package SDA.FinalProject.service;

import SDA.FinalProject.exception.AlreadyExistsException;
import SDA.FinalProject.exception.NotFoundException;
import SDA.FinalProject.model.Carrier;
import SDA.FinalProject.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;

    public Carrier create (Carrier carrier){
        if(carrierRepository.existsByName(carrier.getName())){
            throw new AlreadyExistsException(String.format("Carrier with NAME= %s already exists", carrier.getName()));
        }
        return carrierRepository.save(carrier);
    }

    public Carrier getOneById (Long id){
        Optional<Carrier> carrier = carrierRepository.findById(id);
        if(!carrier.isPresent()){
            throw new NotFoundException(String.format("Carrier with ID= %s does not exist",id));
        }
        return carrier.get();
    }

    public List<Carrier> getAll (){
        return carrierRepository.findAll(new Sort(Sort.Direction.ASC,"name"));
    }

    public List<Carrier> search (String name){
        return carrierRepository.findAllByNameContaining(name);
    }

    public void deleteById (Long id){
        if(!carrierRepository.existsById(id)){
            throw new NotFoundException(String.format("Carrier with ID= %s does not exist",id));
        }
        carrierRepository.deleteById(id);
    }

    public Carrier updateById (Carrier carrier, Long id){
        if(!carrierRepository.existsById(id)){
            throw new NotFoundException(String.format("Carrier with ID= %s does not exist",id));
        }
        if(carrierRepository.existsByName(carrier.getName())){
            throw new AlreadyExistsException(String.format("Carrier with NAME= %s already exists", carrier.getName()));
        }
        carrier.setId(id);
        return carrierRepository.save(carrier);
    }

}
