package com.inlimited.springmvc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name = "USER_NAME", nullable = false, length = 20)
    private String userName;
    @Column(name = "USER_EMAIL", nullable = false, length = 20)
    private String userEmail;
    @Column(name = "ROLE", length = 10)
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Receipt> receipts = new ArrayList<>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userId.equals(user.userId)) return false;
        if (!userName.equals(user.userName)) return false;
        if (!userEmail.equals(user.userEmail)) return false;
        return receipts != null ? receipts.equals(user.receipts) : user.receipts == null;
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + userEmail.hashCode();
        result = 31 * result + (receipts != null ? receipts.hashCode() : 0);
        return result;
    }
}
