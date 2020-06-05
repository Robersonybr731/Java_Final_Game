/* �{���d��: Ch13_2_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �ϥ�Windows Event��ť�̪�JFrame
class NewWindow extends JFrame
                implements WindowListener {
   public NewWindow(String title) {  // �غc�l
      super(title);
      Container c = getContentPane();
      c.add(new JLabel("Windows Event��ť��"));
      addWindowListener(this); // ���U�ƥ�B�z
      setSize(200,100);   setVisible(false);
   }
   // ��@�ƥ�B�z��k
   public void windowClosing(WindowEvent evt) {
      setVisible(false); }
   public void windowClosed(WindowEvent evt) { }
   public void windowOpened(WindowEvent evt) { }
   public void windowIconified(WindowEvent evt) { }
   public void windowDeiconified(WindowEvent evt) { }
   public void windowActivated(WindowEvent evt) { }
   public void windowDeactivated(WindowEvent evt) { }
}
// Swing���ε{�����O
public class Ch13_2_2 extends JFrame {
   // �إ�NewWindow��������
   NewWindow win = new NewWindow("JFrame�s����");
   public Ch13_2_2() {   // �غc�l
      super("WindowEvent�d��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      JButton button = new JButton("�}�ҵ���");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            win.setVisible(true); // ��ܵ���
         } });
      c.add(new JLabel("WindowAdapter��s��"));
      c.add(button);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch13_2_2 app = new Ch13_2_2();
      app.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt)
         { System.exit(0); } });
      app.setSize(300,100);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}