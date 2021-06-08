package com.exam.member01;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MemberTableModel extends AbstractTableModel {
	private ArrayList<MemberTO> datas;
	private String[] columnNames = new String[] {
		"\uBC88\uD638", "\uADF8\uB8F9", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C"
	};
	private boolean[] columnEditables = new boolean[] {
		false, false, false, false, false
	};
	
	public MemberTableModel() {
		// TODO Auto-generated constructor stub
		MemberDAO dao = new MemberDAO();
		datas = dao.listMember();
				
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

		MemberTO to = datas.get(rowIndex);
		String result="";
		switch (columnIndex) {
		case 0:
			result = to.getSeq() + "";
			break;
		case 1:
			result = to.getGroupNo() + "";
			break;
		case 2:
			result = to.getName();
			break;
		case 3:
			result = to.getPhone();
			break;
		case 4:
			result = to.getEmail();
			break;
		}
		
		return result;
	}

}
