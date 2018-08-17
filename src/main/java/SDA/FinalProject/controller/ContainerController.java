package SDA.FinalProject.controller;

import SDA.FinalProject.model.*;
import SDA.FinalProject.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/containers")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Container createContainer(@RequestBody @Valid Container container) {
        return containerService.create(container);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Container> searchContainers(
//            @RequestParam(required = false, defaultValue = "") String containerName,
//            @RequestParam(required = false, defaultValue = "") String carrierName,
//            @RequestParam(name = "containerStatus", required = false) Set<ContainerStatus> containerStatuses,
//            @RequestParam(name = "containerType", required = false) Set<ContainerType> containerTypes,
//            @RequestParam(required = false) LocalDate dateOfLoading,
//            @RequestParam(required = false) LocalDate dateOfDischarge,
//            @RequestParam(required = false) String portOfLoadingName,
//            @RequestParam(required = false) String portOfDischargeName,
//            @RequestParam(required = false) String forwarderNotice,
//            @RequestParam(required = false) String customerNotice) {
//        if(CollectionUtils.isEmpty(containerStatuses)){
//            Set<ContainerStatus> allStatuses = new HashSet<>();
//            allStatuses.add(ContainerStatus.DELIVERED);
//            allStatuses.add(ContainerStatus.DEPARTURED);
//            allStatuses.add(ContainerStatus.DISCHARGED);
//            allStatuses.add(ContainerStatus.PLANNED);
//            allStatuses.add(ContainerStatus.ORDERED);
//        }
//        if(CollectionUtils.isEmpty(containerTypes)){
//            Set<ContainerType> allTypes = new HashSet<>();
//            allTypes.add(ContainerType.c20dv);
//            allTypes.add(ContainerType.c20flatrack);
//            allTypes.add(ContainerType.c20opentop);
//            allTypes.add(ContainerType.c20reefer);
//            allTypes.add(ContainerType.c40dv);
//            allTypes.add(ContainerType.c40hcdv);
//            allTypes.add(ContainerType.c40flatrack);
//            allTypes.add(ContainerType.c40hcreefer);
//            allTypes.add(ContainerType.c40opentop);
//            allTypes.add(ContainerType.c45hcpalletwide);
//        }
//        return containerService.search(containerName, carrierName, containerStatuses, containerTypes,
//                dateOfLoading, dateOfDischarge, portOfLoadingName, portOfDischargeName,
//                forwarderNotice, customerNotice);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Container getContainerById(@PathVariable Long id) {
        return containerService.getById(id);
    }

    @GetMapping("/allContainers")
    @ResponseStatus(HttpStatus.OK)
    public List<Container> getAllContainers() {
        return containerService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContainerById(@PathVariable Long id) {
        containerService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Container updateContainerById(@RequestBody @Valid Container container, @PathVariable Long id) {
        container.setId(id);
        return containerService.updateById(container, id);
    }

}
