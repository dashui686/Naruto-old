package com.dashui.naruto.satoken.util;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaStorage;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.dashui.naruto.satoken.domain.LoginAdmin;
import com.dashui.naruto.satoken.enums.DeviceType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 登录鉴权助手
 * <p>
 * user_type 为 用户类型 同一个用户表 可以有多种用户类型 例如 pc,app
 * deivce 为 设备类型 同一个用户类型 可以有 多种设备类型 例如 web,ios
 * 可以组成 用户类型与设备类型多对多的 权限灵活控制
 * <p>
 * 多用户体系 针对 多种用户类型 但权限控制不一致
 * 可以组成 多用户类型表与多设备类型 分别控制权限
 *
 * @author Lion Li
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginHelper {

    public static final String LOGIN_USER_KEY = "loginAdmin";
    public static final String USER_KEY = "adminId";

    /**
     * 登录系统
     *
     * @param loginAdmin 登录用户信息
     */
    public static void login(LoginAdmin loginAdmin) {
        loginByDevice(loginAdmin, null);
    }

    /**
     * 登录系统 基于 设备类型
     * 针对相同用户体系不同设备
     *
     * @param loginAdmin 登录用户信息
     */
    public static void loginByDevice(LoginAdmin loginAdmin, DeviceType deviceType) {
        SaStorage storage = SaHolder.getStorage();
        storage.set(LOGIN_USER_KEY, loginAdmin);
        storage.set(USER_KEY, loginAdmin.getId());
        SaLoginModel model = new SaLoginModel();
        if (ObjectUtil.isNotNull(deviceType)) {
            model.setDevice(deviceType.getDevice());
        }
        StpUtil.login(loginAdmin.getId(), model.setExtra(USER_KEY, loginAdmin.getId()));
        StpUtil.getTokenSession().set(LOGIN_USER_KEY, loginAdmin);
    }

    /**
     * 获取用户(多级缓存)
     */
    public static LoginAdmin getLoginUser() {
        LoginAdmin loginUser = (LoginAdmin) SaHolder.getStorage().get(LOGIN_USER_KEY);
        if (loginUser != null) {
            return loginUser;
        }
        loginUser = (LoginAdmin) StpUtil.getTokenSession().get(LOGIN_USER_KEY);
        SaHolder.getStorage().set(LOGIN_USER_KEY, loginUser);
        return loginUser;
    }

    /**
     * 获取用户基于token
     */
    public static LoginAdmin getLoginUser(String token) {
        return (LoginAdmin) StpUtil.getTokenSessionByToken(token).get(LOGIN_USER_KEY);
    }

    /**
     * 获取用户id
     */
    public static Long getUserId() {
        Long userId;
        try {
            userId = Convert.toLong(SaHolder.getStorage().get(USER_KEY));
            if (ObjectUtil.isNull(userId)) {
                userId = Convert.toLong(StpUtil.getExtra(USER_KEY));
                SaHolder.getStorage().set(USER_KEY, userId);
            }
        } catch (Exception e) {
            return null;
        }
        return userId;
    }

    /**
     * 获取部门ID
     */
    // public static Long getDeptId() {
    //     return getLoginUser().getDeptId();
    // }

    /**
     * 获取用户账户
     */
    public static String getUsername() {
        return getLoginUser().getUserName();
    }

    /**
     * 获取用户类型
     */
    // public static UserType getUserType() {
    //     String loginId = StpUtil.getLoginIdAsString();
    //     return UserType.getUserType(loginId);
    // }

    /**
     * 是否为管理员
     *
     * @param userId 用户ID
     * @return 结果
     */
    // public static boolean isAdmin(Long userId) {
    //     return UserConstants.ADMIN_ID.equals(userId);
    // }

    // public static boolean isAdmin() {
    //     return isAdmin(getUserId());
    // }

}
