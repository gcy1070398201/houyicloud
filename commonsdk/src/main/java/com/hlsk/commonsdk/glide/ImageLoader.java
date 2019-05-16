package com.hlsk.commonsdk.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.hlsk.commonsdk.R;

import java.io.File;

/**
 * 首页-专题
 *
 * @author guchenyang
 * @Date 2019/5/15
 * @time 18:05
 */
public class ImageLoader {
    private Context mContext;
    private RequestOptions requestOptions;

    private ImageLoader(Context context) {
        this.mContext = context.getApplicationContext();
        requestOptions = RequestOptions.errorOf(R.mipmap.public_ic_launcher)
                .placeholder(R.mipmap.public_ic_launcher)
                .skipMemoryCache(false)//不使用内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL);//把图片缓存到本地
    }

    public volatile static ImageLoader mImageLoader = null;

    public static ImageLoader getImageLoader(Context context) {
        if (mImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (mImageLoader == null) {
                    return mImageLoader = new ImageLoader(context);
                }
            }
        }
        return mImageLoader;
    }

    /**
     * 加载网络图片
     * @param url 地址
     * @param imageView
     */
    public void loadUrl(String url, ImageView imageView) {

        Glide.with(mContext)
                .load(url)
                .apply(requestOptions)
                .transition(new DrawableTransitionOptions())//默认动画
                .into(imageView);
    }
    /**
     * 加载资源ID图片
     * @param resources 资源ID
     * @param imageView
     */
    public void loadResources(int resources, ImageView imageView) {
        Glide.with(mContext)
                .load(resources)
                .apply(requestOptions)
                .transition(new DrawableTransitionOptions())//默认动画
                .into(imageView);
    }
    /**
     * 加载file 文件 图片
     * @param file 文件
     * @param imageView
     */
    public void loadFile(File file, ImageView imageView) {
        Glide.with(mContext)
                .load(file)
                .apply(requestOptions)
                .transition(new DrawableTransitionOptions())//默认动画
                .into(imageView);
    }

    /**
     * 设置圆角
     *
     * @param radius 圆角大小
     * @return
     */
    public ImageLoader setRadius(int radius) {
        RoundedCorners roundedCorners = new RoundedCorners(radius);
        requestOptions = RequestOptions.bitmapTransform(roundedCorners);
        return this;
    }

    /**
     * 加载圆图
     *
     * @return
     */
    public ImageLoader setCircleCrop() {
        requestOptions = RequestOptions.circleCropTransform();
        return this;
    }

    /**
     * 取消图片加载
     * @param imageView
     */
    public void cleanImage(ImageView imageView){
        Glide.with(mContext).clear(imageView);
    }

}
