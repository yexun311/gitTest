package com.ye.cache.qianqu1;

import com.ssp.common.enums.system.MacroReplaceChannel;
import com.ssp.common.enums.system.MacroReplaceEnum;


/**
 * 千曲宏替换
 * @author yxd
 * @since 2022/8/17 13：30
 */
public enum QQMacroReplace implements MacroReplaceChannel {

    /** 请求时预留的广告位高度 类型：Integer 必填 */
    __REQ_WIDTH__(MacroReplaceEnum.WIDTH),
    /** 请求时预留的广告位宽度 类型：Integer 必填 */
    __REQ_HEIGHT__(MacroReplaceEnum.HEIGHT),
    /** 实际广告位的宽,单位为像素 类型：Integer 必填 */
    __WIDTH__(MacroReplaceEnum.WIDTH),
    /** 实际广告位的高,单位为像素 类型：Integer 必填 */
    __HEIGHT__(MacroReplaceEnum.HEIGHT),
    /**请正确获取有效值并替换，
     * 如无法获取时，需替换为-999。当未替换为有效值时，流量收益会受到不同程度的影响：
     * 1.替换为-999，影响流量收益。全部为-999 请求将不返回广告
     * 2.替换为无效值（非数字格式或取值异常）， 影响流量收益
     * 3.未替换：请求将不返回广告
     *
     * 用户手指按下时的横坐标 类型：Integer 必填 */
    __DOWN_X__(MacroReplaceEnum.ADOWN_PRESSX),
    /** 用户手指按下时的纵坐标 类型：Integer 必填 */
    __DOWN_Y__(MacroReplaceEnum.ADOWN_PRESSY),
    /** 用户手指离开设备屏幕时的横坐标。类型：Integer 必填 */
    __UP_X__(MacroReplaceEnum.AUP_PRESSX),
    /** 用户手指离开设备屏幕时的纵坐标。类型：Integer 必填 */
    __UP_Y__(MacroReplaceEnum.AUP_PRESSY),
    /** 下载类广告，且 downType=2 时，需要用 clickUrl 二次请求获得的 clickid 替换 类型：String 必填 */
    __CLICK_ID__(MacroReplaceEnum.CLICK_ID),
     ;

    private MacroReplaceEnum replace;

    QQMacroReplace(MacroReplaceEnum replace) {
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

    /** 枚举 values() 底层，每次调用都会new一个数组，将其缓存下来 */
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
