package com.kwan.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kwan.home.Action;

public class WeatherController {

	private List<WeatherDTO> ar;

	private WeatherService ws;

	public Action start(HttpServletRequest request) {

		System.out.println("Weather Controller.start");

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

		} else if (id.equals("detail")) { // detail

			// list.jsp에서 a태그 href를 통해 parameter가 담긴 주소로 request 생성
			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			weatherDTO = ws.getDetail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("wdto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");
			} else {
				request.setAttribute("massage", "정보가 없습니다.");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
		} // detail

		return action;
	}
}
