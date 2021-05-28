package day_033;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

// 지역을 인수로 받아 해당 지역의 노선 콤보박스 모델을 만드는 클래스
public class LineComboBoxModel extends DefaultComboBoxModel<Object> {
	private ArrayList<SubwayTO> items;
	
	public LineComboBoxModel( String strLocal ) {
		// TODO Auto-generated constructor stub
		SubwayDAO dao = new SubwayDAO();
		this.items = dao.listLine( strLocal );
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return items.size();
	}
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		// ArrayList에서 순서에 맞는 to 가져오기
		SubwayTO to = items.get(index);
		
		// to에서 line 가져오기
		String result = to.getLine();
		return result;
	}
}
