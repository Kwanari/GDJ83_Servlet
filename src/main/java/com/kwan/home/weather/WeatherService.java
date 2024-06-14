package com.kwan.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDTO wdto;
	private WeatherDAO wdao;

	public WeatherService() {

	}

	// list
	public List<WeatherDTO> getWeathers(List<WeatherDTO> list) {
		System.out.println("Service.getWeathers");

		WeatherDAO wDAO = new WeatherDAO();

		try {
			list = wDAO.getWeathers(wdto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

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

	// add
	public void add(WeatherDTO weatherDTO) throws Exception {
		wdao = new WeatherDAO();
		wdao.add(weatherDTO);
	}

	// delete
	public void delete(WeatherDTO weatherDTO) {
		wdao = new WeatherDAO();
		try {
			wdao.delete(weatherDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(WeatherDTO weatherDTO) {

		wdao = new WeatherDAO();

		try {
			wdao.update(weatherDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
