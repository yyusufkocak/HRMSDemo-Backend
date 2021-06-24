package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDateTime;

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

@Proxy(lazy = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user_confirms")
public class UserConfirm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="confirmed_date")
	private LocalDateTime ConfirmedDate;
	
	@ManyToOne
	@JoinColumn(name="confirming_staff_id")
	private StaffUser staffUser;
	
	
	@OneToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	
}
