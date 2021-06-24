package hrms.humanResourcesManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Proxy(lazy = false)
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
	
	@JsonProperty
	@Column(name="confirm")
	private boolean confirm=false;
	
	
	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private List<Advertisement> advertisements;
	
	@OneToOne(mappedBy = "employer")
	@JsonIgnore
	private UserConfirm userConfirm;



}