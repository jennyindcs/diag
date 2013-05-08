package controller;

import java.io.File;
import java.util.Vector;

import results.TeacherViewProcessor;
import analysis.ProblemAnalyzer;
import collector.CsvReader;
import data.Course;
import data.CourseResult;
import data.FinalResult;
import data.Group;
import data.GroupResult;
import data.ProblemPieChart;
import data.Student;
import data.StudentResult;

/**
 *	Diagnoser class
 *	This class controls the diagnosing process
 */
public class Diagnoser {
	
	public static FinalResult diagnose(String courseId, double p1, double p2, int p3, double p4, double p5, File groupFile, File studentFile) {

		FinalResult result = new FinalResult();


		CsvReader csv = new CsvReader();

		String cid = courseId;

		Vector<Group> vecG = new Vector<Group>();

		Vector<Student> vecS = new Vector<Student>();

		Course course = new Course();

		ProblemAnalyzer par = new ProblemAnalyzer();

		CourseResult cr = new CourseResult();

		TeacherViewProcessor tvp = new TeacherViewProcessor();

		Vector<GroupResult> vecGR = new Vector<GroupResult>();

		Vector<StudentResult> vecSR = new Vector<StudentResult>();

		ProblemPieChart chart1 = new ProblemPieChart();

		ProblemPieChart chart2 = new ProblemPieChart();

		ProblemPieChart chart3 = new ProblemPieChart();

		ProblemPieChart chart4 = new ProblemPieChart();

		ProblemPieChart chart5 = new ProblemPieChart();


		vecG = csv.getGroups(cid, groupFile);

		vecS = csv.getStudents(cid, groupFile, studentFile);

		course.setcourseID(cid);

		course.setParameter1(p1);

		course.setParameter2(p2);

		course.setParameter3(p3);

		course.setParameter4(p4);

		course.setParameter5(p5);

		course.setavgGroupFeedback(csv.calculateAvgGroupFeedback(vecG));

		course.setavgGroupPosts(csv.calculateAvgGroupPosts(vecG));

		cr = par.diagnoseCourse(course, vecG, vecS);

		vecGR = tvp.getGroupTable(cr);

		vecSR = tvp.getStudentTable(cr);

		chart1 = tvp.getGroupProblemPieChart("1", cr);

		chart2 = tvp.getGroupProblemPieChart("2", cr);

		chart3 = tvp.getStudentProblemPieChart("3", cr);

		chart4 = tvp.getStudentProblemPieChart("4", cr);

		chart5 = tvp.getStudentProblemPieChart("5", cr);

		result.vecGR = vecGR;

		result.vecSR = vecSR;

		result.chart1 = chart1;

		result.chart2 = chart2;

		result.chart3 = chart3;

		result.chart4 = chart4;

		result.chart5 = chart5;

		return result;

		}
	
}
