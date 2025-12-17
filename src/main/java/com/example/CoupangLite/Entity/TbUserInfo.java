package com.example.CoupangLite.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USER_INFO")
public class TbUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int seq;
    private String id;
    private String pw;
    private String user_name;
    private int phone_number;
    private String user_type;
    private LocalDateTime account_join_date;
    private LocalDateTime account_delete_date;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public LocalDateTime getAccount_join_date() {
        return account_join_date;
    }

    public void setAccount_join_date(LocalDateTime account_join_date) {
        this.account_join_date = account_join_date;
    }

    public LocalDateTime getAccount_delete_date() {
        return account_delete_date;
    }

    public void setAccount_delete_date(LocalDateTime account_delete_date) {
        this.account_delete_date = account_delete_date;
    }

}
