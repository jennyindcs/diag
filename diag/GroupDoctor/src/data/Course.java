package data;

//import java.util.Vector;

public class Course {
	
	String courseID;
	double parameter1, parameter2, parameter4, parameter5;
	int parameter3;
	int avgGroupFeedback, avgGroupPosts;
	
	public String getcourseID(){
		return courseID;
	}
	
	public void setcourseID(String id){
		courseID=id;
	}

	public int getavgGroupFeedback(){
		return avgGroupFeedback;
	}
	public void setavgGroupFeedback(int af){
		avgGroupFeedback = af;
	}
	
	public int getavgGroupPosts(){
		return avgGroupPosts;
	}
	public void setavgGroupPosts(int ap){
		avgGroupPosts = ap;
	}
	
	public double getParameter1(){
		return parameter1;
	}
	
	public void setParameter1(double p1){
		parameter1=p1;
	}
	
	public double getParameter2(){
		return parameter2;
	}
	
	public void setParameter2(double p2){
		parameter2=p2;
	}
	
	public int getParameter3(){
		return parameter3;
	}
	
	public void setParameter3(int p3){
		parameter3=p3;
	}
	
	public double getParameter4(){
		return parameter4;
	}
	
	public void setParameter4(double p4){
		parameter4=p4;
	}
	
	public double getParameter5(){
		return parameter5;
	}
	
	public void setParameter5(double p5){
		parameter5=p5;
	}
}
