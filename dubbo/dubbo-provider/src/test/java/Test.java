import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal("200");
        System.out.println();
        BigDecimal b = a.divideAndRemainder(BigDecimal.ONE)[1];
        System.out.println(b);

    }
}
