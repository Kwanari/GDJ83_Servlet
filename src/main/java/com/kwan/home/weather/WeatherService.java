package com.kwan.home.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherService {

	private StringBuffer sb;
	private WeatherDTO wdto;

	public WeatherService() {
		this.sb = new StringBuffer();
		this.sb.append("서울 , 29.3 - 맑음 - 60");
		this.sb.append("-부산 ,33.6 - 흐림 - 90");
		this.sb.append("-제주 , 26.5 - 눈 - 30");
		this.sb.append("-광주 , 10.6 - 태풍 - 80");
	}

	public List<WeatherDTO> getWeathers() {

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();

		String str = sb.toString();
		str = str.replace(",", "-");
		String[] arStr = str.split("-");

		// tokenizer 이용 선호

		for (int i = 0; i < arStr.length; i++) {
			wdto = new WeatherDTO();

			wdto.setCity(arStr[i].trim());
			wdto.setGion(Double.parseDouble(arStr[i + 1].trim()));
			wdto.setStatus(arStr[i + 2].trim());
			wdto.setHumidity(Integer.parseInt(arStr[i + 3].trim()));

			i += 3;
			ar.add(wdto);
		}

		return ar;

	}
}
