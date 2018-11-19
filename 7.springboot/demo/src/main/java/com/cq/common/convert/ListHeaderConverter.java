/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.convert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cq.common.enums.ListHeaderEnum;
import com.google.common.base.Splitter;

/**
 * 表头查询转换
 *
 * @since 2018年3月7日 下午2:44:50
 * @author huangyi
 *
 */
public class ListHeaderConverter {
    private static final Logger LOG = LoggerFactory.getLogger(ListHeaderConverter.class);

    private ListHeaderConverter() {
    }

    /**
     * 表头查询转换
     *
     * @param object
     *            转换的对象
     * @return 转换后的对象
     */
    public static Object headConverter(Object object) {
        if (object == null) {
            return null;
        }
        Class<? extends Object> getClass = object.getClass();
        Field[] fields = getClass.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].get(object) != null) {
                    String value = fields[i].get(object).toString();
                    String fldSetName = fields[i].getName();
                    ListHeaderEnum[] enumValues = ListHeaderEnum.values();
                    for (ListHeaderEnum header : enumValues) {
                        String code = header.getCode();
                        if (value.startsWith(code)) {
                            // 日期区间单独判断
                            String dategtlt = ListHeaderEnum.DATE_GTLT.getCode();
                            String inlcude = ListHeaderEnum.INCLUDE.getCode();
                            if (value.startsWith(dategtlt)) {
                                String[] split = value.replace(dategtlt, "").split(",");
                                Field tempAttributeGt = object.getClass().getDeclaredField(fldSetName + "Gt");
                                tempAttributeGt.setAccessible(true);
                                tempAttributeGt.set(object, split[0]);
                                Field tempAttributeLt = object.getClass().getDeclaredField(fldSetName + "Lt");
                                tempAttributeLt.setAccessible(true);
                                tempAttributeLt.set(object, split[1]);
                                fields[i].set(object, null);
                            } else if (value.startsWith(inlcude)) {

                                // 包含单独判断
                                Field tempAttribute = object.getClass().getDeclaredField(fldSetName + header.getSuffix());
                                tempAttribute.setAccessible(true);
                                String replace = value.replace(inlcude, "");
                                List<String> splitToList = Splitter.on(",").trimResults().splitToList(replace);
                                List<String> list = new ArrayList<>(splitToList);
                                List<String> filterList = new ArrayList<>();
                                for (String string : list) {
                                    filterList.add("'" + string + "'");
                                }
                                tempAttribute.set(object, "(" + StringUtils.join(filterList, ",") + ")");
                                fields[i].set(object, null);
                            } else {
                                // 其它情况
                                Field tempAttribute = object.getClass().getDeclaredField(fldSetName + header.getSuffix());
                                tempAttribute.setAccessible(true);
                                tempAttribute.set(object, value.replace(code, ""));
                                fields[i].set(object, null);
                            }
                        }
                    }
                    // enum for end
                }
            }
            // class for end
        } catch (Exception e) {
            LOG.error("", e);
        }
        LOG.info(object.toString());
        return object;
    }

    /*    public static void main(String[] args) {
        Test test = new Test();
        test.setName("黄毅");
        test.setAge("$eq$18");
        test.setAge("$gteq$18");
        test.setBirthday("$gtlt$92,96");
        test.setAge("$in$92,96,100");
        headConverter(test);
        // System.out.println(test);
        // String string = "$o$123";
        // System.out.println(string.replace("$o$", ""));
    }*/

}

/*class Test implements Serializable {
    private static final long serialVersionUID = 8568510883396819419L;
    String name;
    String age;
    String birthday;
    String nameLike;
    String ageGt;
    String ageLt;
    String ageGte;
    String ageLte;
    String ageEquals;
    String ageIn;
    String birthdayGt;
    String birthdayLt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    public String getAgeGt() {
        return ageGt;
    }

    public void setAgeGt(String ageGt) {
        this.ageGt = ageGt;
    }

    public String getAgeLt() {
        return ageLt;
    }

    public void setAgeLt(String ageLt) {
        this.ageLt = ageLt;
    }

    public String getAgeGte() {
        return ageGte;
    }

    public void setAgeGte(String ageGte) {
        this.ageGte = ageGte;
    }

    public String getAgeLte() {
        return ageLte;
    }

    public void setAgeLte(String ageLte) {
        this.ageLte = ageLte;
    }

    public String getAgeEquals() {
        return ageEquals;
    }

    public void setAgeEquals(String ageEquals) {
        this.ageEquals = ageEquals;
    }

    public String getAgeIn() {
        return ageIn;
    }

    public void setAgeIn(String ageIn) {
        this.ageIn = ageIn;
    }

    public String getBirthdayGt() {
        return birthdayGt;
    }

    public void setBirthdayGt(String birthdayGt) {
        this.birthdayGt = birthdayGt;
    }

    public String getBirthdayLt() {
        return birthdayLt;
    }

    public void setBirthdayLt(String birthdayLt) {
        this.birthdayLt = birthdayLt;
    }

    public Test() {
        super();
    }

    @Override
    public String toString() {
        return "Test [name=" + name + ", age=" + age + ", birthday=" + birthday + ", nameLike=" + nameLike + ", ageGt=" + ageGt + ", ageLt=" + ageLt
                + ", ageGte=" + ageGte + ", ageLte=" + ageLte + ", ageEquals=" + ageEquals + ", ageIn=" + ageIn + ", birthdayGt=" + birthdayGt + ", birthdayLt="
                + birthdayLt + "]";
    }

}*/
