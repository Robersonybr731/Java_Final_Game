/* �{���d��: Ch12_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_2 extends JFrame
                    implements ActionListener {
   private JButton btn1, btn2;
   private JLabel lbl;
   public Ch12_2() { // �غc�l
      super("JButton�PJLabel����d��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      lbl = new JLabel("����");
      JLabel lbl1 =new JLabel(new ImageIcon("tree.jpg"));
      btn1 = new JButton("�}��(S)");
      btn1.setMnemonic(KeyEvent.VK_S);  // �]�w����
      btn1.addActionListener(this); // ���U�ƥ�B�z
      btn2 = new JButton(new ImageIcon("blue.gif"));
      btn2.setToolTipText("����");  // ������r
      btn2.addActionListener(this); // ���U�ƥ�B�z
      JPanel jpane = new JPanel(); // �إ�JPanel����
      jpane.add(lbl1);   jpane.add(lbl);
      jpane.add(btn1);  jpane.add(btn2);
      c.add(jpane);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      // �P�_�ƥ�ӷ�������
      if (evt.getSource() == btn1) lbl.setText("�}��");
      if (evt.getSource() == btn2) lbl.setText("����");
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_2 app = new Ch12_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}