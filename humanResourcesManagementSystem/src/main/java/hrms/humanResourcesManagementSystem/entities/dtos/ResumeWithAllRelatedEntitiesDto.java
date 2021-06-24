package hrms.humanResourcesManagementSystem.entities.dtos;

import java.util.List;

import org.hibernate.annotations.Proxy;

import hrms.humanResourcesManagementSystem.entities.concretes.CoverLetter;
import hrms.humanResourcesManagementSystem.entities.concretes.JobExperience;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerEducation;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerLanguage;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeekerSkill;
import hrms.humanResourcesManagementSystem.entities.concretes.Link;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResumeWithAllRelatedEntitiesDto {
	
	private int id;
	private String jobSeekerName;
	private List<JobSeekerEducation> educations;
	private List<JobSeekerSkill> jobSeekerSkills;
	private List<Link> links;
	private List<JobExperience> jobExperiences;
	private List<JobSeekerLanguage> languages;
	private List<CoverLetter> coverLetters;
}
