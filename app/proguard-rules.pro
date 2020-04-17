# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#---------------------------------1.实体类---------------------------------
# 在开发的时候我们可以将所有的实体类放在一个包内，这样我们写一次混淆就行了。


#----------------------------------------------------------------------------

#---------------------------------2.第三方包-------------------------------

#工行功能
-keep public class com.icbc.smartpos.deviceservice.aidl.**{*;}
-keep public class com.icbc.smartpos.transservice.aidl.**{*;}

#联迪pos
-keep public class landicorp.android.eptapi.**{*;}
-keep public class android.dualscreenmanager.aidl.**{*;}
-keep public class com.smartpos.dualscreen.**{*;}
-keep public class com.landicorp.idcard.pic.lib.**{*;}
-keep public class com.ivsign.android.IDCReader.**{*;}
-keep public class com.landicorp.idcard.reader.lib.**{*;}
-keep public class com.otg.idcard.**{*;}
-keep public class com.landicorp.**{*;}

#RxDownload
-keep public class zlc.season.rxdownload.**{*;}

#zxing
-dontwarn com.google.zxing.**
-keep public class com.google.zxing.** { *;}

#友盟
-keep public class com.umeng.** {*;}


#ARouter
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep public class com.alibaba.android.arouter.facade.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider
-keep class * implements com.alibaba.android.arouter.facade.template.IProvider

# Gson
-dontwarn com.google.gson.**
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** {*;}
-keep class com.google.gson.stream.** { *; }
-keep class com.google.** {
    <fields>;
    <methods>;
}

# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-keep class okhttp3.** { *;}
-keep class okio.** { *;}
-dontwarn sun.security.**
-keep class sun.security.** { *;}
-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn okio.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-dontwarn okhttp3.internal.platform.ConscryptPlatform

# Okio
-dontwarn com.squareup.**
-dontwarn okio.**
-keep public class org.codehaus.* { *; }
-keep public class java.nio.* { *; }
-keep class okio.** {*;}

#okserver-1.1.0
-keep class com.lzy.okserver.** { *;}

# RxJava RxAndroid
-dontwarn rx.**
-keep class rx.** { *; }
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

# ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#LRecyclerview
-dontwarn com.github.jdsjlzx.**
-keep class com.github.jdsjlzx.progressindicator.indicators.** { *; }

#retrofit2
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature, InnerClasses, EnclosingMethod
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
-keepattributes Exceptions
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
-dontwarn retrofit2.KotlinExtensions
-dontwarn org.robovm.**
-keep class org.robovm.** { *; }
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

#bottom tab
-keep class me.majiajie.pagerbottomtabstrip.**.{*;}

#log
-keep class com.orhanobut.logger.** {*;}

#RxPermission
-keep class com.tbruyelle.rxpermissions2.** {*;}

#RxRelay
-keep class com.jakewharton.rxrelay2.** {*;}

#RxBinding
-keep class com.jakewharton.rxbinding3.** {*;}

#base-adapter
-keep class com.zhy.** {*;}

#RxLife
-keep class com.trello.rxlifecycle3.** {*;}

#commons-lang
-keep class org.apache.commons.lang3.** {*;}

# EventBus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

#httpclient (org.apache.http.legacy.jar)
-dontwarn android.net.compatibility.**
-dontwarn android.net.http.**
-dontwarn com.android.internal.http.multipart.**
-dontwarn org.apache.commons.**
-dontwarn org.apache.http.**
-dontwarn org.apache.http.protocol.**
-keep class android.net.compatibility.**{*;}
#-keep class android.net.http.**{*;}
-keep class com.android.internal.http.multipart.**{*;}
-keep class org.apache.commons.**{*;}
-keep class org.apache.org.**{*;}
-keep class org.apache.harmony.**{*;}


-keep class org.reactivestreams.**.{*;}
-keep class org.hamcrest.**.{*;}

#jsoup
-dontwarn org.jsoup.**
-keep class org.jsoup.**.{*;}
-keeppackagenames org.jsoup.nodes



#GreenDao
#-keep class org.greenrobot.greendao.**{*;}
#-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
#public static java.lang.String TABLENAME;
#}
#-keep class **$Properties

# If you do not use SQLCipher:
#-dontwarn org.greenrobot.greendao.database.**
# If you do not use Rx:
#-dontwarn rx.**


