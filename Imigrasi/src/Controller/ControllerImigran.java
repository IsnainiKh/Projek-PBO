/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOImigran;
import DAOInterface.IDAOImigran;
import Model.Imigran;
import Model.TabelModelImigran;
import View.Menu;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author RIVANKA
 */
public class ControllerImigran {
	
	
	
	public ControllerImigran(Menu frmImigran){
		this.frmImigran = frmImigran;
		iImigran = new DAOImigran();
		
	}
	
	
	// menampilkan data di dalam tabel gui
	public void isiTable(){
		
		listImigran = iImigran.getAll();
		TabelModelImigran tabelImg = new TabelModelImigran(listImigran);
		frmImigran.getTableData().setModel(tabelImg);
		
	}
	
	public void insert(){
		
		Imigran a = new Imigran();
		a.setKode(frmImigran.gettxtKode().getText());
		a.setNama(frmImigran.gettxtNama().getText());
		a.setAlamat(frmImigran.gettxtAlamat().getText());
		a.setWarga(frmImigran.gettxtWarga().getText());
		a.setJenis_kelamin(frmImigran.getcomboJenis().getSelectedItem().toString()); //khusus selected karena menggunakan combo box lalu di ubah menjadi string
		String tanggal1 = frmImigran.getdateTanggal().getDate().toString().substring(4, 10);
		String tanggal2 = frmImigran.getdateTanggal().getDate().toString().substring(23, 28);
		a.setTanggal(tanggal1 + ","+ tanggal2);  // khusus dateformat karena menggunakan datechooser lalu di ubah menjadi string
		iImigran.insert(a); //perintah insert
		JOptionPane.showMessageDialog(null, "input sukses"); //alert jika berhasil
		
	}
	
	public void reset(){ //untuk mereset saat setelah menyimpan atau mengubah data agar kolom form kosong
		
		if(!frmImigran.gettxtKode().isEnabled()){ //fungsi pengendalian jika kolom input kode terkunci
			frmImigran.gettxtKode().setEnabled(true); //perintah untuk membuka kembali kunci input kode paspor
		}
		frmImigran.gettxtKode().setText("");
		frmImigran.gettxtNama().setText("");
		frmImigran.gettxtAlamat().setText("");
		frmImigran.gettxtWarga().setText("");
		frmImigran.getdateTanggal().setDate(null);
		
	}
	//fungsi dari throws Parse Exception adalah agar fungsi parse mengubah string ke date berhasil
	public void isiField(int row) throws ParseException{ //untuk actionListener mouse clicked saat salah satu data di tabel maka akan muncul di form data yang telah di pilih
		frmImigran.gettxtKode().setText(listImigran.get(row).getKode());
		frmImigran.gettxtKode().setEnabled(false); //berfungsi untuk mengunci primary key / kode paspor agar tidak dapat di ubah
		frmImigran.gettxtNama().setText(listImigran.get(row).getNama());
		frmImigran.gettxtAlamat().setText(listImigran.get(row).getAlamat());
		frmImigran.gettxtWarga().setText(listImigran.get(row).getWarga());
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, y");
		String date = listImigran.get(row).getTanggal();
		frmImigran.getdateTanggal().setDate(sdf.parse(date));
		frmImigran.getcomboJenis().setSelectedItem(listImigran.get(row).getJenis_kelamin());
	}
	
	public void update(){
		
		Imigran a = new Imigran();
		a.setKode(frmImigran.gettxtKode().getText());
		a.setNama(frmImigran.gettxtNama().getText());
		a.setAlamat(frmImigran.gettxtAlamat().getText());
		a.setWarga(frmImigran.gettxtWarga().getText());
		a.setJenis_kelamin(frmImigran.getcomboJenis().getSelectedItem().toString()); //khusus selected karena menggunakan combo box lalu di ubah menjadi string
		String tanggal1 = frmImigran.getdateTanggal().getDate().toString().substring(4, 10);
		String tanggal2 = frmImigran.getdateTanggal().getDate().toString().substring(23, 28);
		a.setTanggal(tanggal1 + ","+ tanggal2);  // khusus dateformat karena menggunakan datechooser lalu di ubah menjadi string
		iImigran.update(a); //perintah insert
		JOptionPane.showMessageDialog(null, "Update sukses"); //alert jika berhasil
	}
	
	public void delete(){
		
		iImigran.delete(frmImigran.gettxtKode().getText()); //perintah hapus
		JOptionPane.showMessageDialog(null, "Hapus sukses"); //alert jika berhasil
	}
	
	public void cari(){
		listImigran = iImigran.getAllByNameKode(frmImigran.gettxtCari().getText()); //mengambil nama dari form search //dan karena return dari DAOImigran 
		TabelModelImigran tabelImg = new TabelModelImigran(listImigran);
		frmImigran.getTableData().setModel(tabelImg);
	}
	
	
	Menu frmImigran;
	IDAOImigran iImigran;
	List<Imigran>listImigran;
	
}
