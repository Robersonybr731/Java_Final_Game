/* �{���d��: Ch14_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch14_2 extends JFrame
                    implements ActionListener {
   private JButton blue, yellow, green;
   private Container c;
   public Ch14_2() {    // �غc�l
      super ("JToolBar����d��");
      c = getContentPane();
      c.setBackground(Color.white);
      JToolBar toolBar = new JToolBar();
      blue = new JButton(new ImageIcon("blue1.gif"));
      blue.setToolTipText("�Ŧ�");
      blue.addActionListener(this);
      yellow=new JButton(new ImageIcon("yellow1.gif"));
      yellow.setToolTipText("����");
      yellow.addActionListener(this);
      green = new JButton(new ImageIcon("green1.gif"));
      green.setToolTipText("���");
      green.addActionListener(this);
      toolBar.add(blue);  toolBar.add(yellow);
      toolBar.add(green);
      c.add(toolBar, BorderLayout.NORTH);
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      if ( evt.getSource() == blue )
         c.setBackground(Color.blue);
      if ( evt.getSource() == yellow )
         c.setBackground(Color.yellow);
      if ( evt.getSource() == green )
         c.setBackground(Color.green);
      repaint();  // ��ø
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch14_2 app = new Ch14_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}