package h0;

import a4.x;
import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.GoogleApiActivity;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends f {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5406c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final e f5407d = new e();

    public static AlertDialog d(Activity activity, int i, k0.q qVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(k0.p.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(2131951799) : resources.getString(2131951809) : resources.getString(2131951802);
        if (string != null) {
            builder.setPositiveButton(string, qVar);
        }
        String c9 = k0.p.c(activity, i);
        if (c9 != null) {
            builder.setTitle(c9);
        }
        Log.w("GoogleApiAvailability", androidx.lifecycle.l.u(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                i iVar = new i();
                y.h(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                iVar.f5418a = alertDialog;
                if (onCancelListener != null) {
                    iVar.f5419b = onCancelListener;
                }
                iVar.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        c cVar = new c();
        y.h(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        cVar.f5399a = alertDialog;
        if (onCancelListener != null) {
            cVar.f5400b = onCancelListener;
        }
        cVar.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog d10 = d(googleApiActivity, i, new k0.q(super.a(googleApiActivity, i, "d"), googleApiActivity, 0), googleApiActivity2);
        if (d10 == null) {
            return;
        }
        e(googleApiActivity, d10, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i, PendingIntent pendingIntent) {
        int i6;
        Log.w("GoogleApiAvailability", x.g(i, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new j(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String e10 = i == 6 ? k0.p.e(context, "common_google_play_services_resolution_required_title") : k0.p.c(context, i);
        if (e10 == null) {
            e10 = context.getResources().getString(2131951806);
        }
        String d10 = (i == 6 || i == 19) ? k0.p.d(context, "common_google_play_services_resolution_required_text", k0.p.a(context)) : k0.p.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        y.g(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(e10).setStyle(new NotificationCompat.BigTextStyle().bigText(d10));
        PackageManager packageManager = context.getPackageManager();
        if (p0.b.f8406c == null) {
            p0.b.f8406c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (p0.b.f8406c.booleanValue()) {
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (p0.b.c(context)) {
                style.addAction(2131230871, resources.getString(2131951814), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(2131951806)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(d10);
        }
        if (p0.b.a()) {
            if (!p0.b.a()) {
                throw new IllegalStateException();
            }
            synchronized (f5406c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(2131951805);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            style.setChannelId("com.google.android.gms.availability");
        }
        Notification build = style.build();
        if (i == 1 || i == 2 || i == 3) {
            g.f5410a.set(false);
            i6 = 10436;
        } else {
            i6 = 39789;
        }
        notificationManager.notify(i6, build);
    }

    public final void g(Activity activity, j0.f fVar, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog d10 = d(activity, i, new k0.q(super.a(activity, i, "d"), fVar, 1), onCancelListener);
        if (d10 == null) {
            return;
        }
        e(activity, d10, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
