import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;


/*
class FirstWindow extends JFrame implements ActionListener{ //아놔이게모지
	public FirstWindow(){

		JTextField tf1 = new JTextField();
		Container ct = getContentPane();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2,1));
		JButton bt1 = new JButton("확인");
		jp1.add(tf1);
		jp1.add(bt1);
		Frame.setLayout(new GridLayout());
		ct.add(Frame,BorderLayout.CENTER);
		setTitle("아이피를 입력 하 시게나!");
		setSize(150,150);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae){
			 String actionString = ae.getActionCommand();
			    if(actionString.equals("확인")) {
					 new GClientWindow();
			    }
		}
	}
*/ //어떻게하는지 몰겠응..

class GClientWindow extends JFrame implements ActionListener,MouseListener
{ // 이벤트 처리 위한 리스너포함
	JTextField jtf;
	static JTable table;// 뭔지몰라서 추가해논거
	static DefaultTableModel dtm;//
	static JScrollPane jsp;//
	
	public GClientWindow(){

		JFrame Frame = new JFrame("음");
		String msg = ";;";
		JOptionPane.showMessageDialog(Frame, msg);
	
		Container c = getContentPane();

		
		//파일파일파일 메뉴봐 메뉴봐 메뉴봐
		c.setLayout(new BorderLayout());
		JMenuBar jmb = new JMenuBar(); // 메뉴바 객체 생성
		JMenu file = new JMenu("File"); // 각 메뉴 객체 생성합니다
		JMenu connect = new JMenu("Connect");
		JMenu option = new JMenu("Option");
		JMenu about = new JMenu("About");

		JMenuItem subadd = new JMenuItem("Add"); // 서브메뉴를 위한 JmenuItem 객체 생성
		JMenuItem subexit = new JMenuItem("Exit"); // 서브메뉴를 위한 JmenuItem 객체 생성
		JMenuItem subconnect = new JMenuItem("Connect");
		JMenuItem subdisconnect = new JMenuItem("DisConnect");
		JMenuItem subsetting  = new JMenuItem("Settings");
		JMenuItem subabout = new JMenuItem("About..");
		JCheckBox subcheck = new JCheckBox("Now Monitoring");
		
		file.add(subadd);
		file.add(subexit); //서브메뉴를 메뉴에 추가
		connect.add(subconnect);
		connect.add(subdisconnect);
		option.add(subcheck); // true 해야되는데 흉물임-_- 젠장
		option.add(subsetting);
		about.add(subabout);
		
		
		
		
		setSize(500,350); // 전체 프레임 지정
		setTitle("Gesitoring"); //
		jmb.add(file); // 메뉴바에 항목들 넣기
		jmb.add(connect);
		jmb.add(option);
		jmb.add(about);
		setJMenuBar(jmb);
//삭제해도되나봐 setVisible(true);
		
		JPanel panel2 = new JPanel(); /** 혹시몰라서 추가*/
		panel2.setLayout(new BorderLayout());
		c.add(panel2);
		
		//이제 아래 부터는 테이블 입니다요
		String[] colHeads = {"이 름","URL","감시주기","새 글","감시중"};
		Object[][] data ={
				{"ㅋㅎㅎㅋㅎ","www.ppp.ccc","10","없음","감시중"}
				,{"니니215125125125","w.w.w","60","있음","감시중"}
				,{"니니","w.w.w","360","있음","감시중"}
				,{"니니","w.w.w","1","있음","감시중"}
				,{"니니","w.w.w","3","있음","감시중"}
				,{"니니","w.w.w","1","있음","감시중"}
				,{"니니","w.w.w","60","있음","감시중"}
				,{"니니","w.w.w","3","있음","감시중"}
		};
		
		//진짜모르겠음이건-_-
//		table = new JTable(data, colHeads){ //셀내용 못고치게.
//			public boolean isCellEditable(int row, int col) { // 셀 내용 못고치게.
//				return false; //셀 내용 못고치게 ㅠ.ㅠ
//			}
//		};
		
		dtm = new DefaultTableModel(data, colHeads){ //셀내용 못고치게.
			public boolean isCellEditable(int row, int col) { // 셀 내용 못고치게.
				return false; //셀 내용 못고치게 ㅠ.ㅠ
			}
		};
		table = new JTable(dtm);
		

		//tablee.addMouseListener(); //TODO:테이블에 마우스리스너 추가해야함
		
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(table , v, h);
		panel2.add(jsp,BorderLayout.CENTER);

		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//<최소화 입니다>hideonclose 해야댐?
		//DO_NOTHING_ON_CLOSE 종료 안됨ㅋㅋㅋㅋㅋ/
		this.setName("mainFrame");
		
		table.addMouseListener(this); // 테이블도 마우스 클릭하는거 듣게 한당ㅋ.ㅋ
		subadd.addActionListener(this);
		subexit.addActionListener(this); //서브메뉴에 리스너 등록
		subconnect.addActionListener(this); //서브메뉴에 리스너 등록
		subdisconnect.addActionListener(this); //서브메뉴에 리스너 등록
		subsetting.addActionListener(this); //서브메뉴에 리스너 등록
		subabout.addActionListener(this); //서브메뉴에 리스너 등록
		subcheck.addActionListener(this); //서브메뉴에 리스너 등록

		
		setVisible(true);
		System.out.println(this.getName() + ":load complete");
		
		
		
		
	}
	class About extends JFrame{ // 어바웃 눌렀을대 뜨는 클래스예염
		public About()
		{
			JLabel p = new JLabel();
			p =  new JLabel(new ImageIcon("어바웃.jpg"));	// 어바웃에 대한 이미지아이콘 객체
			Container ct = getContentPane();
			p.setLayout(new GridLayout());
			ct.add(p,BorderLayout.CENTER);
			setTitle("ABOUT!");
			setSize(150,150);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 최소화 ㅠㅠ
			setVisible(true);
		}
	}
//	BufferedWriter bw = new BufferedWriter(new FileWriter(modFile));

	
//마우스더블클릭왜안되냠씨발이런으 ㅡ아아아다안되미친거같네


	
		
	public void actionPerformed(ActionEvent event){
		 String actionString = event.getActionCommand();
		    if(actionString.equals("Exit")) {
		        System.exit(0);
		    }
		    if(actionString.equals("Settings")){
		    	new Options();
		    }
		    if(actionString.equals("About..")){
		    	new About();
		    }
		    if(actionString.equals("Add")){
		    	System.out.println("send to siteinput : \"\",\"\",0");
		    	new Siteinput("","",0);
		    }
		   
	}

	public void mouseClicked(MouseEvent event){
		System.out.println("click invoked");
		if (event.getComponent() == table) {
			if (event.getClickCount() == 2) { // 더블클릭하면
				System.out.println("dblclick invoke");
				TableModel tm = table.getModel(); // 이건 모냐???? ㅋㅋㅋㅋㅋㅋ
				Point pt = event.getPoint();
				int i = table.rowAtPoint(pt); //행번호
				System.out.println("send to siteinput :" + table.getValueAt(i, 0).toString() + ", " 
						+ table.getValueAt(i, 1).toString() + ", " + Integer.parseInt(table.getValueAt(i, 2).toString()));
					
				new Siteinput(table.getValueAt(i, 0).toString(), table.getValueAt(i, 1).toString(), 
						Integer.parseInt(table.getValueAt(i, 2).toString())); //앞부터 이름, url, cycle
				
			}
		}
	}
	public void mouseReleased(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	
}


public class GClient{  
	public static void main(String[] args){
		 new GClientWindow();
	}		
}
