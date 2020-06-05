/* 程式範例: Ch11_4_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_4_2 extends JFrame {
   public Ch11_4_2() {    // 建構子
      super("FlowLayout版面配置");
      Container c = getContentPane();
      c.setLayout(new FlowLayout(FlowLayout.LEFT,3,3));
      c.add(new JButton("按鈕一"));
      c.add(new JButton("按鈕二"));
      c.add(new JButton("按鈕三"));
      c.add(new JButton("按鈕四"));
      c.add(new JButton("按鈕五"));
      c.add(new JButton("按鈕六"));
      c.add(new JButton("按鈕七"));
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_4_2 app = new Ch11_4_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}