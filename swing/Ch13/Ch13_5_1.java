/* �{���d��: Ch13_5_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch13_5_1 extends JFrame {
   private JLabel lbl;
   public Ch13_5_1() {   // �غc�l
      super ("ActionEvent�ƥ�B�z�d��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      JTextField txt = new JTextField(12);
      txt.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            JTextField s = (JTextField) evt.getSource();
            lbl.setText(s.getText());
         } });
      String[] items = { "iPod", "iPhone",
                         "iPad", "Mac Air"};
      JComboBox<String> jcb = new JComboBox<>(items);
      jcb.setSelectedIndex(3); // ���w�w�]���
      jcb.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            JComboBox c = (JComboBox) evt.getSource();
            lbl.setText((String) c.getSelectedItem());
         } });
      lbl = new JLabel("��ܿ�J���"); // ��ܵ��G����
      JPanel jpane = new JPanel(); // �إ�JPanel����
      jpane.add(txt); jpane.add(jcb);
      c.add(jpane);   c.add(lbl);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch13_5_1 app = new Ch13_5_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(280,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}