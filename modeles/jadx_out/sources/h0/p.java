package h0;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import k0.v;
import k0.w;
import k0.x;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final k f5433a;

    /* renamed from: b, reason: collision with root package name */
    public static final k f5434b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile x f5435c;

    /* renamed from: d, reason: collision with root package name */
    public static final Object f5436d;

    /* renamed from: e, reason: collision with root package name */
    public static Context f5437e;

    static {
        new k(l.K("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"), 0);
        new k(l.K("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"), 1);
        new k(l.K("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"), 2);
        new k(l.K("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"), 3);
        f5433a = new k(l.K("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 4);
        f5434b = new k(l.K("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 5);
        f5436d = new Object();
    }

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            if (f5437e != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f5437e = context.getApplicationContext();
            }
        }
    }

    public static void b() {
        x vVar;
        if (f5435c != null) {
            return;
        }
        y.g(f5437e);
        synchronized (f5436d) {
            try {
                if (f5435c == null) {
                    IBinder b7 = t0.e.c(f5437e, t0.e.f9491d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = w.j;
                    if (b7 == null) {
                        vVar = null;
                    } else {
                        IInterface queryLocalInterface = b7.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        vVar = queryLocalInterface instanceof x ? (x) queryLocalInterface : new v(b7, "com.google.android.gms.common.internal.IGoogleCertificatesApi", 3);
                    }
                    f5435c = vVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static s c(String str, m mVar, boolean z9, boolean z10) {
        try {
            b();
            y.g(f5437e);
            try {
                x xVar = f5435c;
                s0.b bVar = new s0.b(f5437e.getPackageManager());
                v vVar = (v) xVar;
                Parcel G = vVar.G();
                int i = z0.g.f11901a;
                boolean z11 = true;
                G.writeInt(1);
                int Y = a.a.Y(G, 20293);
                a.a.T(G, 1, str);
                a.a.R(G, 2, mVar);
                a.a.X(G, 3, 4);
                G.writeInt(z9 ? 1 : 0);
                a.a.X(G, 4, 4);
                G.writeInt(z10 ? 1 : 0);
                a.a.a0(G, Y);
                z0.g.b(G, bVar);
                Parcel c9 = vVar.c(G, 5);
                if (c9.readInt() == 0) {
                    z11 = false;
                }
                c9.recycle();
                return z11 ? s.f5444d : new r(new n(z9, str, mVar));
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return s.c("module call", e10);
            }
        } catch (t0.b e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            return s.c("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }
}
