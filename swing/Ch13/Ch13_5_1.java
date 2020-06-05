/* 程式範例: Ch13_5_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch13_5_1 extends JFrame {
   private JLabel lbl;
   public Ch13_5_1() {   // 建構子
      super ("ActionEvent事件處理範例");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      JTextField txt = new JTextField(12);
      txt.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            JTextField s = (JTextField) evt.getSource();
            lbl.setText(s.getText());
         } });
      String[] items = { "iPod", "iPhone",
                         "iPad", "Mac Air"};
      JComboBox<String> jcb = new JComboBox<>(items);
      jcb.setSelectedIndex(3); // 指定預設選擇
      jcb.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            JComboBox c = (JComboBox) evt.getSource();
            lbl.setText((String) c.getSelectedItem());
         } });
      lbl = new JLabel("顯示輸入資料"); // 顯示結果標籤
      JPanel jpane = new JPanel(); // 建立JPanel物件
      jpane.add(txt); jpane.add(jcb);
      c.add(jpane);   c.add(lbl);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_5_1 app = new Ch13_5_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(280,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}