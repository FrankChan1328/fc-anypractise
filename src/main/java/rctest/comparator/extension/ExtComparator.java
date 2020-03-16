/**
 * @(#)LastNameComparator.java 2019-12-25
 * 
 * Copyright 2000-2019 by ChinanetCenter Corporation.
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ChinanetCenter Corporation ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with ChinanetCenter.
 * 
 */
package rctest.comparator.extension;

import rctest.Extension;

/**
 * Extension 类Ext 属性排序
 */
public class ExtComparator extends BaseComparator {

    @Override
    public int compare(Extension o1, Extension o2) {
        return compareStr(o1.getExt(), o2.getExt());
    }
}
