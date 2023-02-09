package com.whalien207.myweb.trip.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.whalien207.myweb.command.TripVO;
import com.whalien207.myweb.util.Criteria;

@Mapper
public interface TripMapper {
 
	public int noticeRegist(TripVO vo);
//	public ArrayList<TripVO> getList(); //그냥 전체 조회
	public ArrayList<TripVO> getList(Criteria cri); //페이지 별 조회
	public TripVO getContent(int tno);
	public int noticeModify(TripVO vo);
	public int noticeDelete(int tno);
	public void upHit(int tno);
	
	public ArrayList<TripVO> getPrevNext(int tno);
	public int getTotal(Criteria cri);
}
