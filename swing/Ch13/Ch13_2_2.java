/* 程式範例: Ch13_2_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 使用Windows Event傾聽者的JFrame
class NewWindow extends JFrame
                implements WindowListener {
   public NewWindow(String title) {  // 建構子
      super(title);
      Container c = getContentPane();
      c.add(new JLabel("Windows Event傾聽者"));
      addWindowListener(this); // 註冊事件處理
      setSize(200,100);   setVisible(false);
   }
   // 實作事件處理方法
   public void windowClosing(WindowEvent evt) {
      setVisible(false); }
   public void windowClosed(WindowEvent evt) { }
   public void windowOpened(WindowEvent evt) { }
   public void windowIconified(WindowEvent evt) { }
   public void windowDeiconified(WindowEvent evt) { }
   public void windowActivated(WindowEvent evt) { }
   public void windowDeactivated(WindowEvent evt) { }
}
// Swing應用程式類別
public class Ch13_2_2 extends JFrame {
   // 建立NewWindow視窗物件
   NewWindow win = new NewWindow("JFrame新視窗");
   public Ch13_2_2() {   // 建構子
      super("WindowEvent範例");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      JButton button = new JButton("開啟視窗");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            win.setVisible(true); // 顯示視窗
         } });
      c.add(new JLabel("WindowAdapter改編者"));
      c.add(button);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_2_2 app = new Ch13_2_2();
      app.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt)
         { System.exit(0); } });
      app.setSize(300,100);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}