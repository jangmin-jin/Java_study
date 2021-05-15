package ex01;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class CustomListModel extends AbstractListModel<Object> {
	//String[] items = new String[] {"사과", "딸기", "수박", "참외", "드래곤후르츠", "두리안", "배", "포도", "샤인머스켓", "샤인오이", "사과", "딸기", "수박", "참외", "드래곤후르츠", "두리안", "배", "포도", "샤인머스켓", "샤인오이", "사과", "딸기", "수박", "참외", "드래곤후르츠", "두리안", "배", "포도", "샤인머스켓", "샤인오이"};
	
	ArrayList<String> items = null;
	
	public CustomListModel() {
		items = new ArrayList<String>();
		items.add("사과");
		items.add("딸기");
		items.add("수박");
		items.add("참외");
		items.add("드래곤후르츠");
		items.add("두리안");
		items.add("배");
		items.add("포도");
		items.add("샤인머스켓");
		items.add("샤인오이");
	}
	
	@Override
	public int getSize() {
		return items.size();
	}

	@Override
	public Object getElementAt(int index) {
		return items.get(index);
	}	
}