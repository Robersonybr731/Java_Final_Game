/* 程式範例: Ch13_5_3.java */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch13_5_3 extends JFrame {
   private JList<String> nList;
   private JLabel lbl;
   public Ch13_5_3() {   // 建構子
      super("ListSelectionEvent事件處理範例");
      String[] names = {"陳會安", "江小魚",
                        "小龍女", "陳允傑"};
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      nList = new JList<>(names);  // 建立單選JList元件
      nList.setVisibleRowCount(3); // 顯示3個選項
      nList.setSelectionMode(
               ListSelectionModel.SINGLE_SELECTION);
      nList.addListSelectionListener(  // 註冊事件處理
                     new ListSelectionListener() {
         public void valueChanged(
                         ListSelectionEvent evt) {
           if (evt.getValueIsAdjusting() == false)
               if ( nList.getSelectedIndex() != -1 ) {
                  String name =
                    nList.getSelectedValue().toString();
                  lbl.setText(name);
               }
         } });
      JScrollPane scroll1 = new JScrollPane(nList);
      lbl = new JLabel("選擇結果");
      c.add(scroll1);  c.add(lbl);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_5_3 app = new Ch13_5_3();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,120);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}