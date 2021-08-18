package br.com.logusretail.consultorio.utils.parsers;

import java.time.LocalDateTime;


public class LocalDateTimeParse {
	private String stringData;

	public LocalDateTimeParse(String date) {
		this.stringData = date;
	}
	
	public LocalDateTime getDate() {
		return stringData!=null ? LocalDateTime.parse(stringData) :null;
	}
}
