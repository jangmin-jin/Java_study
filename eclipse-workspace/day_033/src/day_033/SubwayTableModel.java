package day_033;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

// 지역과 노선을 인수로 받아 해당하는 데이터에 대해 지역, 노선, 역이름 테이블 모델을 만드는 클래스
public class SubwayTableModel extends AbstractTableModel {
	private ArrayList<SubwayTO> datas;
	private String[] columnNames = {"지역", "노선", "역이름"};
	
	public SubwayTableModel( String strLocal, String strLine ) {
		// TODO Auto-generated constructor stub
		SubwayDAO dao = new SubwayDAO();
		this.datas = dao.searchStation(strLocal, strLine);
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String result = "";
		// arraylist에서 순서에 맞는 to 가져오기
		SubwayTO to = datas.get(rowIndex);
		// 열 순서에 맞게 to 안의 데이터 가져오기
		switch( columnIndex ) {
		case 0 :
			result = to.getLocal();
			break;
		case 1 :
			result = to.getLine();
			break;
		case 2 :
			result = to.getStation();
			break;
		}
		return result;
	}

}
