package com.yeonoo.masterdata.item.service;

import java.util.List;

import com.yeonoo.masterdata.item.domain.RawDTO;


public interface RawService {

	// 전체 반제품조회
	public List<RawDTO> rawList();
	
	// 반제품 등록
	public int insertRaw(RawDTO dto);

	// 반제품 정보 수정
	public int updateRaw(RawDTO dto);

	// 반제품 삭제
	public void deleteRaw(String itemCode);
}