package rw.rca.tresor.Models;

import javax.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users",
        uniqueConstraints={
        @UniqueConstraint(columnNames = "username"),
        }
)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String phone;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(String name,String username, String phone ,  String password) {
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    public User() {

    }
}
