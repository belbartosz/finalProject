package SDA.FinalProject.service;

import SDA.FinalProject.exception.NotFoundException;
import SDA.FinalProject.model.*;
import SDA.FinalProject.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;


    public Container create(Container container) {
        return containerRepository.save(container);
    }

    public Container getById(Long id) {
        Optional<Container> container = containerRepository.findById(id);
        if (!container.isPresent()) {
            throw new NotFoundException(String.format("Container with ID= %s does not exist"));
        }
        return container.get();
    }

    public List<Container> search(Long customerId, String containerNumber, Long carrierId, Set<ContainerStatus> containerStatuses,
                                   Set<ContainerType> containerTypes, LocalDate dateOfLoading, LocalDate dateOfDischarge,
                                   Long portOfLoadingId, Long portOfDischargeId, String forwarderNotice, String customerNotice) {
        return containerRepository.search(customerId, containerNumber, carrierId, containerStatuses, containerTypes, dateOfLoading, dateOfDischarge, portOfLoadingId, portOfDischargeId, forwarderNotice, customerNotice);
        }

    public List<Container> getAll() {
        return containerRepository.findAll();
    }

    public void deleteById(Long id) {
        if (!containerRepository.existsById(id)) {
            throw new NotFoundException(String.format("Container with ID= %s does not exist"));
        }
        containerRepository.deleteById(id);
    }

    public Container updateById(Container container, Long id) {
        if (!containerRepository.existsById(id)) {
            throw new NotFoundException(String.format("Container with ID= %s does not exist"));
        }
        container.setId(id);
        return containerRepository.save(container);
    }
}
