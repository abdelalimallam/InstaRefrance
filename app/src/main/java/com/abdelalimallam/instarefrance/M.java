package com.abdelalimallam.instarefrance;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abdelalimallam.instarefrance.model.CurrentUserResponse;
import com.abdelalimallam.instarefrance.utils.AppConst;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Locale;



public class M {
    static ProgressDialog pDialog;
    private static SharedPreferences mSharedPreferences;

    public static void showLoadingDialog(Context mContext) {
        if (pDialog != null)
            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }

        pDialog = new ProgressDialog(mContext);
        pDialog.setMessage(mContext.getString(R.string.please_wait));
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public static void hideLoadingDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }


    public static void T(Context mContext, String Message) {
        Toast.makeText(mContext, Message, Toast.LENGTH_SHORT).show();
    }

    public static void Error(final Runnable r, Context c) {
//
//        new SweetAlertDialog(c, SweetAlertDialog.ERROR_TYPE)
//                .setTitleText(c.getString(R.string.Error_onloading_1))
//                .setContentText(c.getString(R.string.Error_onloading_2))
//                .setCancelText(c.getString(R.string.Error_onloading_4))
//                .setConfirmText(c.getString(R.string.Error_onloading_3))
//                .showCancelButton(true)
//                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        sDialog.cancel();
//
//                    }
//                })
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        r.run();
//                        sweetAlertDialog.cancel();
//
//                    }
//                })
//                .show();


    }

    public static void Error(final Runnable r, Context c, String Message) {
//
//        new SweetAlertDialog(c, SweetAlertDialog.ERROR_TYPE)
//                .setTitleText(c.getString(R.string.Error_onloading_1))
//                .setContentText(Message)
//                .setCancelText(c.getString(R.string.Error_onloading_4))
//                .setConfirmText(c.getString(R.string.Error_onloading_3))
//                .showCancelButton(true)
//                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        sDialog.cancel();
//
//                    }
//                })
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        r.run();
//                        sweetAlertDialog.cancel();
//
//                    }
//                })
//                .show();


    }


    private void MeasureExecutionTime() {
    }

    public static void L(String Message) {
        Log.e(AppConst.TAG, Message);
    }

    public static boolean setToken(String token, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("token", token);
        return editor.commit();
    }

    public static String getToken(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("token", null);
    }

    public static void logOut(Context mContext) {
        setUser(null, mContext);
        setToken(null, mContext);
    }

    public static boolean setUser(CurrentUserResponse userEntity, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String user = gson.toJson(userEntity);
        editor.putString("User", user);
        return editor.commit();
    }

    public static CurrentUserResponse getUser(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        String user = mSharedPreferences.getString("User", "");
        Gson gson = new Gson();


        return gson.fromJson(user, CurrentUserResponse.class);
    }

    public static boolean isValidUrl(String text) {
        return Patterns.WEB_URL.matcher(text).matches();
    }

    public static void showNotification(Context mContext, Intent resultIntent, String title, String text, int id) {
        PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext, 0,
                resultIntent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mNotifyBuilder;
        NotificationManager mNotificationManager;

        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyBuilder = new NotificationCompat.Builder(mContext)
                .setContentTitle(title)
                .setContentText(text)

                .setSmallIcon(R.mipmap.ic_launcher);

        mNotifyBuilder.setContentIntent(resultPendingIntent);

        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;
        defaults = defaults | Notification.DEFAULT_SOUND;

        mNotifyBuilder.setDefaults(defaults);
        mNotifyBuilder.setAutoCancel(true);

        mNotificationManager.notify(id, mNotifyBuilder.build());
    }

    public static SharedPreferences.Editor editSharedPref(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        return editor;
    }

    public static SharedPreferences getSharedPref(Context mContext) {
        return mContext.getSharedPreferences("settings", 0);
    }

    public static String SelectedItem = "error";

    public static void showPlayListDialog(final Context c, final ArrayList<String> data, String title) {

    }
//
//    public void showInputDialog() {
//        new MaterialDialog.Builder(this)
//                .title(R.string.add_new_playlist)
//                .content(R.string.add_new_playlist_content)
//                .inputType(InputType.TYPE_CLASS_TEXT |
//                        InputType.TYPE_TEXT_VARIATION_PERSON_NAME |
//                        InputType.TYPE_TEXT_FLAG_CAP_WORDS)
//                .inputRange(2, 20)
//                .positiveText(R.string.add_new_playlist_submit)
//                .input(R.string.add_new_playlist_input_hint, R.string.add_new_playlist_input_hint, false, new MaterialDialog.InputCallback() {
//                    @Override
//                    public void onInput(MaterialDialog dialog, CharSequence input) {
//                        PlaylistModel p = new PlaylistModel();
//                        p.setNameEn(input.toString());
//                        p.setNameAr(input.toString());
//                        p.setIsSystem(0);
//                        p.setIsUpdated(1);
//                        p.setPlaylistUID(0);
//                        p.setSystemListen(0);
//                        p.setUserListen(0);
//                        p.setIsFavorite(0);
//                        p.setSquareimage(R.drawable.playlist_item + "");
//                        long PlyId = db.addNewPlayList(p);
//
//                        Playlist_Tracks track = new Playlist_Tracks();
//                        track.setId_Track(PlayerConstants.list_Of_Tracks.get(Song_postion).getSongId());
//                        track.setIdPlaylist((int) PlyId);
//                        db.insertSingleTrackInPlaylist(track);
//
//                        dialog.dismiss();
//                        showPlayListDialog();
//
//                    }
//                }).show();
//    }

    public static int getValueOfAttribute(Context context, int attr) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(attr, typedValue, true);
        return typedValue.data;
    }

    public static String Lang(Context c) {
        String langPref = "Language";
        SharedPreferences prefs = c.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");

        return language;

    }

    public static void loadLocale(Context c) {
        String langPref = "Language";
        SharedPreferences prefs = c.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        changeLang(language, c);
    }

    private static Locale myLocale;

    public static void changeLang(String lang, Context c) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang, c);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        c.getResources().updateConfiguration(config, c.getResources().getDisplayMetrics());
    }

    public static void saveLocale(String lang, Context c) {
        String langPref = "Language";
        SharedPreferences prefs = c.getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }

    public static void setTextByLanguage(Context context, TextView textView, String Value_Ar, String Value_En) {
        switch (M.Lang(context)) {
            case "ar": {
                if (!Value_Ar.isEmpty())
                    textView.setText(Value_Ar);
                else
                    textView.setText(Value_En);

            }
            break;
            case "en_US": {
                if (!Value_En.isEmpty())

                    textView.setText(Value_En);
                else
                    textView.setText(Value_Ar);

            }
            break;

        }

    }

    public static void SetTextData(TextView tv, String Data) {
        tv.setText(Data);
    }

    public static String ETGetText(EditText editText) {
        return editText.getText().toString();
    }
}
