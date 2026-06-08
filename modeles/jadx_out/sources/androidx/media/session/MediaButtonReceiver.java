package androidx.media.session;

import a4.x;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.c;
import android.support.v4.media.d;
import android.support.v4.media.g;
import android.support.v4.media.h;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.i;
import android.support.v4.media.session.m;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class MediaButtonConnectionCallback extends c {
        private final Context mContext;
        private final Intent mIntent;
        private h mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        public MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.mPendingResult = pendingResult;
        }

        private void finish() {
            Messenger messenger;
            d dVar = this.mMediaBrowser.f250a;
            g gVar = dVar.f;
            if (gVar != null && (messenger = dVar.g) != null) {
                try {
                    Message obtain = Message.obtain();
                    obtain.what = 7;
                    obtain.arg1 = 1;
                    obtain.setData(null);
                    obtain.replyTo = messenger;
                    ((Messenger) gVar.f247b).send(obtain);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            dVar.f241b.disconnect();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.c
        public void onConnected() {
            Context context;
            MediaSessionCompat$Token mediaSessionCompat$Token;
            try {
                context = this.mContext;
                d dVar = this.mMediaBrowser.f250a;
                if (dVar.h == null) {
                    dVar.h = MediaSessionCompat$Token.a(dVar.f241b.getSessionToken(), null);
                }
                mediaSessionCompat$Token = dVar.h;
                new HashSet();
            } catch (RemoteException e10) {
                Log.e(MediaButtonReceiver.TAG, "Failed to create a media controller", e10);
            }
            if (mediaSessionCompat$Token == null) {
                throw new IllegalArgumentException("sessionToken must not be null");
            }
            android.support.v4.media.session.h iVar = Build.VERSION.SDK_INT >= 24 ? new i(context, mediaSessionCompat$Token) : new android.support.v4.media.session.h(context, mediaSessionCompat$Token);
            KeyEvent keyEvent = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent == null) {
                throw new IllegalArgumentException("KeyEvent may not be null");
            }
            iVar.f282a.dispatchMediaButtonEvent(keyEvent);
            finish();
        }

        @Override // android.support.v4.media.c
        public void onConnectionFailed() {
            finish();
        }

        @Override // android.support.v4.media.c
        public void onConnectionSuspended() {
            finish();
        }

        public void setMediaBrowser(h hVar) {
            this.mMediaBrowser = hVar;
        }
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, ComponentName componentName, long j) {
        if (componentName == null) {
            Log.w(TAG, "The component name of media button receiver should be provided.");
            return null;
        }
        int i = j == 4 ? 126 : j == 2 ? 127 : j == 32 ? 87 : j == 16 ? 88 : j == 1 ? 86 : j == 64 ? 90 : j == 8 ? 89 : j == 512 ? 85 : 0;
        if (i == 0) {
            Log.w(TAG, "Cannot build a media button pending intent with the given action: " + j);
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i));
        return PendingIntent.getBroadcast(context, i, intent, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName getMediaButtonReceiverComponent(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (queryBroadcastReceivers.size() <= 1) {
            return null;
        }
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (queryIntentServices.isEmpty()) {
            return null;
        }
        StringBuilder v = x.v("Expected 1 service that handles ", str, ", found ");
        v.append(queryIntentServices.size());
        throw new IllegalStateException(v.toString());
    }

    public static KeyEvent handleIntent(m mVar, Intent intent) {
        return null;
    }

    private static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d(TAG, "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName serviceComponentByAction = getServiceComponentByAction(context, "android.intent.action.MEDIA_BUTTON");
        if (serviceComponentByAction != null) {
            intent.setComponent(serviceComponentByAction);
            startForegroundService(context, intent);
            return;
        }
        ComponentName serviceComponentByAction2 = getServiceComponentByAction(context, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (serviceComponentByAction2 == null) {
            a.i("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            return;
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, goAsync);
        h hVar = new h(applicationContext, serviceComponentByAction2, mediaButtonConnectionCallback);
        mediaButtonConnectionCallback.setMediaBrowser(hVar);
        hVar.f250a.f241b.connect();
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long j) {
        ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent == null) {
            Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
            return null;
        }
        return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, j);
    }
}
