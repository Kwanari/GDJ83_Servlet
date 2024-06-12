package com.kwan.home.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {

	public List<Student> getStudents() {
		ArrayList<Student> ar = new ArrayList<Student>();
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			Student stu = new Student();

			stu.setNum(i + 1);
			stu.setName("name" + i);
			stu.setAvg(random.nextInt(100) + random.nextDouble());

			ar.add(stu);
		}

		return ar;
	}

	public Student makeStudent() {

		Student stu = new Student();

		// DB에서 꺼내올 데이터
		stu.setNum(1);
		stu.setName("kwan");
		stu.setAvg(1.1);

		return stu;
	}
}
