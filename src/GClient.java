import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;


/*
class FirstWindow extends JFrame implements ActionListener{ //�Ƴ��̰Ը���
	public FirstWindow(){

		JTextField tf1 = new JTextField();
		Container ct = getContentPane();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2,1));
		JButton bt1 = new JButton("Ȯ��");
		jp1.add(tf1);
		jp1.add(bt1);
		Frame.setLayout(new GridLayout());
		ct.add(Frame,BorderLayout.CENTER);
		setTitle("�����Ǹ� �Է� �� �ðԳ�!");
		setSize(150,150);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae){
			 String actionString = ae.getActionCommand();
			    if(actionString.equals("Ȯ��")) {
					 new GClientWindow();
			    }
		}
	}
*/ //����ϴ��� ������..

class GClientWindow extends JFrame implements ActionListener,MouseListener
{ // �̺�Ʈ ó�� ���� ����������
	JTextField jtf;
	static JTable table;// �������� �߰��س��
	static DefaultTableModel dtm;//
	static JScrollPane jsp;//
	
	public GClientWindow(){

		JFrame Frame = new JFrame("��");
		String msg = ";;";
		JOptionPane.showMessageDialog(Frame, msg);
	
		Container c = getContentPane();

		
		//������������ �޴��� �޴��� �޴���
		c.setLayout(new BorderLayout());
		JMenuBar jmb = new JMenuBar(); // �޴��� ��ü ����
		JMenu file = new JMenu("File"); // �� �޴� ��ü �����մϴ�
		JMenu connect = new JMenu("Connect");
		JMenu option = new JMenu("Option");
		JMenu about = new JMenu("About");

		JMenuItem subadd = new JMenuItem("Add"); // ����޴��� ���� JmenuItem ��ü ����
		JMenuItem subexit = new JMenuItem("Exit"); // ����޴��� ���� JmenuItem ��ü ����
		JMenuItem subconnect = new JMenuItem("Connect");
		JMenuItem subdisconnect = new JMenuItem("DisConnect");
		JMenuItem subsetting  = new JMenuItem("Settings");
		JMenuItem subabout = new JMenuItem("About..");
		JCheckBox subcheck = new JCheckBox("Now Monitoring");
		
		file.add(subadd);
		file.add(subexit); //����޴��� �޴��� �߰�
		connect.add(subconnect);
		connect.add(subdisconnect);
		option.add(subcheck); // true �ؾߵǴµ� �买��-_- ����
		option.add(subsetting);
		about.add(subabout);
		
		
		
		
		setSize(500,350); // ��ü ������ ����
		setTitle("Gesitoring"); //
		jmb.add(file); // �޴��ٿ� �׸�� �ֱ�
		jmb.add(connect);
		jmb.add(option);
		jmb.add(about);
		setJMenuBar(jmb);
//�����ص��ǳ��� setVisible(true);
		
		JPanel panel2 = new JPanel(); /** Ȥ�ø��� �߰�*/
		panel2.setLayout(new BorderLayout());
		c.add(panel2);
		
		//���� �Ʒ� ���ʹ� ���̺� �Դϴٿ�
		String[] colHeads = {"�� ��","URL","�����ֱ�","�� ��","������"};
		Object[][] data ={
				{"����������","www.ppp.ccc","10","����","������"}
				,{"�ϴ�215125125125","w.w.w","60","����","������"}
				,{"�ϴ�","w.w.w","360","����","������"}
				,{"�ϴ�","w.w.w","1","����","������"}
				,{"�ϴ�","w.w.w","3","����","������"}
				,{"�ϴ�","w.w.w","1","����","������"}
				,{"�ϴ�","w.w.w","60","����","������"}
				,{"�ϴ�","w.w.w","3","����","������"}
		};
		
		//��¥�𸣰����̰�-_-
//		table = new JTable(data, colHeads){ //������ ����ġ��.
//			public boolean isCellEditable(int row, int col) { // �� ���� ����ġ��.
//				return false; //�� ���� ����ġ�� ��.��
//			}
//		};
		
		dtm = new DefaultTableModel(data, colHeads){ //������ ����ġ��.
			public boolean isCellEditable(int row, int col) { // �� ���� ����ġ��.
				return false; //�� ���� ����ġ�� ��.��
			}
		};
		table = new JTable(dtm);
		

		//tablee.addMouseListener(); //TODO:���̺� ���콺������ �߰��ؾ���
		
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(table , v, h);
		panel2.add(jsp,BorderLayout.CENTER);

		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//<�ּ�ȭ �Դϴ�>hideonclose �ؾߴ�?
		//DO_NOTHING_ON_CLOSE ���� �ȵʤ���������/
		this.setName("mainFrame");
		
		table.addMouseListener(this); // ���̺� ���콺 Ŭ���ϴ°� ��� �Ѵ礻.��
		subadd.addActionListener(this);
		subexit.addActionListener(this); //����޴��� ������ ���
		subconnect.addActionListener(this); //����޴��� ������ ���
		subdisconnect.addActionListener(this); //����޴��� ������ ���
		subsetting.addActionListener(this); //����޴��� ������ ���
		subabout.addActionListener(this); //����޴��� ������ ���
		subcheck.addActionListener(this); //����޴��� ������ ���

		
		setVisible(true);
		System.out.println(this.getName() + ":load complete");
		
		
		
		
	}
	class About extends JFrame{ // ��ٿ� �������� �ߴ� Ŭ��������
		public About()
		{
			JLabel p = new JLabel();
			p =  new JLabel(new ImageIcon("��ٿ�.jpg"));	// ��ٿ��� ���� �̹��������� ��ü
			Container ct = getContentPane();
			p.setLayout(new GridLayout());
			ct.add(p,BorderLayout.CENTER);
			setTitle("ABOUT!");
			setSize(150,150);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // �ּ�ȭ �Ф�
			setVisible(true);
		}
	}
//	BufferedWriter bw = new BufferedWriter(new FileWriter(modFile));

	
//���콺����Ŭ���־ȵǳȾ����̷��� �Ѿƾƾƴپȵǹ�ģ�Ű���


	
		
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
			if (event.getClickCount() == 2) { // ����Ŭ���ϸ�
				System.out.println("dblclick invoke");
				TableModel tm = table.getModel(); // �̰� ���???? ������������
				Point pt = event.getPoint();
				int i = table.rowAtPoint(pt); //���ȣ
				System.out.println("send to siteinput :" + table.getValueAt(i, 0).toString() + ", " 
						+ table.getValueAt(i, 1).toString() + ", " + Integer.parseInt(table.getValueAt(i, 2).toString()));
					
				new Siteinput(table.getValueAt(i, 0).toString(), table.getValueAt(i, 1).toString(), 
						Integer.parseInt(table.getValueAt(i, 2).toString())); //�պ��� �̸�, url, cycle
				
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
