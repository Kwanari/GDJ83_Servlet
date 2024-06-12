package com.kwan.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDTO wdto;

	public WeatherService() {

	}

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
}
