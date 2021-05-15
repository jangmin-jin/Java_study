package ex01;

import javax.swing.SpinnerListModel;

public class CustomSpinnerListModel extends SpinnerListModel {
	
	private static String[] items = {"사과", "참외", "수박", "딸기"};
	public CustomSpinnerListModel() {
		super( items );
	}
}