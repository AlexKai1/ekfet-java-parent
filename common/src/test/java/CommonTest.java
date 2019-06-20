public class CommonTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Math.min(Runtime.getRuntime().availableProcessors() * 2 + 1, 32));
    }
}
