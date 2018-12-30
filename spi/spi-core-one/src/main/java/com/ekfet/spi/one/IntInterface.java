package com.ekfet.spi.one;

import com.ekfet.spi.core.NumberInterface;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: IntInterface
 * @date 2018/12/30 14:47
 */
public class IntInterface  implements NumberInterface {

    @Override
    public void getNumber() {
        System.out.println("Inteface=100");
    }
}