#友盟
#-keep class com.umeng.** {*;}
#友盟分享
#-dontshrink
#-dontoptimize
#-dontwarn com.google.android.maps.**
#-dontwarn android.webkit.WebView
#-dontwarn com.umeng.**
#-dontwarn com.tencent.weibo.sdk.**
#-dontwarn com.facebook.**
#-keep public class javax.**
#-keep public class android.webkit.**
#-dontwarn android.support.v4.**
#-keep enum com.facebook.**
#-keepattributes Exceptions,InnerClasses,Signature
#-keepattributes *Annotation*
#-keepattributes SourceFile,LineNumberTable
#
#-keep public interface com.facebook.**
#-keep public interface com.tencent.**
#-keep public interface com.umeng.socialize.**
#-keep public interface com.umeng.socialize.sensor.**
#-keep public interface com.umeng.scrshot.**
#
#-keep public class com.umeng.socialize.* {*;}
#
#
#-keep class com.facebook.**
#-keep class com.facebook.** { *; }
#-keep class com.umeng.scrshot.**
#-keep public class com.tencent.** {*;}
#-keep class com.umeng.socialize.sensor.**
#-keep class com.umeng.socialize.handler.**
#-keep class com.umeng.socialize.handler.*
#-keep class com.umeng.weixin.handler.**
#-keep class com.umeng.weixin.handler.*
#-keep class com.umeng.qq.handler.**
#-keep class com.umeng.qq.handler.*
#-keep class UMMoreHandler{*;}
#-keep class com.tencent.mm.sdk.modelmsg.WXMediaMessage {*;}
#-keep class com.tencent.mm.sdk.modelmsg.** implements com.tencent.mm.sdk.modelmsg.WXMediaMessage$IMediaObject {*;}
#-keep class im.yixin.sdk.api.YXMessage {*;}
#-keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}
#-keep class com.tencent.mm.sdk.** {
#   *;
#}
#-keep class com.tencent.mm.opensdk.** {
#   *;
#}
#-keep class com.tencent.wxop.** {
#   *;
#}
#-keep class com.tencent.mm.sdk.** {
#   *;
#}
#-dontwarn twitter4j.**
#-keep class twitter4j.** { *; }
#
#-keep class com.tencent.** {*;}
#-dontwarn com.tencent.**
#-keep class com.kakao.** {*;}
#-dontwarn com.kakao.**
#-keep public class com.umeng.com.umeng.soexample.R$*{
#    public static final int *;
#}
#-keep public class com.linkedin.android.mobilesdk.R$*{
#    public static final int *;
#}
#-keepclassmembers enum * {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}
#
#-keep class com.tencent.open.TDialog$*
#-keep class com.tencent.open.TDialog$* {*;}
#-keep class com.tencent.open.PKDialog
#-keep class com.tencent.open.PKDialog {*;}
#-keep class com.tencent.open.PKDialog$*
#-keep class com.tencent.open.PKDialog$* {*;}
#-keep class com.umeng.socialize.impl.ImageImpl {*;}
#-keep class com.sina.** {*;}
#-dontwarn com.sina.**
#-keep class  com.alipay.share.sdk.** {
#   *;
#}
#
#-keepnames class * implements android.os.Parcelable {
#    public static final ** CREATOR;
#}
#
#-keep class com.linkedin.** { *; }
#-keep class com.android.dingtalk.share.ddsharemodule.** { *; }
#-keepattributes Signature

# 友盟统计分析
#-keepclassmembers class * { public <init>(org.json.JSONObject); }
#-keepclassmembers enum com.umeng.analytics.** {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}

# Bugly
#-dontwarn com.tencent.bugly.**
#-keep class com.tencent.bugly.** {*;}


#七牛
#-keep class com.qiniu.**{*;}
#-keep class com.qiniu.**{public <init>();}
#-ignorewarnings

#FlycoTablelayout
#-keep class com.flyco.tablayout.**.{*;}

#BGAbanner
#-keep class cn.bingoogolapple,bgabanner.**.{*;}

#convenientbanner
#-keep class com.bigkoo.convenientbanner.**.{*;}


#ForAndroid7
#-keep class com.melvin.android7.**.{*;}

#Hawk
#-keep class com.orhanobut.hawk.**.{*;}

#侧滑页面slide
#-keep class com.r0adkll.slidr.**.{*;}


