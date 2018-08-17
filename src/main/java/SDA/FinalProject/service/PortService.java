package SDA.FinalProject.service;

import SDA.FinalProject.exception.AlreadyExistsException;
import SDA.FinalProject.exception.NotFoundException;
import SDA.FinalProject.model.Port;
import SDA.FinalProject.repository.PortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortService {

    @Autowired
    private PortRepository portRepository;

    public Port create (Port port){
        if(portRepository.existsByName(port.getName())){
            throw new AlreadyExistsException(String.format("Port with NAME= %s already exists", port.getName()));
        }
        return portRepository.save(port);
    }

    public Port getById (Long id){
        Optional<Port> port = portRepository.findById(id);
        if(!port.isPresent()){
            throw new NotFoundException(String.format("Port with ID= %s does not exist"));
        }
        return port.get();
    }

    public List<Port> getAll (){
        return portRepository.findAll(new Sort(Sort.Direction.ASC,"name"));
    }

    public List<Port> search (String name){
        return portRepository.findByNameContaining(name);
    }

    public void deleteById (Long id){
        if(!portRepository.existsById(id)){
            throw new NotFoundException(String.format("Port with ID= %s does not exist"));
        }
        portRepository.deleteById(id);
    }

    public Port updateById (Port port, Long id){
        if(!portRepository.existsById(id)){
            throw new NotFoundException(String.format("Port with ID= %s does not exist"));
        }
        if(portRepository.existsByName(port.getName())){
            throw new AlreadyExistsException(String.format("Port with NAME= %s already exists", port.getName()));
        }
        port.setId(id);
        return portRepository.save(port);
    }

}
