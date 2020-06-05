/* �{���d��: Ch12_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch12_4 extends JFrame
                    implements ActionListener {
   private JScrollBar scroll;
   private JSlider slider;
   private JLabel lbl;
   public Ch12_4() {  // �غc�l
      super("JSlider�PJScrollBar����d��");
      Container c = getContentPane();
      c.setLayout(new BorderLayout());
      lbl = new JLabel("0/0");
      c.add(lbl, BorderLayout.CENTER);
      slider = new JSlider(JSlider.VERTICAL,0,100,50);
      slider.setPaintTicks(true);
      slider.setMinorTickSpacing(5);
      c.add(slider, BorderLayout.WEST);
      scroll = new JScrollBar(
               JScrollBar.HORIZONTAL,50,10,0,100);
      c.add(scroll, BorderLayout.NORTH);
      JButton btn1 = new JButton("���");
      btn1.addActionListener(this); // ���U�ƥ�B�z
      c.add(btn1, BorderLayout.SOUTH);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      int v1 = 0, v2 = 0;
      if ( !scroll.getValueIsAdjusting() )
         v1 = (int)scroll.getValue();
      if ( !slider.getValueIsAdjusting() )
         v2 = (int)slider.getValue();
      lbl.setText(Integer.toString(v1) + "/" +
                  Integer.toString(v2) );
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_4 app = new Ch12_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}