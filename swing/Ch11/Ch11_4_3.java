/* �{���d��: Ch11_4_3.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch11_4_3 extends JFrame
                     implements ActionListener {
   private int num = 1;  // ��1�i�d��
   JPanel cards;
   public Ch11_4_3() {   // �غc�l
      super("CardLayout�����t�m");
      Container c = getContentPane();
      JButton button = new JButton("�U�@��");
      button.addActionListener(this);
      c.add(button, BorderLayout.NORTH);
      cards = new JPanel();
      cards.setLayout(new CardLayout());
      JPanel jp1 = new JPanel(); // �Ĥ@�եd��
      jp1.add(new JButton("���s�@"));
      jp1.add(new JButton("���s�G"));
      jp1.add(new JButton("���s�T"));
      JPanel jp2 = new JPanel(); // �ĤG�եd��
      jp2.add(new JLabel("���ҥ|"));
      jp2.add(new JLabel("���Ҥ�"));
      cards.add(jp1, "���s�d��");
      cards.add(jp2, "���ҥd��");
      c.add(cards, BorderLayout.SOUTH);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      num++;  // �d���ƥ[�@
      CardLayout cl = (CardLayout)(cards.getLayout());
      if ( num > 2 ) {
         cl.first(cards);
         num = 1;
      } else  cl.next(cards);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_4_3 app = new Ch11_4_3();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}