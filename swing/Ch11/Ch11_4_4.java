/* �{���d��: Ch11_4_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_4_4 extends JFrame {
   public Ch11_4_4() {     // �غc�l
      super("GridLayout�����t�m");
      Container c = getContentPane();
      c.setLayout(new GridLayout(2,4,4,4));
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
      Ch11_4_4 app = new Ch11_4_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(350,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}