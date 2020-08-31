package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.VipDaoImpl;
import com.domain.Vip;



public class VipService {
	
	
		// ҵ���ע��Dao����
		private VipDaoImpl vipDaoImpl;

		//spring��set�����Ϳ���ע��
		public void setVipDao(VipDaoImpl vipDaoImpl) {
			this.vipDaoImpl = vipDaoImpl;
		}

		public void save(Vip vip) throws SQLException {
			vipDaoImpl.addVip(vip);
		}
		public void delete(int vid) throws SQLException {
			vipDaoImpl.deleteVip(vid);
		}
		public List<Vip> getAllVip() throws SQLException {
			return vipDaoImpl.getAllVip();
		}
		public Vip findById(int vid) throws SQLException{
			return vipDaoImpl.findById(vid);
		}
		public List<Vip> findByName(String vname) throws SQLException{
			vname="%"+vname+"%";
			return vipDaoImpl.findByName(vname);
		}
		
		public void update(Vip vip) throws SQLException{
			vipDaoImpl.update(vip);
		}


}
