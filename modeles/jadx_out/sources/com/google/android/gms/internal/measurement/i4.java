package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i4 {

    /* renamed from: d, reason: collision with root package name */
    public static i4 f2661d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f2662a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2663b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2664c;

    public i4(int i) {
        switch (i) {
            case 2:
                this.f2663b = new Object();
                break;
            default:
                this.f2662a = false;
                this.f2663b = null;
                this.f2664c = null;
                break;
        }
    }

    public static final void a(i4 i4Var, Context context, String str, x4.g2 g2Var) {
        i4Var.f2662a = true;
        x4.u2.c(context);
        i4Var.f2663b = null;
        if (str != null) {
            i4Var.f2664c = str;
        }
        Bundle f = k0.k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "loginSource", "google");
        if (g2Var != null) {
            f.putString("responseCode", String.valueOf(g2Var.f11204b));
            String str2 = g2Var.f11205c;
            if (str2 != null) {
                f.putString("exception", str2);
            }
        }
        new android.support.v4.media.g(context, 20).E(f, "login");
    }

    public static i4 d(Context context) {
        i4 i4Var;
        i4 i4Var2;
        synchronized (i4.class) {
            try {
                if (f2661d == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        i4Var2 = new i4();
                        i4Var2.f2662a = false;
                        i4Var2.f2663b = context;
                        i4Var2.f2664c = new h4(null);
                    } else {
                        i4Var2 = new i4(0);
                    }
                    f2661d = i4Var2;
                }
                i4 i4Var3 = f2661d;
                if (i4Var3 != null && ((h4) i4Var3.f2664c) != null && !i4Var3.f2662a) {
                    try {
                        context.getContentResolver().registerContentObserver(y3.f2909a, true, (h4) f2661d.f2664c);
                        i4 i4Var4 = f2661d;
                        i4Var4.getClass();
                        i4Var4.f2662a = true;
                    } catch (SecurityException e10) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e10);
                    }
                }
                i4Var = f2661d;
                i4Var.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return i4Var;
    }

    public static synchronized void h() {
        Context context;
        synchronized (i4.class) {
            try {
                i4 i4Var = f2661d;
                if (i4Var != null && (context = (Context) i4Var.f2663b) != null && ((h4) i4Var.f2664c) != null && i4Var.f2662a) {
                    context.getContentResolver().unregisterContentObserver((h4) f2661d.f2664c);
                }
                f2661d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(i0.b bVar, j1.i iVar) {
        g5.f fVar = (g5.f) ((g5.g) this.f2664c).f5315b;
        fVar.getClass();
        m0.a aVar = (m0.a) ((m0.c) bVar).t();
        k0.n nVar = (k0.n) fVar.f5309b;
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(aVar.f2893k);
        int i = x0.a.f11033a;
        if (nVar == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            nVar.writeToParcel(obtain, 0);
        }
        try {
            aVar.j.transact(1, obtain, null, 1);
            obtain.recycle();
            iVar.a(null);
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    public Object c(String str, Context context, v6.i iVar) {
        this.f2663b = new x4.w2();
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        v7.e eVar = o7.m0.f8288a;
        Object C = o7.c0.C(new c4.w(context, xVar, str, this, (t6.c) null), v7.d.f10884a, iVar);
        return C == u6.a.f10762a ? C : p6.x.f8463a;
    }

    public void e(j1.n nVar) {
        synchronized (this.f2663b) {
            try {
                if (((ArrayDeque) this.f2664c) == null) {
                    this.f2664c = new ArrayDeque();
                }
                ((ArrayDeque) this.f2664c).add(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String f(String str) {
        Object a8;
        Context context = (Context) this.f2663b;
        if (context != null && (!c4.a() || c4.b(context))) {
            try {
                try {
                    t tVar = new t(this, str);
                    try {
                        a8 = tVar.a();
                    } catch (SecurityException unused) {
                        long clearCallingIdentity = Binder.clearCallingIdentity();
                        try {
                            a8 = tVar.a();
                        } finally {
                            Binder.restoreCallingIdentity(clearCallingIdentity);
                        }
                    }
                    return (String) a8;
                } catch (SecurityException e10) {
                    e = e10;
                    Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                    return null;
                }
            } catch (IllegalStateException e11) {
                e = e11;
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                return null;
            } catch (NullPointerException e12) {
                e = e12;
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                return null;
            }
        }
        return null;
    }

    public void g(j1.p pVar) {
        j1.n nVar;
        synchronized (this.f2663b) {
            if (((ArrayDeque) this.f2664c) != null && !this.f2662a) {
                this.f2662a = true;
                while (true) {
                    synchronized (this.f2663b) {
                        try {
                            nVar = (j1.n) ((ArrayDeque) this.f2664c).poll();
                            if (nVar == null) {
                                this.f2662a = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    nVar.a(pVar);
                }
            }
        }
    }
}
