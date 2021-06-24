package hrms.humanResourcesManagementSystem.entities.concretes;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "advertisements")
public class Advertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@Column(name = "advert_title")
	private String advertTitle;

	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@Column(name = "job_description")
	private String jobDescription;

	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "open_positions")
	private short openPositions;

	@Column(name = "is_active")
	private boolean isActive = true;

	@Column(name = "min_pay")
	private double minPay;

	@Column(name = "max_pay")
	private double maxPay;

	@Column(name = "starting_date")
	private LocalDateTime  startingDate  ;

	@Column(name = "ending_date")
	private LocalDate  endingDate;


}
