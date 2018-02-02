package design.root.api;

import android.os.Build;
import android.support.annotation.RequiresApi;

import design.root.Constant;
import design.root.entity.HttpMessage;
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
