/* �{���d��: Ch12_5_3.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_5_3 extends JFrame
                      implements ActionListener {
   private JScrollPane scroll;
   private JTextArea area;
   public Ch12_5_3() {  // �غc�l
      super ("JTextArea����d��");
      Container c = getContentPane();
      area = new JTextArea("���ݿ�J���...\n", 15, 30);
      area.setLineWrap(true);
      area.setFont(new Font("�ө���", Font.ITALIC, 16));
      scroll = new JScrollPane(area);
      JButton btn = new JButton("�e�X���");
      btn.addActionListener(this);   // ���U�ƥ�B�z
      c.add(scroll, BorderLayout.CENTER);
      c.add(btn, BorderLayout.SOUTH);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      JOptionPane.showMessageDialog(scroll,
            area.getText(), "Ch12_5_3",
            JOptionPane.QUESTION_MESSAGE);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_5_3 app = new Ch12_5_3();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}