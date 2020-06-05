/* �{���d��: Ch13_5_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch13_5_4 extends JFrame {
   private JScrollBar scroll;
   private JLabel lbl;
   public Ch13_5_4() {  // �غc�l
      super("AdjustmentEvent�ƥ�B�z");
      Container c = getContentPane();
      c.setLayout(new BorderLayout());
      lbl = new JLabel("50");
      c.add(lbl, BorderLayout.SOUTH);
      scroll = new JScrollBar(
               JScrollBar.HORIZONTAL,50,10,0,100);
      // ���U�ƥ�B�z
      scroll.addAdjustmentListener(
                          new AdjustmentListener() {
         public void adjustmentValueChanged(
                             AdjustmentEvent evt) {
            JScrollBar s = (JScrollBar)evt.getSource();
            if ( !s.getValueIsAdjusting() ) {
               int v = (int)s.getValue();
               lbl.setText(Integer.toString(v));
            }
         } });
      c.add(scroll, BorderLayout.NORTH);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch13_5_4 app = new Ch13_5_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}