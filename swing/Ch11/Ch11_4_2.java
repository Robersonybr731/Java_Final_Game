/* �{���d��: Ch11_4_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_4_2 extends JFrame {
   public Ch11_4_2() {    // �غc�l
      super("FlowLayout�����t�m");
      Container c = getContentPane();
      c.setLayout(new FlowLayout(FlowLayout.LEFT,3,3));
      c.add(new JButton("���s�@"));
      c.add(new JButton("���s�G"));
      c.add(new JButton("���s�T"));
      c.add(new JButton("���s�|"));
      c.add(new JButton("���s��"));
      c.add(new JButton("���s��"));
      c.add(new JButton("���s�C"));
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_4_2 app = new Ch11_4_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}