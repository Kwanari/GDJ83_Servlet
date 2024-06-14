package com.kwan.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeatherDAO {

	// DTO: Data Transfer Object
	// DAO: Data Access Object

	// getWeathers 메서드
	// 파일에 날씨정보들을 읽어와 파싱 후 DTO에 담아서 리턴

	public List<WeatherDTO> getWeathers(WeatherDTO wdto) throws Exception {

		System.out.println("DAO.getWeathers");

		File file = new File("C:\\study", "weather.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<WeatherDTO> list = new ArrayList<WeatherDTO>();

		while (true) {

			String str = br.readLine();

			if (str == null) {
				break;
			}
			str = str.replace(",", "-");

			String[] ar = str.split("-");

			wdto = new WeatherDTO();
			wdto.setNum(Long.parseLong(ar[0].trim()));
			wdto.setCity(ar[1].trim().trim());
			wdto.setGion(Double.parseDouble(ar[2].trim()));
			wdto.setStatus(ar[3].trim());
			wdto.setHumidity(Integer.parseInt(ar[4].trim()));

			list.add(wdto);

		}

		br.close();
		fr.close();

		return list;
	}

	// detail
	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> list = this.getWeathers(weatherDTO);
		WeatherDTO detailDTO = new WeatherDTO();

		for (WeatherDTO wdto : list) {
			if (wdto.getNum() == weatherDTO.getNum()) {
				detailDTO = wdto;

				break;
			}

		}

		return detailDTO;
	}

	// add
	public void add(WeatherDTO weatherDTO) throws Exception {

		List<WeatherDTO> list = this.getWeathers(weatherDTO);

		// 도시명-기온-상태-습도

		StringBuffer sb = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		sb.append(ca.getTimeInMillis() + "-");
		sb.append(weatherDTO.getCity() + "-");
		sb.append(weatherDTO.getGion() + "-");
		sb.append(weatherDTO.getStatus() + "-");
		sb.append(weatherDTO.getHumidity());

		System.out.println(sb.toString());

		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, true);

		fw.write(sb.toString() + "\r\n");// write > 버퍼가 다 찰때마다 나옴
		// \r 주사기와 같음 밀어낸후 다시 빈칸을 만들어줌
		fw.flush(); // flush> 버퍼를 비움

		fw.close();

	}

	// delete
	public void delete(WeatherDTO weatherDTO) throws Exception {
		// list 불러와서 지우려고하는 num과 일치하는 것을
		// list 에서 삭제
		// 남은 list를 기존 file에 다시 저장

		List<WeatherDTO> wdto = this.getWeathers(weatherDTO);

		for (WeatherDTO dto : wdto) {
			if (dto.getNum() == weatherDTO.getNum()) {

				wdto.remove(dto); // dto참조변수와 같은 주소의 값 삭제

			}
		}

		StringBuffer sb = new StringBuffer();

		for (WeatherDTO dto : wdto) {
			Calendar ca = Calendar.getInstance();
			sb.append(ca.getTimeInMillis());
			sb.append("-");
			sb.append(dto.getCity());
			sb.append("-");
			sb.append(dto.getGion());
			sb.append("-");
			sb.append(dto.getStatus());
			sb.append("-");
			sb.append(dto.getHumidity());
			sb.append("\r\n");
		}

		File file = new File("C:\\study", "weather.txt");

		FileWriter fw = new FileWriter(file, false);
		fw.write(sb.toString());
		fw.flush();
		fw.close();

	}

	public void update(WeatherDTO weatherDTO) throws Exception {

		List<WeatherDTO> list = this.getWeathers(weatherDTO);
		WeatherDTO wdto = new WeatherDTO();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum() == weatherDTO.getNum()) {
				list.get(i).setCity(weatherDTO.getCity());
				list.get(i).setGion(weatherDTO.getGion());
				list.get(i).setStatus(weatherDTO.getStatus());
				list.get(i).setHumidity(weatherDTO.getHumidity());

				list.set(i, list.get(i));

				break;
			}
		}

		StringBuffer sb = new StringBuffer();

		for (WeatherDTO dto : list) {
			sb.append(dto.getNum());
			sb.append("-");
			sb.append(dto.getCity());
			sb.append("-");
			sb.append(dto.getGion());
			sb.append("-");
			sb.append(dto.getStatus());
			sb.append("-");
			sb.append(dto.getHumidity());
			sb.append("\r\n");
		}

		System.out.println(sb.toString());

//		File file = new File("C:\\study", "weather.txt");
//
//		FileWriter fw = new FileWriter(file, false);
//		fw.write(sb.toString());
//		fw.flush();
//		fw.close();

	}
}
