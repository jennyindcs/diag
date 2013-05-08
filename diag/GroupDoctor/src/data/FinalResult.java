package data;



import java.util.Vector;

import com.google.gson.Gson;



public class FinalResult {
	
	public ProblemPieChart chart1;
	
	public ProblemPieChart chart2;

	public ProblemPieChart chart3;

	public ProblemPieChart chart4;

	public ProblemPieChart chart5;


	public Vector<GroupResult> vecGR;

	public Vector<StudentResult> vecSR;

	public String getGroupResultsJSON() {
		Gson gson = new Gson();
		return gson.toJson(vecGR);
	}
	
	public String getStudentResultsJSON() {
		Gson gson = new Gson();
		return gson.toJson(vecSR);
	}
}