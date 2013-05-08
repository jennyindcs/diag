package collector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import data.Group;
import data.Student;

public class CsvReader {
	
	//read data for all groups belonging to a course
	public Vector<Group> getGroups(String courseID, File groupFile){
		BufferedReader reader = null;
		String cid = courseID;
		Vector<Group> vecGp = new Vector<Group>();
		
		try{
			reader=new BufferedReader(new FileReader(groupFile));
			String NL=null;
			while((NL=reader.readLine())!= null){
				Group gp = new Group();
				String[] oneline=NL.split(",");
				String tmpCourseId = oneline[7];
				if (!tmpCourseId.equals(cid)) {
					continue;
				}
				gp.setID(oneline[0]);
				gp.setoverallPosts(Integer.parseInt(oneline[1]));
				gp.setoverallFeedback(Integer.parseInt(oneline[2]));
				gp.setstudentReplied(Integer.parseInt(oneline[3]));
				gp.setoverParameter4(Integer.parseInt(oneline[4]));
				gp.setstudentPosted(Integer.parseInt(oneline[5]));
				gp.setgroupSize(Integer.parseInt(oneline[6]));
				vecGp.addElement(gp);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try{
				if (reader !=null){
					reader.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return vecGp;		
	}
	
	//read data for all students belonging to a course
	public Vector<Student> getStudents(String courseID, File groupFile, File studentFile){
		BufferedReader readerGroup = null;
		BufferedReader readerStudent = null;
		Vector<String> vecGroupId = new Vector<String>();
		Vector<Student> vecSd = new Vector<Student>();
		
		try{
			readerGroup = new BufferedReader(new FileReader(groupFile));			
			String groupNL = null;
			while((groupNL = readerGroup.readLine())!= null){
				String[] oneline = groupNL.split(",");
				String tmpCourseId = oneline[7];
				if (!tmpCourseId.equals(courseID)) {
					continue;
				}
				vecGroupId.addElement(oneline[0]);
			}
			readerStudent = new BufferedReader(new FileReader(studentFile));
			String studentNL = null;
			while((studentNL = readerStudent.readLine()) != null){
				Student sd = new Student();
				String[] line = studentNL.split(",");
				String tmpGroupId = line[4];
				if(tmpGroupId.equals("groupID")){
					continue;
				}
				if(vecGroupId.contains(tmpGroupId)){
					sd.setStudentID(line[0]);
					sd.setThreadView(Integer.parseInt(line[1]));
					sd.setPostReply(Integer.parseInt(line[2]));
					sd.setPostCreate(Integer.parseInt(line[3]));
					sd.setGroupID(tmpGroupId);
					vecSd.addElement(sd);
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try{
				if (readerGroup != null){
					readerGroup.close();
				}
				if (readerStudent != null){
					readerStudent.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		return vecSd;		
	}
	
	public int calculateAvgGroupFeedback(Vector<Group> vecG){
		int sumGroupFeedback=0;
		int avgGroupFeedback;
		
		for(int i=0; i<vecG.size(); i++){
			int tmpGroupFeedback = vecG.get(i).getoverallFeedback();
			sumGroupFeedback=sumGroupFeedback+tmpGroupFeedback;			
		}
		avgGroupFeedback = Math.round(sumGroupFeedback/vecG.size());
		return avgGroupFeedback;
	}
	
	public int calculateAvgGroupPosts(Vector<Group> vecG){
		int sumGroupPosts=0;
		int avgGroupPosts;
		
		for(int i=0; i<vecG.size(); i++){
			int tmpGroupPost = vecG.get(i).getoverallPosts();
			sumGroupPosts=sumGroupPosts+tmpGroupPost;
		}
		
		avgGroupPosts = Math.round(sumGroupPosts/vecG.size());
		
		return avgGroupPosts;
	}
}
