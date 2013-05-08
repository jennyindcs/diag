package data;

import com.google.gson.Gson;

public class ProblemPieChart {
	String problemID;
	String problemName;
	double percentage_yes;
	double percentage_maybe;
	double percentage_no;
	
	public void setProblemID(String pid){
		problemID = pid;
	}
	public String getProblemID(){
		return problemID;
	}
	
	public void setProblemName(String pname){
		problemName = pname;
	}
	public String getProblemName(){
		return problemName;
	}
	
	public void setPercentageYes(double pyes){
		percentage_yes = pyes;
	}
	public double getPercentageYes(){
		return percentage_yes;
	}
	
	public void setPercentageMaybe(double pmb){
		percentage_maybe = pmb;
	}
	public double getPercentageMaybe(){
		return percentage_maybe;
	}
	
	public void setPercentageNo(double pno){
		percentage_no = pno;
	}
	public double getPercentageNo(){
		return percentage_no;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
