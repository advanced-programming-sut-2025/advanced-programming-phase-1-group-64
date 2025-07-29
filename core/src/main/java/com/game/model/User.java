package com.game.model;

import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @Column(nullable = false)
    private String nickname;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private String securityQuestion;
    @Column(name = "security_answer_hash", nullable = false)
    private String securityAnswerHash;

    public User() {}

    @PrePersist
    private void hashData() {
        if (this.passwordHash != null) {
            this.passwordHash = BCrypt.hashpw(this.passwordHash, BCrypt.gensalt());
        }

        if (this.securityAnswerHash != null) {
            this.securityAnswerHash = BCrypt.hashpw(this.securityAnswerHash, BCrypt.gensalt());
        }
    }

    public void setPassword(String rawPassword) {
        this.passwordHash = rawPassword;
    }

    public void setSecurityAnswer(String rawAnswer) {
        this.securityAnswerHash = rawAnswer;
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public String getSecurityQuestion() { return securityQuestion; }
    public void setSecurityQuestion(String securityQuestion) { this.securityQuestion = securityQuestion; }
    public String getSecurityAnswerHash() { return securityAnswerHash; }
}
