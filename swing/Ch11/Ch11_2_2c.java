/* �{���d��: Ch11_2_2c.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_2_2c extends JFrame
                     implements ActionListener {
   JLabel label;  // �ŧiSwing�����ܼ�
   JPanel jpane;
   public Ch11_2_2c() {    // �غc�l
      super("��ܹ�ܤ��");
      JButton button;   // �ŧiJButton�����ܼ�
      Container c = getContentPane();
      jpane = new JPanel(); // �إ�JPanel����
      label = new JLabel("���չ�ܤ��");
      jpane.add(label);
      button = new JButton("showOptionDialog���s");
      button.addActionListener(this);
      jpane.add(button);
      c.add(jpane);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      Object[] options = {"showMessageDialog���s",
                          "showConfirmDialog���s"};
      int m = JOptionPane.showOptionDialog(jpane,
               "���@�ӫ��s���ĵ�i�T��?",
               "�ާ@���D", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE, null,
               options, options[0]);
      switch (m) {  // ��ܿ��
         case JOptionPane.YES_OPTION:
              label.setText("��showMessageDialog���s");
              break;
         case JOptionPane.NO_OPTION:
              label.setText("��showConfirmDialog���s");
              break;
         default:
              label.setText("�S�����");
      }
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_2_2c app = new Ch11_2_2c();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300, 100); // �]�w�ؤo
      app.setVisible(true);  // ��ܵ���
   }
}