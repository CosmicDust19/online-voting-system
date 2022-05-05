package edu.estu.ovs.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "uk_user_email"))
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false, columnDefinition = "integer")
    protected Integer uid;

    @Column(name = "email", nullable = false, length = 100)
    protected String email;

    @Column(name = "password", nullable = false, length = 100)
    @JsonIgnore
    protected String password;

    @Column(name = "f_name", nullable = false, length = 30)
    protected String fName;

    @Column(name = "m_name", length = 30)
    protected String mName;

    @Column(name = "l_name", nullable = false, length = 30)
    protected String lName;

    @Column(name = "birth_date", nullable = false, columnDefinition = "date")
    protected LocalDate birthDate;

    @Column(name = "creation_date", nullable = false, updatable = false, columnDefinition = "date default current_date")
    protected LocalDate creationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_phone_numbers",
            joinColumns = @JoinColumn(name = "uid"), foreignKey = @ForeignKey(name = "fk_user_phone_numbers_uid"),
            uniqueConstraints = @UniqueConstraint(name = "uk_user_phone_numbers_phone_number", columnNames = "phone_number")
    )
    @JoinColumn(name = "uid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "phone_number", nullable = false, length = 17)
    protected Set<String> phoneNumbers;

}