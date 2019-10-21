package com.stepyen.wechatpay;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
/**
 * date：2019/10/21
 * author：stepyen
 * description：
 */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (WeChatPay.getInstance(this) != null) {
            WeChatPay.getInstance(this).getWXApi().handleIntent(getIntent(), this);
        } else {
            finish();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (WeChatPay.getInstance(this) != null) {
            WeChatPay.getInstance(this).getWXApi().handleIntent(intent, this);
        }
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        //4、支付结果回调 https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=8_5
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            if (WeChatPay.getInstance(this) != null) {
                if (baseResp.errStr != null) {
                    Log.e("weiXinPay", "errStr=" + baseResp.errStr);
                }
                WeChatPay.getInstance(this).onResp(baseResp.errCode, baseResp.errStr);
                finish();
            }
        }
    }
}
