package com.yeonoo.stock.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.yeonoo.stock.domain.Stock;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StockRepositoryImpl implements StockRepository{
	
	private final SqlSession sqlSession;
	
//	@Autowired
//	private StockRepositoryImpl(SqlSession sqlSession) {
//		this.sqlSession=sqlSession;
//		
//	}
	
	@Override
	public List<Stock> searchAll() throws DataAccessException{
        // 데이터베이스에서 검색 결과를 가져오는 로직을 구현한다.

        // 여기서는 더미 데이터를 사용한다.
     
        List<Stock> result=sqlSession.selectList("mapper.stockWh.allStockList");
        
        System.out.println("result repositoryImpl"+result);
        return result;
    }

	@Override
	public void updateStock(Stock data) throws DataAccessException{
		sqlSession.update("mapper.stockWh.updateStock", data);
		
	}
	
	@Override
	public List<Stock> searchWhStock(Stock data) throws DataAccessException {
		System.out.println("보내기전 data"+data);
		if((data.getWarehouse_code()==null||data.getWarehouse_code()=="")&&
				(data.getLot_no()==null||data.getLot_no()=="")&&
				(data.getItem_code()==null||data.getItem_code()=="")&&
				(data.getItem_name()==null||data.getItem_name()=="")&&
				(data.getItem_category()==null||data.getItem_category()=="")&&
				(data.getWarehouse_name()==null||data.getWarehouse_name()=="")) {
			List<Stock> result=sqlSession.selectList("mapper.stockWh.allStockList");
			System.out.println("스톡리포지토리 리저트1"+result);
			return result;
		}else {
			
		    String warehouseCode = data.getWarehouse_code();
		    if (warehouseCode != null && warehouseCode.contains("@N@")) {
		        String[] warehouseCodes = warehouseCode.split("@N@");
		        System.out.println("warehouseCodes 배열"+warehouseCodes);
		        data.setWarehouse_code(null);
		        List<Stock> result = new ArrayList<>();
		        for (String code : warehouseCodes) {
		            data.setWarehouse_code(code);
		            result.addAll(sqlSession.selectList("mapper.stockWh.searchStockList", data));
		            System.out.println("xml 쿼리 갔다온 후"+result);
		        }
		        return result;
		    } else {
			List<Stock> result=sqlSession.selectList("mapper.stockWh.searchStockList", data);
			System.out.println("스톡리포지토리 리저트2"+result);
	        return result;
		    }

		}
	}
	

	@Override
	public List<Stock> searchWhList() throws DataAccessException {
		List<Stock> result = sqlSession.selectList("mapper.stockWh.searchWhList");
		return result;
	}

	@Override
	public List<Stock> searchWh(Stock data) throws DataAccessException {
		System.out.println("xml로 넘기기전 data"+data);
		List<Stock> result = sqlSession.selectList("mapper.stockWh.searchWh", data);
		return result;
	}
}
