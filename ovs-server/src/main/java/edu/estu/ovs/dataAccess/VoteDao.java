package edu.estu.ovs.dataAccess;

import edu.estu.ovs.models.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteDao extends JpaRepository<Vote, Integer> {
}
