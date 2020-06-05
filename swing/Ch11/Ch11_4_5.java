/* 程式範例: Ch11_4_5.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_4_5 extends JFrame {
   public Ch11_4_5() {    // 建構子
      super("GridBagLayout版面配置");
      Container c = getContentPane();
      GridBagLayout gridbag = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      c.setLayout(gridbag); // 設定容器預設的版面配置
      gbc.fill=GridBagConstraints.HORIZONTAL;// 填滿方式
      JButton button1 = new JButton("按鈕一");
      gbc.gridx = 0;  gbc.gridy = 0;  // 第幾欄, 第幾列
      gridbag.setConstraints(button1, gbc);
      c.add(button1);
      JButton button2 = new JButton("按鈕二");
      gbc.gridx = 1;  gbc.gridy = 0;
      gridbag.setConstraints(button2, gbc);
      c.add(button2);
      JButton button3 = new JButton("按鈕三");
      gbc.gridx = 2;  gbc.gridy = 0;
      gridbag.setConstraints(button3, gbc);
      c.add(button3);
      JButton button4 = new JButton("按鈕四");
      gbc.ipady = 30;     // 設定內部墊充
      gbc.weightx = 0.5;  // 尺寸變更的權值
      gbc.gridwidth = 3;  // 使用幾欄
      gbc.gridx = 0;  gbc.gridy = 1;
      gridbag.setConstraints(button4, gbc);
      c.add(button4);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_4_5 app = new Ch11_4_5();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}