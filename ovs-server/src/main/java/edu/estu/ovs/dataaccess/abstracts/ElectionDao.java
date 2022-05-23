package edu.estu.ovs.dataaccess.abstracts;

import edu.estu.ovs.models.entities.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionDao extends JpaRepository<Election, Integer> {
}
