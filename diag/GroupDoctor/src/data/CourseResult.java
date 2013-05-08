package data;

import java.util.Vector;

public class CourseResult {
	String courseID;
	Vector<GroupResult> vecGR = new Vector<GroupResult>();
	Vector<StudentResult> vecSR = new Vector<StudentResult>();
	
	public void setCourseID(String cid){
		courseID = cid;
	}
	public String getCourseID(){
		return courseID;
	}
	public void setVectorGroupResult(Vector<GroupResult> vgr){
		vecGR = vgr;
	}
	public Vector<GroupResult> getVectorGroupResult(){
		return vecGR;
	}
	public void setVectorStudentResult(Vector<StudentResult> vsr){
		vecSR = vsr;
	}
	public Vector<StudentResult> getVectorStudentResult(){
		return vecSR;
	}
}
