/* �{���d��: Ch11_2_2b.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_2_2b extends JFrame
                     implements ActionListener {
   JLabel label;   // �ŧiSwing�����ܼ�
   JPanel jpane;
   public Ch11_2_2b() {   // �غc�l
      super("��ܹ�ܤ��");
      JButton button;  // �ŧiJButton�����ܼ�
      Container c = getContentPane();
      jpane = new JPanel(); // �إ�JPanel����
      label = new JLabel("���չ�ܤ��");
      jpane.add(label);
      button = new JButton("showConfirmDialog���s");
      button.addActionListener(this);
      jpane.add(button);
      c.add(jpane);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
       int n = JOptionPane.showConfirmDialog(jpane,
               "�z�O�_�w�g���UshowMessageDialog���s?",
               "�ާ@���D", JOptionPane.YES_NO_OPTION);
       if (n == JOptionPane.YES_OPTION)
          label.setText("���U�O");
       else if (n == JOptionPane.NO_OPTION)
               label.setText("���U�_");
            else
               label.setText("�S�����");
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_2_2b app = new Ch11_2_2b();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300, 100); // �]�w�ؤo
      app.setVisible(true);  // ��ܵ���
   }
}