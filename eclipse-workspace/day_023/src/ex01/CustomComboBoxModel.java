package ex01;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel extends DefaultComboBoxModel<Object> {
	private String[] items = {"풋사과", "씨없는수박", "메론", "스타후르츠"};
	
	// combobox에서 자동으로 호출되는 메소드
	@Override
	public int getSize() {
		System.out.println( "getSize() 호출" );
		return items.length;
	}
	
	@Override
	public Object getElementAt(int index) {
		System.out.println( "getElementAt() 호출");
		return items[index];
	}
}
