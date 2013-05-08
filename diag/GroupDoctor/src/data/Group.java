package data;

public class Group {

	String groupID;
	int overallPosts;
	int overallFeedback;
	int studentReplied;
	int overParameter4;	
	int studentPosted;
	int groupSize;
	
	public Group(){
		groupID=" ";
		groupSize=0;
		overallPosts=0;
		studentPosted=0;
		overParameter4=0;
		overallFeedback=0;
		studentReplied=0;
	}
	
	public String getID(){
		return groupID;
	}
	
	public void setID(String ID){
		groupID=ID;
	}
	
	public int getgroupSize(){
		return groupSize;
	}
	
	public void setgroupSize(int size){
		groupSize=size;
	}
	
	public int getoverallPosts(){
		return overallPosts;
	}
	
	public void setoverallPosts(int op){
		overallPosts=op;
	}
	
	public int getstudentPosted(){
		return studentPosted;
	}
	
	public void setstudentPosted(int sp){
		studentPosted=sp;
	}
	
	public int getoverParameter4(){
		return overParameter4;
	}
	
	public void setoverParameter4(int op4){
		overParameter4=op4;
	}
	
	public int getoverallFeedback(){
		return overallFeedback;
	}
	
	public void setoverallFeedback(int of){
		overallFeedback=of;
	}

	public int getstudentReplied(){
		return studentReplied;
	}
	
	public void setstudentReplied(int sr){
		studentReplied=sr;
	}
	
}
