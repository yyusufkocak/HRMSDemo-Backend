package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Proxy(lazy = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="skills")
public class Skill {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="skill_name")
	private String skillName;

	@JsonIgnore
	@OneToMany(mappedBy = "skill")	
	private List<JobSeekerSkill> jobSeekerSkills;
	

}
