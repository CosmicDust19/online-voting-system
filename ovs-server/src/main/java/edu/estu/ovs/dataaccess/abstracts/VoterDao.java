package edu.estu.ovs.dataaccess.abstracts;

import edu.estu.ovs.models.entities.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterDao extends JpaRepository<Voter, Integer> {
}
