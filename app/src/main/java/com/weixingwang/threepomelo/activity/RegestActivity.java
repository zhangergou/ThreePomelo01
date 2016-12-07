package com.weixingwang.threepomelo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.weixingwang.threepomelo.R;
import com.weixingwang.threepomelo.utils.BitmapUtils;
import com.weixingwang.threepomelo.utils.DialogUtils;
import com.weixingwang.threepomelo.utils.ToastUtils;
import com.weixingwang.threepomelo.view.CircleImageView;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class RegestActivity extends BaseActivity {

    private CircleImageView circleIv;
    private Dialog dialog;
    /***
     * 使用照相机拍照获取图片
     */
    public static final int SELECT_PIC_BY_TACK_PHOTO = 1;
    /***
     * 使用相册中的图片
     */
    public static final int SELECT_PIC_BY_PICK_PHOTO = 2;

    /***
     * 从Intent获取图片路径的KEY
     */
    public static final String KEY_PHOTO_PATH = "photo_path";
    private Uri photoUri;
    @Override
    protected int getLayoutId() {
        return R.layout.regest_lyout;
    }

    @Override
    protected void initView() {
        circleIv = (CircleImageView) findViewById(R.id.iv_regest_icon);
        setTitle("会员注册");
        isShowBack(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisener() {
        findViewById(R.id.btn_regest_up_icon).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_regest_up_icon:
                //弹出dialog
                showImageDialog();
                break;
            case R.id.cread_log_icon_dia:
                //打开相机
                openCramerer();
                break;
            case R.id.loca_icon_log_dia:
                //打开相册
                openCramererFile();
                break;
            case R.id.dialog_cancle_log:
                dialog.dismiss();
                break;
            default:
                super.onClick(v);
                break;
        }
    }

    private void openCramererFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, SELECT_PIC_BY_PICK_PHOTO);
    }

    private void openCramerer() {
        //执行拍照前，应该先判断SD卡是否存在
        String SDState = Environment.getExternalStorageState();
        if(SDState.equals(Environment.MEDIA_MOUNTED))
        {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//"android.media.action.IMAGE_CAPTURE"
/***
 * 需要说明一下，以下操作使用照相机拍照，拍照后的图片会存放在相册中的
 * 这里使用的这种方式有一个好处就是获取的图片是拍照后的原图
 * 如果不实用ContentValues存放照片路径的话，拍照后获取的图片为缩略图不清晰
 */
            ContentValues values = new ContentValues();
            photoUri = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
/**-----------------*/
            startActivityForResult(intent, SELECT_PIC_BY_TACK_PHOTO);
        }else {
            Toast.makeText(this, "内存卡不存在", Toast.LENGTH_LONG).show();
        }
    }

    private void showImageDialog() {
        View inflate = View.inflate(this, R.layout.regest_image_dialog_layout, null);
        inflate.findViewById(R.id.cread_log_icon_dia).setOnClickListener(this);
        inflate.findViewById(R.id.loca_icon_log_dia).setOnClickListener(this);
        inflate.findViewById(R.id.dialog_cancle_log).setOnClickListener(this);
        dialog = DialogUtils.diaBottm(this, inflate, true);
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dialog.dismiss();
        if (resultCode == Activity.RESULT_OK) {
            doPhoto(requestCode, data);
        }
    }

    private void doPhoto(int requestCode, Intent data) {
        String url=null;
        if (requestCode == SELECT_PIC_BY_PICK_PHOTO){ //从相册取图片，有些手机有异常情况，请注意

            if (data == null) {
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
            photoUri = data.getData();

            if (photoUri == null) {
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
        }
        String[] proj = { MediaStore.Images.Media.DATA };
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1){
            url= BitmapUtils.getImageUrl(this, photoUri);
        }else {
            Cursor actualimagecursor = managedQuery(photoUri, proj, null, null, null);
            if(actualimagecursor.moveToFirst()){;
                int column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                url = actualimagecursor.getString(column_index);
            }
            actualimagecursor.close();
        }
        final String finalUrl = url;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = BitmapUtils.getBitmapForPath(finalUrl);
                Bitmap comp = BitmapUtils.comp(bitmap);
                final Bitmap image = BitmapUtils.compressImage(comp);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        circleIv.setImageBitmap(image);
                        ToastUtils.toast(RegestActivity.this,"以选中");
                    }
                });
            }
        }).start();


    }
}