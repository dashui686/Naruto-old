package com.dashui.naruto;

import cn.hutool.crypto.digest.DigestUtil;
import org.junit.jupiter.api.Test;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/22 23:23
 * @PackageName: com.dashui.naruto
 * @ClassName: DemoTests
 * @Description: TODO
 * @Version 1.0
 */
public class DemoTests {

    @Test
    public void test(){
        String bcrypt = DigestUtil.bcrypt("123456");
        System.out.println(bcrypt);
        boolean b = DigestUtil.bcryptCheck("123456", bcrypt);
        System.out.println(b);

    }

    public static void main(String[] args) {
        String bcrypt = DigestUtil.bcrypt("123456");
        System.out.println(bcrypt);
        boolean b = DigestUtil.bcryptCheck("123456", bcrypt);
        System.out.println(b);

    }


}
