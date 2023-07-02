package com.rms.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.daos.TablesDao;
import com.rms.daos.UserDao;
import com.rms.dtos.TablesDTO;
import com.rms.entities.Tables;
import com.rms.utils.DtoEntityConverter;

@Service
public class TableServiceImpl {

	@Autowired
	private TablesDao tablesDao;
	@Autowired
	private DtoEntityConverter converter;
	@Autowired
	private UserDao userDao;
	
	public Map<String, Object> addTable(TablesDTO tablesDTO){
		Tables tables = tablesDao.save(converter.toTablesEntity(tablesDTO));
		return Collections.singletonMap("InsertedId", tables.getTableId());
	}
	
	public Map<String, Object> updateTable(Integer id, TablesDTO tablesDTO){
		Tables tables = tablesDao.findByTableId(id);
		tables.setTableName(tablesDTO.getTableName());
		tables.setTableCapacity(tablesDTO.getTableCapacity());
		tables = tablesDao.save(tables);
		return Collections.singletonMap("UpdatedId", tables.getTableId());
	}
	
	public Map<String, Object> assignTableWaiter(Integer id, TablesDTO tablesDTO){
		Tables tables = tablesDao.findByTableId(id);
		tables.setTableStatus(tablesDTO.getTableStatus());
		tables.setWaiter(userDao.findByUserId(tablesDTO.getWaiterId()));
		tables = tablesDao.save(tables);
		return Collections.singletonMap("UpdatedId",tables.getTableId());
	}
	
	public List<TablesDTO> getAllTables(){
		List<TablesDTO> sendList = new ArrayList<TablesDTO>();
		List<Tables> list = tablesDao.findAll();
		for(Tables tables : list) {
			sendList.add(converter.toTablesDTO(tables));
		}
		return sendList;
	}
	
	public List<TablesDTO> getAllTablesByStatus(){
		List<TablesDTO> sendList = new ArrayList<TablesDTO>();
		List<Tables> list = tablesDao.findByTableStatus("Booked");
		for(Tables tables : list) {
			sendList.add(converter.toTablesDTO(tables));
		}
		return sendList;
	}
	
	public List<TablesDTO> getTablesByWaiter(Integer id){
		List<TablesDTO> sendList = new ArrayList<TablesDTO>();
		List<Tables> list = tablesDao.findByWaiter_UserId(id);	
		for(Tables tables : list) {
			sendList.add(converter.toTablesDTO(tables));
		}
		return sendList;
	}
	
	public Integer deleteTableById(Integer id) {
		if(tablesDao.existsById(id)) {
			tablesDao.deleteById(id);
			return 1;
		}
		return 0;
	}
	
}
