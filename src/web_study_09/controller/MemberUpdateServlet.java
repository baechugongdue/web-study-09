package web_study_09.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_09.dto.Member;
import web_study_09.service.JoinService;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JoinService service;
	
	@Override
	public void init() throws ServletException {
	    service = new JoinService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginUser");
        System.out.println(loginMember);*/
		request.getRequestDispatcher("member/memberUpdate.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member updateMember = JoinController.getMember(request);
		System.out.println("MemberUpdateServlet - doPost() " + updateMember);
		int res = service.updateMember(updateMember);
		System.out.println("수정 결과 : " + res);
		response.sendRedirect("login.do");
	}

}
