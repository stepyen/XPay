
# Xpay 
集成了支付宝、微信支付sdk  

## sdk依赖版本
 - 支付宝        
implementation (name: 'alipaySdk-15.6.4-20190611174359-noUtdid', ext: 'aar')
 - 微信  
 implementation 'com.tencent.mm.opensdk:wechat-sdk-android-with-mta:5.1.4'
 
 
 ## 下载依赖   
 
 1. 下载项目，依赖xpay_lib
 2. 在主project下的build.gradle添加如下
 ```
 allprojects {

    repositories {
       // 添加  
        flatDir {
            dirs 'libs', '../xpay_lib/libs'
        }
    }
}
 ```
 ## 使用 
 
 
 
 
 
 
 
