package SDA.FinalProject.repository.custom.impl;

import SDA.FinalProject.model.*;
import SDA.FinalProject.repository.custom.ContainerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.springframework.util.CollectionUtils.isEmpty;


public class ContainerRepositoryImplementation implements ContainerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Container> search(Long customerId, String containerNumber, Long carrierId,
                                  Set<ContainerStatus> containerStatuses, Set<ContainerType> containerTypes,
                                  LocalDate dateOfLoading, LocalDate dateOfDischarge, Long portOfLoadingId,
                                  Long portOfDischargeId, String forwarderNotice, String customerNotice) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Container> containerQuery = builder.createQuery(Container.class);
        Root<Container> root = containerQuery.from(Container.class);
        Predicate predicate = builder.conjunction();

        if (customerId != null) {
            Join<Container, Customer> containerCustomerJoin = root.join("customer", JoinType.LEFT);
            predicate = builder.and(predicate, builder.equal(containerCustomerJoin.get("id"),
                    customerId));
        }
        if (containerNumber != null) {
            predicate = builder.and(predicate, builder.like(builder.upper(root.get("containerNumber")),
                    containerNumber.toUpperCase()));
        }
        if (carrierId != null) {
            Join<Container, Carrier> containerCarrierJoin = root.join("carrier", JoinType.LEFT);
            predicate = builder.and(predicate, builder.equal(containerCarrierJoin.get("id"),
                    carrierId));
        }
        if (!isEmpty(containerStatuses)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("containerStatus")),
                    containerStatuses));
        }
        if (!isEmpty(containerTypes)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("containerType")),
                    containerTypes));
        }
        if (dateOfLoading != null) {
            predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get("dateOfLoading"),
                    dateOfLoading));
        }
        if (dateOfDischarge != null) {
            predicate = builder.and(predicate, builder.lessThanOrEqualTo(root.get("dateOfDischarge"),
                    dateOfDischarge));
        }

        if (portOfLoadingId != null) {
            Join<Container, Port> containerPortJoin = root.join("port", JoinType.LEFT);
            predicate = builder.and(predicate, builder.equal(containerPortJoin.get("id"),
                    portOfLoadingId));
        }
        if (portOfDischargeId != null) {
            Join<Container, Port> containerPortJoin = root.join("port", JoinType.LEFT);
            predicate = builder.and(predicate, builder.equal(containerPortJoin.get("id"),
                    portOfDischargeId));
        }
        if (forwarderNotice != null) {
            predicate = builder.and(predicate, builder.like(builder.upper(root.get("forwarderNotice")),
                    forwarderNotice.toUpperCase()));
        }
        if (customerNotice != null) {
            predicate = builder.and(predicate, builder.like(builder.upper(root.get("customerNotice")),
                    customerNotice.toUpperCase()));
        }
        CriteriaQuery<Container> query = containerQuery.where(predicate);

        return entityManager.createQuery(query).getResultList();

    }
}
