package com.kwan.home.student;

import java.util.List;

public class StudentService {
	private StudentDAO studentDAO;
	private List<StudentDTO> list;
	private StudentDTO result;

	public List<StudentDTO> getStudents() {
		studentDAO = new StudentDAO();
		try {
			list = studentDAO.getStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public StudentDTO getDetail(StudentDTO studentDTO) {
		try {
			studentDAO = new StudentDAO();
			result = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}

	public StudentDTO makeStudent() {

		StudentDTO stu = new StudentDTO();

		// DB에서 꺼내올 데이터
		stu.setNum(1);
		stu.setName("kwan");
		stu.setAvg(1.1);

		return stu;
	}
}
