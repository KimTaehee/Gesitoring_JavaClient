import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Options extends JFrame implements ActionListener{
	public JTextField jtf;
	
	public Options(){
		
		Container ct = getContentPane(); 		
		ct.setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel(); //첫번째 페널이요
		JPanel jp2 = new JPanel(); // 두번쨰 페널 추가입니다
		JPanel jp3 = new JPanel();
		JButton oo = new JButton("확인"); // 확인버튼 OO
		JButton no = new JButton("취소"); // 취소버튼 NO


		jtf = new JTextField(10); // 10개의 문자를 저장할 jTexField 객체 생성 
		JComboBox timeset = new JComboBox(); // 콤보박스 객체 생성
		timeset.addItem("3분"); // 콤보 박스에 아이템 추가
		timeset.addItem("10000분");// 콤보박스에 아이템 추가		
		jp1.setLayout(new GridLayout(1,3)); //1행 3열 패널임니다
		jtf.addActionListener(this);// 텥스트필드객체에 이벤트 리스너 등ㅋ록ㅋ		
		jp1.add(new JLabel("검사주기" , Label.RIGHT));  // JLabel 이용 글씨쓰긩
		jp1.add(timeset);	// 패널에 콤보박스 추가
//		jc.ItemListener(this); // 콤보박스에 이벤트리스너 등록
		// p.550쪽에선 ㅠ_ㅠ 어떻게해야되  class JPaneal extends JFrame implements ActionListener{
// 대신에 itemlisntereawfnawf 넣었는데 에호ㅛ 작동을하니?
		
		jp2.setLayout(new GridLayout(2,1));
		jp2.add(new JCheckBox("팝업알림사용",true)); // true 하면 체크가 되서 나옵니다.
		jp2.add(new JLabel(" 팝업 지속 시간 :"));  // JLabel 이용 글씨쓰긩
		jtf = new JTextField(10); // 10개의 문자를 저장할 jTexField 객체 생성
		jp2.add(jtf); // 글자 입력 팝업지속시간에 추가 할것임
		jtf.addActionListener(this); // 텍스트필드객체에 듣는거인듯??
		
		jp2.add(new JCheckBox("소리알람사용",true));

		jp3.setLayout(new GridLayout(1,2));
		jp3.add(oo); //확인버튼 OO 추가
		jp3.add(no); //취소버튼 NO 추가
		
		oo.addActionListener(this);
		no.addActionListener(this);
		
		ct.add(jp1,BorderLayout.NORTH);
		ct.add(jp2,BorderLayout.CENTER);
		ct.add(jp3,BorderLayout.SOUTH);

		setTitle("OPTION");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 최소화되게끔;;
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent event){  // 아오빡침여..
//		jtf.setText(" ");

		if (event.getActionCommand().equals("취소")) //취소를 입력하니까 꺼지네;;
		{
			//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 최소화되게끔;;
			//System.exit(0);
			this.hide();
		}
	}
}

public class GOption {
	public static void main(String[] args){
		new Options();
		}
}