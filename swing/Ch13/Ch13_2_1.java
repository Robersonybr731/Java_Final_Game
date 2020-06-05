/* 程式範例: Ch13_2_1.java */
class MyInt {   // MyInt類別宣告
   public int value;
   public MyInt(int v) { value = v; }
   public void show() {
      System.out.println(value);
   }
}
interface IValue {  // IValue介面宣告
  int value();
}
// 主類別
public class Ch13_2_1 {
   // 主程式
   public static void main(String[] args) {
      // 繼承現存類別來建立匿名內層類別
      MyInt myInt = new MyInt(100) {
         public void show() {
            System.out.println("整數值： " + value);
         }
      };
      myInt.show();
      // 實作介面來建立匿名內層類別
      IValue iValue = new IValue() {
         public int value() {
            return 50;
         }
      };
      System.out.println("傳回值： " + iValue.value());
   }
}