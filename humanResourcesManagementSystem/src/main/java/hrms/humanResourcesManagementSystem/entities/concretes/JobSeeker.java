package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Proxy(lazy = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "job_seekers")
public class JobSeeker extends User {

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "nationality_identity")
	private String nationalityIdentity;

	@NotNull
	@Column(name = "birth_of_year")
	private String birthOfYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")	
	private List<CoverLetter> coverLetters; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")	
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")	
	private List<JobSeekerEducation>  jobSeekerEducations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")	
	private List<JobSeekerLanguage>  jobSeekerLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")	
	private List<JobSeekerSkill>  jobSeekerSkills;


	
	@JsonIgnore
	@OneToOne (mappedBy = "jobSeeker")	
	private Resume resume;


}