package edu.estu.ovs.models.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.ovs.core.utilities.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "uk_user_email"))
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false, columnDefinition = "integer")
    protected Integer uid;

    @Column(name = "email", nullable = false, length = Constants.MaxLength.EMAIL)
    protected String email;

    @Column(name = "password", nullable = false, length = Constants.MaxLength.BCRYPT_PW)
    @JsonIgnore
    protected String password;

    @Column(name = "f_name", nullable = false, length = Constants.MaxLength.F_NAME)
    protected String fName;

    @Column(name = "m_name", length = Constants.MaxLength.M_NAME)
    protected String mName;

    @Column(name = "l_name", nullable = false, length = Constants.MaxLength.L_NAME)
    protected String lName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date", nullable = false, columnDefinition = "date")
    protected LocalDate birthDate;

    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default false")
    protected Boolean enabled;

    @JsonFormat(pattern = "yyyy-MM-dd")
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
    @Column(name = "phone_number", nullable = false, length = Constants.MaxLength.PHONE_NUM)
    protected Set<String> phoneNumbers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "uid", nullable = false), foreignKey = @ForeignKey(name = "fk_user_authorities_uid"),
            inverseJoinColumns = @JoinColumn(name = "auth_id", nullable = false), inverseForeignKey = @ForeignKey(name = "fk_user_authorities_auth_id"),
            uniqueConstraints = @UniqueConstraint(name = "uk_user_authorities_uid_auth_id", columnNames = {"uid", "auth_id"})
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected List<Authority> authorities;

    @PrePersist
    public void onPrePersist() {
        this.enabled = true;
        this.creationDate = LocalDate.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.enabled = true;
    }

    @JsonIgnore
    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        if (this.authorities == null) return new ArrayList<>();
        return this.authorities.stream().map(authority ->
                new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
