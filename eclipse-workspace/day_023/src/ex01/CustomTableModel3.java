package ex01;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel3 extends AbstractTableModel {

	// ArrayList 1개 + 클래스를 사용해서 변경
	private ArrayList<Data> items= null;
	
	public CustomTableModel3() {
		items = new ArrayList<Data>();
		
		Data data1 = new Data("1", "2", "3", "4", "5");
		Data data2 = new Data("11", "2", "3", "4", "5");
		Data data3 = new Data("21", "2", "3", "4", "5");
		Data data4 = new Data("31", "2", "3", "4", "5");
		Data data5 = new Data("41", "2", "3", "4", "5");
		
		items.add(data1);
		items.add(data2);
		items.add(data3);
		items.add(data4);
		items.add(data5);
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
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		String result = "";
		Data data = items.get(rowIndex);
		switch(columnIndex) {
		case 0 : result = data.getNum1(); break;
		case 1 : result = data.getNum2(); break;
		case 2 : result = data.getNum3(); break;
		case 3 : result = data.getNum4(); break;
		case 4 : result = data.getNum5(); break;
		}
		return result;
	}
}
