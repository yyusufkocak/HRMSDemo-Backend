package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "starting_date")
	private LocalDate startingDate;
	

	@Column(name = "ending_date",nullable = true)
	private LocalDate endingDate;
	
	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	public String getEndingDate() {

		if (endingDate == null) {
			
			return "Devam ediyor.";
		}

		return endingDate.toString();
	}
	
	

}
