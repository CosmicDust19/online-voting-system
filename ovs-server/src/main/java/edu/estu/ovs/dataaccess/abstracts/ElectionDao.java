package edu.estu.ovs.dataaccess.abstracts;

import edu.estu.ovs.models.entities.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionDao extends JpaRepository<Election, Integer> {

    List<Election> findByExecutives_UidOrderByCreationDate(Integer adminId);

    List<Election> findByCreator_UidOrderByCreationDate(Integer adminId);

}
