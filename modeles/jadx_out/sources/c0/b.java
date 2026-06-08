package c0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import g0.m;
import h0.f;
import java.io.IOException;
import java.util.HashMap;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public h0.a f1169a;

    /* renamed from: b, reason: collision with root package name */
    public u0.d f1170b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1171c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1172d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public d f1173e;
    public final Context f;
    public final long g;

    public b(Context context) {
        y.g(context);
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext != null ? applicationContext : context;
        this.f1171c = false;
        this.g = -1L;
    }

    public static a a(Context context) {
        b bVar = new b(context);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            bVar.c();
            a e10 = bVar.e();
            d(e10, SystemClock.elapsedRealtime() - elapsedRealtime, null);
            return e10;
        } finally {
        }
    }

    public static void d(a aVar, long j, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_context", "1");
            if (aVar != null) {
                hashMap.put("limit_ad_tracking", true != aVar.f1168c ? "0" : "1");
                String str = aVar.f1167b;
                if (str != null) {
                    hashMap.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                hashMap.put("error", th.getClass().getName());
            }
            hashMap.put("tag", "AdvertisingIdClient");
            hashMap.put("time_spent", Long.toString(j));
            new c(hashMap, 0).start();
        }
    }

    public final void b() {
        y.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f == null || this.f1169a == null) {
                    return;
                }
                try {
                    if (this.f1171c) {
                        o0.a.b().c(this.f, this.f1169a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f1171c = false;
                this.f1170b = null;
                this.f1169a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        y.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f1171c) {
                    b();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int b7 = f.f5409b.b(context, 12451000);
                    if (b7 != 0 && b7 != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    h0.a aVar = new h0.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!o0.a.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f1169a = aVar;
                        try {
                            IBinder a8 = aVar.a();
                            int i = u0.c.i;
                            IInterface queryLocalInterface = a8.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.f1170b = queryLocalInterface instanceof u0.d ? (u0.d) queryLocalInterface : new u0.b(a8);
                            this.f1171c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new m();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final a e() {
        a aVar;
        y.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f1171c) {
                    synchronized (this.f1172d) {
                        d dVar = this.f1173e;
                        if (dVar == null || !dVar.f1179m) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c();
                        if (!this.f1171c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e10) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e10);
                    }
                }
                y.g(this.f1169a);
                y.g(this.f1170b);
                try {
                    u0.b bVar = (u0.b) this.f1170b;
                    bVar.getClass();
                    Parcel obtain = Parcel.obtain();
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean z9 = true;
                    Parcel a8 = bVar.a(obtain, 1);
                    String readString = a8.readString();
                    a8.recycle();
                    u0.b bVar2 = (u0.b) this.f1170b;
                    bVar2.getClass();
                    Parcel obtain2 = Parcel.obtain();
                    obtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int i = u0.a.f10393a;
                    obtain2.writeInt(1);
                    Parcel a10 = bVar2.a(obtain2, 2);
                    if (a10.readInt() == 0) {
                        z9 = false;
                    }
                    a10.recycle();
                    aVar = new a(0, readString, z9);
                } catch (RemoteException e11) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e11);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
        return aVar;
    }

    public final void f() {
        synchronized (this.f1172d) {
            d dVar = this.f1173e;
            if (dVar != null) {
                dVar.f1178l.countDown();
                try {
                    this.f1173e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.g;
            if (j > 0) {
                this.f1173e = new d(this, j);
            }
        }
    }

    public final void finalize() {
        b();
        super.finalize();
    }
}
