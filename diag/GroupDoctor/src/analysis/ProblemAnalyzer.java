package analysis;

import java.util.Vector;

import data.Course;
import data.CourseResult;
import data.Group;
import data.GroupResult;
import data.Student;
import data.StudentResult;

public class ProblemAnalyzer {
	
	public CourseResult diagnoseCourse(Course course, Vector<Group> groups, Vector<Student> students){
		int af = course.getavgGroupFeedback();
		int ap = course.getavgGroupPosts();
		double p1 = course.getParameter1();
		double p2 = course.getParameter2();
		int p3 = course.getParameter3();
		double p5 = course.getParameter5();
		String cid = course.getcourseID();
		Vector<GroupResult> vecGR = new Vector<GroupResult>();
		Vector<StudentResult> vecSR = new Vector<StudentResult>();
		CourseResult cr = new CourseResult();
		
		for(int i=0; i<groups.size();i++){
			GroupResult gr = new GroupResult();
			gr = diagnoseGroup(groups.get(i), af, ap, p1, p2, p3, p5);
			vecGR.addElement(gr);
		}
		for(int i=0; i<students.size();i++){
			StudentResult sr = new StudentResult();
			sr = diagnoseStudent(students.get(i));
			vecSR.addElement(sr);
		}
		
		cr.setCourseID(cid);
		cr.setVectorGroupResult(vecGR);
		cr.setVectorStudentResult(vecSR);
		
		return cr;
	}

	public GroupResult diagnoseGroup(Group gp, int avgfeedback, int avgposts, double P1, double P2, int P3, double P5){
		Group group = gp;
		int avgfb = avgfeedback;
		int avgps = avgposts;
		double p1 = P1;
		double p2 = P2;
		int p3 = P3;
		double p5 = P5;
		GroupResult gr = new GroupResult();
		String gid;
		int result_CP5;
		int result_CP6;
				
		gid = gp.getID();
		result_CP5 = diagnose_CP5(group, avgfb, p1, p2);
		result_CP6 = diagnose_CP6(group, avgps, p3, p5);
		
		gr.setGroupID(gid);
		gr.setResultCP5(result_CP5);
		gr.setResultCP6(result_CP6);
		
		return gr;
	}
	
	public StudentResult diagnoseStudent(Student sd){
		Student student = sd;
		StudentResult sr = new StudentResult();
		String sid, gid;
		int result_CP1;
		int result_CP2;
		int result_CP3;
				
		sid = student.getStudentID();
		result_CP1 = diagnose_CP1(student);
		result_CP2 = diagnose_CP2(student);
		result_CP3 = diagnose_CP3(student);
		gid = student.getGroupID();
		
		sr.setStudentID(sid);
		sr.setResultCP1(result_CP1);
		sr.setResultCP2(result_CP2);
		sr.setResultCP3(result_CP3);
		sr.setGroupID(gid);
		
		return sr;
	}
	
	//diagnosis for CP1 based on predictive model I
	public int diagnose_CP1(Student sd){
		int X1 = sd.getThreadView();
		int X2 = sd.getPostReply();
		int X3 = sd.getPostCreate();
		double G1 = 1.642+0.118*X1-0.934*X2-4.327*X3;
		double G2 = 0.276+0.015*X1+0.148*X2-1.957*X3;
		double P1 = Math.exp(G1)/(1+Math.exp(G1)+Math.exp(G2));
		double P2 = Math.exp(G2)/(1+Math.exp(G1)+Math.exp(G2));
		double P3 = 1/(1+Math.exp(G1)+Math.exp(G2));
		int result=0;
		
		
		if((P1>P2 && P1>P3) || P1 == P2 || P1 == P3 || P2 == P3){
			result = 1;
		}
		else if(P2>P1 && P2>P3){
			result = 2;
		}
		else if(P3>P1 && P3>P2){
			result = 3;
		}
		return result;
	}
	
	//diagnosis for CP2 based on predictive model II
	public int diagnose_CP2(Student sd){
		int X1 = sd.getPostReply();
		int X2 = sd.getPostCreate();
		double G1 = 3.794-0.846*X1-1.851*X2;
		double G2 = 1.699-0.307*X1-0.749*X2;
		double P1 = Math.exp(G1)/(1+Math.exp(G1)+Math.exp(G2));
		double P2 = Math.exp(G2)/(1+Math.exp(G1)+Math.exp(G2));
		double P3 = 1/(1+Math.exp(G1)+Math.exp(G2));
		int result=0;
		
		if((P1>P2 && P1>P3) || P1 == P2 || P1 == P3 || P2 == P3){
			result = 1;
		}
		else if(P2>P1 && P2>P3){
			result = 2;
		}
		else if(P3>P1 && P3>P2){
			result = 3;
		}
		return result;
	}
	
	//diagnosis for CP3 based on predictive model III
	public int diagnose_CP3(Student sd){
		int X1 = sd.getPostReply();
		int X2 = sd.getPostCreate();
		double G1 = 7.459-1.637*X1-5.136*X2;
		double G2 = 4.338-0.555*X1-3.137*X2;
		double P1 = Math.exp(G1)/(1+Math.exp(G1)+Math.exp(G2));
		double P2 = Math.exp(G2)/(1+Math.exp(G1)+Math.exp(G2));
		double P3 = 1/(1+Math.exp(G1)+Math.exp(G2));
		int result=0;
		
		if((P1>P2 && P1>P3) || P1 == P2 || P1 == P3 || P2 == P3){
			result = 1;
		}
		else if(P2>P1 && P2>P3){
			result = 2;
		}
		else if(P3>P1 && P3>P2){
			result = 3;
		}
		return result;
	}
	
	//diagnosis for CP5 based on the CP5 diagnosis algorithm
	public int diagnose_CP5(Group gp, int avgfeedback, double P1, double P2){
		int op = gp.getoverallPosts();
		int of = gp.getoverallFeedback();
		int af = avgfeedback;
		int sr = gp.getstudentReplied();
		int gs = gp.getgroupSize();
		double p1 = P1;
		double p2 = P2;
		int result = 0;
		
		double ratio1 = ((double)sr)/gs;
		double ratio2 = ((double)of)/af;
		if(op == 0 || of == 0){
			result = 1;
		}else {
			if(of < af){
				result = 1;
			}else{
				if(ratio1 < p1){
					result = 1;
				}else{
					if(ratio2 > p2){
						result = 3;
					}else result = 2;
				}
			}
		}
				
		return result;
	}
	
	//diagnosis for CP6 based on the CP6 diagnosis algorithm
	public int diagnose_CP6(Group gp, int avgposts, int P3, double P5){
		int op = gp.getoverallPosts();
		int som = gp.getoverParameter4();
		int sp = gp.getstudentPosted();
		int gs = gp.getgroupSize();
		int ap = avgposts;
		int p3 = P3;
		double p5 = P5;
		int result = 0;
		
		
		if(op <= p3){
			result = 3;
		}		
		else if(som == 1){
			double ratio = ((double)sp)/gs;
			if(ratio > p5){
				result = 1;
			}
			else if(op < ap){
				result = 2;
			}else result = 3;			
		}
		else result = 3;
		
		return result;
	}
}
