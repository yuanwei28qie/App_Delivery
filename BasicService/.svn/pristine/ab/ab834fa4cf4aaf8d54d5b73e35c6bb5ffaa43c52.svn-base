package com.microsilver.mrcard.basicservice.model.enums;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.model.enums.EWarning
 * @Description 
 * 
 * @Author bruce
 * @Version 2017年6月30日 上午10:31:53
 * @Copyright Micro Silver
 *
 */
public enum EWarning {
	Unknown("未知错误",1000),
	
	NonExistent("账号不存在",1001), 
	PasswordError("密码错误",1002),
	SendCheckCodeError("发送验证码错误",1003),
	CheckCodeError("验证码不正确",1004),
	NoBusnessUser("该账号不是商业账号",1017),
	CheckCodeNonExistent("没有查询到验证码",1005),
	CheckCode_Overdue("验证码已过期 ",1006),
	Order_ErrorStatus("订单状态错误",1007),
	MobileExist("手机号已存在",1008),
	MobileNotRegister("手机号未注册",1018),
	Order_Overdue("订单已过期 ",1019),
	Order_Repeat_Payment("订单重复支付",1020),

	
	NotExistMerch("商户不存在",1009),
    MerchInfoException("商户信息异常",1015),
    MerchCardException("银行卡信息异常",1016),
	
	RoomNotEnough("房源不足",1010),
	ErrorAmount("总金额错误",1011),
	NotExistRoom("房间不存在",1012),
	ActivityNotStart("活动未开始",1013),
	TotalAmountMustGreatThanZero("总金额必须大于零",1014),
	
	DisableAccount("账号被禁用",9001),
	ErrorIdentity("请先实名认证",9003),
	ErrorParams("参数错误",9002),
	ErrorStatus("账户状态错误",9004),
	
	UnfinishedOrder("您有未完成的订单",2001),
	UnCommentOrder("您有未评价的订单",2002),
	Order_NonExistent("订单不存在",2003),
	Order_LogException("订单操作日志异常",2004),
	Order_ADDTIP_Exception("添加小费出错",2005),

	FINANCE_EXCEPTION("财务异常",6001),
    SHOPCASH_EXCEPTION("会员提现出错",6002),
    DefaultAccountException("默认提现账号多于一个",6003),
    WithdrawMustMoreThanZero("提现金额必须大于零",6004),
    None_WithdrawCard("未绑定提现账号",6005),
    WITHDRAW_EXCEED_LIMIT("今天提现金额超出限制",6006),
	
	Too_Slow("手慢啦!",10086),
	
	;
    protected String name;
    protected int value;

    private EWarning(String name, int value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static EWarning valueOf(int value){
        switch (value) {
            case 1001:
                return NonExistent ;
            case 2002:
                return PasswordError ;
            
            default:
                return Unknown ;
        }
    }
}
