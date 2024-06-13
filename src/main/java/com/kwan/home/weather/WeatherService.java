package com.kwan.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDTO wdto;
	private WeatherDAO wdao;

	public WeatherService() {

	}

	// list
	public List<WeatherDTO> getWeathers(List<WeatherDTO> ar) {
		System.out.println("Service.getWeathers");

		WeatherDAO wDAO = new WeatherDAO();

		try {
			ar = wDAO.getWeathers(wdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ar;

	}

	// detail
	public WeatherDTO getDetail(WeatherDTO weatherdto) {
		wdao = new WeatherDAO();
		try {
			wdto = wdao.getDetail(weatherdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			wdto = null;
			// exception 발생하면 try를 실행 X wdto에 null값이 들어가지않음
		}

		return wdto;
	}
}
