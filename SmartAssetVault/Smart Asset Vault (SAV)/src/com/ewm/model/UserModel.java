package com.ewm.model;

public class UserModel {
    private String id;
    private String fullName;
    private String phone;
    private String email;
    private String password;
    private String gender;
    private String role;

    public UserModel() {}

    // Convert from store model
    public static UserModel fromAccount(UserAccount acc) {
        if (acc == null) return null;
        UserModel u = new UserModel();
        u.id = acc.getId();
        u.fullName = acc.getFullName();
        u.phone = acc.getPhone();
        u.email = acc.getEmail();
        u.password = acc.getPassword();
        u.gender = acc.getGender();
        u.role = acc.getRole();
        return u;
    }

    // Convert to store model
    public UserAccount toAccount() {
        UserAccount acc = new UserAccount();
        acc.setId(id);
        acc.setFullName(fullName);
        acc.setPhone(phone);
        acc.setEmail(email);
        acc.setPassword(password);
        acc.setGender(gender);
        acc.setRole(role);
        return acc;
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
