package com.example.job_platform.Entity;

import java.time.LocalDate;

import com.example.job_platform.Enum.PaymentStatus;

import javax.persistence.*;

@Entity
@Table(name="subscriptions")
public class PaidSubscription {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private Long recruiterId;
	private Long employeeId;
	private Long planId;
	private Long amount;
	private String userEmail;
	private LocalDate startDate;
	private LocalDate endDate;
	private String currency;
	private PaymentStatus paymentStatus;
	private String invoiceUrl;
	
	public PaidSubscription() {}
	public PaidSubscription( Long id,Long recruiterId,Long employeeId,Long planId,Long amount,String userEmail, LocalDate startDate, LocalDate endDate,String currency,PaymentStatus paymentStatus, String invoiceUrl) {
		this.id=id;
		this.recruiterId=recruiterId;
		this.employeeId=employeeId;
		this.planId=planId;
		this.amount=amount;
		this.userEmail=userEmail;
		this.startDate=startDate;
		this.endDate=endDate;
		this.currency=currency;
		this.paymentStatus=paymentStatus;
		this.invoiceUrl=invoiceUrl;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getPlanId() {
		return planId;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getInvoiceUrl() {
		return invoiceUrl;
	}
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}
	
}
