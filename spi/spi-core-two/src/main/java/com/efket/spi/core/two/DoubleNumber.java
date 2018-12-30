package com.efket.spi.core.two;

import com.ekfet.spi.core.NumberInterface;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: DoubleNumber
 * @date 2018/12/30 14:51
 */
public class DoubleNumber implements NumberInterface {
    @Override
    public void getNumber() {
        System.out.println("DoubleNumber =100.00");
    }
}
