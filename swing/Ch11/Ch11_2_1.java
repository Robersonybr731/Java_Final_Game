/* 程式範例: Ch11_2_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_2_1 extends JFrame {
   public Ch11_2_1() {   // 建構子
      super("JFrame最上層容器");
      Container c=getContentPane();// 取得ContentPane物件
      c.setBackground(Color.white);// 指定背景色彩
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
   	  Ch11_2_1 app = new Ch11_2_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定尺寸
      app.setVisible(true);  // 顯示視窗
   }
}