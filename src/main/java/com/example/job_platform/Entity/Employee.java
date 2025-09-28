package com.example.job_platform.Entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private String name;

    @Column(unique=true)
    private String email;
    private String phone;
    private String qualification;
    private String resumeURL;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    private String password;

    public Employee() {}
    public Employee(Long id,String name,String email,String phone,String qualification,String resumeURL, User user, String password) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.qualification=qualification;
        this.resumeURL=resumeURL;
        this.user = user;
        this.password = password;
    }

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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getResumeURL() {
        return resumeURL;
    }
    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}