package com.dashui.naruto.satoken;

import com.dashui.naruto.satoken.domain.LoginAdmin;
import com.dashui.naruto.satoken.domain.LoginAdminVo;
import com.dashui.naruto.satoken.domain.LoginBody;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 16:05
 * @PackageName: com.dashui.naruto.security
 * @ClassName: UserDetailsService
 * @Description: TODO
 * @Version 1.0
 */
public interface AdminDetailService {

     LoginAdminVo login(LoginBody loginBody);
}
