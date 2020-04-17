package com.melvin.common.rx;

import com.melvin.base.bean.BaseResponse;
import com.melvin.base.bean.Optional;
import com.melvin.base.error.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

public class RxTransformer {

    /**
     * 用来过滤数据BaseResponse<T> to Optional<T>
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<BaseResponse<T>, Optional<T>> handleResult() {
        return upstream -> upstream.flatMap(new Function<BaseResponse<T>, ObservableSource<Optional<T>>>() {
            @Override
            public ObservableSource<Optional<T>> apply(BaseResponse<T> baseResponse) throws Exception {

                if (baseResponse.isRequestSuccess()) {
                    return createHttpData(baseResponse.transform());
                } else {
                    return Observable.error(new ApiException(baseResponse.getCode(), baseResponse.getMessage()));
                }

            }
        });
    }

    /**
     * 发送数据
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Observable<Optional<T>> createHttpData(Optional<T> t) {

        return Observable.create(e -> {
            try {
                e.onNext(t);
                e.onComplete();
            } catch (Exception exc) {
                e.onError(exc);
            }
        });
    }

    public static <T> Observable<T> sendObserverableData(T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {

                try {
                    if (!emitter.isDisposed()) {
                        emitter.onNext(t);
                        emitter.onComplete();
                    }
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }


}
