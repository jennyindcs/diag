package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Diagnoser;
import data.FinalResult;
import data.GroupResult;
import data.StudentResult;

/**
 * Servlet implementation class Diagnoser
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double p1 = 0;
		double p2 = 0;
		int p3 = 0;
		double p4 = 0;
		double p5 = 0;
		String courseId = "-1";
		String groupFileName = "";
		String studentFileName = "";
		
		Enumeration attributeNames = request.getParameterNames();
		while (attributeNames.hasMoreElements()) {
		      String name = (String) attributeNames.nextElement();
		      String value = request.getParameter(name);
		      name = name.toLowerCase();		      
		      
		      if (name.equalsIgnoreCase("p1")) {
		    	  p1 = Double.parseDouble(value)/100;
		      } else if (name.equalsIgnoreCase("p2")) {
		    	  p2 = Double.parseDouble(value)/100;
		      } else if (name.equalsIgnoreCase("p3")) {
		    	  p3 = Integer.parseInt(value);
		      } else if (name.equalsIgnoreCase("p4")) {
		    	  p4 = Double.parseDouble(value)/100;
		      } else if (name.equalsIgnoreCase("p5")) {
		    	  p5 = Double.parseDouble(value)/100;
		      } else if (name.equalsIgnoreCase("course")) {
		    	  courseId = value;
		      } else if (name.startsWith("group_")) {
		    	  groupFileName = name;
		      } else if (name.startsWith("student_")) {
		    	  studentFileName = name;
		      }
		}

		
		File groupFile = new File(this.getServletContext().getRealPath("/") + "res/" + groupFileName); 
		File studentFile = new File(this.getServletContext().getRealPath("/") + "res/" + studentFileName);
		
		FinalResult result = Diagnoser.diagnose(courseId, p1, p2, p3, p4, p5, groupFile, studentFile);
		
		request.setAttribute("final_result", "the_real_result_json");
		request.setAttribute("chart1", result.chart1.toString());
		request.setAttribute("chart2", result.chart2.toString());
		request.setAttribute("chart3", result.chart3.toString());
		request.setAttribute("chart4", result.chart4.toString());
		request.setAttribute("chart5", result.chart5.toString());
		request.setAttribute("vecGR", result.getGroupResultsJSON());
		request.setAttribute("vecSR", result.getStudentResultsJSON());
		
	    try {
	      getServletConfig().getServletContext().getRequestDispatcher("/result.jsp").forward(request,response);

	    } catch (ServletException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
		
	}

}
