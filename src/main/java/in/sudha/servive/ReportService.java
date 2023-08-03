package in.sudha.servive;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.sudha.binding.SearchRequest;
import in.sudha.entity.CitizenPlan;

public interface ReportService {
	
	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
   public List<CitizenPlan> searchBtn(SearchRequest req);
   
   public boolean exportExcel(HttpServletResponse response) throws Exception;
   
   public boolean exportPdf(HttpServletResponse response) throws Exception;
}
