# dileber
android mvp 框架
这是一款mvp框架，他能帮助你快速的搭建应用。

官方交流qq群：171443726

使用介绍：
http://blog.csdn.net/s297165331/article/details/50573600

http://blog.csdn.net/s297165331/article/details/50574406

http://blog.csdn.net/s297165331/article/details/50575931

http://blog.csdn.net/s297165331/article/details/50576049

随着对安卓开发的深入，越来越发现activity类简直无所不能，于是就导致activity里的代码太多，让人感觉非常不爽。

近年来开始流行mvp，于是我对其进行了解，学习，参照了一些资料，自己整合了一套快速开发框架。

我将google 开发的volley，进行了整合，顺便放了一套不错的dialog进去，还有对android常用的一些东西进行了封装。

我将这套项目开源并且放到了github上 日后也将会继续维护这套代码。

先给大家简单的介绍一下

mvp是个什么：

m（model 数据）v（view 展示）p（persent 帮助 model和view进行数据关联）

mvp 大概算是mvc的升级版，作用差不多会让代码的耦合程度降低，

我在框架里又加了一层，delegate（委托层）将代理activity去做一些展示的东西

mvp为什么流行

代码很清晰 ，第一次见到这个代码（在公司看到一个员工使用这种模式开发），我也吃了一惊，结构非常清晰

代码展现了很多东西，松耦合的开发，让我一见钟情，于是我就开始学习和使用mvp

现在我为大家介绍一下dileber

dileber 是基于MVP的模式开发出来的，任何一个android开发人员都能够在我这套框架下开发出漂亮的android代码

如下是 dileber项目里lib的mvp包中的项目架构
model包
是一个model基类 目前类中没有方法，以后我在修改框架的时候可能会在其中增加方法，继承这个model基类的model才有
大家可以不继承

preseter包
是主要的包，
activity继承activitypresent
fragment 继承fragmentpresent

scm包则是网络请求，图片请求的包，我将网络都封装到这里继承于这个类就可以直接访问网络
请求数据，请求图片，记得加权限哦

view包则是view的代理对象，帮助activity代理处理布局文件


快速使用：
要使用这套框架首先需要在AndroidMainfest.xml添加权限

<!--联网权限-->
<uses-permission android:name="android.permission.INTERNET" />
<!--往sdcard中写入数据的权限 -->
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
<!--在sdcard中创建/删除文件的权限 -->
<uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"></uses-permission>
其次要建立一个Application继承于SApplication
public class SmailApplication extends SApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        buglog(Configer.BUG_STATIC,Configer.BUG_NAME);
    }
}
如上buglog是一个日志打印工具，后面会仔细讲解
然后在application 中将name指向刚才继承的类

