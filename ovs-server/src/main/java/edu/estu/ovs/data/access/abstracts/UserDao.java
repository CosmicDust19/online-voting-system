package edu.estu.ovs.data.access.abstracts;

import edu.estu.ovs.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    User getByEmail(String email);

}
