package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Proxy(lazy = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@OneToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobSeekerSkill> jobSeekerSkills;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobSeekerLanguage> jobSeekerLanguages;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobSeekerEducation> jobSeekerEducations;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<CoverLetter> coverLetters;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Link> links;
	

}
