/* �{���d��: Ch11_4_5.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_4_5 extends JFrame {
   public Ch11_4_5() {    // �غc�l
      super("GridBagLayout�����t�m");
      Container c = getContentPane();
      GridBagLayout gridbag = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      c.setLayout(gridbag); // �]�w�e���w�]�������t�m
      gbc.fill=GridBagConstraints.HORIZONTAL;// �񺡤覡
      JButton button1 = new JButton("���s�@");
      gbc.gridx = 0;  gbc.gridy = 0;  // �ĴX��, �ĴX�C
      gridbag.setConstraints(button1, gbc);
      c.add(button1);
      JButton button2 = new JButton("���s�G");
      gbc.gridx = 1;  gbc.gridy = 0;
      gridbag.setConstraints(button2, gbc);
      c.add(button2);
      JButton button3 = new JButton("���s�T");
      gbc.gridx = 2;  gbc.gridy = 0;
      gridbag.setConstraints(button3, gbc);
      c.add(button3);
      JButton button4 = new JButton("���s�|");
      gbc.ipady = 30;     // �]�w�����ԥR
      gbc.weightx = 0.5;  // �ؤo�ܧ��v��
      gbc.gridwidth = 3;  // �ϥδX��
      gbc.gridx = 0;  gbc.gridy = 1;
      gridbag.setConstraints(button4, gbc);
      c.add(button4);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch11_4_5 app = new Ch11_4_5();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}