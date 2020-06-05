/* �{���d��: Ch13_5_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ItemListener����
public class Ch13_5_2 extends JFrame
                      implements ItemListener {
   private Container c;
   private JCheckBox gBox;
   private JRadioButton rdb1, rdb2;
   public Ch13_5_2() {   // �غc�l
      super("ItemEvent�ƥ�B�z");
      c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.green);
      gBox = new JCheckBox("���");
      gBox.setSelected(true);
      gBox.addItemListener(this);  // ���U�ƥ�B�z
      ButtonGroup buttonGroup = new ButtonGroup();
      rdb1 = new JRadioButton("����");
      rdb1.setSelected(true);  // �w��
      rdb1.addItemListener(this);  // ���U�ƥ�B�z
      buttonGroup.add(rdb1);
      rdb2 = new JRadioButton("�Ŧ�");
      rdb2.addItemListener(this);  // ���U�ƥ�B�z
      buttonGroup.add(rdb2);
      c.add(rdb1);  c.add(rdb2);  c.add(gBox);
   }
   // ��@�ƥ�B�z��k
   public void itemStateChanged(ItemEvent evt) {
      if (evt.getSource() == gBox)
         if (evt.getStateChange() == ItemEvent.SELECTED)
            c.setBackground(Color.green);
         else  c.setBackground(Color.white);
      if (evt.getSource() == rdb1)
         c.setBackground(Color.red);
      if (evt.getSource() == rdb2)
         c.setBackground(Color.blue);
      repaint();  // ��ø
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch13_5_2 app = new Ch13_5_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}