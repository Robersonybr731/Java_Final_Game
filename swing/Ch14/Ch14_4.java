/* 程式範例: Ch14_4.java */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 內層視窗類別, 繼承JInternalFrame類別
class InternalFrame extends JInternalFrame {
   static int iframeCount = 0;
   static final int offsetX = 25;
   static final int offsetY = 25;
   public InternalFrame() {   // 建構子
      super("內層視窗: " + (++iframeCount),
             true,        // 可調整尺寸
             true,        // 可關閉
             true,        // 可最大化
             true);       // 可縮小成圖示
      setSize(300,200);   // 設定尺寸
      setLocation(offsetX*iframeCount, // 設定位置
                  offsetY*iframeCount);
   }
}
// 多重視窗的應用程式, 繼承JFrame類別
public class Ch14_4 extends JFrame {
   private JDesktopPane jdesktop;
   public Ch14_4() {    // 建構子
      super("JInternalFrame元件範例");
      int offset = 100;
      Dimension screenSize = // 取得螢幕的尺寸
            Toolkit.getDefaultToolkit().getScreenSize();
      // 設定視窗範圍
      setBounds(offset,offset,screenSize.width-offset*2,
                screenSize.height-offset*2);
      // 建立JDesktopPane物件
      jdesktop = new JDesktopPane();
      createInternalFrame();       // 建立第一個內層視窗
      setContentPane(jdesktop);
      setJMenuBar(createMenuBar());  // 建立功能表
   }
   // 建立MenuBar
   private JMenuBar createMenuBar() {
      JMenuBar menuBar = new JMenuBar();
      JMenu menu = new JMenu("檔案(F)");
      menu.setMnemonic(KeyEvent.VK_F);
      JMenuItem item = new JMenuItem("新增(N)");
      item.setMnemonic(KeyEvent.VK_N);
      item.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            createInternalFrame(); } // 開啟視窗
      });
      menu.add(item);  menuBar.add(menu);
      return menuBar;
   }
   // 建立內層視窗
   private void createInternalFrame() {
      InternalFrame iframe = new InternalFrame();
      iframe.setVisible(true); // 顯示內層視窗
      jdesktop.add(iframe);    // 加入上層視窗
      try {
         iframe.setSelected(true);
      } catch(java.beans.PropertyVetoException e){}
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch14_4 app = new Ch14_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setVisible(true);  // 顯示視窗
   }
}