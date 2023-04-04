package com.yeonoo.so.service;

import java.util.List;
import com.yeonoo.so.domain.ShipOut;
import com.yeonoo.so.domain.ItemShipOutDTO;
import com.yeonoo.so.domain.LotShipOutDTO;

public interface ShipOutService {

	List<ShipOut> getList();
	
	int updateStatus(String outCode);
	
	int writeShipOut(ShipOut elements);
	
	ItemShipOutDTO selectItem(String outCode);
	
	LotShipOutDTO selectLot(String itemCode);
}
