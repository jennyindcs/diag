package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;
/**
 * Servlet implementation class HandleFileUpload
 */
@WebServlet("/HandleFileUpload")
@MultipartConfig
public class HandleFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static boolean startedUpload;
	private static boolean uploadFinished;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleFileUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get file upload");
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		if (startedUpload) {
			if (!uploadFinished) {
				out.print("tryagain");
			}
			else {
				out.print("uploaddone");
			}
			startedUpload = false;
		}
		else {
			out.print("tryagain");
		}

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		startedUpload = true;
		uploadFinished = false;
		
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/") + "res/";
		System.out.println(path);
		out.write("æœ�åŠ¡å™¨æœ¬åœ°è·¯å¾„:" + path + "<br/>\n");
		for (Part p : request.getParts()) {
			String info = "name=" + p.getName() + ", content="
					+ p.getContentType() + ", size=" + p.getSize();
			out.write(info);
			if ((0 == p.getSize()) || (null == p.getContentType())) {
				continue;
			}
			//write every part of request into the file system
			ApplicationPart ap = (ApplicationPart) p;
			String fname1 = ap.getFilename();
			int path_idx = fname1.lastIndexOf("\\") + 1;
			String fname2 = fname1.substring(path_idx, fname1.length());
			p.write(path + fname2);
			System.out.println(fname2);
			System.out.println(p.getContentType());
		}
		startedUpload = true;
		uploadFinished = true;
	}

}
