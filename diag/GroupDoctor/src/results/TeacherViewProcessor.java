package results;

import java.util.Vector;

import data.CourseResult;
import data.GroupResult;
import data.ProblemPieChart;
import data.StudentResult;

/*	This class is to transform a CourseResult 
 * 	to a TeacherView.
 */
public class TeacherViewProcessor {
		
	public Vector<GroupResult> getGroupTable(CourseResult cr){
		Vector<GroupResult> vecGr = cr.getVectorGroupResult();		
		Vector<GroupResult> newVecGR = new Vector<GroupResult>();

		for(int i=0;i<vecGr.size();i++){
			GroupResult gr = new GroupResult();
			String gid = vecGr.get(i).getGroupID();
			int result_CP5 = vecGr.get(i).getResultCP5();
			int result_CP6 = vecGr.get(i).getResultCP6();
			if(result_CP5 == 3 && result_CP6 == 3){
				continue;
			}
			gr.setGroupID(gid);
			gr.setResultCP5(result_CP5);
			gr.setResultCP6(result_CP6);
			newVecGR.addElement(gr);
		}
		
		return newVecGR;
		
	}
	
	public Vector<StudentResult> getStudentTable(CourseResult cr){
		Vector<StudentResult> vecSr = cr.getVectorStudentResult();		
		Vector<StudentResult> newVecSR = new Vector<StudentResult>();

		for(int i=0;i<vecSr.size();i++){
			StudentResult sr = new StudentResult();
			String sid = vecSr.get(i).getStudentID();
			int result_CP1 = vecSr.get(i).getResultCP1();
			int result_CP2 = vecSr.get(i).getResultCP2();
			int result_CP3 = vecSr.get(i).getResultCP3();
			String gid = vecSr.get(i).getGroupID();
			if(result_CP1 == 3 && result_CP2 == 3 && result_CP3 == 3){
				continue;
			}
			sr.setStudentID(sid);
			sr.setResultCP1(result_CP1);
			sr.setResultCP2(result_CP2);
			sr.setResultCP3(result_CP3);
			sr.setGroupID(gid);
			newVecSR.addElement(sr);
		}
		
		return newVecSR;
		
	}

	//calculate statistics for a group problem
	public ProblemPieChart getGroupProblemPieChart(String gpid, CourseResult cr){
		Vector<GroupResult> vecGr = cr.getVectorGroupResult();		
		int sum_yes = 0;
		int sum_maybe = 0;
		int sum_no = 0;
		double percentage_yes;
		double percentage_maybe;
		double percentage_no;
		ProblemPieChart pie = new ProblemPieChart();
		
		if(gpid.equals("1")){
			for(int i=0;i<vecGr.size();i++){
				GroupResult gr = new GroupResult();
				gr = vecGr.get(i);
				int result_CP5 = gr.getResultCP5();
				if(result_CP5 == 1){
					sum_yes++;
				}
				else if(result_CP5 == 2){
					sum_maybe++;
				}
				else if(result_CP5 == 3){
					sum_no++;
				}
			}
		}
		else if(gpid.equals("2")){
			for(int i=0;i<vecGr.size();i++){
				GroupResult gr = new GroupResult();
				gr = vecGr.get(i);
				int result_CP6 = gr.getResultCP6();
				if(result_CP6 == 1){
					sum_yes++;
				}
				else if(result_CP6 == 2){
					sum_maybe++;
				}
				else if(result_CP6 == 3){
					sum_no++;
				}
			}
		}	
		
		percentage_yes = ((double)sum_yes)/vecGr.size();
		percentage_maybe = ((double)sum_maybe)/vecGr.size();
		percentage_no = ((double)sum_no)/vecGr.size();
		
		pie.setProblemID(gpid);
		pie.setPercentageYes(percentage_yes);
		pie.setPercentageMaybe(percentage_maybe);
		pie.setPercentageNo(percentage_no);
		
		if(gpid.equals("1")){
			pie.setProblemName("little feedback on each other's task work");
		}else{
			pie.setProblemName("single student dominating the group");
		}
		
		return pie;
	}
	
	//calculate statistics for a student problem
	public ProblemPieChart getStudentProblemPieChart(String spid, CourseResult cr){
		Vector<StudentResult> vecSr = cr.getVectorStudentResult();
		StudentResult sr = new StudentResult();
		int result_CP1;
		int sum_yes = 0;
		int sum_maybe = 0;
		int sum_no = 0;
		int result_CP2;
		int result_CP3;
		double percentage_yes;
		double percentage_maybe;
		double percentage_no;
		ProblemPieChart pie = new ProblemPieChart();
		
		if(spid.equals("3")){
			for(int i=0;i<vecSr.size();i++){
				sr = vecSr.get(i);
				result_CP1 = sr.getResultCP1();
				if(result_CP1 == 1){
					sum_yes++;
				}
				else if(result_CP1 == 2){
					sum_maybe++;
				}
				else if(result_CP1 == 3){
					sum_no++;
				}
			}
		}
		else if(spid.equals("4")){
			for(int i=0;i<vecSr.size();i++){
				sr = vecSr.get(i);
				result_CP2 = sr.getResultCP2();
				if(result_CP2 == 1){
					sum_yes++;
				}
				else if(result_CP2 == 2){
					sum_maybe++;
				}
				else if(result_CP2 == 3){
					sum_no++;
				}
			}
		}	
		else if(spid == "5"){
			for(int i=0;i<vecSr.size();i++){
				sr = vecSr.get(i);
				result_CP3 = sr.getResultCP3();
				if(result_CP3 == 1){
					sum_yes++;
				}
				else if(result_CP3 == 2){
					sum_maybe++;
				}
				else if(result_CP3 == 3){
					sum_no++;
				}
			}
		}
		
		percentage_yes = ((double)sum_yes)/vecSr.size();
		percentage_maybe = ((double)sum_maybe)/vecSr.size();
		System.out.println("sum_maybe = " + sum_maybe + " vecsr.size() = " + vecSr.size());
		percentage_no = ((double)sum_no)/vecSr.size();
		
		pie.setProblemID(spid);
		pie.setPercentageYes(percentage_yes);
		pie.setPercentageMaybe(percentage_maybe);
		pie.setPercentageNo(percentage_no);
		
		if(spid.equals("3")){
			pie.setProblemName("not contributing much in online discussions");
		}else if(spid.equals("4")){
			pie.setProblemName("not actively meeting the deadlines");
		}else{
			pie.setProblemName("not actively completing the assigned work");
		}
		
		return pie;
	}
}
