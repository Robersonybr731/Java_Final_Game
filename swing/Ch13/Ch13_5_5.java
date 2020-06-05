/* �{���d��: Ch13_5_5.java */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch13_5_5 extends JFrame {
   private JSlider slider;
   private JLabel lbl;
   public Ch13_5_5() {   // �غc�l
      super("ChangeEvent�ƥ�B�z�d��");
      Container c = getContentPane();
      c.setLayout(new BorderLayout());
      lbl = new JLabel("50");
      c.add(lbl, BorderLayout.CENTER);
      slider = new JSlider(JSlider.VERTICAL,0,100,50);
      slider.setPaintTicks(true);
      slider.setMinorTickSpacing(5);
      // ���U�ƥ�B�z
      slider.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent evt) {
            JSlider s = (JSlider)evt.getSource();
            if ( !s.getValueIsAdjusting() ) {
               int v = (int)s.getValue();
               lbl.setText(Integer.toString(v));
            }
         } });
      c.add(slider, BorderLayout.WEST);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch13_5_5 app = new Ch13_5_5();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}