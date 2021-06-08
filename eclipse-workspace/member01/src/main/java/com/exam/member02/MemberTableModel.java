package com.exam.member02;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MemberTableModel extends AbstractTableModel {
	private ArrayList<ArrayList<String>> datas;
	private String[] columnNames = new String[] {
		"\uBC88\uD638", "\uADF8\uB8F9", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C"
	};
	private boolean[] columnEditables = new boolean[] {
		false, false, false, false, false
	};
	
	public MemberTableModel() {
		// TODO Auto-generated constructor stub
		datas = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> data = new ArrayList<String>();
		data.add( "1" );
		data.add( "기본" );
		data.add( "홍길동" );
		data.add( "010-1111-1111" );
		data.add( "test1@test.com" );
		
		datas.add( data );
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnEditables[columnIndex];
	}
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return datas.get(rowIndex).get(columnIndex);
	}

}
