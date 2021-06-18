package hrms.humanResourcesManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.wsdl.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Job_seeker_languages")
public class JobSeekerLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	
//	@Min(value = 1) bende bu ve bununla aynı işi yapan anotasyonlar çalışmadığı için aşağıda setLanguageLevel kısmında if-else ile halletmeye çalıştım 
//	@Max(value = 5)
	@Column(name ="language_level")
	private Byte languageLevel;
	
	
	public void setLanguageLevel(Byte languageLevel) {
		
		if (languageLevel>=1 && languageLevel<=5) {
			this.languageLevel = languageLevel;
		}
		else {
			System.out.print("Lütfen 1 ve 5 arasında bir değer giriniz");   
		}
	}
	
}
