/* 程式範例: Ch12_5_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch12_5_2 extends JFrame
                      implements ActionListener {
   private JLabel lbl;
   private JPasswordField pass;
   public Ch12_5_2() {  // 建構子
      super ("JPasswordField元件範例");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      pass = new JPasswordField(12); // 建立密碼欄位
      // 建立標籤
      JLabel pLbl = new JLabel("使用者密碼: ");
      pLbl.setLabelFor(pass);// 屬於密碼欄位
      // 顯示輸入文字內容的標籤
      lbl = new JLabel("顯示欄位輸入的資料");
      JButton btn1 = new JButton("確定");
      btn1.addActionListener(this); // 註冊事件處理
      JPanel jpane = new JPanel(); // 建立JPanel物件
      jpane.add(pLbl); jpane.add(pass); jpane.add(btn1);
      c.add(jpane);    c.add(lbl);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      lbl.setText("輸入密碼 : "
                 + new String(pass.getPassword()));
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch12_5_2 app = new Ch12_5_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}