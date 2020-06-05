/* �{���d��: Ch12_3_3a.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_3_3a extends JFrame
                       implements ActionListener {
   private JLabel lbl;
   private JComboBox<String> jcb;
   public Ch12_3_3a() {    // �غc�l
      super("JComboBox����d��-�i�s��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      String[] items = { "�ϥβ{��", "�ϥΫH�Υd",
                         "������b", "�ϥΤ䲼"};
      jcb = new JComboBox<>(items);
      jcb.setEditable(true);
      jcb.setSelectedIndex(3); // ���w�w�]���
      JButton btn1 = new JButton("���");
      btn1.addActionListener(this); // ���U�ƥ�B�z
      lbl = new JLabel(items[3]);
      c.add(jcb);  c.add(btn1);  c.add(lbl);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      String name = (String) jcb.getSelectedItem();
      lbl.setText(name);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_3_3a app = new Ch12_3_3a();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}