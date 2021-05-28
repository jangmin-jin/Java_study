package day_033;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

// 지역명 콤보박스의 모델을 만드는 클래스
public class LocalComboBoxModel extends DefaultComboBoxModel<Object> {
	private ArrayList<SubwayTO> items;
	
	public LocalComboBoxModel() {
		// TODO Auto-generated constructor stub
		SubwayDAO dao = new SubwayDAO();
		this.items = dao.listLocal();
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return items.size();
	}
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		// arraylist에서 순서에 맞는 to 가져오기
		SubwayTO to = items.get(index);
		// to에서 local 가져오기
		String result = to.getLocal();
		return result;
	}

}
