package e1;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c2 extends com.google.android.gms.internal.measurement.y implements i0 {
    public final u4 i;
    public Boolean j;

    /* renamed from: k, reason: collision with root package name */
    public String f3846k;

    public c2(u4 u4Var) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        k0.y.g(u4Var);
        this.i = u4Var;
        this.f3846k = null;
    }

    @Override // e1.i0
    public final void A(x4 x4Var, c5 c5Var) {
        k0.y.g(x4Var);
        d(c5Var);
        H(new x1(this, x4Var, c5Var, 3));
    }

    @Override // e1.i0
    public final void B(c5 c5Var) {
        String str = c5Var.f3850a;
        k0.y.d(str);
        G(str, false);
        H(new v1(this, c5Var, 3));
    }

    @Override // e1.i0
    public final void C(c5 c5Var) {
        d(c5Var);
        H(new v1(this, c5Var, 1));
    }

    @Override // e1.i0
    public final void D(Bundle bundle, c5 c5Var) {
        d(c5Var);
        String str = c5Var.f3850a;
        k0.y.g(str);
        H(new b2(this, bundle, str, c5Var));
    }

    @Override // e1.i0
    public final List E(String str, String str2, boolean z9, c5 c5Var) {
        d(c5Var);
        String str3 = c5Var.f3850a;
        k0.y.g(str3);
        u4 u4Var = this.i;
        try {
            List<y4> list = (List) u4Var.b().n(new y1(this, str3, str, str2, 0)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (y4 y4Var : list) {
                if (!z9 && a5.F(y4Var.f4427c)) {
                }
                arrayList.add(new x4(y4Var));
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            u4Var.a().f4339o.d(w0.o(str3), "Failed to query user properties. appId", e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            u4Var.a().f4339o.d(w0.o(str3), "Failed to query user properties. appId", e);
            return Collections.EMPTY_LIST;
        }
    }

    public final void G(String str, boolean z9) {
        boolean isEmpty = TextUtils.isEmpty(str);
        u4 u4Var = this.i;
        if (isEmpty) {
            u4Var.a().f4339o.b("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z9) {
            try {
                if (this.j == null) {
                    boolean z10 = true;
                    if (!"com.google.android.gms".equals(this.f3846k) && !p0.b.b(u4Var.f4316u.f4259a, Binder.getCallingUid()) && !h0.h.a(u4Var.f4316u.f4259a).b(Binder.getCallingUid())) {
                        z10 = false;
                    }
                    this.j = Boolean.valueOf(z10);
                }
                if (this.j.booleanValue()) {
                    return;
                }
            } catch (SecurityException e10) {
                u4Var.a().f4339o.c(w0.o(str), "Measurement Service called with invalid calling package. appId");
                throw e10;
            }
        }
        if (this.f3846k == null) {
            Context context = u4Var.f4316u.f4259a;
            int callingUid = Binder.getCallingUid();
            AtomicBoolean atomicBoolean = h0.g.f5410a;
            if (p0.b.d(context, callingUid, str)) {
                this.f3846k = str;
            }
        }
        if (str.equals(this.f3846k)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    public final void H(Runnable runnable) {
        u4 u4Var = this.i;
        if (u4Var.b().m()) {
            runnable.run();
        } else {
            u4Var.b().p(runnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        boolean z9;
        List list;
        u4 u4Var = this.i;
        ArrayList arrayList = null;
        k0 k0Var = null;
        m0 m0Var = null;
        switch (i) {
            case 1:
                u uVar = (u) com.google.android.gms.internal.measurement.z.a(parcel, u.CREATOR);
                c5 c5Var = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                v(uVar, c5Var);
                parcel2.writeNoException();
                return true;
            case 2:
                x4 x4Var = (x4) com.google.android.gms.internal.measurement.z.a(parcel, x4.CREATOR);
                c5 c5Var2 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                A(x4Var, c5Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                c5 c5Var3 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                p(c5Var3);
                parcel2.writeNoException();
                return true;
            case 5:
                u uVar2 = (u) com.google.android.gms.internal.measurement.z.a(parcel, u.CREATOR);
                String readString = parcel.readString();
                parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                k0.y.g(uVar2);
                k0.y.d(readString);
                G(readString, true);
                H(new x1(this, uVar2, readString, 2));
                parcel2.writeNoException();
                return true;
            case 6:
                c5 c5Var4 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                r(c5Var4);
                parcel2.writeNoException();
                return true;
            case 7:
                c5 c5Var5 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                Object[] objArr = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.z.d(parcel);
                d(c5Var5);
                String str = c5Var5.f3850a;
                k0.y.g(str);
                try {
                    List<y4> list2 = (List) u4Var.b().n(new u1(this, str, 0)).get();
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    for (y4 y4Var : list2) {
                        if (objArr == false && a5.F(y4Var.f4427c)) {
                        }
                        arrayList2.add(new x4(y4Var));
                    }
                    arrayList = arrayList2;
                } catch (InterruptedException e10) {
                    e = e10;
                    u4Var.a().f4339o.d(w0.o(str), "Failed to get user properties. appId", e);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                } catch (ExecutionException e11) {
                    e = e11;
                    u4Var.a().f4339o.d(w0.o(str), "Failed to get user properties. appId", e);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                u uVar3 = (u) com.google.android.gms.internal.measurement.z.a(parcel, u.CREATOR);
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                byte[] n10 = n(uVar3, readString2);
                parcel2.writeNoException();
                parcel2.writeByteArray(n10);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                j(readLong, readString3, readString4, readString5);
                parcel2.writeNoException();
                return true;
            case 11:
                c5 c5Var6 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                String z10 = z(c5Var6);
                parcel2.writeNoException();
                parcel2.writeString(z10);
                return true;
            case 12:
                e eVar = (e) com.google.android.gms.internal.measurement.z.a(parcel, e.CREATOR);
                c5 c5Var7 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                w(eVar, c5Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                e eVar2 = (e) com.google.android.gms.internal.measurement.z.a(parcel, e.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                k0.y.g(eVar2);
                k0.y.g(eVar2.f3884l);
                k0.y.d(eVar2.f3882a);
                G(eVar2.f3882a, true);
                H(new m1.a(this, new e(eVar2), 6, false));
                parcel2.writeNoException();
                return true;
            case 14:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                ClassLoader classLoader = com.google.android.gms.internal.measurement.z.f2922a;
                z9 = parcel.readInt() != 0;
                c5 c5Var8 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                List E = E(readString6, readString7, z9, c5Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(E);
                return true;
            case 15:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                ClassLoader classLoader2 = com.google.android.gms.internal.measurement.z.f2922a;
                z9 = parcel.readInt() != 0;
                com.google.android.gms.internal.measurement.z.d(parcel);
                List h = h(readString8, readString9, readString10, z9);
                parcel2.writeNoException();
                parcel2.writeTypedList(h);
                return true;
            case 16:
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                c5 c5Var9 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                List y9 = y(readString11, readString12, c5Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(y9);
                return true;
            case 17:
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                com.google.android.gms.internal.measurement.z.d(parcel);
                List o10 = o(readString13, readString14, readString15);
                parcel2.writeNoException();
                parcel2.writeTypedList(o10);
                return true;
            case 18:
                c5 c5Var10 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                B(c5Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.z.a(parcel, Bundle.CREATOR);
                c5 c5Var11 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                D(bundle, c5Var11);
                parcel2.writeNoException();
                return true;
            case 20:
                c5 c5Var12 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                i(c5Var12);
                parcel2.writeNoException();
                return true;
            case 21:
                c5 c5Var13 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                i f = f(c5Var13);
                parcel2.writeNoException();
                if (f == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                f.writeToParcel(parcel2, 1);
                return true;
            case 24:
                c5 c5Var14 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.z.a(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                d(c5Var14);
                String str2 = c5Var14.f3850a;
                k0.y.g(str2);
                if (u4Var.e0().q(null, f0.Z0)) {
                    try {
                        list = (List) u4Var.b().o(new z1(this, c5Var14, bundle2, 0)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e12) {
                        u4Var.a().f4339o.d(w0.o(str2), "Failed to get trigger URIs. appId", e12);
                        list = Collections.EMPTY_LIST;
                    }
                } else {
                    try {
                        list = (List) u4Var.b().n(new z1(this, c5Var14, bundle2, 1)).get();
                    } catch (InterruptedException | ExecutionException e13) {
                        u4Var.a().f4339o.d(w0.o(str2), "Failed to get trigger URIs. appId", e13);
                        list = Collections.EMPTY_LIST;
                    }
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(list);
                return true;
            case 25:
                c5 c5Var15 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                m(c5Var15);
                parcel2.writeNoException();
                return true;
            case 26:
                c5 c5Var16 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                s(c5Var16);
                parcel2.writeNoException();
                return true;
            case 27:
                c5 c5Var17 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                C(c5Var17);
                parcel2.writeNoException();
                return true;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                c5 c5Var18 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                n4 n4Var = (n4) com.google.android.gms.internal.measurement.z.a(parcel, n4.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    m0Var = queryLocalInterface instanceof m0 ? (m0) queryLocalInterface : new l0(readStrongBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback", 0);
                }
                com.google.android.gms.internal.measurement.z.d(parcel);
                g(c5Var18, n4Var, m0Var);
                parcel2.writeNoException();
                return true;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                c5 c5Var19 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                d dVar = (d) com.google.android.gms.internal.measurement.z.a(parcel, d.CREATOR);
                com.google.android.gms.internal.measurement.z.d(parcel);
                u(c5Var19, dVar);
                parcel2.writeNoException();
                return true;
            case 31:
                c5 c5Var20 = (c5) com.google.android.gms.internal.measurement.z.a(parcel, c5.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.z.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    k0Var = queryLocalInterface2 instanceof k0 ? (k0) queryLocalInterface2 : new j0(readStrongBinder2, "com.google.android.gms.measurement.internal.ITriggerUrisCallback", 0);
                }
                com.google.android.gms.internal.measurement.z.d(parcel);
                l(c5Var20, bundle3, k0Var);
                parcel2.writeNoException();
                return true;
        }
    }

    public final void c(Runnable runnable) {
        u4 u4Var = this.i;
        if (u4Var.b().m()) {
            runnable.run();
        } else {
            u4Var.b().r(runnable);
        }
    }

    public final void d(c5 c5Var) {
        k0.y.g(c5Var);
        String str = c5Var.f3850a;
        k0.y.d(str);
        G(str, false);
        this.i.k0().k(c5Var.f3851b);
    }

    @Override // e1.i0
    public final i f(c5 c5Var) {
        d(c5Var);
        String str = c5Var.f3850a;
        k0.y.d(str);
        u4 u4Var = this.i;
        try {
            return (i) u4Var.b().o(new u1(this, c5Var, 1)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            u4Var.a().f4339o.d(w0.o(str), "Failed to get consent. appId", e10);
            return new i(null);
        }
    }

    @Override // e1.i0
    public final void g(c5 c5Var, n4 n4Var, m0 m0Var) {
        d(c5Var);
        String str = c5Var.f3850a;
        k0.y.g(str);
        this.i.b().p(new b2(this, str, n4Var, m0Var, 0));
    }

    @Override // e1.i0
    public final List h(String str, String str2, String str3, boolean z9) {
        G(str, true);
        u4 u4Var = this.i;
        try {
            List<y4> list = (List) u4Var.b().n(new y1(this, str, str2, str3, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (y4 y4Var : list) {
                if (!z9 && a5.F(y4Var.f4427c)) {
                }
                arrayList.add(new x4(y4Var));
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            u4Var.a().f4339o.d(w0.o(str), "Failed to get user properties as. appId", e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            u4Var.a().f4339o.d(w0.o(str), "Failed to get user properties as. appId", e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // e1.i0
    public final void i(c5 c5Var) {
        k0.y.d(c5Var.f3850a);
        k0.y.g(c5Var.B);
        c(new v1(this, c5Var, 4));
    }

    @Override // e1.i0
    public final void j(long j, String str, String str2, String str3) {
        H(new w1(this, str2, str3, str, j, 0));
    }

    @Override // e1.i0
    public final void l(c5 c5Var, Bundle bundle, k0 k0Var) {
        d(c5Var);
        String str = c5Var.f3850a;
        k0.y.g(str);
        this.i.b().p(new a2(this, c5Var, bundle, k0Var, str));
    }

    @Override // e1.i0
    public final void m(c5 c5Var) {
        k0.y.d(c5Var.f3850a);
        k0.y.g(c5Var.B);
        c(new v1(this, c5Var, 6));
    }

    @Override // e1.i0
    public final byte[] n(u uVar, String str) {
        k0.y.d(str);
        k0.y.g(uVar);
        G(str, true);
        u4 u4Var = this.i;
        u0 u0Var = u4Var.a().v;
        t1 t1Var = u4Var.f4316u;
        q0 q0Var = t1Var.f4268s;
        String str2 = uVar.f4289a;
        u0Var.c(q0Var.a(str2), "Log and bundle. event");
        u4Var.f().getClass();
        long nanoTime = System.nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) u4Var.b().o(new l1(this, uVar, str)).get();
            if (bArr == null) {
                u4Var.a().f4339o.c(w0.o(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            u4Var.f().getClass();
            u4Var.a().v.e("Log and bundle processed. event, size, time_ms", t1Var.f4268s.a(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e10) {
            e = e10;
            u4Var.a().f4339o.e("Failed to log and bundle. appId, event, error", w0.o(str), t1Var.f4268s.a(str2), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            u4Var.a().f4339o.e("Failed to log and bundle. appId, event, error", w0.o(str), t1Var.f4268s.a(str2), e);
            return null;
        }
    }

    @Override // e1.i0
    public final List o(String str, String str2, String str3) {
        G(str, true);
        u4 u4Var = this.i;
        try {
            return (List) u4Var.b().n(new y1(this, str, str2, str3, 3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            u4Var.a().f4339o.c(e10, "Failed to get conditional user properties as");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // e1.i0
    public final void p(c5 c5Var) {
        d(c5Var);
        H(new v1(this, c5Var, 0));
    }

    @Override // e1.i0
    public final void r(c5 c5Var) {
        d(c5Var);
        H(new v1(this, c5Var, 2));
    }

    @Override // e1.i0
    public final void s(c5 c5Var) {
        k0.y.d(c5Var.f3850a);
        k0.y.g(c5Var.B);
        c(new v1(this, c5Var, 5));
    }

    @Override // e1.i0
    public final void u(c5 c5Var, d dVar) {
        d(c5Var);
        H(new x1((Object) this, c5Var, (Object) dVar, 4));
    }

    @Override // e1.i0
    public final void v(u uVar, c5 c5Var) {
        k0.y.g(uVar);
        d(c5Var);
        H(new x1(this, uVar, c5Var, 1));
    }

    @Override // e1.i0
    public final void w(e eVar, c5 c5Var) {
        k0.y.g(eVar);
        k0.y.g(eVar.f3884l);
        d(c5Var);
        e eVar2 = new e(eVar);
        eVar2.f3882a = c5Var.f3850a;
        H(new x1(this, eVar2, c5Var, 0));
    }

    @Override // e1.i0
    public final List y(String str, String str2, c5 c5Var) {
        d(c5Var);
        String str3 = c5Var.f3850a;
        k0.y.g(str3);
        u4 u4Var = this.i;
        try {
            return (List) u4Var.b().n(new y1(this, str3, str, str2, 2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            u4Var.a().f4339o.c(e10, "Failed to get conditional user properties");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // e1.i0
    public final String z(c5 c5Var) {
        d(c5Var);
        u4 u4Var = this.i;
        try {
            return (String) u4Var.b().n(new u1(u4Var, c5Var)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            u4Var.a().f4339o.d(w0.o(c5Var.f3850a), "Failed to get app instance id. appId", e10);
            return null;
        }
    }
}
