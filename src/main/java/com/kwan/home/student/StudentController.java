package com.kwan.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kwan.home.Action;

public class StudentController {

	private StudentService ss;

	public StudentController() {
		this.ss = new StudentService();
	}

	public Action start(HttpServletRequest request) {
		System.out.println("Student Controller");

		// student/???
		// list : 학생 정보 전체 출력
		// add : 학생 1명 정보 추가
		// delete : 학생 1명 정보 삭제
		// detail : 학생 1명 정보 출력

		String uri = request.getRequestURI();

		String[] ar = uri.split("/");

		Action action = new Action();
		action.setFlag(true);
		String method = request.getMethod(); // request변수에서 메서드를 변수에 저장

		if (ar[2].equals("list")) {
			List<Student> arStu = ss.getStudents();
			request.setAttribute("arStu", arStu);

			action.setPath("/WEB-INF/views/student/list.jsp");

		} else if (ar[2].equals("add")) {

			if (method.toUpperCase().equals("POST")) { // 메서드의 값이 POST라면
				// 학생 등록 데이터 꺼내야함

				Student student = new Student();

				String name = request.getParameter("name");
				double avg = Double.parseDouble(request.getParameter("avg"));
				int num = Integer.parseInt(request.getParameter("num"));

				request.getParameter("ch");
				request.getParameter("mobile");

				// 파라미터에서 오는 값이 다수일때
				String[] ch2 = request.getParameterValues("ch2");

				for (String a : ch2) {
					System.out.println(a);
				}

				student.setAvg(avg);
				student.setName(name);
				student.setNum(num);

				action.setFlag(false);
				action.setPath("./list");

			} else {

				action.setPath("/WEB-INF/views/student/add.jsp");

			}

		} else if (ar[2].equals("delete")) {

		} else if (ar[2].equals("detail")) {
			Student stu = ss.makeStudent();
			request.setAttribute("stu", stu);
			action.setPath("/WEB-INF/views/student/detail.jsp");
		} else {

		}

		return action;

	}

}
