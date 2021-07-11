/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RIVANKA
 */
public class TabelModelImigran extends AbstractTableModel {

	public TabelModelImigran(List<Imigran> listOrder){
		this.listImigran=listOrder;
	}
	@Override
	public int getRowCount() {
		return this.listImigran.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int column){
		
		return switch (column) {
			case 0 -> "kode Paspor";
			case 1 -> "nama";
			case 2 -> "alamat";
			case 3 -> "warga";
			case 4 -> "jenis kelamin";
			case 5 -> "tanggal Lahir";
			default -> null;
		};
		
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return switch (columnIndex) {
			case 0 -> listImigran.get(rowIndex).getKode();
			case 1 -> listImigran.get(rowIndex).getNama();
			case 2 -> listImigran.get(rowIndex).getAlamat();
			case 3 -> listImigran.get(rowIndex).getWarga();
			case 4 -> listImigran.get(rowIndex).getJenis_kelamin();
			case 5 -> listImigran.get(rowIndex).getTanggal();
			default -> null;
		};
	}
	List<Imigran> listImigran;
}
