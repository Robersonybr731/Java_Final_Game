/* 程式範例: Ch11_4_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_4_1 extends JFrame {
   public Ch11_4_1() {   // 建構子
      super("BorderLayout版面配置");
      Container c = getContentPane();
      c.setLayout(new BorderLayout(4,4));
      c.add(new JButton("北按鈕"), BorderLayout.NORTH);
      c.add(new JButton("中按鈕"), BorderLayout.CENTER);
      c.add(new JButton("西按鈕"), BorderLayout.WEST);
      c.add(new JButton("南按鈕"), BorderLayout.SOUTH);
      c.add(new JButton("東按鈕"), BorderLayout.EAST);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_4_1 app = new Ch11_4_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}