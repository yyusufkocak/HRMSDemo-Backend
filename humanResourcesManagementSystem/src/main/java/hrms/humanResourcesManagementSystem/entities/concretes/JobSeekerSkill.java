package hrms.humanResourcesManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Job_seeker_skills")
public class JobSeekerSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
    private Skill skill;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
