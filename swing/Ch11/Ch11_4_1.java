/* �{���d��: Ch11_4_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_4_1 extends JFrame {
   public Ch11_4_1() {   // �غc�l
      super("BorderLayout�����t�m");
      Container c = getContentPane();
      c.setLayout(new BorderLayout(4,4));
      c.add(new JButton("�_���s"), BorderLayout.NORTH);
      c.add(new JButton("�����s"), BorderLayout.CENTER);
      c.add(new JButton("����s"), BorderLayout.WEST);
      c.add(new JButton("�n���s"), BorderLayout.SOUTH);
      c.add(new JButton("�F���s"), BorderLayout.EAST);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_4_1 app = new Ch11_4_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}