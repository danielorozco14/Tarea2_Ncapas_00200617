package com.uca.capas.PNC_TAREA2.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	/*
	 * Informacion del Estudiante
	 */
	@RequestMapping("/about")
	public @ResponseBody String about() {
		String txt= "Estudiante: Daniel Alejandro Orozco, 4 año de Ing.Informatica ,Carnet: 00200617";
		return txt;
	}
	
	/*
	 * @param day, month,year
	 */
	
	@RequestMapping("/fecha")//formato: fecha?day=14&month=07&year=1999
	public @ResponseBody String fecha(HttpServletRequest req) {
		Integer day = Integer.parseInt(req.getParameter("day"));
		Integer month = Integer.parseInt(req.getParameter("month"));
		Integer year = Integer.parseInt(req.getParameter("year"));
		
		Calendar c= Calendar.getInstance();
		c.set(year, month-1, day);
		String dia;
		switch(c.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				dia="Domingo";
				break;
			case 2:
				dia="Lunes";
				break;
			case 3:
				dia="Martes";
				break;
			case 4:
				dia="Miercoles";
				break;
			case 5:
				dia="Jueves";
				break;
			case 6:
				dia="Viernes";
				break;
			case 7:
				dia="Sabado";
				break;
			default:
				dia="No selecciono nada";
				break;
		}
		
		
		return "El dia es: "+dia;	
		
	}
	
}
