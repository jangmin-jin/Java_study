package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomZipcodeModel extends AbstractTableModel {
	
	// 최종 결과를 담을 변수 datas 선언
	private ArrayList<ZipcodeTO> datas;
	
	// column들의 이름을 정해준다.
	private String[] columnNames = new String[] {
			"\uC6B0\uD3B8\uBC88\uD638", "\uC2DC\uB3C4", "\uAD6C\uAD70", "\uB3D9", "\uB9AC", "\uBC88\uC9C0"
		};
	
	// 생성자
	public CustomZipcodeModel(String strDong){
		DataDAO dao = new DataDAO();
		this.datas = dao.searchZipcode(strDong);
	}

	@Override
	public String getColumnName(int column) {
		// 새로운 컬럼의 이름들을 반환
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
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// 해당 행마다의 열 정보들을 result에 넣어준다.
		String result = "";
		ZipcodeTO to = datas.get(rowIndex);
		switch(columnIndex) {
		case 0:
			result = to.getZipcode();
			break;
		case 1:
			result = to.getSido();
			break;
		case 2:
			result = to.getGugun();
			break;
		case 3:
			result = to.getDong();
			break;
		case 4:
			result = to.getRi();
			break;
		case 5:
			result = to.getBunji();
			break;
		}
		
		return result;
	}
}