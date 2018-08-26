package SDA.FinalProject.repository.custom;

import SDA.FinalProject.model.Container;
import SDA.FinalProject.model.ContainerStatus;
import SDA.FinalProject.model.ContainerType;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ContainerRepositoryCustom {

    List<Container> search(Long customerId,
                           String containerNumber, Long carrierId,
                           Set<ContainerStatus> containerStatuses, Set<ContainerType> containerTypes,
                           LocalDate dateOfLoading, LocalDate dateOfDischarge, Long portOfLoadingId,
                           Long portOfDischargeId, String forwarderNotice, String customerNotice);

}
