package servlets_for_html;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StuRegister")
public class StuRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StuRegister() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		String edu = request.getParameter("edu");
		String address = request.getParameter("address");
		
		Stu_Register_Bean srb=new Stu_Register_Bean();
		srb.setName(name);
		srb.setNumber(Long.parseLong(number));
		srb.setEmail(email);
		srb.setPassword(password);
		srb.setDob(dob);
		srb.setEdu(edu);
		srb.setAddress(address);
		

		Stu_Register_DAO dao=new Stu_Register_DAO();
		
		try {
		    long connect = dao.connect(srb);
		    if (connect > 0) {
		        request.setAttribute("id", connect);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("stusuccess.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        response.sendRedirect("error.html");
		        
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    response.sendRedirect("exp_error.html");
		}
		
	}

}
