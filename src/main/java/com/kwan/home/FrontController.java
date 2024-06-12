package com.kwan.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwan.home.student.StudentController;
import com.kwan.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Front Controller");

		String uri = request.getRequestURI();
		String method = request.getMethod();

		if (!uri.equals("/favicon.ico")) {

//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Index.jsp");
//			view.forward(request, response);

			String[] p = uri.split("/"); // uri /기준으로 나눔
			Action action = new Action(); // action 클래스 객체 생성

			if (uri.equals("/")) {
				action.setFlag(true); // if문
				action.setPath("/WEB-INF/views/Index.jsp"); // index 주소 입력

			} else if (p[1].equals("student")) {

				StudentController sc = new StudentController();

				action = sc.start(request);
				// uri를 start메서드 인자값으로 보내고 각 메뉴주소를 인스턴스변수로 하는 action 객체를 return 받음

			} else if (p[1].equals("weather")) {

				WeatherController wc = new WeatherController();

				action = wc.start(request);
				// uri를 start메서드 인자값으로 보내고 각 메뉴주소를 인스턴스변수로 하는 action 객체를 return 받음

			}

			if (action.isFlag()) {
				RequestDispatcher view = request.getRequestDispatcher(action.getPath());
				view.forward(request, response);
			} else {
				response.sendRedirect(action.getPath());
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
