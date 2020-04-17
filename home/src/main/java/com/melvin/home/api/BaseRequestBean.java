package com.melvin.home.api;

public class BaseRequestBean<T> {
    //后端记录用ID
    private String serviceId;
    private T data;
    //设备唯一号
    private String devUniqueNo;
    //设备型号
    private String devModel;
    //系统平台  android
    private String platform;
    //系统版本
    private String devOsVer;
    //app版本
    private String appVer;
    //随机串
    private String echostr;
    //时间戳
    private String timestamp;
    //签名
    private String sign;
    //重试字段，有效期内，相同则返回相同结果
    private String retryKey;
    //调用接口方法对应code
    private String method;
    //酒店名称
    private String hotelName;
    //是2020还是2014
    private String pmsType;


    public BaseRequestBean() {
        initBaseParameters();
    }

    private void initBaseParameters() {
        //用wifi mac作为设备唯一号
//        devUniqueNo = DeviceInfo.getDeviceUniqueNo();
//        devModel = DeviceInfo.getModel();
//        platform = "android";
//        devOsVer = DeviceInfo.getOSRelease();
//        appVer = DeviceInfo.getVersionName();
//        echostr = String.valueOf(RandomUtils.nextInt(1000, 9999));
//        timestamp = DateUtils.getStamp(DateUtils.FORMAT_YYYYMMDDHHmmss, new Date());

    }

    /**
     * 用除data外的参数获取md5值
     */
    public void generateSign(String apiKey, String salt, String echostr) {
//        StringBuilder result = new StringBuilder();
//        result.append(serviceId).append(devUniqueNo).append(devModel).append(platform).append(devOsVer)
//                .append(appVer).append(echostr).append(timestamp).append(retryKey).append(method).append(hotelName);

//        sign = SignUtil.getSign(apiKey, salt, echostr);
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDevUniqueNo() {
        return devUniqueNo;
    }

    public void setDevUniqueNo(String devUniqueNo) {
        this.devUniqueNo = devUniqueNo;
    }

    public String getDevModel() {
        return devModel;
    }

    public void setDevModel(String devModel) {
        this.devModel = devModel;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDevOsVer() {
        return devOsVer;
    }

    public void setDevOsVer(String devOsVer) {
        this.devOsVer = devOsVer;
    }

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRetryKey() {
        return retryKey;
    }

    public void setRetryKey(String retryKey) {
        this.retryKey = retryKey;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPmsType() {
        return pmsType;
    }

    public void setPmsType(String pmsType) {
        this.pmsType = pmsType;
    }

    @Override
    public String toString() {
        return "BaseRequestBean{" +
                "serviceId='" + serviceId + '\'' +
                ", data=" + data +
                ", devUniqueNo='" + devUniqueNo + '\'' +
                ", devModel='" + devModel + '\'' +
                ", platform='" + platform + '\'' +
                ", devOsVer='" + devOsVer + '\'' +
                ", appVer='" + appVer + '\'' +
                ", echostr='" + echostr + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", sign='" + sign + '\'' +
                ", retryKey='" + retryKey + '\'' +
                ", method='" + method + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", pmsType='" + pmsType + '\'' +
                '}';
    }
}
