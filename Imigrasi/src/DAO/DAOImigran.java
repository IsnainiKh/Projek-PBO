/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.Connector;
import DAOInterface.IDAOImigran;
import Model.Imigran;
import com.mysql.jdbc.PreparedStatement;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RIVANKA
 */
public class DAOImigran implements IDAOImigran{
	Connector connector = new Connector();

	public DAOImigran()
	{
		Connector connector = new Connector();
	
	}
	
	//read data
	@Override
	public List<Imigran> getAll() {
		
		List<Imigran> listImigran =null;
		try{
					
			listImigran = new ArrayList<Imigran>();
			connector.statement = connector.koneksi.createStatement();			
			String queryRead= "select * from imigran";
			ResultSet result = connector.statement.executeQuery(queryRead);
			
			while(result.next()){
				
				Imigran img = new Imigran();
				img.setKode(result.getString("kode"));
				img.setNama(result.getString("nama"));
				img.setAlamat(result.getString("alamat"));
				img.setWarga(result.getString("warga"));
				img.setJenis_kelamin(result.getString("jenis_kelamin"));
				img.setTanggal(result.getString("tanggal"));
				listImigran.add(img);
			}
			
		}catch(SQLException ex){
			System.out.println("error");
		}
		
		
		return listImigran;
		
	}
	
	

	//write data
	@Override
	public void insert(Imigran a) {

		try{
			
						
String queryWrite = "insert into imigran (kode,nama,alamat,warga,jenis_kelamin,tanggal) values ('"+a.getKode()+"','"+a.getNama()+"','"+a.getAlamat()+"','"+a.getWarga()+"','"+a.getJenis_kelamin()+"','"+a.getTanggal().toString()+"');";
	connector.statement = connector.koneksi.createStatement();
        connector.statement.executeUpdate(queryWrite);	

		}catch(SQLException e){
			System.out.println("gagal input: " + e);//error ketika di awal
		}

		
	}
	
	@Override
	public void update(Imigran a) {
		try {
		String kodeUpdate = a.getKode();
		String queryUpdate = "update imigran set kode='"+a.getKode()+"', nama='"+a.getNama()+"', alamat='"+a.getAlamat()+"', warga='"+a.getWarga()+"', jenis_kelamin='"+a.getJenis_kelamin()+"', tanggal='"+a.getTanggal().toString()+"' where kode='"+kodeUpdate+"';";
	connector.statement = connector.koneksi.createStatement();
        connector.statement.executeUpdate(queryUpdate);	

			
		} catch (Exception e) {
			System.out.println("gagal update: " + e);
		}
		
		
	}

	@Override
	public void delete(String kode) {
		try {
		String queryDelete = "delete  from imigran where kode='"+kode+"';";
	connector.statement = connector.koneksi.createStatement();
        connector.statement.executeUpdate(queryDelete);			
		} catch (Exception e) {
			System.out.println("gagal delete: " + e);
		}
	}

	@Override
	public List<Imigran> getAllByNameKode(String cari) {
		
		
		List<Imigran> listImigran =null;
		try{
					
			listImigran = new ArrayList<Imigran>();
			connector.statement = connector.koneksi.createStatement();
			String temp = "%"+cari+"%";
			String querySearch = "select * from imigran where nama like '"+temp+"' or kode like '"+temp+"';";
			ResultSet result = connector.statement.executeQuery(querySearch);
			
			while(result.next()){
				
				Imigran img = new Imigran();
				img.setKode(result.getString("kode"));
				img.setNama(result.getString("nama"));
				img.setAlamat(result.getString("alamat"));
				img.setWarga(result.getString("warga"));
				img.setJenis_kelamin(result.getString("jenis_kelamin"));
				img.setTanggal(result.getString("tanggal"));
				listImigran.add(img);
			}
			
		}catch(SQLException ex){
			System.out.println("error");
		}
		return listImigran; //digunakan saat controller
		
	}
	

	
}
