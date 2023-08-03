package in.sudha.servive;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import in.sudha.binding.SearchRequest;
import in.sudha.entity.CitizenPlan;
import in.sudha.repo.CitizenPlanRepo;
import in.sudha.util.EmailSender;
import in.sudha.util.ExcelGenerator;
import in.sudha.util.PdfGenerator;
import java.util.logging.Logger;


@Service
public class ReportServiceImpl implements ReportService {
	private static final Logger logger = Logger.getLogger(ReportServiceImpl.class.getName());


	@Autowired
	private CitizenPlanRepo planrepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailSender emailUtils;
	
	@Override
	public List<String> getPlanName() {
		//2nd method
		return planrepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return planrepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> searchBtn(SearchRequest req) {
		//copy binding obj into entity obj 1st create entity obj
		CitizenPlan entityObj=new CitizenPlan();
		
		
		//if plan name not empty and not null then only set the plan name
		if(null!=req.getPlanName() && !"".equals(req.getPlanName())) {
			entityObj.setPlanName(req.getPlanName());
		}
		if(null!=req.getPlanStatus() && !"".equals(req.getPlanStatus())) {
			entityObj.setPlanStatus(req.getPlanStatus());
		}
		if(null!=req.getGender() && !"".equals(req.getGender())) {
			entityObj.setGender(req.getGender());
		}
		if(null!=req.getStartDate()&& !"".equals(req.getStartDate())) {
			String startDate = req.getStartDate();
			DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//convert String to local date
			LocalDate localDate = LocalDate.parse(startDate, ofPattern);
			entityObj.setPlanStartDate(localDate);
		}
		if(null!=req.getEndDate()&& !"".equals(req.getEndDate())) {
			String endDate = req.getEndDate();
			DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//convert String to local date
			LocalDate localDate = LocalDate.parse(endDate, ofPattern);
			entityObj.setPlanEndDate(localDate);
		}
		
		return planrepo.findAll(Example.of(entityObj));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		File file=new File("Plans.xls");
		List<CitizenPlan> excelplans = planrepo.findAll();
		excelGenerator.generator(response, excelplans,file);
		
		String subject="Test mail";
		String body="<h1>Hello Test </h1>";
		String to="sudhag9686@gmail.com";
		
	
		emailUtils.sendMail(subject, body, to,file);
	
			boolean delete = file.delete();
			if(delete) {
				logger.info("File deleted successfully!");
			}else {
				logger.warning("File deleted Fail!");
			}
		

		return true;
	}
	
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f=new File("Plans.pdf");
		
		List<CitizenPlan> pdfplans = planrepo.findAll();
		pdfGenerator.generator(response, pdfplans ,f);
		
		String subject="Test mail";
		String body="<h1>Hello Test </h1>";
		String to="sudhag9686@gmail.com";
		
		emailUtils.sendMail(subject, body, to,f);
		boolean delete = f.delete();
		
		if(delete) {
			logger.info("File deleted successfully!");
		}else {
			logger.warning("File deleted Fail!");
		}
		return true;
	}

}
