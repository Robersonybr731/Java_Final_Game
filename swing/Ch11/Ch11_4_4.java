/* 程式範例: Ch11_4_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_4_4 extends JFrame {
   public Ch11_4_4() {     // 建構子
      super("GridLayout版面配置");
      Container c = getContentPane();
      c.setLayout(new GridLayout(2,4,4,4));
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
      Ch11_4_4 app = new Ch11_4_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(350,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}