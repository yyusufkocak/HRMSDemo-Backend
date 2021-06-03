package hrms.humanResourcesManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
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
	


}