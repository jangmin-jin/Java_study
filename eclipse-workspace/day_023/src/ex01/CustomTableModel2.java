package ex01;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel2 extends AbstractTableModel {

	// 데이터 행 / 열 선언
	ArrayList<String> item1, item2, item3, item4, item5 = null;
	ArrayList<ArrayList<String>> items = null;
	
	public CustomTableModel2() {
		item1 = new ArrayList<String>();
		item1.add("1");
		item1.add("2");
		item1.add("3");
		item1.add("4");
		item1.add("5");
		item2 = new ArrayList<String>();
		item2.add("6");
		item2.add("7");
		item2.add("8");
		item2.add("9");
		item2.add("10");
		item3 = new ArrayList<String>();
		item3.add("11");
		item3.add("12");
		item3.add("13");
		item3.add("14");
		item3.add("15");
		item4 = new ArrayList<String>();
		item4.add("16");
		item4.add("17");
		item4.add("18");
		item4.add("14");
		item4.add("15");
		item5 = new ArrayList<String>();
		item5.add("21");
		item5.add("22");
		item5.add("23");
		item5.add("24");
		item5.add("25");
		
		items = new ArrayList<ArrayList<String>>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
	}
	
	// 컬럼 관련 정보 선언
	private String[] columnNames = new String[] {
			"\uCEEC\uB7FC1", "\uCEEC\uB7FC2", "\uCEEC\uB7FC3", "\uCEEC\uB7FC4", "\uCEEC\uB7FC5"
	};
	
	// 컬럼
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	// 데이터 행, 열
	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return items.get(0).size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return items.get(rowIndex).get(columnIndex);
	}
}