<application
        android:name=".app.SmailApplication"
        android:label="@string/app_name"
        android:icon="@drawable/ic_launcher">

        架构如下

        建立五个包

        app 基本包，包含设置，application

        delegate 委托view层 ，包含所有界面的所有delegate，和相关的view接口

        model  模型类 ，包含网络请求的 model

        presenter  处理model和view

        scm 处理网络数据，包括网络回调类


        下面开始正式谈论框架的使用了

        首先

        先介绍一下我封装后的日志类

        日志类的简介，后序会有详细介绍

        框架中封装了android的log类。

        如果你想改log打印名字的话，或者关闭log，需要在你继承的application的oncreate方法中写下如下

         buglog(true,“tag”);
        第一个参数是是否关闭 信息打印  ，如果填写false的话是关闭，true不关闭 默认不关闭

        后面则是log的名字

        如何使用log类

        要打印的数据用逗号分开，该日志打印类还可以将你的行号和类打印出来。

        如下

        SLog.i("info",error.getMessage(),"dddddd","dsdsdsds");
        打印效果如下
        com.zhonghua.smailadd I/smailapp﹕ info {"error_code":10001,"reason":"错误的请求KEY"} dddddd dsdsdsds  [ threadID=1,threadName=main,fileName=SplashActivity.java,className=com.zhonghua.smailadd.presenter.SplashActivity$1,methodName=success,lineNumber=39 ]
        答应info信息
        SLog.i("info",error.getMessage());
        打印错误信息
        SLog.e("ERROR_MESSAGE",error.getMessage());
        打印警告信息
        SLog.w("w",error.getMessage());

        其次介绍一下如何网络请求

        这是我封装了volley后的网络请求

        首先要在继承scm

        public class GoodsListScm extends Scm {
        继承scm后的子类就有网络请求的能力了

        如下图获取数据

        public void getGoodsList(String search, Integer order, Integer orderType, Double lat, Double lon, final OnGoodsListListener onGoodslistListener) {
            onGoodslistListener.before();
            Map<String,Object> map = new HashMap<String,Object>();
            netWork("http://api.avatardata.cn/Constellation/Query", map, GoodsModel.class, new HttpListener<GoodsModel>(){

                @Override
                protected void onSuccess(GoodsModel response) {
                    onGoodslistListener.success(response);
                }

                @Override
                protected void onFailure(VolleyError error) {
                    SLog.e("ERROR_MESSAGE",error.getMessage());
                    onGoodslistListener.failed();
                }
            } , TYPE_POST);
        }

        请注意如下实现
        netWork("http://api.avatardata.cn/Constellation/Query", map, GoodsModel.class, new HttpListener<GoodsModel>(){
        network中是目前可以传入model和string的
        map目前只支持int string ，double 等基本类型后序我会继续添加的

        请求的类型有两种

        TYPE_POST    TYPE_GET

        你需要建立一个回调函数来将数据传回view

        如果数据简单的话直接使用

        INetListener
        就可以完成数据的接收

        继承的使用如下

        public interface OnGoodsListListener<T> extends INetListener<T>{


        }
        里面可以写你自己的接口
        在view端的接收数据如下

        GoodsListScm goodsListScm = new GoodsListScm();
        goodsListScm.getGoodsList(null, null, null, null, null, new OnGoodsListListener<GoodsModel>() {
            @Override
            public void before() {
                viewDelegate.loading();
            }

            @Override
            public void success(GoodsModel model) {
                String ss = HJson.toJson(model);
                SLog.i(">>>>>>",ss);
                viewDelegate.loadDialogDismiss();
            }

            @Override
            public void failed() {
                viewDelegate.loadDialogDismiss();
            }
        });



        图片的网络请求，默认的缓存到一个目录下，后期我回开放缓存的接口会让大家自己缓存自己的地方

        如何请求图片

        如下

        netWorkForImage(imageView,"https://c1.staticflickr.com/8/7516/16112631626_91e4c54e1e_n.jpg",R.drawable.splash);
        imageview是你的view  后面的参数是网址和 未请求到图片时显示的默认图片



写一个类继承于AppViewDelegate


public class SplashViewDelegate extends AppViewDelegate{


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash;
    }

    LinearLayout splash_layout;
    ImageView imageView;

    @Override
    public void initWidget() {
        super.initWidget();
        splash_layout = bindView(R.id.splash_layout);
        imageView = bindView(R.id.imageView);
    }

}
如图需要实现 getRootLayoutId方法，这个方法主要就是返回 splashactivity的layout

SplashViewDelegate
这个delegate就是专门为splashactivity产生的类
initwidget就是可以初始化一些组件

你可以把你要初始化的组件放到这里，还可以在这个类里写一些展示效果

展示效果可以写到view接口

再通过对接口的编程，达到需要的效果

implements ISplashView{


如果你想获得当前activity

则可以使用


getActivity();

获得当前layout

getRootView()



然后开始讲解 presenter了


首先我想讲两个特殊的注解

@CloseStatusBar
@CloseTitle
public class SplashActivity extends ActivityPresenter<SplashViewDelegate>  {
一个是
@CloseStatusBar
他的作用是可以使得当前activity全屏

一个是

@CloseTitle
他的作用是可以使得当前activity的title消失

上面的两个注解主要为了方便开发


presenter一般使用代码如下


public class SplashActivity extends ActivityPresenter<SplashViewDelegate>  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ISplashScm imageSrc = new SplashScm();
        imageSrc.showSplashResourceImage((ImageView) viewDelegate.get(R.id.imageView));

        GoodsListScm goodsListScm = new GoodsListScm();
        goodsListScm.getGoodsList(null, null, null, null, null, new OnGoodsListListener<GoodsModel>() {
            @Override
            public void before() {
                viewDelegate.loading();
            }

            @Override
            public void success(GoodsModel model) {
                String ss = HJson.toJson(model);
                SLog.i(">>>>>>",ss);
                viewDelegate.loadDialogDismiss();
            }

            @Override
            public void failed() {
                viewDelegate.loadDialogDismiss();
            }
        });



    }

    @Override
    protected Class<SplashViewDelegate> getDelegateClass() {
        return SplashViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }


    @Override
    public void onClick(View view) {

    }
}


你可以在bindevenlistener中编写监听器代码，

如下


@Override
protected void bindEvenListener() {
    super.bindEvenListener();

    viewDelegate.setOnClickListener(this,R.id.mask_left);
}
或者如下
viewDelegate.setOnClickListener(this,R.id.mask_left,R.id.confirm_button);
或者如下
viewDelegate.setOnClickListener(this,button1,view2,view3);

如果你想展示 toast

我写了一个自定义的toast帮助你使用

viewDelegate.toast("ddddd", Toast.LENGTH_SHORT);

还有一个不错的 加载框


viewDelegate.loading();

viewDelegate.loadDialogDismiss();

注意成对使用

还有一个确定取消框

viewDelegate.dialogOk("eeee", new DialogLinstener() {
    @Override
    public void confirm(Dialog dialog) {

    }

    @Override
    public void cancel(Dialog dialog) {

    }
});

错误对话框

viewDelegate.showAlert(SplashViewDelegate.DIALOG_ERROR,"ddd");

成功对话框


viewDelegate.showAlert(SplashViewDelegate.DIALOG_SUCCESS,"ddd");

最基本的使用就是这么多了

perfmanger

shareperferences的封装类，非常棒的封装，简化了很多操作，由于过于庞大单独找一个章节讲。

Hjson

gson的封装类基本用法

toJson(Object object)

fromJson(String gsonString, Class<T> cls)

HNetwork

网络检查类

帮助你检查网络

HNetwork.getInstance();
检查是否有网络
checkNetwork()
检查是否是在wifi环境下
isWifi()
我先简单讲一下

perfmanger 的基本使用方法，后序会出一个新的章节讲更多使用
写入key value   name则是你要写入的名字


PerfManager.getInstance().put(String name,String key, Object object)
获取value
PerfManager.getInstance().get(String name,String key, Object defaultObject)
清除key
PerfManager.getInstance().clear(String name)




