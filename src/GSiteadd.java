import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class Siteinput extends JFrame implements ActionListener{
	public Siteinput(String name, String url, int refreshCycle){
		JTextField nametext = new JTextField(); // 글자 입력 하는 공간 생성
		nametext.setText(name);
		JTextField urltext = new JTextField(); // 글자 입력 하는 공간 생성
		urltext.setText(url);
		
		JButton okB = new JButton("확인"); // 버튼 2개 생성 
		JButton deleteB = new JButton("삭제");
		
		JPanel jp1 = new JPanel(); //첫번째 페널이요
		JPanel jp2 = new JPanel(); //en번째 페널이요
		JPanel jp3 = new JPanel(); //tp번째 페널이요
		
		JComboBox jc = new JComboBox(); // 콤보박스 객체 생성
		jc.addItem("기본 설정에 따름");
		jc.addItem("1분"); // 콤보 박스에 아이템 추가
		jc.addItem("3분");// 콤보박스에 아이템 추가	
		jc.addItem("10분");
		jc.addItem("30분");
		jc.addItem("1시간");
		jc.addItem("6시간");
		
		switch(refreshCycle) {
		case 0: jc.setSelectedItem("기본 설정에 따름"); break; 
		case 1: jc.setSelectedItem("1분"); break;
		case 3: jc.setSelectedItem("3분"); break;
		case 10: jc.setSelectedItem("10분"); break;
		case 30: jc.setSelectedItem("30분"); break;
		case 60: jc.setSelectedItem("1시간"); break;
		case 360: jc.setSelectedItem("6시간"); break;
		default: System.out.println("combobox 대입 err 없는 cycle이 입력됨");
		}
		
		JLabel nameL = new JLabel("이름"); // 글자 표시 라벨 생성
		JLabel settingL = new JLabel("검사주기"); // 글자 표시 라벨 생성
		JLabel urlL = new JLabel("URL");  // 글자 표시 라벨 생성
		
		
		okB.addActionListener(this); // 추가 버튼 누르면 듣는당
		deleteB.addActionListener(this); // 삭제 버튼 누르면 듣는당
		jc.addActionListener(this); // 콤보박스 버튼 누르면 듣는당
		urltext.addActionListener(this); // url 입력하면 듣
		nametext.addActionListener(this); // 이름 입력하면 듣
//		readName.addActionListener(this);


		Container ct = getContentPane(); // 퀀테이너 
		ct.setLayout(new BorderLayout());

		jp1.setLayout(new GridLayout(1,4));	
		jp1.add(nameL); // 이름
		jp1.add(nametext); // 이름입력 창
		jp1.add(settingL); // 검사주기
		jp1.add(jc);	// 패널에 콤보박스 추가

		jp2.setLayout(new GridLayout(1,2));
		jp2.add(urlL); // url 
		jp2.add(urltext); // url 입력창
		
		
		jp3.setLayout(new GridLayout(1,3));
		jp3.add(okB); // 확인 버트 추가
		jp3.add(deleteB); // 삭제 버튼 추가
		
		
		ct.add(jp1,BorderLayout.NORTH);
		ct.add(jp2,BorderLayout.CENTER);
		ct.add(jp3,BorderLayout.SOUTH);
		setTitle("사이트 입력");
		setSize(400,125);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 최소화 되게끔입니다.
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
//		nametext.setText(" ");
//		urltext.setText(" "); // 왜 에러가 뜨는가!!!!!
	/**	if(event.getActionCommand().equals("확인")){
			// 이름이나 고등학교, 학년이 바뀐 경우
			if(!nametext.getText().equals(oriName) ||
					!readScl.getText().equals(oriScl) ||
					!readGrd.getText().equals(oriGrd))
			{
				try{
					// 수정할 파일의 파일 클래스
					File modFile = new File
						(readName.getText() + "_" + readScl.getText() + "_" + readGrd.getText() + "_.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(modFile));
					// 위에서 수정된 정보 저장 (파일의 이름이 바뀜)
					bw.write(readName.getText() + "|" + readScl.getText() + "|" + readGrd.getText() + "|" 
						+ readAdr.getText() + "|" + readTel.getText() + "|" + readPrt.getText() + "|" 
						+ readPTel.getText() + "|" + readAct.getText());
					
					// 이름(또는 고등학교, 학년)이 바뀌기 전의 파일 삭제
					new File(oriName + "_" + oriScl + "_" + oriGrd + "_.txt").delete();
					
					bw.close();
					
					// 
					modFile = new File
							(readName.getText() + "_" + readScl.getText() + "_" + readGrd.getText() + "_course.txt");
					bw = new BufferedWriter(new FileWriter(modFile));
					for(int i=0; i<dtm.getRowCount(); i++){
						bw.write(subTable.getValueAt(i, 0).toString() + "|" 
								+ subTable.getValueAt(i, 1).toString() + "|"
								+ subTable.getValueAt(i, 2).toString() + "|");
						bw.newLine();
					}
					
					bw.close();
					
					new File(oriName + "_" + oriScl + "_" + oriGrd + "_course.txt").delete();
					
					oriName = readName.getText();
					oriScl = readScl.getText();
					oriGrd = readGrd.getText();
					
				} catch(IOException e){}
				
			}
			else {
				try{
					File existFile = new File(oriName + "_" + oriScl + "_" + oriGrd + "_.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(existFile));
					bw.write(readName.getText() + "|" + readScl.getText() + "|" + readGrd.getText() + "|" 
						+ readAdr.getText() + "|" + readTel.getText() + "|" + readPrt.getText() + "|" 
						+ readPTel.getText() + "|" + readAct.getText());
					
					bw.close();
				} catch(IOException e){ }
			}
			
			
			String msg = "저장이 완료되었습니다";
			JOptionPane.showMessageDialog(sFrame, msg);
			ServerWindow.refreshTable();
		}
		*/
	}
}

//public class GSiteadd {
//	public static void main(String args[])
//	{
//		new Siteinput();
//	}
//}
