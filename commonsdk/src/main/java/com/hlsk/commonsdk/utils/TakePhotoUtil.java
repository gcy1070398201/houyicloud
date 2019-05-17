package com.hlsk.commonsdk.utils;

import android.net.Uri;
import android.os.Environment;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.TakePhotoOptions;

import java.io.File;

/**
 * 相机 相册 选取工具类
 * @author guchenyang
 * @Date 2019/5/14
 * @time 16:25
 */
public class TakePhotoUtil {
    /**
     *
     * @param type 1-相机 2-相册
     * @param isTrue true-裁剪  false-不裁剪
     * @param takePhoto
     */
    public static void onClickTakePhoto(String type,boolean isTrue,TakePhoto takePhoto) {
        File file = new File(Environment.getExternalStorageDirectory(), "/houyiyunapp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        if (type.equals("1")){
            //相机
            if (isTrue){
                takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
            }else{
                takePhoto.onPickFromCapture(imageUri);
            }
        }else if (type.equals("2")){
            //相册
            if (isTrue){
                takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
            }else{
                takePhoto.onPickFromGallery();
            }
        }
    }

    private static void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
            builder.setWithOwnGallery(true);
            builder.setCorrectImage(true);
        takePhoto.setTakePhotoOptions(builder.create());
    }

    /**
     * 压缩
     * @param takePhoto
     */
    private static void configCompress(TakePhoto takePhoto) {
        CompressConfig config;
        config = new CompressConfig.Builder().setMaxSize(500*1024)
                .create();
        takePhoto.onEnableCompress(config, false);
    }
    /**
     * 裁剪
     * @param
     */
    private static CropOptions getCropOptions() {

        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setAspectX(1).setAspectY(1);
        builder.setWithOwnCrop(false);
        return builder.create();
    }
}
