/* 程式範例: Ch11_2_2c.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_2_2c extends JFrame
                     implements ActionListener {
   JLabel label;  // 宣告Swing物件變數
   JPanel jpane;
   public Ch11_2_2c() {    // 建構子
      super("顯示對話方塊");
      JButton button;   // 宣告JButton物件變數
      Container c = getContentPane();
      jpane = new JPanel(); // 建立JPanel物件
      label = new JLabel("測試對話方塊");
      jpane.add(label);
      button = new JButton("showOptionDialog按鈕");
      button.addActionListener(this);
      jpane.add(button);
      c.add(jpane);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      Object[] options = {"showMessageDialog按鈕",
                          "showConfirmDialog按鈕"};
      int m = JOptionPane.showOptionDialog(jpane,
               "哪一個按鈕顯示警告訊息?",
               "操作問題", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE, null,
               options, options[0]);
      switch (m) {  // 顯示選擇
         case JOptionPane.YES_OPTION:
              label.setText("選showMessageDialog按鈕");
              break;
         case JOptionPane.NO_OPTION:
              label.setText("選showConfirmDialog按鈕");
              break;
         default:
              label.setText("沒有選擇");
      }
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_2_2c app = new Ch11_2_2c();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300, 100); // 設定尺寸
      app.setVisible(true);  // 顯示視窗
   }
}