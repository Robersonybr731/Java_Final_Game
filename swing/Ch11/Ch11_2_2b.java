/* 程式範例: Ch11_2_2b.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_2_2b extends JFrame
                     implements ActionListener {
   JLabel label;   // 宣告Swing物件變數
   JPanel jpane;
   public Ch11_2_2b() {   // 建構子
      super("顯示對話方塊");
      JButton button;  // 宣告JButton物件變數
      Container c = getContentPane();
      jpane = new JPanel(); // 建立JPanel物件
      label = new JLabel("測試對話方塊");
      jpane.add(label);
      button = new JButton("showConfirmDialog按鈕");
      button.addActionListener(this);
      jpane.add(button);
      c.add(jpane);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
       int n = JOptionPane.showConfirmDialog(jpane,
               "您是否已經按下showMessageDialog按鈕?",
               "操作問題", JOptionPane.YES_NO_OPTION);
       if (n == JOptionPane.YES_OPTION)
          label.setText("按下是");
       else if (n == JOptionPane.NO_OPTION)
               label.setText("按下否");
            else
               label.setText("沒有選擇");
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_2_2b app = new Ch11_2_2b();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300, 100); // 設定尺寸
      app.setVisible(true);  // 顯示視窗
   }
}