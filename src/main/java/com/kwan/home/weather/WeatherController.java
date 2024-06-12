package com.kwan.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kwan.home.Action;

public class WeatherController {

	private List<WeatherDTO> ar;

	private WeatherService ws;

	public Action start(HttpServletRequest request) {
		System.out.println("Weather Controller");

		ws = new WeatherService();

		String uri = request.getRequestURI();

		String id = uri.substring(9);

		Action action = new Action();
		action.setFlag(true);

		if (id.equals("list")) {

			request.setAttribute("wdto", ws.getWeathers(ar));
			action.setPath("/WEB-INF/views/weather/list.jsp");

		} else if (id.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
		} else if (id.equals("delete")) {

		} else if (id.equals("detail")) {
			action.setPath("/WEB-INF/views/weather/detail.jsp");
		}

		return action;
	}
}
