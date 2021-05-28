package day_032;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

// CustomSubwayModel
public class CustomSubwayModel extends AbstractTableModel {
	
	private ArrayList<SubwayTO> datas;
	
	private String[] columnNames = new String[] {
			"no", "local", "line", "station"
	};
	
	// 생성자를 통한 table 초기화
	public CustomSubwayModel(String local, String line) {
		SubwayDAO dao = new SubwayDAO();
		this.datas = dao.searchSubway(local, line);
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		return datas.size();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = "";
		SubwayTO to = datas.get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			result = to.getNo();
			break;
		case 1:
			result = to.getLocal();
			break;
		case 2:
			result = to.getLine();
			break;
		case 3:
			result = to.getStation();
			break;
		}
		
		return result;
	}
}