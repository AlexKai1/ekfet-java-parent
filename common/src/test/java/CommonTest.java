import java.lang.reflect.ParameterizedType;

public class CommonTest {
    public static void main(String[] args) {
       /* System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Math.min(Runtime.getRuntime().availableProcessors() * 2 + 1, 32));*/
       // getSession("21312");
       // CommonTest commonTest=new CommonTest();
        System.out.println(Double.valueOf("0.00000001"));

    }

    /*public   <T> T getSession(String sessionKey) throws  Exception {
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(tClass);
      //  T t= Class.forName(tClass.getName());
       // return
    }*/
}
