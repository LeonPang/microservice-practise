package com.pl.microservicegatewayzuul;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * Created by 庞亮 on 2017/9/21.
 */
@RestController
public class AggregationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AggregationController.class);

    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String,User>> aggregate(@PathVariable Long id){
        Observable<HashMap<String,User>> result = this.aggregateObservable(id);
        return this.toDeferredResult(result);
    }

    public Observable<HashMap<String,User>> aggregateObservable(Long id){
        return Observable.zip(
            this.aggregationService.getMovieUserById(id),this.aggregationService.getMovieUserById(id),
                (user,movieUser) -> {
                    HashMap<String,User> map = Maps.newHashMap();
                    map.put("user",user);
                    map.put("movieUser",movieUser);
                    return map;
            }
        );
    }

    public DeferredResult<HashMap<String,User>> toDeferredResult(Observable<HashMap<String,User>> details){
        DeferredResult<HashMap<String,User>> result = new DeferredResult<HashMap<String,User>>();
        details.subscribe(new Observer<HashMap<String,User>>(){
            @Override
            public void onCompleted() {
                LOGGER.info("complete");
            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.error("error",throwable);
            }

            @Override
            public void onNext(HashMap<String, User> stringUserHashMap) {
                result.setResult(stringUserHashMap);
            }
        });
        return result;
    }
}
