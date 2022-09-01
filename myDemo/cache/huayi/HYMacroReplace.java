package com.ye.cache.huayi;

import com.ssp.common.enums.system.MacroReplaceChannel;
import com.ssp.common.enums.system.MacroReplaceEnum;

/**
 * 华毅宏替换
 * @author yxd
 * @since 2022/8/17 17:06
 */
public enum HYMacroReplace implements MacroReplaceChannel {

    /** 用户手指按下时的横坐标 */
    _DOWN_X_(MacroReplaceEnum.ADOWN_PRESSX),
    /** 用户手指按下时的纵坐标 */
    _DOWN_Y_(MacroReplaceEnum.ADOWN_PRESSY),
    /** 用户手指离开手机屏幕时的横坐标 */
    _UP_X_(MacroReplaceEnum.AUP_PRESSX),
    /** 用户手指离开手机屏幕时的纵坐标 */
    _UP_Y_(MacroReplaceEnum.AUP_PRESSY),
    /** 实际广告位的宽，单位为像素 */
    _WIDTH_(MacroReplaceEnum.WIDTH),
    /** 实际广告位的高，单位为像素 */
    _HEIGHT_(MacroReplaceEnum.HEIGHT),
    /** 需要把上报URL里的_CLICKID_转换成响应内容里的 clickid值 */
    _CLICKID_(MacroReplaceEnum.CLICK_ID),
    /** 事件触发时间(单位：毫秒) */
    _TS_(MacroReplaceEnum.TIME_START),
    /** 事件触发时间(单位：秒) */
    _SEC_(MacroReplaceEnum.TIME_START_SE),
    ;

    private MacroReplaceEnum replace;

    HYMacroReplace(MacroReplaceEnum replace) {
        this.replace = replace;
    }

    @Override
    public String getMacroOri() {
        return name();
    }

    @Override
    public MacroReplaceEnum getReplace() {
        return replace;
    }

    /** 枚举 values() 底层，每次调用都会new 一个数组，将其缓存下来 */
    private static final MacroReplaceChannel[] values = values();
    public static MacroReplaceChannel[] getValues() {
        return values;
    }

    /** 渠道宏名称 与 SSP系统-宏名称 对应数组 */
    private static final String[] macrosChannel = new String[values.length];
    private static final String[] macrosSys = new String[values.length];

    static {

        for (int i = 0; i < values.length; i++) {
            MacroReplaceChannel macro = values[i];
            if (macro.getReplace() == MacroReplaceEnum.NON) {
                continue;
            }
            macrosChannel[i] = macro.getMacroOri();
            macrosSys[i] = macro.getReplace().getMacro();
        }

    }

    public static String[] getMacrosChannel() {
        return macrosChannel;
    }

    public static String[] getMacrosSys() {
        return macrosSys;
    }

}
