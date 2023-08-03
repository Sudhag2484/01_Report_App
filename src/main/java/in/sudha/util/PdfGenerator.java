package in.sudha.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.sudha.entity.CitizenPlan;

@Component
public class PdfGenerator {
	private Logger logger=LoggerFactory.getLogger(PdfGenerator.class);

	public void generator(HttpServletResponse response,List<CitizenPlan> records,File f) throws Exception {
		
		
		try(Document document = new Document(PageSize.A4))//create doc with A4 page size
		{
		PdfWriter.getInstance(document, response.getOutputStream());//wtever doc created that is attached to outputstream
		PdfWriter.getInstance(document, new  FileOutputStream(f));
		document.open();//open doc
		Paragraph p = new Paragraph("Citizen Plan Info");
		document.add(p);
		
		PdfPTable table=new PdfPTable(8);
		
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("ENd Date");
		table.addCell("Benefit Amount");
		
		
		for(CitizenPlan plan:records)//from parameter cntr
			{
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
			table.addCell(String.valueOf(plan.getBenifitAmt()));
			
		}
		document.add(table);
		
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}
