/* �{���d��: Ch13_5_3.java */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch13_5_3 extends JFrame {
   private JList<String> nList;
   private JLabel lbl;
   public Ch13_5_3() {   // �غc�l
      super("ListSelectionEvent�ƥ�B�z�d��");
      String[] names = {"���|�w", "���p��",
                        "�p�s�k", "������"};
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      nList = new JList<>(names);  // �إ߳��JList����
      nList.setVisibleRowCount(3); // ���3�ӿﶵ
      nList.setSelectionMode(
               ListSelectionModel.SINGLE_SELECTION);
      nList.addListSelectionListener(  // ���U�ƥ�B�z
                     new ListSelectionListener() {
         public void valueChanged(
                         ListSelectionEvent evt) {
           if (evt.getValueIsAdjusting() == false)
               if ( nList.getSelectedIndex() != -1 ) {
                  String name =
                    nList.getSelectedValue().toString();
                  lbl.setText(name);
               }
         } });
      JScrollPane scroll1 = new JScrollPane(nList);
      lbl = new JLabel("��ܵ��G");
      c.add(scroll1);  c.add(lbl);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch13_5_3 app = new Ch13_5_3();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,120);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}