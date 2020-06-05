/* 程式範例: Ch12_5_3.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch12_5_3 extends JFrame
                      implements ActionListener {
   private JScrollPane scroll;
   private JTextArea area;
   public Ch12_5_3() {  // 建構子
      super ("JTextArea元件範例");
      Container c = getContentPane();
      area = new JTextArea("等待輸入資料...\n", 15, 30);
      area.setLineWrap(true);
      area.setFont(new Font("細明體", Font.ITALIC, 16));
      scroll = new JScrollPane(area);
      JButton btn = new JButton("送出資料");
      btn.addActionListener(this);   // 註冊事件處理
      c.add(scroll, BorderLayout.CENTER);
      c.add(btn, BorderLayout.SOUTH);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      JOptionPane.showMessageDialog(scroll,
            area.getText(), "Ch12_5_3",
            JOptionPane.QUESTION_MESSAGE);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch12_5_3 app = new Ch12_5_3();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}