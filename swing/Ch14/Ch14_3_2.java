/* �{���d��: Ch14_3_2.java */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.*;
// �~��JFrame���O
public class Ch14_3_2 extends JFrame {
   public Ch14_3_2() {   // �غc�l
      super("JColorChooser����d��");
      final Container c = getContentPane();
      c.setBackground(Color.white); // �I�����զ�
      // �إ�JColorChooser()����
      final JColorChooser jcc = new JColorChooser();
      JButton button = new JButton("��ܭI����m");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Color newColor;
            newColor = jcc.showDialog(Ch14_3_2.this,
                     "��ܭI����m", c.getBackground());
            if ( newColor != null )
               c.setBackground(newColor);
         } });
      c.add(new JLabel(), BorderLayout.CENTER);
      c.add(button, BorderLayout.SOUTH);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch14_3_2 app = new Ch14_3_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}