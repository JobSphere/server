package com.portal.jobsphere.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.portal.jobsphere.utils.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="post")
public class Post implements Constants {

	@Column(nullable = false)
	private UUID profileId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID postId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String location;

	@Column(nullable = false)
	private String description;

	@Column
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> requirements;

	@Column
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> responsibilities;

	@Column(name = "num_of_applicants")
	private Integer numOfApplicants;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "total_applicants", nullable = false)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> idsOfAppliedApplicants;

	public Post() {
	}

	public Post(UUID profileId, String title, String description, List<String> requirements, List<String> responsibilities, String location) {
		this.profileId = profileId;
		this.title = title;
		this.description = description;
		this.requirements = requirements;
		this.responsibilities = responsibilities;
		this.location = location;
		this.numOfApplicants = 0;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		this.idsOfAppliedApplicants = new ArrayList<>();
	}

	public UUID getProfileId() {
		return profileId;
	}
	
	public UUID getPostId() {
		return postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt.format(formatter);
	}

	public String getUpdatedAt() {
		return updatedAt.format(formatter);
	}

	public void setUpdatedAt() {
		updatedAt = LocalDateTime.now();
	}

	public Integer getNumOfApplicants() {
		return numOfApplicants;
	}

	public void setNumOfApplicants(Integer numOfApplicants) {
		this.numOfApplicants = numOfApplicants;
	}

	public List<String> getIdsOfAppliedApplicants() {
		return idsOfAppliedApplicants;
	}

	public void setIdsOfAppliedApplicants(List<String> idsOfAppliedApplicants) {
		this.idsOfAppliedApplicants = idsOfAppliedApplicants;
	}

	public List<String> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<String> requirements) {
		this.requirements = requirements;
	}

	public List<String> getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}
}
