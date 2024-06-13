package com.kwan.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	private StudentDTO studentDTO;

	public List<StudentDTO> getStudent() throws Exception {
		File file = new File("C:\\study", "student.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();

		while (true) {

			String s = br.readLine();

			if (s == null) {
				break;
			}
			String[] ar = s.split("-");

			studentDTO = new StudentDTO();

			studentDTO.setNum(Integer.parseInt(ar[0].trim()));
			studentDTO.setName(ar[1].trim());
			studentDTO.setKor(Integer.parseInt(ar[2].trim()));
			studentDTO.setEng(Integer.parseInt(ar[3].trim()));
			studentDTO.setMath(Integer.parseInt(ar[4].trim()));
			studentDTO.setTotal(Integer.parseInt(ar[5].trim()));
			studentDTO.setAvg(Double.parseDouble(ar[6].trim()));

			list.add(studentDTO);
		}

		return list;
	}

	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudent();
		StudentDTO result = new StudentDTO();
		for (StudentDTO sDTO : ar) {
			if (sDTO.getNum() == studentDTO.getNum()) {
				result = sDTO;

				break;
			}
		}

		return result;
	}

}
