/* �{���d��: Ch11_2_2a.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_2_2a extends JFrame
                      implements ActionListener {
   JLabel label;    // �ŧiSwing�����ܼ�
   JPanel jpane;
   public Ch11_2_2a() {     // �غc�l
      super("��ܹ�ܤ��");
      JButton button;  // �ŧiJButton�����ܼ�
      Container c = getContentPane();
      jpane = new JPanel(); // �إ�JPanel����
      label = new JLabel("���չ�ܤ��");
      jpane.add(label);
      button = new JButton("showMessageDialog���s");
      button.addActionListener(this);
      jpane.add(button);
      c.add(jpane);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      label.setText("���UshowMessageDialog���s");
      JOptionPane.showMessageDialog(jpane,
                  "�@�Ӵ��ժ��T������!",
                  "Ch11_2_2a",
                  JOptionPane.QUESTION_MESSAGE);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_2_2a app = new Ch11_2_2a();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300, 100); // �]�w�ؤo
      app.setVisible(true);  // ��ܵ���
   }
}