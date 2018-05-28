package com.microsilver.mrcard.basicservice.model.enums;


public enum EWarning {
	Unknown("未知错误",1000),
	
	NonExistent("账号不存在",1001), 
	PasswordError("密码错误",1002),
	SendCheckCodeError("发送验证码错误",1003),
	CheckCodeError("验证码不正确",1004),
	CheckCodeNonExistent("没有查询到验证码",1005),
	CheckCode_Overdue("验证码已过期 ",1006),
	Order_ErrorStatus("订单状态错误",1007),
	MobileExist("手机号已存在",1008),
	MobileRegistered("手机已注册",1009),
	NoGetCheckCode("为获取到验证码,请联系管理员",1010),
	CheckCodeTypeNotSame("验证码类型不一致",1043),
	MessageIsNull("你输入的信息为空",1011),
	PhoneIsNull("手机号为空",1012),
	CheckCodeIsNull("验证码为空",1013),
	NoUserOfAddress("无该用户或者该用户的地址信息",1014),
	UserNoAddress("该用户无地址可使用",1015),
	MobileNotRegister("手机号未注册",1018),
	Order_Overdue("订单已过期 ",1019),
	Order_Repeat_Payment("订单重复支付",1020),
	NoOrderInfo("无订单信息",1021),
	CardNotSame("身份证信息不一致",1022),
	NotType("无该类型",1023),
	NoAreaMsg("无区域信息",1024),
	MobileNotConformingToSpecifications("电话不符合规格",1025),
	UninitializedVersion("未初始化版本",1026),
	NotPerfectData("未完善资料",1027),
	RobbOrderError("抢单失败",1028),
	OperationFailed("操作失败",1029),
	AliPayAccountError("支付宝信息不正确",1030),
	BalanceNotEnough("余额不足",1031),
	NoFinanceMsg("无财务信息",1032),
	NotWithDrawDate("不在提现日期内",1033),
	OrderAccountError("订单金额错误",1034),
	DispatchError("运费不一致",1035),
	NoFinance("无财务信息",1036),
	DeliveryDisable("骑手已禁用",1037),
	PlatFormNoFinanceMsg("平台无财务信息",1038),
	DeliveryNoFinanceMsg("骑手无财务信息",1039),
	AgentNoFinanceMsg("代理商无财务信息",1040),
	NoDeliveryServiceScore("无骑手服务分",1041),
	ErrorParams("参数错误",9002),
	NoAgent("无代理商信息",1042),

	
	
	
	
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
