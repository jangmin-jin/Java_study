package jsoup;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomNewsModel extends AbstractTableModel {

	private ArrayList<JSoupTO> newsLists;
	
	private String[] columnNames = new String[] {
			"출처", "제목", "내용"
	};
	
	public CustomNewsModel(String address) {
		
		String mostViewNews = "https://news.daum.net/ranking/kkomkkom";
		String mostComentNews = "https://news.daum.net/ranking/bestreply";
		String AgeNews = "https://news.daum.net/ranking/age";
		
		JSoupDAO2 dao = new JSoupDAO2(address);
		// 주소상 열독률이거나 댓글이면 dao.newslists함수 실행
		if(address == mostViewNews || address == mostComentNews) {
			this.newsLists = dao.newsLists(address);
		}  
		
		// 주소상 연령대면 dao.newsListsAge함수 실행
		// 마지막 컬럼 내용도 [내용]에서 [연령대]로 변경
		if(address == AgeNews) {
			this.newsLists = dao.newsListsAge(address);
			this.columnNames[2] = "연령대";
		}
		
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		return newsLists.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		JSoupTO to = newsLists.get(rowIndex);
		String result = "";
		switch( columnIndex ) {
		case 0:
			result = to.getSource();
			break;
		case 1:
			result = to.getSubject();
			break;
			
		// 만약 연령대를 볼 시엔 마지막 컬럼에는 Age가 들어갈 수 있게.
		case 2:
			if(to.getContent() != null) {
				result = to.getContent();
			}
			if(to.getAge() != null) {
				result = to.getAge();
			}

			break;
		}
		
		return result;
	}
}