package com.simple.command;

public class Quiz01VO {
	
	private String year;
	private String month;
	private String day;
	
	public Quiz01VO() {
	}

	public Quiz01VO(String year, String month, String day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		int month_i = Integer.parseInt(month);
		if(month_i < 10) {
			this.month = "0"+month;
		}else {
			this.month = month;
		}
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		int day_i = Integer.parseInt(day);
		if(day_i < 10) {
			this.day = "0"+day;
		}else {
			this.day = day;
		}
	}

	@Override
	public String toString() {
		return "Quiz01VO [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

}
