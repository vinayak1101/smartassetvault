package com.ewm.model;

public class UserAccount {
    private String id;
    private String fullName;
    private String phone;
    private String email;      // used as login identifier
    private String password;   // plaintext for coursework (later hash)
    private String gender;
    private String role;       // ADMIN / USER

    public UserAccount() {}

    public UserAccount(String id, String fullName, String phone, String email,
                       String password, String gender, String role) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
