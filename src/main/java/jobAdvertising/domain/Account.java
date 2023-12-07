package jobAdvertising.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;

    private String password;

    private String role;

//    private List<String> skills;
//
//    public List<String> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<String> skills) {
//        this.skills = skills;
//    }
    @Transient // This annotation excludes the field from persistence
    private String admin_name = "group1admin";

    @Transient
    private String admin_pass = "password123";

    public Long getId() { return id;}

    public void setId(Long id){this.id = id;}

    public String getUsername() { return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() { return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRole() { return role;}

    public void setRole(String username) {this.role = role;}

    public String getAdmin_name() { return admin_name;}

    public String getAdmin_pass() { return admin_pass;}

}
