package edu.estu.ovs.dataaccess.abstracts;

import edu.estu.ovs.models.entities.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationDao extends JpaRepository<Certification, Integer> {
}
