package com.ptit.exam.util;

/**
 * User: thuongntt
 * Date: 12/18/13
 * Time: 5:43 AM
 */
public class StringUtils
{
    public static boolean isEmpty(String str)
    {
        str = str.trim();
        if (null == str || 0 == str.length() || "".equals(str))
        {
            return false;
        }
        return true;
    }
}
