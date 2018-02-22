package com.tzduan.base.api;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.reflect.ParameterizedType;

import com.tzduan.base.Constant;
import com.tzduan.base.entity.HttpMessage;
import com.tzduan.base.util.InstanceUtil;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2018/2/1.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
class ResultFilter<T> implements Function<HttpMessage<T>, T> {

    @Override
    public T apply(HttpMessage<T> tHttpMessage) throws Exception {
        switch (tHttpMessage.getReturnCode()) {
            case Constant.RETURN_CODE.SERVER_OK: {
                if (null == tHttpMessage.getReturnData()) {
                    Class mReturnDataClass = (Class) ((ParameterizedType) (this.getClass()
                            .getGenericSuperclass())).getActualTypeArguments()[0];
                    return InstanceUtil.getInstance(mReturnDataClass);
                }
                return tHttpMessage.getReturnData();
            }
            case Constant.RETURN_CODE.SERVER_ERR: {
                throw new ApiException.IO(tHttpMessage.getReturnCode(), tHttpMessage
                        .getReturnInfo());
            }
            default: {
                throw new ApiException.API(tHttpMessage.getReturnCode(), tHttpMessage
                        .getReturnInfo());
            }
        }
    }
}
