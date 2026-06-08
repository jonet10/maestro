package j5;

import a4.x;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.activities.MyDownloads;
import com.uptodown.receivers.DownloadNotificationReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.a0;
import r7.o0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class o {
    public static boolean a(Context context) {
        boolean z9;
        SharedPreferences sharedPreferences;
        context.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                try {
                    sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception unused) {
                }
                if (sharedPreferences.contains("recibir_notificaciones")) {
                    z9 = sharedPreferences.getBoolean("recibir_notificaciones", true);
                    if (!z9) {
                    }
                }
                z9 = true;
                if (!z9) {
                }
            }
            return false;
        }
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences2.contains("recibir_notificaciones")) {
                return sharedPreferences2.getBoolean("recibir_notificaciones", true);
            }
        } catch (Exception unused2) {
        }
        return true;
    }

    public static void b(Context context, int i) {
        String str;
        if (Build.VERSION.SDK_INT < 24 || i <= 0) {
            return;
        }
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        NotificationManager notificationManager = (NotificationManager) systemService;
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        kotlin.jvm.internal.b d10 = a0.d(activeNotifications);
        while (true) {
            if (!d10.hasNext()) {
                str = null;
                break;
            }
            StatusBarNotification statusBarNotification = (StatusBarNotification) d10.next();
            if (i == statusBarNotification.getId()) {
                str = statusBarNotification.getGroupKey();
                break;
            }
        }
        if (str == null) {
            return;
        }
        int i6 = 0;
        while (true) {
            if (!(i6 < activeNotifications.length)) {
                notificationManager.cancel(i);
                return;
            }
            int i10 = i6 + 1;
            try {
                StatusBarNotification statusBarNotification2 = activeNotifications[i6];
                if (i != statusBarNotification2.getId() && kotlin.jvm.internal.l.a(statusBarNotification2.getGroupKey(), str)) {
                    return;
                } else {
                    i6 = i10;
                }
            } catch (ArrayIndexOutOfBoundsException e10) {
                androidx.privacysandbox.ads.adservices.customaudience.a.s(e10.getMessage());
                return;
            }
        }
    }

    public static void c(Context context) {
        Intent intent;
        String string;
        int i;
        context.getClass();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        x4.r b7 = a5.b.b();
        if (b7 != null) {
            g l10 = g.D.l(context);
            l10.b();
            ArrayList P = l10.P();
            l10.c();
            Iterator it = P.iterator();
            it.getClass();
            int i6 = 0;
            int i10 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                x4.r rVar = (x4.r) next;
                if (rVar.p()) {
                    if (rVar.i() == 0) {
                        i10++;
                    } else {
                        o0 o0Var = a5.b.f193a;
                        if (a5.b.c(rVar.f11361q)) {
                            i6++;
                        }
                    }
                }
            }
            int i11 = i6 + i10;
            String str = b7.f11366w;
            String str2 = (str == null || str.length() == 0) ? b7.f11355b : b7.f11366w;
            String string2 = context.getResources().getString(2131952402);
            int i12 = b7.i();
            String string3 = context.getResources().getString(2131952466);
            StringBuilder sb = new StringBuilder();
            sb.append(string2);
            sb.append(" ");
            sb.append(str2);
            sb.append(" (");
            sb.append(i12);
            String n10 = x.n(sb, string3, ")");
            String k5 = x.k(i5.H(context, b7.j()), "/", i5.H(context, b7.k()));
            int i13 = b7.i();
            builder.setOnlyAlertOnce(true);
            builder.setSmallIcon(2131231477);
            builder.setAutoCancel(false);
            builder.setOngoing(true);
            builder.setProgress(100, i13, false);
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.addLine(k5);
            if (i10 > 0) {
                String string4 = context.getString(2131952508);
                string4.getClass();
                inboxStyle.addLine(String.format(string4, Arrays.copyOf(new Object[]{Integer.valueOf(i11)}, 1)));
                Intent intent2 = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
                intent2.setAction("CANCEL_ALL");
                intent2.putExtra("download", b7);
                intent2.putExtra("notificationID", 261);
                builder.addAction(2131230928, context.getString(2131951942), PendingIntent.getBroadcast(context, 0, intent2, h()));
            }
            builder.setStyle(inboxStyle);
            builder.setContentTitle(n10);
            Intent intent3 = new Intent(context, (Class<?>) MyDownloads.class);
            TaskStackBuilder create = TaskStackBuilder.create(context);
            create.getClass();
            create.addParentStack(MyDownloads.class);
            create.addNextIntent(intent3);
            builder.setContentIntent(create.getPendingIntent(0, h()));
            if (a5.b.d()) {
                intent = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
                intent.setAction("RESUME");
                string = context.getString(2131952713);
                string.getClass();
                i = 2131231411;
            } else {
                intent = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
                intent.setAction("PAUSE");
                string = context.getString(2131951655);
                string.getClass();
                i = 2131231405;
            }
            builder.addAction(i, string, PendingIntent.getBroadcast(context, 0, intent, h()));
            Intent intent4 = new Intent(context, (Class<?>) DownloadNotificationReceiver.class);
            intent4.setAction("CANCEL");
            intent4.putExtra("download", b7);
            intent4.putExtra("notificationID", 261);
            builder.addAction(2131230928, context.getString(2131952425), PendingIntent.getBroadcast(context, 0, intent4, h()));
        } else {
            builder.setOnlyAlertOnce(true);
            builder.setSmallIcon(2131231477);
            builder.setAutoCancel(false);
            builder.setOngoing(true);
            String string5 = context.getString(2131952494);
            string5.getClass();
            builder.setContentTitle(string5);
        }
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).notify(261, builder.build());
    }

    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(android.content.Context r17, java.io.File r18, boolean r19, int r20) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.o.d(android.content.Context, java.io.File, boolean, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(android.content.Context r15, x4.g r16, int r17, android.graphics.Bitmap r18, x4.x1 r19) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.o.e(android.content.Context, x4.g, int, android.graphics.Bitmap, x4.x1):void");
    }

    public static Bitmap f(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                bitmap.getClass();
                return bitmap;
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            createBitmap.getClass();
        } else {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.getClass();
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(android.content.Context r11) {
        /*
            e1.c0 r0 = j5.g.D
            j5.g r11 = r0.l(r11)
            r11.b()
            r1 = 0
            r2 = 0
            java.lang.String r0 = "notificationId"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Exception -> L3e
            android.database.sqlite.SQLiteDatabase r3 = r11.f6673a     // Catch: java.lang.Exception -> L3e
            r3.getClass()     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = "active_notifications"
            r9 = 0
            r10 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L3e
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L40
            int r0 = r2.getInt(r1)     // Catch: java.lang.Exception -> L3e
        L2b:
            r3 = r0
        L2c:
            boolean r0 = r2.moveToNext()     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L3c
            int r0 = r2.getInt(r1)     // Catch: java.lang.Exception -> L39
            if (r0 <= r3) goto L2c
            goto L2b
        L39:
            r0 = move-exception
            r1 = r3
            goto L44
        L3c:
            r1 = r3
            goto L40
        L3e:
            r0 = move-exception
            goto L44
        L40:
            r2.close()     // Catch: java.lang.Exception -> L3e
            goto L52
        L44:
            r0.printStackTrace()
            if (r2 == 0) goto L52
            boolean r0 = r2.isClosed()
            if (r0 != 0) goto L52
            r2.close()
        L52:
            r11.c()
            if (r1 != 0) goto L5a
            r11 = 300(0x12c, float:4.2E-43)
            goto L5c
        L5a:
            int r11 = r1 + 1
        L5c:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.o.g(android.content.Context):int");
    }

    public static int h() {
        return Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(android.content.Context r9, x4.r r10, java.lang.String r11) {
        /*
            r9.getClass()
            boolean r0 = a(r9)
            if (r0 == 0) goto Lf8
            java.lang.String r0 = "download_notification"
            r1 = 0
            r2 = 1
            java.lang.String r3 = "SettingsPreferences"
            android.content.SharedPreferences r3 = r9.getSharedPreferences(r3, r1)     // Catch: java.lang.Exception -> L1e
            boolean r4 = r3.contains(r0)     // Catch: java.lang.Exception -> L1e
            if (r4 == 0) goto L1e
            boolean r0 = r3.getBoolean(r0, r2)     // Catch: java.lang.Exception -> L1e
            goto L1f
        L1e:
            r0 = r2
        L1f:
            if (r0 == 0) goto Lf8
            r0 = 0
            if (r10 == 0) goto L27
            java.lang.String r3 = r10.f11366w
            goto L28
        L27:
            r3 = r0
        L28:
            if (r3 == 0) goto L3b
            int r3 = r3.length()
            if (r3 != 0) goto L31
            goto L3b
        L31:
            r10.getClass()
            java.lang.String r0 = r10.f11366w
            r0.getClass()
        L39:
            r3 = r0
            goto L53
        L3b:
            if (r10 == 0) goto L40
            java.lang.String r3 = r10.f11355b
            goto L41
        L40:
            r3 = r0
        L41:
            if (r3 == 0) goto L39
            int r3 = r3.length()
            if (r3 != 0) goto L4a
            goto L39
        L4a:
            r10.getClass()
            java.lang.String r0 = r10.f11355b
            r0.getClass()
            goto L39
        L53:
            int r10 = r11.length()
            r0 = 2131951915(0x7f13012b, float:1.9540258E38)
            if (r10 != 0) goto L64
            java.lang.String r10 = r9.getString(r0)
            r10.getClass()
            goto L6c
        L64:
            java.lang.String r10 = r9.getString(r0)
            java.lang.String r10 = a4.x.C(r10, r11)
        L6c:
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r9.getSystemService(r0)
            r0.getClass()
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r5 = "CHANNEL_ID_UPTODOWN"
            r4.<init>(r9, r5)
            r5 = 2131231477(0x7f0802f5, float:1.8079036E38)
            r4.setSmallIcon(r5)
            if (r3 == 0) goto L90
            int r5 = r3.length()
            if (r5 != 0) goto L8d
            goto L90
        L8d:
            r4.setContentTitle(r3)
        L90:
            androidx.core.app.NotificationCompat$BigTextStyle r5 = new androidx.core.app.NotificationCompat$BigTextStyle
            r5.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r5 = r5.bigText(r10)
            r4.setStyle(r5)
            r4.setContentText(r10)
            r4.setAutoCancel(r2)
            android.content.Intent r10 = new android.content.Intent
            java.lang.Class<com.uptodown.activities.MainActivity> r2 = com.uptodown.activities.MainActivity.class
            r10.<init>(r9, r2)
            androidx.core.app.TaskStackBuilder r5 = androidx.core.app.TaskStackBuilder.create(r9)
            r5.getClass()
            r5.addParentStack(r2)
            r5.addNextIntent(r10)
            int r10 = h()
            android.app.PendingIntent r10 = r5.getPendingIntent(r1, r10)
            r4.setContentIntent(r10)
            android.content.Intent r10 = new android.content.Intent
            java.lang.Class<com.uptodown.activities.MyDownloads> r2 = com.uptodown.activities.MyDownloads.class
            r10.<init>(r9, r2)
            androidx.core.app.TaskStackBuilder r5 = androidx.core.app.TaskStackBuilder.create(r9)
            r5.getClass()
            r5.addParentStack(r2)
            r5.addNextIntent(r10)
            int r10 = h()
            android.app.PendingIntent r10 = r5.getPendingIntent(r1, r10)
            r4.setContentIntent(r10)
            r10 = 257(0x101, float:3.6E-43)
            android.app.Notification r1 = r4.build()
            r0.notify(r10, r1)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = java.lang.String.valueOf(r0)
            r6 = 0
            r7 = 0
            r8 = r9
            r5 = r11
            k(r3, r4, r5, r6, r7, r8)
        Lf8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.o.i(android.content.Context, x4.r, java.lang.String):void");
    }

    public static void j(Context context, Uri uri) {
        context.getClass();
        String string = context.getString(2131951718);
        string.getClass();
        String string2 = context.getString(2131952403);
        string2.getClass();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage(context.getPackageName());
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, h());
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        builder.setSmallIcon(2131231477);
        builder.setContentTitle(string);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(string2));
        builder.setContentText(string2);
        builder.setAutoCancel(true);
        builder.setContentIntent(activity);
        ((NotificationManager) systemService).notify(259, builder.build());
        k(string, String.valueOf(System.currentTimeMillis()), string2, "update_uptodown", uri.getPath(), context);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void k(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, android.content.Context r8) {
        /*
            r8.getClass()
            e1.c0 r0 = j5.g.D
            j5.g r8 = r0.l(r8)
            r8.b()
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = "timestamp"
            r0.put(r1, r4)
            java.lang.String r4 = "title"
            r0.put(r4, r3)
            java.lang.String r3 = "msg"
            r0.put(r3, r5)
            java.lang.String r3 = "actions"
            r0.put(r3, r6)
            java.lang.String r3 = "extra_info"
            r0.put(r3, r7)
            android.database.sqlite.SQLiteDatabase r3 = r8.f6673a
            r3.getClass()
            java.lang.String r4 = "notifications"
            r5 = 0
            r3.insert(r4, r5, r0)
            r3 = 0
            android.database.sqlite.SQLiteDatabase r6 = r8.f6673a     // Catch: java.lang.Exception -> L59
            r6.getClass()     // Catch: java.lang.Exception -> L59
            java.lang.String r7 = "SELECT COUNT(id) AS count FROM notifications"
            android.database.Cursor r6 = r6.rawQuery(r7, r5)     // Catch: java.lang.Exception -> L59
            boolean r7 = r6.moveToFirst()     // Catch: java.lang.Exception -> L4c
            if (r7 == 0) goto L4f
            int r7 = r6.getInt(r3)     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r7 = move-exception
            r0 = r3
            goto L5c
        L4f:
            r7 = r3
        L50:
            r6.close()     // Catch: java.lang.Exception -> L54
            goto L6b
        L54:
            r0 = move-exception
            r2 = r0
            r0 = r7
            r7 = r2
            goto L5c
        L59:
            r7 = move-exception
            r0 = r3
            r6 = r5
        L5c:
            r7.printStackTrace()
            if (r6 == 0) goto L6a
            boolean r7 = r6.isClosed()
            if (r7 != 0) goto L6a
            r6.close()
        L6a:
            r7 = r0
        L6b:
            r6 = 100
            if (r7 <= r6) goto Lad
            android.database.sqlite.SQLiteDatabase r6 = r8.f6673a     // Catch: java.lang.Exception -> L85
            r6.getClass()     // Catch: java.lang.Exception -> L85
            java.lang.String r7 = "SELECT id FROM notifications ORDER BY id DESC LIMIT 100,1"
            android.database.Cursor r5 = r6.rawQuery(r7, r5)     // Catch: java.lang.Exception -> L85
            boolean r6 = r5.moveToFirst()     // Catch: java.lang.Exception -> L85
            if (r6 == 0) goto L87
            int r3 = r5.getInt(r3)     // Catch: java.lang.Exception -> L85
            goto L87
        L85:
            r6 = move-exception
            goto L8b
        L87:
            r5.close()     // Catch: java.lang.Exception -> L85
            goto L99
        L8b:
            r6.printStackTrace()
            if (r5 == 0) goto L99
            boolean r6 = r5.isClosed()
            if (r6 != 0) goto L99
            r5.close()
        L99:
            if (r3 <= 0) goto Lad
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String[] r3 = new java.lang.String[]{r3}
            android.database.sqlite.SQLiteDatabase r5 = r8.f6673a
            r5.getClass()
            java.lang.String r6 = "id<=?"
            r5.delete(r4, r6, r3)
        Lad:
            r8.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.o.k(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(android.content.Context r22) {
        /*
            Method dump skipped, instructions count: 765
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.o.l(android.content.Context):void");
    }
}
