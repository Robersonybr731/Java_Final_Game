/* 程式範例: Ch13_3_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch13_3_2 extends JFrame {
   private boolean isDragging;// 是否是拖拉狀態
   private int x, y;          // 目前座標
   private int prevX, prevY;  // 前一點座標
   public Ch13_3_2() {  // 建構子
      super ("滑鼠拖拉事件範例");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent evt) {
            // 目前是否是拖拉狀態
            if ( isDragging == true) return;
            isDragging = true;  // 進入拖拉狀態
            // 重新計算座標
            x = evt.getX();  y = evt.getY();
            prevX = x;       prevY = y;
         }
         public void mouseReleased(MouseEvent evt) {
            isDragging = false;  // 離開拖拉狀態
         } });
      addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseDragged(MouseEvent evt) {
            // 目前不是拖拉狀態
            if ( isDragging == false ) return;
            int tempX = evt.getX(), tempY = evt.getY();
            Graphics g = getGraphics();
            g.setColor(Color.blue);   // 繪出藍線
            g.drawLine(prevX, prevY, tempX, tempY);
            prevX = tempX;  prevY = tempY; // 保留座標
         } });
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_3_2 app = new Ch13_3_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}