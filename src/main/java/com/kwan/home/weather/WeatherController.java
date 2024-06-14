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

		// Method 형식 출력
		String method = request.getMethod();

		if (id.equals("list")) {

			request.setAttribute("wdto", ws.getWeathers(ar));
			action.setPath("/WEB-INF/views/weather/list.jsp");

		} else if (id.equals("add")) {

			if (method.toUpperCase().equals("POST")) {
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				String status = request.getParameter("status");
				int humidity = Integer.parseInt(request.getParameter("humidity"));

				WeatherDTO weatherDTO = new WeatherDTO();

				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setStatus(status);
				weatherDTO.setHumidity(humidity);

				try {
					ws.add(weatherDTO);
				} catch (Exception e) {
					e.printStackTrace();
				}

//				action.setPath("/weather/list");
//				action.setPath("list");
				action.setPath("./list");
				action.setFlag(false); // frontcontroller에서 리다이렉트
			} else {
				action.setPath("/WEB-INF/views/weather/add.jsp");
			}

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
