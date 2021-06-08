package com.exam.member02;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class GroupListModel extends AbstractListModel {
	private ArrayList<String> datas; 
	
	public GroupListModel() {
		// TODO Auto-generated constructor stub
		datas = new ArrayList<String>();
		datas.add( "기본" );
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return datas.get(index);
	}
}
