/* 程式範例: Ch11_1_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch11_1_2 extends JFrame
                     implements ActionListener {
   private static String labelString = "按幾次: ";
   private int num = 0;  // 次數統計
   private JLabel label;
   public Ch11_1_2() {   // 建構子
      super("Swing應用程式範例");  // 視窗標題文字
      Container c = getContentPane(); // 取得ContentPane
      c.setLayout(new FlowLayout());  // 版面配置
      label = new JLabel(labelString + num);
      label.setBorder(   // 設定框線
      	    BorderFactory.createLineBorder(Color.blue));
      JButton button = new JButton("按一下(K)");
      button.setMnemonic(KeyEvent.VK_K);// 設定按鍵Alt_K
      button.addActionListener(this);   // 註冊事件處理
      JPanel jpane = new JPanel();  // 建立JPanel物件
      jpane.setBorder(   // 設定框線
      	  BorderFactory.createLineBorder(Color.yellow));
      jpane.add(label);  // 新增元件到JPanel
      jpane.add(button);
      c.add(jpane);      // 新增元件到ContentPane
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      num++; // 按鈕次數加一
      label.setText(labelString+num); // 重設文字內容
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式的物件
      Ch11_1_2 app = new Ch11_1_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}