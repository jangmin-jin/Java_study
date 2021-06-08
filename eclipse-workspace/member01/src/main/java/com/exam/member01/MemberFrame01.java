package com.exam.member01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

import com.exam.member01.MemberTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberFrame01 extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberFrame01 frame = new MemberFrame01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberFrame01() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn11 = new JButton("그룹추가");
		btn11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn11.setBounds(12, 10, 80, 23);
		contentPane.add(btn11);
		
		JButton btn12 = new JButton("그룹수정");
		btn12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn12.setBounds(104, 10, 80, 23);
		contentPane.add(btn12);
		
		JButton btn13 = new JButton("그룹삭제");
		btn13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn13.setBounds(196, 10, 80, 23);
		contentPane.add(btn13);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 43, 264, 304);
		contentPane.add(scrollPane1);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		list = new JList();
		list.setModel( new GroupListModel() );
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane1.setViewportView(list);
		
		JButton btn21 = new JButton("회원추가");
		btn21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberInsertDialog dialog = new MemberInsertDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModal(true);
				dialog.setVisible(true);
				
				table.setModel(new MemberTableModel());
			}
		});
		btn21.setBounds(288, 10, 97, 23);
		contentPane.add(btn21);
		
		JButton btn22 = new JButton("회원수정");
		btn22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(MemberFrame01.this, "데이터 선택", "에러", JOptionPane.WARNING_MESSAGE);
				}else {
					int seq = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
					//System.out.println(seq);
					//System.out.println(table.getSelectedRow());
					
					MemberModifyDialog dialog = new MemberModifyDialog(seq);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setModal(true);
					dialog.setVisible(true);
					
					table.setModel(new MemberTableModel());
				}

			}
		});
		btn22.setBounds(397, 10, 97, 23);
		contentPane.add(btn22);
		
		JButton btn23 = new JButton("회원삭제");
		btn23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(table.getSelectedRow());
				if( table.getSelectedRow() == -1){
					JOptionPane.showMessageDialog(MemberFrame01.this, "데이터 선택", "에러", JOptionPane.WARNING_MESSAGE);
				}else {
					System.out.println(table.getValueAt(table.getSelectedRow(), 0));
					
					int seq = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
					
					MemberTO to = new MemberTO();
					to.setSeq(seq);
					
					MemberDAO dao = new MemberDAO();
					if( dao.deleteMember(to) ) {
						table.setModel(new MemberTableModel());
					}else {
						JOptionPane.showMessageDialog(MemberFrame01.this, "삭제 에러", "에러", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btn23.setBounds(506, 10, 97, 23);
		contentPane.add(btn23);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(287, 43, 567, 304);
		contentPane.add(scrollPane2);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel( new MemberTableModel() );
		scrollPane2.setViewportView(table);
	}
}
