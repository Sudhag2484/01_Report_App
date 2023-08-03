package in.sudha.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.sudha.constants.AppConstants;
import in.sudha.entity.CitizenPlan;
import in.sudha.repo.CitizenPlanRepo;

@Component
public class DataLoader  implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepo repo;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		
		//first it delete the existing data and add new data to db table
		repo.deleteAll();
		
		//Cash Plan -Approval
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus(AppConstants.APPROVED);
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmt(5000.00);
		
		//Cash plan -Denial
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Martin");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus(AppConstants.DENIED);
		c2.setDenialReason("Renatl Income");
		

		//Cash plan -Terminated
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Smith");
		c3.setGender(AppConstants.FEMALE);
		c3.setPlanName("Cash");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmt(5000.00);
		c3.setPlanStatus(AppConstants.TERMINATED);
		c3.setTerminatedReason("Employeed");
		c3.setTerminatedDate(LocalDate.now());
		
		//Food Plan -Approval
				CitizenPlan c4 = new CitizenPlan();
				c4.setCitizenName("David");
				c4.setGender("Male");
				c4.setPlanName("Food");
				c4.setPlanStatus(AppConstants.APPROVED);
				c4.setPlanStartDate(LocalDate.now());
				c4.setPlanEndDate(LocalDate.now().plusMonths(6));
				c4.setBenifitAmt(4500.00);
				
				//Food plan -Denial
				CitizenPlan c5 = new CitizenPlan();
				c5.setCitizenName("Neel");
				c5.setGender("Male");
				c5.setPlanName("Food");
				c5.setPlanStatus(AppConstants.DENIED);
				c5.setDenialReason(AppConstants.PROP_INC);
				

				//Food plan -Terminated
				CitizenPlan c6 = new CitizenPlan();
				c6.setCitizenName("Orlen");
				c6.setGender(AppConstants.FEMALE);
				c6.setPlanName("Food");
				c6.setPlanStartDate(LocalDate.now().minusMonths(4));
				c6.setPlanEndDate(LocalDate.now().plusMonths(6));
				c6.setBenifitAmt(4000.00);
				c6.setPlanStatus(AppConstants.TERMINATED);
				c6.setTerminatedReason("Employeed");
				c6.setTerminatedDate(LocalDate.now());
		
				//Medical Plan -Approval
				CitizenPlan c7 = new CitizenPlan();
				c7.setCitizenName("Charles");
				c7.setGender("Male");
				c7.setPlanName(AppConstants.MEDICAL);
				c7.setPlanStatus(AppConstants.APPROVED);
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenifitAmt(3000.00);
				
				//Medical plan -Denial
				CitizenPlan c8 = new CitizenPlan();
				c8.setCitizenName("Roy");
				c8.setGender("Male");
				c8.setPlanName(AppConstants.MEDICAL);
				c8.setPlanStatus(AppConstants.DENIED);
				c8.setDenialReason(AppConstants.PROP_INC);
				

				//Medical plan -Terminated
				CitizenPlan c9 = new CitizenPlan();
				c9.setCitizenName("Tinku");
				c9.setGender("Female");
				c9.setPlanName(AppConstants.MEDICAL);
				c9.setPlanStartDate(LocalDate.now().minusMonths(4));
				c9.setPlanEndDate(LocalDate.now().plusMonths(6));
				c9.setBenifitAmt(5500.00);
				c9.setPlanStatus(AppConstants.TERMINATED);
				c9.setTerminatedReason("Govt Job");
				c9.setTerminatedDate(LocalDate.now());
				

				//Emp Plan -Approval
				CitizenPlan c10 = new CitizenPlan();
				c10.setCitizenName("Kings");
				c10.setGender("Male");
				c10.setPlanName(AppConstants.EMPLOYMENT);
				c10.setPlanStatus(AppConstants.APPROVED);
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenifitAmt(2500.00);
				
				//Emp plan -Denial
				CitizenPlan c11 = new CitizenPlan();
				c11.setCitizenName("Prince");
				c11.setGender("Male");
				c11.setPlanName(AppConstants.EMPLOYMENT);
				c11.setPlanStatus(AppConstants.DENIED);
				c11.setDenialReason(AppConstants.PROP_INC);
				

				//Emp plan -Terminated
				CitizenPlan c12 = new CitizenPlan();
				c12.setCitizenName("Reeta");
				c12.setGender(AppConstants.FEMALE);
				c12.setPlanName(AppConstants.EMPLOYMENT);
				c12.setPlanStartDate(LocalDate.now().minusMonths(4));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenifitAmt(2000.00);
				c12.setPlanStatus(AppConstants.TERMINATED);
				c12.setTerminatedReason("Govt Job");
				c12.setTerminatedDate(LocalDate.now());
				
				List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
				
				repo.saveAll(list);
		}



}
