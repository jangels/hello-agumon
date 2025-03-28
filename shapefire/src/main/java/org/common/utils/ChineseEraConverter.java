package org.common.utils;

import java.time.LocalDateTime;

public class ChineseEraConverter {

    // 天干数组（10个）
    private static final String[] TIAN_GAN = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    // 地支数组（12个）
    private static final String[] DI_ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

    /**
     * 将公历年份转换为天干地支纪年
     * @param year 公历年份（公元后）
     * @return 天干地支组合字符串（如"甲子"）
     */
    public static String toChineseEra(int year) {
        // 计算基准偏移量（甲子年对应公元4年）
        int base = year - 4;

        // 计算天干和地支的索引（避免负数）
        int ganIndex = Math.floorMod(base, 10); // 天干索引
        int zhiIndex = Math.floorMod(base, 12); // 地支索引

        return TIAN_GAN[ganIndex] + DI_ZHI[zhiIndex];
    }

    public static void main(String[] args) {
        // 测试用例
//        System.out.println(toChineseEra(2023)); // 输出：癸卯
//        System.out.println(toChineseEra(2024)); // 输出：甲辰
//        System.out.println(toChineseEra(1984)); // 输出：甲子
//        System.out.println(toChineseEra(2020)); // 输出：庚子
        System.out.println(toChineseEra(LocalDateTime.now().getYear()));
    }
}