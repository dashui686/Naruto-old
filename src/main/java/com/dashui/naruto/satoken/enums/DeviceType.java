package com.dashui.naruto.satoken.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 设备类型
 * 针对一套 用户体系
 *
 * @author Lion Li
 */
@Getter
@AllArgsConstructor
public enum DeviceType {

    /**
     * pc端
     */
    PC("pc"),

    /**
     * 小程序端
     */
    XCX("xcx");

    private final String device;
}
