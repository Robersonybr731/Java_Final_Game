/* �{���d��: Ch12_3_3.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_3_3 extends JFrame
                       implements ActionListener {
   private JLabel lbl;
   private JComboBox<String> jcb;
   public Ch12_3_3() {   // �غc�l
      super("JComboBox����d��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      String[] items = { "�T����", "������",
                         "�C����", "����"};
      jcb = new JComboBox<>(items);
      jcb.setSelectedIndex(3); // ���w�w�]���
      JButton btn1 = new JButton("���");
      btn1.addActionListener(this); // ���U�ƥ�B�z
      lbl = new JLabel(items[3]);
      c.add(jcb);  c.add(btn1);  c.add(lbl);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      String name = (String)jcb.getSelectedItem();
      lbl.setText(name);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_3_3 app = new Ch12_3_3();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}