#支付宝
#-keep class com.alipay.android.app.IAlixPay{*;}
#-keep class com.alipay.android.app.IAlixPay$Stub{*;}
#-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
#-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
#-keep class com.alipay.sdk.app.PayTask{ public *;}
#-keep class com.alipay.sdk.app.AuthTask{ public *;}
#-keep class com.alipay.sdk.app.H5PayCallback {
#    <fields>;
#    <methods>;
#}
#-keep class com.alipay.android.phone.mrpc.core.** { *; }
#-keep class com.alipay.apmobilesecuritysdk.** { *; }
#-keep class com.alipay.mobile.framework.service.annotation.** { *; }
#-keep class com.alipay.mobilesecuritysdk.face.** { *; }
#-keep class com.alipay.tscenter.biz.rpc.** { *; }
#-keep class org.json.alipay.** { *; }
#-keep class com.alipay.tscenter.** { *; }
#-keep class com.ta.utdid2.** { *;}
#-keep class com.ut.device.** { *;}

# 极光推送
#-dontoptimize
#-dontpreverify
#
#-dontwarn cn.jpush.**
#-keep class cn.jpush.** { *; }
#-keep class * extends cn.jpush.android.helpers.JPushMessageReceiver { *; }
#
#-dontwarn cn.jiguang.**
#-keep class cn.jiguang.** { *; }

# photoView
#-keep class com.bm.library.** { *;}

#pickerview
#-keep class coom.bigkoo.pickerview.** { *;}
#-keep class com.google.android.gms.** { *;}

#magicIndicator
#-keep class net.lucode.hackware.magicindicator.**{ *;}


# AndPermission
#-keepclassmembers class ** {
#    @com.yanzhenjie.permission.PermissionYes <methods>;
#}
#-keepclassmembers class ** {
#    @com.yanzhenjie.permission.PermissionNo <methods>;
#}

#pinyin4j
#-dontwarn net.soureceforge.pinyin4j.**
#-dontwarn demo.**
#-libraryjars src/libs/pinyin4j-2.5.0.jar
#-keep class net.sourceforge.pinyin4j.** { *;}
#-keep class demo.** { *;}
#-keep class com.hp.** { *;}

# FastJson
#-dontwarn com.alibaba.fastjson.**
#-keep class com.alibaba.fastjson.** { *; }
#-keepattributes Signature
#-keepattributes *Annotation*

# 高德相关依赖
# 集合包:3D地图3.3.2 导航1.8.0 定位2.5.0
#-dontwarn com.amap.api.**
#-dontwarn com.autonavi.**
#-dontwarn com.loc.**
#-keep class com.amap.api.**{*;}
#-keep class com.autonavi.**{*;}
#-keep class com.loc.**{*;}
# 地图服务
#-dontwarn com.amap.api.services.**
#-keep class com.map.api.services.** {*;}
# 3D地图
#-dontwarn com.amap.api.mapcore.**
#-dontwarn com.amap.api.maps.**
#-dontwarn com.autonavi.amap.mapcore.**
#-keep class com.amap.api.mapcore.**{*;}
#-keep class com.amap.api.maps.**{*;}
#-keep class com.autonavi.amap.mapcore.**{*;}
# 定位
#-dontwarn com.amap.api.location.**
#-dontwarn com.aps.**
#-keep class com.amap.api.location.**{*;}
#-keep class com.aps.**{*;}
# 导航
#-dontwarn com.amap.api.navi.**
#-dontwarn com.autonavi.**
#-keep class com.amap.api.navi.** {*;}
#-keep class com.autonavi.** {*;}

#swipeLayout
#-dontwarn com.daimajia.swipe.**
#-keep class com.daimajia.swipe.** {*;}



#refresh
#-dontwarn com.handmark.pulltorefresh.library.**
#-keep class com.handmark.pulltorefresh.library.** {*;}

#PhotoPicker
#-dontwarn me.iwf.photopicker.**
#-keep class me.iwf.photopicker.**{*;}

#nineoldandroids
#-dontwarn com.nineoldandroids.*
#-keep class com.nineoldandroids.** { *;}


#xhttp
#-keep class com.android.anqiansong.**{ *;}



#imageLoader
#-dontwarn com.nostra13.universalimageloader.**
#-keep class com.nostra13.universalimageloader.** {*;}



#autolayout
#-keep class com.zhy.autolayout.** { *;}

