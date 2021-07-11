/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOInterface;

import Model.Imigran;
import java.util.List;

/**
 *
 * @author RIVANKA
 */


public interface IDAOImigran {
	//read data
	public List<Imigran> getAll();
	
	//insert data
	public void insert(Imigran a);
	
	
	//abstract method untuk update
	public void update(Imigran a);
	
	//hapus data
	public void delete(String kode);//untuk menghapus dengan mengambil dari primary key
	
	//cari data
	public List<Imigran>getAllByNameKode (String nama);
	
}
