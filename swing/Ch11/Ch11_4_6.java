/* �{���d��: Ch11_4_6.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_4_6 extends JFrame {
   public Ch11_4_6() {    // �غc�l
      super("BoxLayout�����t�m");
      Container c = getContentPane();
      JPanel jpane1 = new JPanel(); // �Ĥ@��JPanel
      BoxLayout bl1, bl2;
      bl1 = new BoxLayout(jpane1, BoxLayout.Y_AXIS);
      jpane1.setLayout(bl1); // �]�w�e���w�]�������t�m
      JLabel label = new JLabel("�a�}:");
      jpane1.add(label);
      jpane1.add(
      	     Box.createRigidArea(new Dimension(2,5)));
      JTextArea area = new
             JTextArea("�ǳƿ�J���...\n", 15, 30);
      JScrollPane scroll = new JScrollPane(area);
      scroll.setAlignmentX(LEFT_ALIGNMENT);
      jpane1.add(scroll);
      JPanel jpane2 = new JPanel(); //  �ĤG��JPanel
      bl2 = new BoxLayout(jpane2, BoxLayout.X_AXIS);
      jpane2.setLayout(bl2); // �]�w�e���w�]�����t�m
      JButton button1 = new JButton("�x�s");
      jpane2.add(button1);
      jpane2.add(Box.createHorizontalGlue());
      JButton button2 = new JButton("�ƻs");
      jpane2.add(button2);
      jpane2.add(
      	     Box.createRigidArea(new Dimension(20,5)));
      JButton button3 = new JButton("�K�W");
      jpane2.add(button3);
      c.add(jpane1, BorderLayout.CENTER);
      c.add(jpane2, BorderLayout.SOUTH);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_4_6 app = new Ch11_4_6();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}