package com.whalien207.myweb.trip.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whalien207.myweb.command.TripVO;
import com.whalien207.myweb.util.Criteria;

@Service("tripService")
public class TripServiceImpl implements TripService {

	@Autowired
	private TripMapper tripMapper;

	@Override
	public int noticeRegist(TripVO vo) {
		return tripMapper.noticeRegist(vo);
	}
	
	@Override
	public ArrayList<TripVO> getList(Criteria cri) {
		return tripMapper.getList(cri);
	}
	
	@Override
	public TripVO getContent(int tno) {
		return tripMapper.getContent(tno);
	}
	
	@Override
	public int noticeModify(TripVO vo) {
		return tripMapper.noticeModify(vo);
	}
	
	@Override
	public int noticeDelete(int tno) {
		return tripMapper.noticeDelete(tno);
	}
	
	@Override
	public void upHit(int tno) {
		tripMapper.upHit(tno);
	}
	
	@Override
	public ArrayList<TripVO> getPrevNext(int tno) {
		return tripMapper.getPrevNext(tno);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return tripMapper.getTotal(cri);
	}
}
