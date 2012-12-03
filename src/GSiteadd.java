import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class Siteinput extends JFrame implements ActionListener{
	public Siteinput(String name, String url, int refreshCycle){
		JTextField nametext = new JTextField(); // ���� �Է� �ϴ� ���� ����
		nametext.setText(name);
		JTextField urltext = new JTextField(); // ���� �Է� �ϴ� ���� ����
		urltext.setText(url);
		
		JButton okB = new JButton("Ȯ��"); // ��ư 2�� ���� 
		JButton deleteB = new JButton("����");
		
		JPanel jp1 = new JPanel(); //ù��° ����̿�
		JPanel jp2 = new JPanel(); //en��° ����̿�
		JPanel jp3 = new JPanel(); //tp��° ����̿�
		
		JComboBox jc = new JComboBox(); // �޺��ڽ� ��ü ����
		jc.addItem("�⺻ ������ ����");
		jc.addItem("1��"); // �޺� �ڽ��� ������ �߰�
		jc.addItem("3��");// �޺��ڽ��� ������ �߰�	
		jc.addItem("10��");
		jc.addItem("30��");
		jc.addItem("1�ð�");
		jc.addItem("6�ð�");
		
		switch(refreshCycle) {
		case 0: jc.setSelectedItem("�⺻ ������ ����"); break; 
		case 1: jc.setSelectedItem("1��"); break;
		case 3: jc.setSelectedItem("3��"); break;
		case 10: jc.setSelectedItem("10��"); break;
		case 30: jc.setSelectedItem("30��"); break;
		case 60: jc.setSelectedItem("1�ð�"); break;
		case 360: jc.setSelectedItem("6�ð�"); break;
		default: System.out.println("combobox ���� err ���� cycle�� �Էµ�");
		}
		
		JLabel nameL = new JLabel("�̸�"); // ���� ǥ�� �� ����
		JLabel settingL = new JLabel("�˻��ֱ�"); // ���� ǥ�� �� ����
		JLabel urlL = new JLabel("URL");  // ���� ǥ�� �� ����
		
		
		okB.addActionListener(this); // �߰� ��ư ������ ��´�
		deleteB.addActionListener(this); // ���� ��ư ������ ��´�
		jc.addActionListener(this); // �޺��ڽ� ��ư ������ ��´�
		urltext.addActionListener(this); // url �Է��ϸ� ��
		nametext.addActionListener(this); // �̸� �Է��ϸ� ��
//		readName.addActionListener(this);


		Container ct = getContentPane(); // �����̳� 
		ct.setLayout(new BorderLayout());

		jp1.setLayout(new GridLayout(1,4));	
		jp1.add(nameL); // �̸�
		jp1.add(nametext); // �̸��Է� â
		jp1.add(settingL); // �˻��ֱ�
		jp1.add(jc);	// �гο� �޺��ڽ� �߰�

		jp2.setLayout(new GridLayout(1,2));
		jp2.add(urlL); // url 
		jp2.add(urltext); // url �Է�â
		
		
		jp3.setLayout(new GridLayout(1,3));
		jp3.add(okB); // Ȯ�� ��Ʈ �߰�
		jp3.add(deleteB); // ���� ��ư �߰�
		
		
		ct.add(jp1,BorderLayout.NORTH);
		ct.add(jp2,BorderLayout.CENTER);
		ct.add(jp3,BorderLayout.SOUTH);
		setTitle("����Ʈ �Է�");
		setSize(400,125);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // �ּ�ȭ �ǰԲ��Դϴ�.
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
//		nametext.setText(" ");
//		urltext.setText(" "); // �� ������ �ߴ°�!!!!!
	/**	if(event.getActionCommand().equals("Ȯ��")){
			// �̸��̳� ����б�, �г��� �ٲ� ���
			if(!nametext.getText().equals(oriName) ||
					!readScl.getText().equals(oriScl) ||
					!readGrd.getText().equals(oriGrd))
			{
				try{
					// ������ ������ ���� Ŭ����
					File modFile = new File
						(readName.getText() + "_" + readScl.getText() + "_" + readGrd.getText() + "_.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(modFile));
					// ������ ������ ���� ���� (������ �̸��� �ٲ�)
					bw.write(readName.getText() + "|" + readScl.getText() + "|" + readGrd.getText() + "|" 
						+ readAdr.getText() + "|" + readTel.getText() + "|" + readPrt.getText() + "|" 
						+ readPTel.getText() + "|" + readAct.getText());
					
					// �̸�(�Ǵ� ����б�, �г�)�� �ٲ�� ���� ���� ����
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
			
			
			String msg = "������ �Ϸ�Ǿ����ϴ�";
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
