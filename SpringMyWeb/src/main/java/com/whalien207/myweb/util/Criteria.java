package com.whalien207.myweb.util;

import lombok.Data;

//sql문에 페이지 번호, 데이터 갯수를 전달해줄 클래스이다.

//getter,setter는 lombok을 사용하여 생성
@Data 
public class Criteria {

	private int page; //페이지 번호
	private int amount; //데이터 갯수
	
	private String searchType;//검색타입
	private String searchName;//검색값
	
	//초기값을 셋팅 해줘야 하므로 lombok을 사용하지 않고 생성자를 직접만들어주었다.
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}

	public Criteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	
	//limit 함수의 페이지 시작 부분에 들어갈 getter
	public int getPageStart() {
		return (page - 1) * amount;
	}

}
