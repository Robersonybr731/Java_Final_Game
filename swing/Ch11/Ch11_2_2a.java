/* 程式範例: Ch11_2_2a.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_2_2a extends JFrame
                      implements ActionListener {
   JLabel label;    // 宣告Swing物件變數
   JPanel jpane;
   public Ch11_2_2a() {     // 建構子
      super("顯示對話方塊");
      JButton button;  // 宣告JButton物件變數
      Container c = getContentPane();
      jpane = new JPanel(); // 建立JPanel物件
      label = new JLabel("測試對話方塊");
      jpane.add(label);
      button = new JButton("showMessageDialog按鈕");
      button.addActionListener(this);
      jpane.add(button);
      c.add(jpane);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      label.setText("按下showMessageDialog按鈕");
      JOptionPane.showMessageDialog(jpane,
                  "一個測試的訊息視窗!",
                  "Ch11_2_2a",
                  JOptionPane.QUESTION_MESSAGE);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_2_2a app = new Ch11_2_2a();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300, 100); // 設定尺寸
      app.setVisible(true);  // 顯示視窗
   }
}