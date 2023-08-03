package in.sudha.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="CITIZEN_PLAN_INFO")
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;//yyyy-MM-dd
	private LocalDate planEndDate;
	private Double benifitAmt;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminatedReason;
	

	
	

}
