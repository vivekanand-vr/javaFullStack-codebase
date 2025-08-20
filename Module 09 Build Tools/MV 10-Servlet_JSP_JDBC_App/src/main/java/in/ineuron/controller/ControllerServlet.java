package in.ineuron.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.model.StudentDTO;
import in.ineuron.model.StudentVO;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;
import in.ineuron.util.HibernateUtil;

@WebServlet(urlPatterns = { "/search" }, loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {

	static {
		HibernateUtil.startUp();
	}
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentService stdService = StudentServiceFactory.getStudentService();

		List<StudentDTO> studentDTO = stdService.findAllStudents();
		System.out.println(studentDTO);

		// convert to VO and send
		ArrayList<StudentVO> student = new ArrayList<StudentVO>();
		for (StudentDTO stdDao : studentDTO) {
			StudentVO studentVO = new StudentVO();
			studentVO.setSaddress(stdDao.getSaddress());
			studentVO.setSid(stdDao.getSid().toString());
			studentVO.setSname(stdDao.getSname());
			studentVO.setSage(stdDao.getSage().toString());
			student.add(studentVO);
		}
		System.out.println(student);
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("./disp.jsp");
		rd.forward(request, response);
	}
}
