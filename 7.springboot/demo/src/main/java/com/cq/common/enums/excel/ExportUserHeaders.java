/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.excel;

import com.cq.common.enums.ExportExcelEnumInterface;

/**
 * <p>
 * 类描述:人员档案页面导出excel字段名
 * </p>
 *
 * @since 2018年10月8日
 * @author chengq
 */
public enum ExportUserHeaders implements ExportExcelEnumInterface {

    /** 员工编号 **/
    USERNO(" userNo", ExcelDataType.STRING.getCode()),

    /** 中文姓名 **/
    USERNAME("userName", ExcelDataType.STRING.getCode()),

    /** 花名/英文名 **/
    ENGLISHNAME("englishName", ExcelDataType.STRING.getCode()),

    /** 证件号码 **/
    IDCARDNO("idCardNo", ExcelDataType.STRING.getCode()),

    /** 出生日期 **/
    BIRTHDATE(" birthdate", ExcelDataType.STRING.getCode()),

    /** 性别 **/
    SEX("sex", ExcelDataType.STRING.getCode()),

    /** 系统帐号 **/
    USERCODE("userCode", ExcelDataType.STRING.getCode()),

    /** 所属公司 **/
    COMPANYNAME("companyName", ExcelDataType.STRING.getCode()),

    /** 所属部门 **/
    MAINDEPARTNAME("mainDepartName", ExcelDataType.STRING.getCode()),

    /** 所属班组/所属团队 **/
    CLASSNAME("className", ExcelDataType.STRING.getCode()),

    /** 入职日期 **/
    ENTRYDATE("entryDate", ExcelDataType.STRING.getCode()),

    /** 试用期/实习期（月） **/
    PROBATIONARYPERIOD("probationaryPeriod", ExcelDataType.STRING.getCode()),

    /** 延迟转正（天） **/
    DELAYDAY(" delayDay", ExcelDataType.STRING.getCode()),

    /** 转正日期 **/
    REGULARDATE("regularDate", ExcelDataType.STRING.getCode()),

    /** 是否在编 0否，1是 **/
    ISORGANISED("isOrganised", ExcelDataType.STRING.getCode()),

    /** 离职日期 **/
    LEAVEDATE("leaveDate", ExcelDataType.STRING.getCode()),

    /** 直属上级 **/
    LEADER(" leader", ExcelDataType.STRING.getCode()),

    /** 直属下级 **/
    SUBORDINATE("subordinate", ExcelDataType.STRING.getCode()),

    /** 任职类型 **/
    JOBCATEGORY("jobCategory", ExcelDataType.STRING.getCode()),

    /** 人员类别 **/
    USERCATEGORY("userCategory", ExcelDataType.STRING.getCode()),

    /** 人员状态 **/
    USERSTATUS("userStatus", ExcelDataType.STRING.getCode()),

    /** 籍贯 **/
    BIRTHPLACE("birthPlace", ExcelDataType.STRING.getCode()),

    /** 技能特长 **/
    USERSPECIALLIST("userSpecialList", ExcelDataType.STRING.getCode()),

    /** 手机号码 **/
    PHONE(" phone", ExcelDataType.STRING.getCode()),

    /** QQ号 **/
    QQ("qq", ExcelDataType.STRING.getCode()),

    /** 办公号码 **/
    OFFICEPHONE("officePhone", ExcelDataType.STRING.getCode()),

    /** 邮箱 **/
    MAIL("mail", ExcelDataType.STRING.getCode()),

    /** 最高学历 **/
    EDUCATIONLEVEL("educationLevel", ExcelDataType.STRING.getCode()),

    /** 专业 **/
    MAJOR("major", ExcelDataType.STRING.getCode()),

    /** 毕业学校 **/
    SCHOOL("school", ExcelDataType.STRING.getCode()),

    /** 毕业时间 **/
    ENDDATE(" endDate", ExcelDataType.STRING.getCode()),

    /** 年龄 **/
    AGE("age", ExcelDataType.STRING.getCode()),

    /** 司龄 **/
    ENTRYAGE("entryAge", ExcelDataType.STRING.getCode()),

    /** 参加工作日期 **/
    STARTWORKDATE("startworkDate", ExcelDataType.STRING.getCode()),

    /** 社会工龄 **/
    SOCIALAGE("socialAge", ExcelDataType.STRING.getCode()),

    /** 婚姻情况 默认0 未婚0、已婚1、离婚2、丧偶3、不详4 **/
    MARITALSTATUS("maritalStatus", ExcelDataType.STRING.getCode()),

    /** 孕育状况 默认0 未育0、已育1 **/
    PREGNANTSTATUS("pregnantStatus", ExcelDataType.STRING.getCode()),

    /** 户口类别 默认0 本地城镇0、外地城镇1、本地农村2、外地农村3 **/
    ACCOUNTCATEGORY(" accountCategory", ExcelDataType.STRING.getCode()),

    /** 户口所在地 **/
    ACCOUNTADDRESS("accountAddress", ExcelDataType.STRING.getCode()),

    /** 民族 **/
    NATION("nation", ExcelDataType.STRING.getCode()),

    /** 政治面貌 默认0 群众0、共青团员1、中共党员2、中共预备党员3、民主党派4 **/
    POLITICSSTATUS("politicsStatus", ExcelDataType.STRING.getCode()),

    /** 入党日期 **/
    JOINPARTYDATE("joinPartyDate", ExcelDataType.STRING.getCode()),

    /** 兴趣爱好 **/
    HOBBY("hobby", ExcelDataType.STRING.getCode()),

    /** 现居住地址 **/
    ADDRESS("address", ExcelDataType.STRING.getCode()),

    /** 家庭地址 **/
    HOMEADDRESS("homeAddress", ExcelDataType.STRING.getCode()),

    /** 入职体检日期 **/
    PHYSICALDATE(" physicalDate", ExcelDataType.STRING.getCode()),

    /** 入职培训日期 **/
    TRAINDATE("trainDate", ExcelDataType.STRING.getCode()),

    /** 招聘渠道：0社招，1校招 **/
    RECRUITCHANNEL("recruitChannel", ExcelDataType.STRING.getCode()),

    /** 招聘方式：招聘网站0、官方邮箱1、内推2、同业推荐3、猎头4、招聘会5、宣讲会6 **/
    RECRUITTYPE("recruitType", ExcelDataType.STRING.getCode()),

    /** 内推人姓名 **/
    PUSHUSERNAME("pushUsername", ExcelDataType.STRING.getCode()),

    /** 与内推人关系 **/
    PUSHRELATION("pushRelation", ExcelDataType.STRING.getCode()),

    /** 备注 **/
    MEMO("memo", ExcelDataType.STRING.getCode());

    private String dbName;
    private Integer dataType;

    @Override
    public String getDbName() {
        return dbName;
    }

    /**
     *
     * @param dbName
     *            需要设置的dbName
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public Integer getDataType() {
        return dataType;
    }

    /**
     *
     * @param dataType
     *            需要设置的dataType
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     *
     * @param dbName
     *            需要设置的dbName
     * @param dataType
     *            需要设置的dataType
     */
    ExportUserHeaders(String dbName, Integer dataType) {
        this.dbName = dbName;
        this.dataType = dataType;
    }

}
