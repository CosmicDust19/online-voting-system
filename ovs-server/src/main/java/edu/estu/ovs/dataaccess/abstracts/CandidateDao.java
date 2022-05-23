package edu.estu.ovs.dataaccess.abstracts;

import edu.estu.ovs.models.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
}
