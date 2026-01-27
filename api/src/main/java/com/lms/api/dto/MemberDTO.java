package com.lms.api.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MemberDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime membershipExpDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<BookDTO> borrowedBooks;
    private MemberProfileDTO memberProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<BookDTO> getBorrowedBooks() {

        return borrowedBooks;
    }

    public void setBorrowedBooks(List<BookDTO> borrowedBooks) {

        this.borrowedBooks = borrowedBooks;
    }

    public MemberProfileDTO getMemberProfile() {
        return memberProfile;
    }

    public void setMemberProfile(MemberProfileDTO memberProfile) {
        this.memberProfile = memberProfile;
    }

}
