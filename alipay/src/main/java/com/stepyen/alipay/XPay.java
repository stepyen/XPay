package com.stepyen.alipay;
import android.app.Activity;
/**
 * date：2019/10/21
 * author：stepyen
 * description：
 */
public class XPay {
    private static XPay xPay;
    private Activity mContext;

    private XPay(Activity context) {
        mContext = context;
    }

    public static XPay getIntance(Activity context) {
        if (xPay == null) {
            synchronized (XPay.class) {
                if (xPay == null) {
                    xPay = new XPay(context);
                }
            }
        }
        return xPay;
    }

    public interface AliPayListener {
        //支付成功
        void onPaySuccess();

        //支付失败
        void onPayError(int error_code, String message);

        //支付取消
        void onPayCancel();
    }

    public void toAliPay(String payParameters, AliPayListener listener) {
        if (payParameters != null) {
            if (listener != null) {
                Alipay.getInstance(mContext).startAliPay(payParameters, listener);
            }
        } else {
            if (listener != null) {
                listener.onPayError(Alipay.PAY_PARAMETERS_ERROE, "参数异常");
            }
        }
    }
}
