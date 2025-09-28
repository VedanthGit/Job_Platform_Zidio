package com.example.job_platform.DTO;

public class AnalyticsResponse {

    public Long totalAuth;
    public Long totalStudents;
    public Long totalRecruiters;
    public Long totalJobPosts;
    public Long totalApplications;
    public Long totalAdmins;
    public Long totalFileUpload;
    public Long totalEmails;
    public Long totalSubscriptionPlan;
    public Long totalPayment;
    public Long totalUserPaymentStatus;

    // Default constructor
    public AnalyticsResponse() {}

    // Parameterized constructor
    public AnalyticsResponse(Long totalStudents,
                             Long totalRecruiters,
                             Long totalJobPosts,
                             Long totalAuth,
                             Long totalApplications,
                             Long totalAdmins,
                             Long totalEmails,
                             Long totalFileUpload,
                             Long totalSubscriptionPlan,
                             Long totalPayment,
                             Long totalUserPaymentStatus) {

        this.totalStudents = totalStudents;
        this.totalRecruiters = totalRecruiters;
        this.totalJobPosts = totalJobPosts;
        this.totalAuth = totalAuth;
        this.totalApplications = totalApplications;
        this.totalAdmins = totalAdmins;
        this.totalEmails = totalEmails;
        this.totalFileUpload = totalFileUpload;
        this.totalSubscriptionPlan = totalSubscriptionPlan;
        this.totalPayment = totalPayment;
        this.totalUserPaymentStatus = totalUserPaymentStatus;
    }
}
