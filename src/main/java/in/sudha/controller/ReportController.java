package in.sudha.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sudha.binding.SearchRequest;
import in.sudha.entity.CitizenPlan;
import in.sudha.servive.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search",new SearchRequest());	//2nd method
		init(model);
		return "index";		//telling that displaying in index page by returning page
}

	private void init(Model model) {
		model.addAttribute("name", service.getPlanName());		//to get planname from service
		model.addAttribute("status", service.getPlanStatus());		//to get planstatus from service
	}
	@PostMapping("/searchele")
	public String handleSearch(@ModelAttribute("search") SearchRequest req,Model model) {
		//System.out.println(req);//selected dropdown coming to UI or not see on console
		List<CitizenPlan> plans = service.searchBtn(req);
		model.addAttribute("plans",plans);//to get all output without any filter if click on search
		init(model);
		return "index";
	}
	//for pdf download
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");//pdf represents as pdf
		response.addHeader("content-Disposition", "attachment:filename=plans.pdf");//telling the browser sending one file as attachment just download
		service.exportPdf(response);
	}
	
	//for excel download
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");//octet represents as xl
		response.addHeader("content-Disposition", "attachment:filename=plans.xls");//telling the browser sending one file as attachment just download
	    service.exportExcel(response);
	}
}
