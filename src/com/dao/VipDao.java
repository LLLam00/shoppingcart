package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.Vip;



public interface VipDao {
	void addVip(Vip vip) throws SQLException;
	void deleteVip(Integer vid) throws SQLException;
	public Vip findById(Integer vid) throws SQLException;
	public List<Vip> findByName(String vname) throws SQLException;
	public List<Vip> getAllVip() throws SQLException;
	public void update(Vip vip)throws SQLException;
}
