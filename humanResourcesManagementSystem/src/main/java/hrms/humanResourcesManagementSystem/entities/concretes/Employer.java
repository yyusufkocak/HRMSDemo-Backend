package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employers")
public class Employer extends User{
	

	@Column(name="company_name")
	private String companyName;
	

	@Column(name="web_address")
	private String webAddress;

	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private List<Advertisement> advertisements;
	
	
}