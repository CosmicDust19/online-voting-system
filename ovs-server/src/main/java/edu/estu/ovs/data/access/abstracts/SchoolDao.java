package edu.estu.ovs.data.access.abstracts;

import edu.estu.ovs.models.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao extends JpaRepository<School, Integer> {
}
