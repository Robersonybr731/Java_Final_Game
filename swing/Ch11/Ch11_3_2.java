/* �{���d��: Ch11_3_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_3_2 extends JFrame {
   public Ch11_3_2() {  // �غc�l
      super("JScrollPane�����e���d��");
      Container c = getContentPane();
      JTextArea area = new
                JTextArea("�ǳƿ�J���...\n", 15, 30);
      JScrollPane scroll = new JScrollPane(area);
      scroll.setPreferredSize(new Dimension(250, 100));
      scroll.setMinimumSize(new Dimension(250,100));
      scroll.setAlignmentX(LEFT_ALIGNMENT);
      c.add(scroll, BorderLayout.CENTER); // �s�W�b����
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_3_2 app = new Ch11_3_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}