#core
#-keep class com.afollested.materialdialogs.** { *;}

#library1.3.0
#-keep class me.zhanghai.android.materialprogressbar.** { *;}



#multidex-1.0.1
#-keep class android.support.multidex.** { *;}

#multidex-instrumentation-1.0.1
#-keep class android.support.multidex.instrumentation.** { *;}
#-keep class com.android.test.runner.** { *;}

#okgo-2.0.0
#-keep class com.lzy.okgo.** { *;}


#-libraryjars libs/第三方jar包
#-libraryjars libs/AMap_Location_V3.1.0_20161027.jar
#-libraryjars libs/AMap_Search_V3.6.0_20161110.jar
#-libraryjars libs/AMap_Map3D_SDK_V4.1.2_20161104.jar
#-libraryjars libs/AndroidSwipeLayout_v1.1.8.jar
#-libraryjars libs/libammsdk.jar
#-libraryjars libs/pinyin4j-2.5.0.jar
#-libraryjars libs/RxAndroid.jar
#-libraryjars libs/universal-image-loader-1.9.5.jar
#-libraryjars libs/zxing.jar
#-libraryjars libs/armeabi/libgdinamapv4sdk752.so
#-libraryjars libs/armeabi/libgdinamapv4sdk752ex.so
#-libraryjars libs/armeabi/arm64-v8a/libgdinamapv4sdk752.so
#-libraryjars libs/armeabi/arm64-v8a/libgdinamapv4sdk752ex.so

# 百度地图（jar包换成自己的版本，记得签名要匹配）
#-libraryjars libs/baidumapapi_v2_1_3.jar
#-keep class com.baidu.** {*;}
#-keep class vi.com.** {*;}
#-keep class com.sinovoice.** {*;}
#-keep class pvi.com.** {*;}
#-dontwarn com.baidu.**
#-dontwarn vi.com.**
#-dontwarn pvi.com.**

#baidu
#-keep class com.baidu.** { *; }
#-dontwarn com.baidu.**


# Facebook
#-keep class com.facebook.** {*;}
#-keep interface com.facebook.** {*;}
#-keep enum com.facebook.** {*;}

# Fresco
#-keep class com.facebook.fresco.** {*;}
#-keep interface com.facebook.fresco.** {*;}
#-keep enum com.facebook.fresco.** {*;}

# Jackson
#-dontwarn org.codehaus.jackson.**
#-dontwarn com.fasterxml.jackson.databind.**
#-keep class org.codehaus.jackson.** { *;}
#-keep class com.fasterxml.jackson.** { *; }





# OrmLite
#-keepattributes *DatabaseField*
#-keepattributes *DatabaseTable*
#-keepattributes *SerializedName*
#-keep class com.j256.**
#-keepclassmembers class com.j256.** { *; }
#-keep enum com.j256.**
#-keepclassmembers enum com.j256.** { *; }
#-keep interface com.j256.**
#-keepclassmembers interface com.j256.** { *; }

# Realm
#-keep class io.realm.annotations.RealmModule
#-keep @io.realm.annotations.RealmModule class *
#-keep class io.realm.internal.Keep
#-keep @io.realm.internal.Keep class * { *; }
#-dontwarn javax.**
#-dontwarn io.realm.**

# Retrolambda
#-dontwarn java.lang.invoke.*

# 微信支付
#-dontwarn com.tencent.mm.**
#-dontwarn com.tencent.wxop.stat.**
#-keep class com.tencent.mm.** {*;}
#-keep class com.tencent.wxop.stat.**{*;}

# 信鸽
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep class com.tencent.android.tpush.**  {* ;}
#-keep class com.tencent.mid.**  {* ;}
#-keepattributes *Annotation*

# 新浪微博
#-keep class com.sina.weibo.sdk.* { *; }
#-keep class android.support.v4.* { *; }
#-keep class com.tencent.* { *; }
#-keep class com.baidu.* { *; }
#-keep class lombok.ast.ecj.* { *; }
#-dontwarn android.support.v4.**
#-dontwarn com.tencent.**s
#-dontwarn com.baidu.**

# 讯飞语音
#-dontwarn com.iflytek.**
#-keep class com.iflytek.** {*;}

# 银联
#-dontwarn com.unionpay.**
#-keep class com.unionpay.** { *; }



