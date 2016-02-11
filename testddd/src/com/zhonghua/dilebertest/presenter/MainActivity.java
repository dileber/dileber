package com.zhonghua.dilebertest.presenter;

import android.os.Bundle;
import android.view.View;
import com.zhonghua.dileber.mvp.presenter.ActivityPresenter;
import com.zhonghua.dileber.tools.SLog;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.MainViewDelegate;
import com.zhonghua.dilebertest.scm.IMainScm;
import com.zhonghua.dilebertest.scm.MainScm;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends ActivityPresenter<MainViewDelegate>  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IMainScm mainSrc = new MainScm();

        //如下是同步  哈皮

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                SLog.d("sss", "Item: " + s);
            }

            @Override
            public void onCompleted() {
                SLog.d("sss", "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                SLog.d("sss", "Error!");
            }};


        //扩展
        Subscriber<String> subscriber = new Subscriber<String>() {
            //可以用于做一些准备工作，例如数据的清零或重置
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onNext(String s) {
                SLog.d("sss", "Item: " + s);
            }

            @Override
            public void onCompleted() {
                SLog.d("sss", "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                SLog.d("sss", "Error!");
            }
        };

        //是否持有
        subscriber.isUnsubscribed();
        //取消持有
        subscriber.unsubscribe();


        //可以看到，这里传入了一个 OnSubscribe 对象作为参数。OnSubscribe
        // 会被存储在返回的 Observable 对象中，它的作用相当于一个计划表，
        // 当 Observable 被订阅的时候，OnSubscribe 的 call() 方法会自动被调用，
        // 事件序列就会依照设定依次触发（对于上面的代码，就是观察者Subscriber
        // 将会被调用三次 onNext() 和一次 onCompleted()）。这样，
        // 由被观察者调用了观察者的回调方法，就实现了由被观察者向观察者的事件传递，即观察者模式。

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

        Observable observable3 = Observable.just("Hello", "Hi", "Aloha");
// 将会依次调用：
// onNext("Hello");
// onNext("Hi");
// onNext("Aloha");
// onCompleted();

        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable38 = Observable.from(words);

// 创建了 Observable 和 Observer 之后，再用 subscribe() 方法将它们联结起来，整条链子就可以工作了。代码形式很简单：

        observable.subscribe(observer);
// 或者：
        observable.subscribe(subscriber);




        //创建定义回调

        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                SLog.d("sss",, s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                SLog.d("sss", "completed");
            }
        };

// 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        observable.subscribe(onNextAction);
// 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable.subscribe(onNextAction, onErrorAction);
// 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);




        //在 RxJava 的默认规则中，事件的发出和消费都是在同一个线程的。
        // 也就是说，如果只用上面的方法，实现出来的只是一个同步的观察者模式。
        // 观察者模式本身的目的就是『后台处理，前台回调』的异步机制，因此异步对于
        // RxJava 是至关重要的。而要实现异步，则需要用到 RxJava 的另一个概念： Scheduler 。


//        1) Scheduler 的 API (一)
//
//        在RxJava 中，Scheduler ——调度器，相当于线程控制器，RxJava 通过它来指定每一段代码应该运行在什么样的线程。RxJava 已经内置了几个 Scheduler ，它们已经适合大多数的使用场景：
//
//        Schedulers.immediate(): 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。
//        Schedulers.newThread(): 总是启用新线程，并在新线程执行操作。
//        Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，因此多数情况下 io() 比 newThread() 更有效率。不要把计算工作放在 io() 中，可以避免创建不必要的线程。
//        Schedulers.computation(): 计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。
//        另外， Android 还有一个专用的 AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。
//        有了这几个 Scheduler ，就可以使用 subscribeOn() 和 observeOn() 两个方法来对线程进行控制了。
//
//        subscribeOn(): 指定 subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程。或者叫做事件产生的线程。
//        observeOn(): 指定 Subscriber 所运行在的线程。或者叫做事件消费的线程。


        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        SLog.d("ff", "number:" + number);
                    }
                });

        //上面这段代码中，由于 subscribeOn(Schedulers.io()) 的指定，
        // 被创建的事件的内容 1、2、3、4 将会在 IO 线程发出；而由于
        // observeOn(AndroidScheculers.mainThread()) 的指定，
        // 因此 subscriber 数字的打印将发生在主线程 。事实上，
        // 这种在 subscribe() 之前写上两句 subscribeOn(Scheduler.io())
        // 和 observeOn(AndroidSchedulers.mainThread()) 的使用方式非常常见，
        // 它适用于多数的 『后台线程取数据，主线程显示』的程序策略。

    }

    @Override
    protected Class<MainViewDelegate> getDelegateClass() {
        return MainViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }


    @Override
    public void onClick(View view) {

    }
}