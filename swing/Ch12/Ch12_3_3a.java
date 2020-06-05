/* 程式範例: Ch12_3_3a.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch12_3_3a extends JFrame
                       implements ActionListener {
   private JLabel lbl;
   private JComboBox<String> jcb;
   public Ch12_3_3a() {    // 建構子
      super("JComboBox元件範例-可編輯");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      String[] items = { "使用現金", "使用信用卡",
                         "直接轉帳", "使用支票"};
      jcb = new JComboBox<>(items);
      jcb.setEditable(true);
      jcb.setSelectedIndex(3); // 指定預設選擇
      JButton btn1 = new JButton("選擇");
      btn1.addActionListener(this); // 註冊事件處理
      lbl = new JLabel(items[3]);
      c.add(jcb);  c.add(btn1);  c.add(lbl);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      String name = (String) jcb.getSelectedItem();
      lbl.setText(name);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch12_3_3a app = new Ch12_3_3a();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}