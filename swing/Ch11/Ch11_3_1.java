/* �{���d��: Ch11_3_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_3_1 extends JFrame {
   public Ch11_3_1() {   // �غc�l
      super("JPanel�����e���d��");
      Container c = getContentPane();
      JPanel jpane1 = new JPanel(); // �إ�JPanel����
      jpane1.add(new JButton("�����s"));
      JPanel jpane2 = new JPanel(); // �إ�JPanel����
      jpane2.add(new JLabel("�k����"));
      c.add(jpane1, BorderLayout.WEST); // �s�W�b���
      c.add(jpane2, BorderLayout.EAST); // �s�W�b�F��
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_3_1 app = new Ch11_3_1();
   	  app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}