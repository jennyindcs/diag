package data;

public class Student {
	String studentID;
	int threadView, postReply, postCreate;
	String groupID;
	
	public void setStudentID(String sid){
		studentID = sid;
	}
	public String getStudentID(){
		return studentID;
	}
	public void setThreadView(int tv){
		threadView=tv;
	}
	public int getThreadView(){
		return threadView;
	}
	public void setPostReply(int pr){
		postReply = pr;
	}
	public int getPostReply(){
		return postReply;
	}
	public void setPostCreate(int pc){
		postCreate = pc;
	}
	public int getPostCreate(){
		return postCreate;
	}
	public void setGroupID(String gid){
		groupID = gid;
	}
	public String getGroupID(){
		return groupID;
	}
}
