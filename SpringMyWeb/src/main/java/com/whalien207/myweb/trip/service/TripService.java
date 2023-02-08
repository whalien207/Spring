package com.whalien207.myweb.trip.service;

import java.util.ArrayList;

import com.whalien207.myweb.command.TripVO;

public interface TripService {
	
	public int noticeRegist(TripVO vo); //글 등록
	public ArrayList<TripVO> getList(); //글 리스트 조회
	public TripVO getContent(int tno); //글 상세조회
	public int noticeModify(TripVO vo); //글 수정
	public int noticeDelete(int tno); //글 수정
	public void upHit(int tno); //글번호
	public ArrayList<TripVO> getPrevNext(int tno);
}
