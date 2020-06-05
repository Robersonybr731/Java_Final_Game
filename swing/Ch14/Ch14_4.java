/* �{���d��: Ch14_4.java */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// ���h�������O, �~��JInternalFrame���O
class InternalFrame extends JInternalFrame {
   static int iframeCount = 0;
   static final int offsetX = 25;
   static final int offsetY = 25;
   public InternalFrame() {   // �غc�l
      super("���h����: " + (++iframeCount),
             true,        // �i�վ�ؤo
             true,        // �i����
             true,        // �i�̤j��
             true);       // �i�Y�p���ϥ�
      setSize(300,200);   // �]�w�ؤo
      setLocation(offsetX*iframeCount, // �]�w��m
                  offsetY*iframeCount);
   }
}
// �h�����������ε{��, �~��JFrame���O
public class Ch14_4 extends JFrame {
   private JDesktopPane jdesktop;
   public Ch14_4() {    // �غc�l
      super("JInternalFrame����d��");
      int offset = 100;
      Dimension screenSize = // ���o�ù����ؤo
            Toolkit.getDefaultToolkit().getScreenSize();
      // �]�w�����d��
      setBounds(offset,offset,screenSize.width-offset*2,
                screenSize.height-offset*2);
      // �إ�JDesktopPane����
      jdesktop = new JDesktopPane();
      createInternalFrame();       // �إ߲Ĥ@�Ӥ��h����
      setContentPane(jdesktop);
      setJMenuBar(createMenuBar());  // �إߥ\���
   }
   // �إ�MenuBar
   private JMenuBar createMenuBar() {
      JMenuBar menuBar = new JMenuBar();
      JMenu menu = new JMenu("�ɮ�(F)");
      menu.setMnemonic(KeyEvent.VK_F);
      JMenuItem item = new JMenuItem("�s�W(N)");
      item.setMnemonic(KeyEvent.VK_N);
      item.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            createInternalFrame(); } // �}�ҵ���
      });
      menu.add(item);  menuBar.add(menu);
      return menuBar;
   }
   // �إߤ��h����
   private void createInternalFrame() {
      InternalFrame iframe = new InternalFrame();
      iframe.setVisible(true); // ��ܤ��h����
      jdesktop.add(iframe);    // �[�J�W�h����
      try {
         iframe.setSelected(true);
      } catch(java.beans.PropertyVetoException e){}
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch14_4 app = new Ch14_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setVisible(true);  // ��ܵ���
   }
}