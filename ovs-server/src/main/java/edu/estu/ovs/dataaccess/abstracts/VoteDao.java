package edu.estu.ovs.dataaccess.abstracts;

import edu.estu.ovs.models.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteDao extends JpaRepository<Vote, Integer> {

    List<Vote> getByElection_Eid(Integer eid);

    List<Vote> getByVoter_Uid(Integer voterId);

    List<Vote> getByElection_EidAndCandidate_Uid(Integer eid, Integer candId);

    Vote findFirstByElection_EidAndVoter_Uid(Integer eid, Integer voterId);

}
