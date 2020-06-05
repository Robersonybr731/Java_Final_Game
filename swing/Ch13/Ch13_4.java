/* 程式範例: Ch13_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作KeyListener介面
public class Ch13_4 extends JFrame
                    implements KeyListener {
   private JLabel lbl;
   public Ch13_4() {  // 建構子
      super ("鍵盤事件範例");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      lbl = new JLabel("KeyEvent"); // 建立標籤
      addKeyListener(this); // 註冊事件處理
      c.add(lbl);
   }
   // 實作事件處理方法
   public void keyPressed(KeyEvent evt) {
      int key = evt.getKeyCode();
      switch (key) {
         case KeyEvent.VK_LEFT:
              lbl.setText("向左"+Integer.toString(key));
              break;
         case KeyEvent.VK_RIGHT:
              lbl.setText("向右"+Integer.toString(key));
              break;
         case KeyEvent.VK_UP:
              lbl.setText("向上"+Integer.toString(key));
              break;
         case KeyEvent.VK_DOWN:
              lbl.setText("向下"+Integer.toString(key));
              break;
         default: lbl.setText(Integer.toString(key));
      }
   }
   public void keyTyped(KeyEvent evt) { }
   public void keyReleased(KeyEvent evt) { }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_4 app = new Ch13_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}