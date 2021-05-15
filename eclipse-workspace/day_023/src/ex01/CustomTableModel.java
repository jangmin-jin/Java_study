package ex01;

import java.io.BufferedReader;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {

	// 데이터 행 / 열 선언
	private String[][] items = null;
	
	// 컬럼 관련 정보 선언
	private String[] columnNames = new String[] {
			"\uBC88\uD638", "\uC6B0\uD3B8\uBC88\uD638", "\uC2DC/\uB3C4", "\uAD6C/\uAD70", "\uB3D9", "\uC74D/\uBA74/\uB9AC", "\uBC88\uC9C0"
	};
	
	// 컬럼
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	// 데이터 행, 열
	@Override
	public int getRowCount() {
		return items.length;
	}

	@Override
	public int getColumnCount() {
		return items[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return items[rowIndex][columnIndex];
	}

}
