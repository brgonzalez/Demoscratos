package com.itcr.demoscratos.services;

import java.util.List;

import com.itcr.demoscratos.api.RequestController;
import com.itcr.demoscratos.models.FullTopic;
import com.itcr.demoscratos.models.Report;
import com.itcr.demoscratos.models.TotalVotes;

public class LaTeXReportService {
	
	private RequestController rc = RequestController.getInstance();
	private DateService dateService = new DateService();
	
	private String pathReports = "/home/brgonzalez/Descargas/Reportes/";
	private String ext = ".tex";
	
	public void generateReport(String idTopic){
		FileService fileService = new FileService();
		if (!fileService.exists(pathReports)){
			fileService.createDirectory(pathReports);
		}
		fileService.createFile(pathReports+idTopic+ext);
		fileService.writeFile(pathReports+idTopic+ext, writeReport(idTopic));
	}
	
	public String writeReport(String idTopic){
		String report ="";
		String space ="\\ \\\\"+"\n";
		FullTopic topic = rc.getFullTopic(idTopic);
		Report r = rc.getReport(idTopic);
		
		report +="\\documentclass[a4paper,10pt]{article}\n";
		report +="\\usepackage[utf8]{inputenc}\n";

		report +="\\title{Reporte del tema: "+topic.getTitle() +"}\n";
		report +="\\author{Administrador Demoscratos}\n";

		report +="\\begin{document}\n";
		
		report += space;
		
		report +="\\maketitle\n";
		
		report +="\\centering"+"\n";
		
		report +="Fecha de creación: "+ dateService.normalizeDate((String) topic.getCreatedAt())+"\n";
		report += space;
		report += space;
		report +="Fecha de cierre: "+ dateService.normalizeDate((String) topic.getClosingAt())+"\n";
		report += space;
		report += space;
		report += "Total de participantes: "+r.getTotalParticipants()+"\n";
		report += space;
		report += space;
		
		report +="Según las votaciones del tema, estos son los resultados actuales \n";
		report +="\\ \\\\"+"\n";
		report += space;
		report += space;
		
		report +="\\centering"+"\n";
		report +="\\begin{tabular}{| l | c |}"+"\n";
		report +="\\hline"+"\n";		
		report +="Opción de voto & Cantidad de votos \\\\"+"\n";
		report += "\\hline"+"\n";
		List<TotalVotes> totalVotes = r.getTotalVotes();
		for(int i = 0 ; i < totalVotes.size(); i++){
			report+=totalVotes.get(i).getOption().getOption()+" & "+totalVotes.get(i).getTotal()+"\\\\"+"\n";
		}
		
		report += "\\hline"+"\n";  
		report += "\\end{tabular}"+"\n";
		
		report +="\\medskip\n";



		report +="\\end{document}\n";

		return report;
	}
	public static void main(String[] args){
		LaTeXReportService s = new LaTeXReportService();
		System.out.println(s.writeReport(""));
	}

}
