import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Options extends JFrame implements ActionListener{
	public JTextField jtf;
	
	public Options(){
		
		Container ct = getContentPane(); 		
		ct.setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel(); //ù��° ����̿�
		JPanel jp2 = new JPanel(); // �ι��� ��� �߰��Դϴ�
		JPanel jp3 = new JPanel();
		JButton oo = new JButton("Ȯ��"); // Ȯ�ι�ư OO
		JButton no = new JButton("���"); // ��ҹ�ư NO


		jtf = new JTextField(10); // 10���� ���ڸ� ������ jTexField ��ü ���� 
		JComboBox timeset = new JComboBox(); // �޺��ڽ� ��ü ����
		timeset.addItem("3��"); // �޺� �ڽ��� ������ �߰�
		timeset.addItem("10000��");// �޺��ڽ��� ������ �߰�		
		jp1.setLayout(new GridLayout(1,3)); //1�� 3�� �г��Ӵϴ�
		jtf.addActionListener(this);// ����Ʈ�ʵ尴ü�� �̺�Ʈ ������ ��Ϥ�		
		jp1.add(new JLabel("�˻��ֱ�" , Label.RIGHT));  // JLabel �̿� �۾����m
		jp1.add(timeset);	// �гο� �޺��ڽ� �߰�
//		jc.ItemListener(this); // �޺��ڽ��� �̺�Ʈ������ ���
		// p.550�ʿ��� ��_�� ����ؾߵ�  class JPaneal extends JFrame implements ActionListener{
// ��ſ� itemlisntereawfnawf �־��µ� ��ȣ�� �۵����ϴ�?
		
		jp2.setLayout(new GridLayout(2,1));
		jp2.add(new JCheckBox("�˾��˸����",true)); // true �ϸ� üũ�� �Ǽ� ���ɴϴ�.
		jp2.add(new JLabel(" �˾� ���� �ð� :"));  // JLabel �̿� �۾����m
		jtf = new JTextField(10); // 10���� ���ڸ� ������ jTexField ��ü ����
		jp2.add(jtf); // ���� �Է� �˾����ӽð��� �߰� �Ұ���
		jtf.addActionListener(this); // �ؽ�Ʈ�ʵ尴ü�� ��°��ε�??
		
		jp2.add(new JCheckBox("�Ҹ��˶����",true));

		jp3.setLayout(new GridLayout(1,2));
		jp3.add(oo); //Ȯ�ι�ư OO �߰�
		jp3.add(no); //��ҹ�ư NO �߰�
		
		oo.addActionListener(this);
		no.addActionListener(this);
		
		ct.add(jp1,BorderLayout.NORTH);
		ct.add(jp2,BorderLayout.CENTER);
		ct.add(jp3,BorderLayout.SOUTH);

		setTitle("OPTION");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // �ּ�ȭ�ǰԲ�;;
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent event){  // �ƿ���ħ��..
//		jtf.setText(" ");

		if (event.getActionCommand().equals("���")) //��Ҹ� �Է��ϴϱ� ������;;
		{
			//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // �ּ�ȭ�ǰԲ�;;
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