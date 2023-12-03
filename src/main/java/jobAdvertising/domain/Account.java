package jobAdvertising.domain;

public class Account {

    private Long id;

    private String username;

    private String password;

    private String role;

    private String admin_name = "group1admin";

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
