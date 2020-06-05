/* 程式範例: Ch14_3_1.java */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
// 繼承JFrame類別
public class Ch14_3_1 extends JFrame {
   public Ch14_3_1() {    // 建構子
      super("JFileChooser元件範例");
      Container c = getContentPane();
      // 建立擁有捲動軸的文字區域元件
      final JTextArea area = new JTextArea(15,30);
      JScrollPane scroll = new JScrollPane(area);
      // 建立JFileChooser元件
      final JFileChooser jfc = new JFileChooser();
      JPanel button = new JPanel(); // 按鈕的JPanel
      // 建立開啟檔案的按鈕
      JButton open = new JButton("開啟檔案");
      open.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            int n = jfc.showOpenDialog(Ch14_3_1.this);
            if ( n == JFileChooser.APPROVE_OPTION ) {
               File file = jfc.getSelectedFile();
               area.append("開啟檔案名稱: ");
               area.append(file.getName() + "\n");
            }
         } });
      button.add(open);
      // 建立儲存檔案按鈕
      JButton save = new JButton("儲存檔案");
      save.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            int m = jfc.showSaveDialog(Ch14_3_1.this);
            if ( m == JFileChooser.APPROVE_OPTION ) {
               File file = jfc.getSelectedFile();
               area.append("儲存檔案名稱: ");
               area.append(file.getName() + "\n");
            }
         } });
      button.add(save);
      c.add(scroll, BorderLayout.CENTER);
      c.add(button, BorderLayout.SOUTH);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch14_3_1 app = new Ch14_3_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}