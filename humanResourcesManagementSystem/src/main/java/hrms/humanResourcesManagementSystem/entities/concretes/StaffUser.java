package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Proxy(lazy = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="staff_users")
public class StaffUser extends User {
	

	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String LastName;

	@JsonIgnore
	@OneToMany(mappedBy = "staffUser")
	private List<UserConfirm> userConfirm;
}

