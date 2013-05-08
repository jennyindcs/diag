package data;

public class StudentResult {
	String studentID, groupID;
	int result_CP1, result_CP2, result_CP3;
	
	public void setStudentID(String sid){
		studentID = sid;
	}
	public String getStudentID(){
		return studentID;
	}
	public void setResultCP1(int rCP1){
		result_CP1 = rCP1;
	}
	public int getResultCP1(){
		return result_CP1;
	}
	public void setResultCP2(int rCP2){
		result_CP2 = rCP2;
	}
	public int getResultCP2(){
		return result_CP2;
	}
	public void setResultCP3(int rCP3){
		result_CP3 = rCP3;
	}
	public int getResultCP3(){
		return result_CP3;
	}
	public void setGroupID(String gid){
		groupID = gid;
	}
	public String getGroupID(){
		return groupID;
	}
}
