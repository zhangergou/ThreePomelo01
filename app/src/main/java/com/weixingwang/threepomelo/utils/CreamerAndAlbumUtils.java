package com.weixingwang.threepomelo.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import com.weixingwang.threepomelo.activity.CreateShopActivity;
import com.weixingwang.threepomelo.activity.RegestActivity;

import java.io.File;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/7 0007.
 */
public class CreamerAndAlbumUtils {
    /***
     * 使用照相机拍照获取图片
     */
    private static final int SELECT_PIC_BY_TACK_PHOTO = 1;
    /***
     * 使用相册中的图片
     */
    private static final int SELECT_PIC_BY_PICK_PHOTO = 2;
    private static Handler handler = new Handler(Looper.getMainLooper());
    /***
     * 从Intent获取图片路径的KEY
     */
    private static final String KEY_PHOTO_PATH = "photo_path";


    public static Uri openCramerer(Context context, int activityType) {
        Uri photoUri = null;
        //执行拍照前，应该先判断SD卡是否存在
        String SDState = Environment.getExternalStorageState();
        if (SDState.equals(Environment.MEDIA_MOUNTED)) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//"android.media.action.IMAGE_CAPTURE"
/***
 * 需要说明一下，以下操作使用照相机拍照，拍照后的图片会存放在相册中的
 * 这里使用的这种方式有一个好处就是获取的图片是拍照后的原图
 * 如果不实用ContentValues存放照片路径的话，拍照后获取的图片为缩略图不清晰
 */
            ContentValues values = new ContentValues();
            photoUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
            startActiCreamer(context, intent, activityType);

        } else {
            Toast.makeText(context, "内存卡不存在", Toast.LENGTH_LONG).show();
        }
        return photoUri;
    }


    public static void openCramererFile(Context context, int activityType) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActiCreamerFile(context, intent, activityType);

    }

    public static void doPhoto(final Context context, int requestCode, Intent data,
                               final ImageView circleIv, Uri photoUri, int avtivityType) {

        String url = null;
        if (requestCode == SELECT_PIC_BY_PICK_PHOTO) { //从相册取图片，有些手机有异常情况，请注意

            if (data == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
            photoUri = data.getData();

            if (photoUri == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
        }
        String[] proj = {MediaStore.Images.Media.DATA};
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            photoUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            url = BitmapUtils.getImageUrl(context, photoUri);
        } else {
            Cursor actualimagecursor = getCursor(context, photoUri, proj, avtivityType);

            if (actualimagecursor.moveToFirst()) {
                ;
                int column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                url = actualimagecursor.getString(column_index);
            }
            actualimagecursor.close();
        }
        final String finalUrl = url;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = BitmapUtils.getimage(finalUrl);
                Bitmap comp = BitmapUtils.comp(bitmap);
                final Bitmap image = BitmapUtils.compressImage(comp);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        circleIv.setImageBitmap(image);
                        ToastUtils.toast(context, "以选中");
                    }
                });
            }
        }).start();

    }

    public static String getPhoto(final Context context, int requestCode, Intent data,
                                  Uri photoUri, int avtivityType) {
        String url = null;
        if (requestCode == SELECT_PIC_BY_PICK_PHOTO) { //从相册取图片，有些手机有异常情况，请注意

            if (data == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return null;
            }
            photoUri = data.getData();

            if (photoUri == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return null;
            }
        }
        String[] proj = {MediaStore.Images.Media.DATA};
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            photoUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            url = BitmapUtils.getImageUrl(context, photoUri);
        } else {
            Cursor actualimagecursor = getCursor(context, photoUri, proj, avtivityType);

            if (actualimagecursor.moveToFirst()) {
                ;
                int column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                url = actualimagecursor.getString(column_index);
            }
            actualimagecursor.close();
        }

        return url;
    }


    private static void startActiCreamer(Context context, Intent intent, int activityType) {
        switch (activityType) {
            case 1:
                RegestActivity reg = (RegestActivity) context;
                reg.startActivityForResult(intent, SELECT_PIC_BY_TACK_PHOTO);
                break;
            case 2:
                CreateShopActivity cp = (CreateShopActivity) context;
                cp.startActivityForResult(intent, SELECT_PIC_BY_TACK_PHOTO);
                break;
        }

    }

    private static void startActiCreamerFile(Context context, Intent intent, int activityType) {
        switch (activityType) {
            case 1:
                RegestActivity reg = (RegestActivity) context;
                reg.startActivityForResult(intent, SELECT_PIC_BY_PICK_PHOTO);
                break;
            case 2:
                CreateShopActivity cp = (CreateShopActivity) context;
                cp.startActivityForResult(intent, SELECT_PIC_BY_PICK_PHOTO);
                break;
        }

    }

    private static Cursor getCursor(Context context, Uri photoUri, String[] proj, int activityType) {
        Cursor object = null;
        switch (activityType) {
            case 1:
                RegestActivity reg = (RegestActivity) context;
                object = reg.managedQuery(photoUri, proj, null, null, null);
                break;
            case 2:
                CreateShopActivity cp = (CreateShopActivity) context;
                object = cp.managedQuery(photoUri, proj, null, null, null);
                break;
        }
        return object;
    }

    public static HashMap<String, File> putMap(final Context context, int requestCode, Intent data,
                                               final String iconName, final ImageView iv, Uri photoUri, int avtivityType) {
        final HashMap<String, File> hashMap = new HashMap<>();
        String url = null;
        if (requestCode == SELECT_PIC_BY_PICK_PHOTO) { //从相册取图片，有些手机有异常情况，请注意

            if (data == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return null;
            }
            photoUri = data.getData();

            if (photoUri == null) {
                Toast.makeText(context, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return null;
            }
        }
        String[] proj = {MediaStore.Images.Media.DATA};
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            photoUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            url = BitmapUtils.getImageUrl(context, photoUri);
        } else {
            Cursor actualimagecursor = getCursor(context, photoUri, proj, avtivityType);

            if (actualimagecursor.moveToFirst()) {
                ;
                int column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                url = actualimagecursor.getString(column_index);
            }
            actualimagecursor.close();
        }
        final String finalUrl = url;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Bitmap bitmap = BitmapUtils.getimageIcon(finalUrl);
//                Bitmap comp = BitmapUtils.comp(bitmap);
//                final Bitmap image = BitmapUtils.compressImage(comp);
//                final byte[] bytes = BitmapUtils.getBitmapbyte(image);
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        File file = BytesToFileUtils.getFile(bytes, context.getFilesDir().getAbsolutePath(), iconName);
//                        iv.setImageBitmap(image);
//                        hashMap.put(iconName,file);
//                    }
//                });
//            }
//        }).start();
        Bitmap bitmap = BitmapUtils.getimageIcon(finalUrl);
        Bitmap comp = BitmapUtils.comp(bitmap);
        final Bitmap image = BitmapUtils.compressImage(comp);
        final byte[] bytes = BitmapUtils.getBitmapbyte(image);
        File file = BytesToFileUtils.getFile(bytes, context.getFilesDir().getAbsolutePath(), iconName);
        iv.setImageBitmap(image);
        hashMap.put(iconName, file);
        return hashMap;
    }
}
