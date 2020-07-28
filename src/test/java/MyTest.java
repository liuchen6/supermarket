public class MyTest {


    public static void main(String[] args) {
        System.out.println(Math.round(67.9999999999999999999999999999999999));

        java.text.DecimalFormat df =new java.text.DecimalFormat("0.00");
        System.out.println(df.format(0.6799999999999999999));
    }
}
