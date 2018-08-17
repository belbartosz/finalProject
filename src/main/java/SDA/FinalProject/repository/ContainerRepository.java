package SDA.FinalProject.repository;

import SDA.FinalProject.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    List<Container> findAllByContainerNumberContaining(String name);

//    List<Container> findAllByContainerNumberContainingAndCarrier_NameContainingAndContainerStatusInAndContainerTypeInAndDateOfLoadingGreaterThanEqualAndDateOfDischargeLessThanEqualAndPortOfLoading_NameContainingAndPortOfDischarge_NameContainingAndforwarderNoticeContainingAndCustomerNoticeContaining(
//            String containerNumber, String carrierName, Set<ContainerStatus> containerStatuses, Set<ContainerType> containerTypes, LocalDate dateOfLoading, LocalDate dateOfDischarge, String portOfLoadingName, String portOfDischargeName, String forwarderNotice, String customerNotice);


}
