/* �{���d��: Ch12_3_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_3_4 extends JFrame
                      implements ActionListener {
   private JList<String> nList, cList;
   private JLabel lbl;
   public Ch12_3_4() {  // �غc�l
      super("JList����d��");
      String[] names = {"���|�w", "���p��",
                        "�p�s�k", "������"};
      String[] items = {"�{���y��", "�p�������",
                        "��Ʈw�t��", "�����]�p"};
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      nList = new JList<>(names);  // �إ߳�諸JList����
      nList.setVisibleRowCount(1); // ���1�ӿﶵ
      nList.setSelectionMode(
               ListSelectionModel.SINGLE_SELECTION);
      JScrollPane scroll1 = new JScrollPane(nList);
      cList = new JList<>(items);  // �ƿ諸JList����
      cList.setVisibleRowCount(3); // ���3�ӿﶵ
      JScrollPane scroll2 = new JScrollPane(cList);
      JButton btn1 = new JButton("���");
      btn1.addActionListener(this); // ���U�ƥ�B�z
      lbl = new JLabel("��ܵ��G");
      c.add(scroll1);  c.add(scroll2);
      c.add(btn1);     c.add(lbl);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
       String str = "";
       if ( nList.getSelectedIndex() != -1 ) // �B�z���
          str = nList.getSelectedValue();
       if ( !cList.isSelectionEmpty() ) { // �B�z�ƿ�
          str = "";
          for (String item:cList.getSelectedValuesList())
             str = str + item + " ";
       }
       lbl.setText(str);  // ��ܿ�ܪ��ﶵ
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_3_4 app = new Ch12_3_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}