package edu.estu.ovs.dataaccess.abstracts;

import edu.estu.ovs.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    boolean deleteByEmail(String email);

    Optional<User> findByEmail(String email);

    User getByEmail(String email);

}