# 友盟自动更新
#-keepclassmembers class * { public <init>(org.json.JSONObject); }
#-keep public class cn.irains.parking.cloud.pub.R$*{ public static final int *; }
#-keep public class * extends com.umeng.**
#-keep class com.umeng.** { *; }


#topsnackbar
#-dontwarn com.androidadvance.topsnackbar.**
#-keep class com.androidadvance.topsnackbar.**{*;}




#----------------------------------------------------------------------------

#---------------------------------3.与js互相调用的类------------------------

#-keepclassmembers class xx.xx.xx.xxx$InJavaScriptLocalObj { #解决webview和js的交互问题
# public *;
#}
#-keepattributes JavascriptInterface

#其中的xx.xx.xx.xxx换成自己的完整包名，如果是内部类使用了webview与js的交互功能，则需要添加“$”后面跟着的是内部类名，
#例如：xx.xx.xx.xxx$InJavaScriptLocalObj；如果不使用内部类，直接xx.xx.xx.xxx就可以了。
#-keepattributes JavascriptInterface是解决：
#“android sdk api >= 17 时需要加@JavascriptInterface”所出现的问题。

# 与JS交互
-keepattributes SetJavaScriptEnabled
-keepattributes JavascriptInterface

# 保留与JS交互接口 , API17+
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}


#-------------------------------------------------------------------------

#---------------------------------4.反射相关的类和方法-----------------------



#----------------------------------------------------------------------------


#-------------------------------------------基本不用动区域--------------------------------------------
# 对于一些基本指令的添加
#
#############################################
# 代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5

# 混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames

# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses

# 这句话能够使我们的项目混淆后产生映射文件
# 包含有类名->混淆后类名的映射关系
-verbose
-printmapping proguardMapping.txt

# 指定不去忽略非公共库的类成员
-dontskipnonpubliclibraryclassmembers

# 不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。
-dontpreverify

-dontoptimize

# 保留Annotation不混淆
-keepattributes *Annotation*,InnerClasses

# 避免混淆泛型
-keepattributes Signature

# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

-ignorewarnings

# 指定混淆是采用的算法，后面的参数是一个过滤器
# 这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !roomStateCode/simplification/cast,!field/*,!class/merging/*

#----------------------------------------------------------------------------
#---------------------------------默认保留区---------------------------------
# 保留我们使用的四大组件，自定义的Application等等这些类不被混淆
# 因为这些子类都有可能被外部调用
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Appliction
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends android.os.IInterface

#androidX混淆
-keep class com.google.android.material.** {*;}
-keep class androidx.** {*;}
-keep public class * extends androidx.**
-keep interface androidx.** {*;}
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**
-dontwarn androidx.**

# 保留support下的所有类及其内部类
-keep class android.support.** {*;}

# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**

# 保留R下面的资源
-keep class **.R$* {*;}
#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}

# 保留本地native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# 保留在Activity中的方法参数是view的方法，
# 这样以来我们在layout中写的onClick就不会被影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}


# 保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保留我们自定义控件（继承自View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclasseswithmembers class * { # 保持自定义控件类不被混淆
 public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {# 保持自定义控件类不被混淆
 public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity { # 保持自定义控件类不被混淆
 public void *(android.view.View);
}

# 保留Parcelable序列化类不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# 保留Serializable序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#####################记录生成的日志数据,gradle build时在本项目根目录输出################



#apk 包内所有 class 的内部结构

-dump class_files.txt

#未混淆的类和成员

-printseeds seeds.txt

#列出从 apk 中删除的代码

-printusage unused.txt

#混淆前后的映射

-printmapping mapping.txt



#####################记录生成的日志数据，gradle build时 在本项目根目录输出-end################

# 移除Log类打印各个等级日志的代码，打正式包的时候可以做为禁log使用，这里可以作为禁止log打印的功能使用
# 记得proguard-android.txt中一定不要加-dontoptimize才起作用
# 另外的一种实现方案是通过BuildConfig.DEBUG的变量来控制
#-assumenosideeffects class android.util.Log {
#    public static int v(...);
#    public static int i(...);
#    public static int w(...);
#    public static int d(...);
#    public static int e(...);
#}

#不混淆反射用到的类
-keepattributes Signature
-keepattributes EnclosingMethod


#---------------------------------webview------------------------------------

# webView处理，项目中没有使用到webView忽略即可
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
    public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

#----------------------------------------------------------------------------