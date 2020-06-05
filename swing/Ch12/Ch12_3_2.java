/* �{���d��: Ch12_3_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_3_2 extends JFrame
                      implements ActionListener {
   private JRadioButton rdb1, rdb2;
   private JLabel lbl;
   public Ch12_3_2() {  // �غc�l
      super("JRadioButton����d��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      lbl = new JLabel(new ImageIcon("tiger.jpg"));
      // �@�տﶵ�s
      ButtonGroup buttonGroup = new ButtonGroup();
      rdb1 = new JRadioButton("�Ѫ�(T)");
      rdb1.setMnemonic(KeyEvent.VK_T);
      rdb1.setSelected(true);  // �w��
      buttonGroup.add(rdb1);
      rdb2 = new JRadioButton("�ѹ�(M)");
      rdb2.setMnemonic(KeyEvent.VK_M);
      buttonGroup.add(rdb2);
      JButton btn1 = new JButton("���");
      btn1.addActionListener(this); // ���U�ƥ�B�z
      JPanel jpane = new JPanel(); // �إ�JPanel����
      jpane.add(rdb1); jpane.add(rdb2); jpane.add(lbl);
      c.add(jpane);    c.add(btn1);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      if ( rdb1.isSelected() ) // ����
         lbl.setIcon(new ImageIcon("/tiger.jpg"));
      if ( rdb2.isSelected() )
         lbl.setIcon(new ImageIcon("/mouse.jpg"));
      repaint();  // ��ø
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_3_2 app = new Ch12_3_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(350,250);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}