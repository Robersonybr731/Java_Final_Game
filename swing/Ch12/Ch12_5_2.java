/* �{���d��: Ch12_5_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_5_2 extends JFrame
                      implements ActionListener {
   private JLabel lbl;
   private JPasswordField pass;
   public Ch12_5_2() {  // �غc�l
      super ("JPasswordField����d��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      pass = new JPasswordField(12); // �إ߱K�X���
      // �إ߼���
      JLabel pLbl = new JLabel("�ϥΪ̱K�X: ");
      pLbl.setLabelFor(pass);// �ݩ�K�X���
      // ��ܿ�J��r���e������
      lbl = new JLabel("�������J�����");
      JButton btn1 = new JButton("�T�w");
      btn1.addActionListener(this); // ���U�ƥ�B�z
      JPanel jpane = new JPanel(); // �إ�JPanel����
      jpane.add(pLbl); jpane.add(pass); jpane.add(btn1);
      c.add(jpane);    c.add(lbl);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      lbl.setText("��J�K�X : "
                 + new String(pass.getPassword()));
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_5_2 app = new Ch12_5_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}