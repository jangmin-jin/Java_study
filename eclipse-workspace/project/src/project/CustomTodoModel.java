package project;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTodoModel extends AbstractTableModel {

	private ArrayList<TodolistTO> datas;
	
	// 할일, 입력 날짜, 완료 날짜
	private String[] columnNames = new String[] {
			"\uD560\uC77C", "\uC785\uB825 \uB0A0\uC9DC", "\uC644\uB8CC \uB0A0\uC9DC"
		};
	
	// 생성자
	public CustomTodoModel(String id, int listSelect) {
		DataDAO dao = new DataDAO();
		switch (listSelect) {
		case 0:
			// System.out.println("할일목록접근");
			this.datas = dao.printTodolist(id);
			break;
		case 1:
			// System.out.println("완료목록접근");
			this.datas = dao.printCompleteTodolist(id);
			break;
		case 2:
			// System.out.println("삭제목록접근");
			this.datas = dao.printDeleteTodolist(id);
			break;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		// 새로운 컬럼의 이름을 반환
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		// 행의 갯수
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// 열의 갯수
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result ="";
		TodolistTO to = datas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			result = to.getTodo();
			break;
		case 1:
			result = to.getTime();
			break;
		case 2:
			result = to.getComtime();
			break;
		}
		
		return result;
	}

}
