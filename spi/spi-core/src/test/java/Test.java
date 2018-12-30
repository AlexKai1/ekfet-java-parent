import com.ekfet.spi.core.NumberInterface;

import java.util.ServiceLoader;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: Test
 * @date 2018/12/30 14:56
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<NumberInterface> serviceLoader=ServiceLoader.load(NumberInterface.class);
        serviceLoader.forEach(x->{
            x.getNumber();
        });
    }
}
