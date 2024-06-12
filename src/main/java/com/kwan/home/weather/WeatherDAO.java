package com.kwan.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
}
