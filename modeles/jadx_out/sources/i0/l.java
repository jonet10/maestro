package i0;

import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import k0.g0;
import k0.m;
import k0.n;
import k0.r;
import k0.s;
import x4.b3;
import x4.d1;
import x4.d2;
import x4.d3;
import x4.j0;
import x4.k0;
import x4.k2;
import x4.l2;
import x4.q2;
import x4.t1;
import x4.w2;
import x4.x2;
import x4.y1;
import x4.z2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5622a;

    public /* synthetic */ l(int i) {
        this.f5622a = i;
    }

    public static void a(k0.g gVar, Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        int i6 = gVar.f6863a;
        a.a.X(parcel, 1, 4);
        parcel.writeInt(i6);
        int i10 = gVar.f6864b;
        a.a.X(parcel, 2, 4);
        parcel.writeInt(i10);
        int i11 = gVar.f6865l;
        a.a.X(parcel, 3, 4);
        parcel.writeInt(i11);
        a.a.T(parcel, 4, gVar.f6866m);
        a.a.R(parcel, 5, gVar.f6867n);
        a.a.U(parcel, 6, gVar.f6868o, i);
        a.a.Q(7, gVar.f6869p, parcel);
        a.a.S(parcel, 8, gVar.f6870q, i);
        a.a.U(parcel, 10, gVar.f6871r, i);
        a.a.U(parcel, 11, gVar.f6872s, i);
        boolean z9 = gVar.f6873t;
        a.a.X(parcel, 12, 4);
        parcel.writeInt(z9 ? 1 : 0);
        int i12 = gVar.f6874u;
        a.a.X(parcel, 13, 4);
        parcel.writeInt(i12);
        boolean z10 = gVar.v;
        a.a.X(parcel, 14, 4);
        parcel.writeInt(z10 ? 1 : 0);
        a.a.T(parcel, 15, gVar.f6875w);
        a.a.a0(parcel, Y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f5622a) {
            case 0:
                int L = t0.f.L(parcel);
                String str = null;
                h0.b bVar = null;
                int i = 0;
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < L) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 1) {
                        i = t0.f.E(parcel, readInt);
                    } else if (c9 == 2) {
                        str = t0.f.p(parcel, readInt);
                    } else if (c9 == 3) {
                        pendingIntent = (PendingIntent) t0.f.o(parcel, readInt, PendingIntent.CREATOR);
                    } else if (c9 != 4) {
                        t0.f.H(parcel, readInt);
                    } else {
                        bVar = (h0.b) t0.f.o(parcel, readInt, h0.b.CREATOR);
                    }
                }
                t0.f.t(parcel, L);
                return new Status(i, str, pendingIntent, bVar);
            case 1:
                int L2 = t0.f.L(parcel);
                ArrayList arrayList = null;
                int i6 = 0;
                while (parcel.dataPosition() < L2) {
                    int readInt2 = parcel.readInt();
                    char c10 = (char) readInt2;
                    if (c10 == 1) {
                        i6 = t0.f.E(parcel, readInt2);
                    } else if (c10 != 2) {
                        t0.f.H(parcel, readInt2);
                    } else {
                        arrayList = t0.f.r(parcel, readInt2, k0.j.CREATOR);
                    }
                }
                t0.f.t(parcel, L2);
                return new n(i6, arrayList);
            case 2:
                int L3 = t0.f.L(parcel);
                int i10 = -1;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                String str2 = null;
                String str3 = null;
                long j = 0;
                long j6 = 0;
                while (parcel.dataPosition() < L3) {
                    int readInt3 = parcel.readInt();
                    switch ((char) readInt3) {
                        case 1:
                            i11 = t0.f.E(parcel, readInt3);
                            break;
                        case 2:
                            i12 = t0.f.E(parcel, readInt3);
                            break;
                        case 3:
                            i13 = t0.f.E(parcel, readInt3);
                            break;
                        case 4:
                            j = t0.f.F(parcel, readInt3);
                            break;
                        case 5:
                            j6 = t0.f.F(parcel, readInt3);
                            break;
                        case 6:
                            str2 = t0.f.p(parcel, readInt3);
                            break;
                        case 7:
                            str3 = t0.f.p(parcel, readInt3);
                            break;
                        case '\b':
                            i14 = t0.f.E(parcel, readInt3);
                            break;
                        case '\t':
                            i10 = t0.f.E(parcel, readInt3);
                            break;
                        default:
                            t0.f.H(parcel, readInt3);
                            break;
                    }
                }
                t0.f.t(parcel, L3);
                return new k0.j(i11, i12, i13, j, j6, str2, str3, i14, i10);
            case 3:
                int L4 = t0.f.L(parcel);
                Account account = null;
                int i15 = 0;
                int i16 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < L4) {
                    int readInt4 = parcel.readInt();
                    char c11 = (char) readInt4;
                    if (c11 == 1) {
                        i15 = t0.f.E(parcel, readInt4);
                    } else if (c11 == 2) {
                        account = (Account) t0.f.o(parcel, readInt4, Account.CREATOR);
                    } else if (c11 == 3) {
                        i16 = t0.f.E(parcel, readInt4);
                    } else if (c11 != 4) {
                        t0.f.H(parcel, readInt4);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) t0.f.o(parcel, readInt4, GoogleSignInAccount.CREATOR);
                    }
                }
                t0.f.t(parcel, L4);
                return new r(i15, account, i16, googleSignInAccount);
            case 4:
                int L5 = t0.f.L(parcel);
                int i17 = 0;
                boolean z9 = false;
                boolean z10 = false;
                IBinder iBinder = null;
                h0.b bVar2 = null;
                while (parcel.dataPosition() < L5) {
                    int readInt5 = parcel.readInt();
                    char c12 = (char) readInt5;
                    if (c12 == 1) {
                        i17 = t0.f.E(parcel, readInt5);
                    } else if (c12 == 2) {
                        iBinder = t0.f.D(parcel, readInt5);
                    } else if (c12 == 3) {
                        bVar2 = (h0.b) t0.f.o(parcel, readInt5, h0.b.CREATOR);
                    } else if (c12 == 4) {
                        z9 = t0.f.C(parcel, readInt5);
                    } else if (c12 != 5) {
                        t0.f.H(parcel, readInt5);
                    } else {
                        z10 = t0.f.C(parcel, readInt5);
                    }
                }
                t0.f.t(parcel, L5);
                return new s(i17, iBinder, bVar2, z9, z10);
            case 5:
                int L6 = t0.f.L(parcel);
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                boolean z11 = false;
                boolean z12 = false;
                while (parcel.dataPosition() < L6) {
                    int readInt6 = parcel.readInt();
                    char c13 = (char) readInt6;
                    if (c13 == 1) {
                        i18 = t0.f.E(parcel, readInt6);
                    } else if (c13 == 2) {
                        z11 = t0.f.C(parcel, readInt6);
                    } else if (c13 == 3) {
                        z12 = t0.f.C(parcel, readInt6);
                    } else if (c13 == 4) {
                        i19 = t0.f.E(parcel, readInt6);
                    } else if (c13 != 5) {
                        t0.f.H(parcel, readInt6);
                    } else {
                        i20 = t0.f.E(parcel, readInt6);
                    }
                }
                t0.f.t(parcel, L6);
                return new m(i18, i19, i20, z11, z12);
            case 6:
                int L7 = t0.f.L(parcel);
                Bundle bundle = null;
                k0.f fVar = null;
                int i21 = 0;
                h0.d[] dVarArr = null;
                while (parcel.dataPosition() < L7) {
                    int readInt7 = parcel.readInt();
                    char c14 = (char) readInt7;
                    if (c14 == 1) {
                        bundle = t0.f.n(parcel, readInt7);
                    } else if (c14 == 2) {
                        dVarArr = (h0.d[]) t0.f.q(parcel, readInt7, h0.d.CREATOR);
                    } else if (c14 == 3) {
                        i21 = t0.f.E(parcel, readInt7);
                    } else if (c14 != 4) {
                        t0.f.H(parcel, readInt7);
                    } else {
                        fVar = (k0.f) t0.f.o(parcel, readInt7, k0.f.CREATOR);
                    }
                }
                t0.f.t(parcel, L7);
                g0 g0Var = new g0();
                g0Var.f6876a = bundle;
                g0Var.f6877b = dVarArr;
                g0Var.f6878l = i21;
                g0Var.f6879m = fVar;
                return g0Var;
            case 7:
                int L8 = t0.f.L(parcel);
                m mVar = null;
                int[] iArr = null;
                int[] iArr2 = null;
                boolean z13 = false;
                boolean z14 = false;
                int i22 = 0;
                while (parcel.dataPosition() < L8) {
                    int readInt8 = parcel.readInt();
                    switch ((char) readInt8) {
                        case 1:
                            mVar = (m) t0.f.o(parcel, readInt8, m.CREATOR);
                            break;
                        case 2:
                            z13 = t0.f.C(parcel, readInt8);
                            break;
                        case 3:
                            z14 = t0.f.C(parcel, readInt8);
                            break;
                        case 4:
                            int G = t0.f.G(parcel, readInt8);
                            int dataPosition = parcel.dataPosition();
                            if (G != 0) {
                                iArr = parcel.createIntArray();
                                parcel.setDataPosition(dataPosition + G);
                                break;
                            } else {
                                iArr = null;
                                break;
                            }
                        case 5:
                            i22 = t0.f.E(parcel, readInt8);
                            break;
                        case 6:
                            int G2 = t0.f.G(parcel, readInt8);
                            int dataPosition2 = parcel.dataPosition();
                            if (G2 != 0) {
                                iArr2 = parcel.createIntArray();
                                parcel.setDataPosition(dataPosition2 + G2);
                                break;
                            } else {
                                iArr2 = null;
                                break;
                            }
                        default:
                            t0.f.H(parcel, readInt8);
                            break;
                    }
                }
                t0.f.t(parcel, L8);
                return new k0.f(mVar, z13, z14, iArr, i22, iArr2);
            case 8:
                int L9 = t0.f.L(parcel);
                Bundle bundle2 = new Bundle();
                Scope[] scopeArr = k0.g.f6861x;
                String str4 = null;
                IBinder iBinder2 = null;
                Account account2 = null;
                String str5 = null;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                boolean z15 = false;
                int i26 = 0;
                boolean z16 = false;
                h0.d[] dVarArr2 = k0.g.f6862y;
                h0.d[] dVarArr3 = dVarArr2;
                while (parcel.dataPosition() < L9) {
                    int readInt9 = parcel.readInt();
                    switch ((char) readInt9) {
                        case 1:
                            i23 = t0.f.E(parcel, readInt9);
                            break;
                        case 2:
                            i24 = t0.f.E(parcel, readInt9);
                            break;
                        case 3:
                            i25 = t0.f.E(parcel, readInt9);
                            break;
                        case 4:
                            str4 = t0.f.p(parcel, readInt9);
                            break;
                        case 5:
                            iBinder2 = t0.f.D(parcel, readInt9);
                            break;
                        case 6:
                            scopeArr = (Scope[]) t0.f.q(parcel, readInt9, Scope.CREATOR);
                            break;
                        case 7:
                            bundle2 = t0.f.n(parcel, readInt9);
                            break;
                        case '\b':
                            account2 = (Account) t0.f.o(parcel, readInt9, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            t0.f.H(parcel, readInt9);
                            break;
                        case '\n':
                            dVarArr2 = (h0.d[]) t0.f.q(parcel, readInt9, h0.d.CREATOR);
                            break;
                        case 11:
                            dVarArr3 = (h0.d[]) t0.f.q(parcel, readInt9, h0.d.CREATOR);
                            break;
                        case '\f':
                            z15 = t0.f.C(parcel, readInt9);
                            break;
                        case '\r':
                            i26 = t0.f.E(parcel, readInt9);
                            break;
                        case 14:
                            z16 = t0.f.C(parcel, readInt9);
                            break;
                        case 15:
                            str5 = t0.f.p(parcel, readInt9);
                            break;
                    }
                }
                t0.f.t(parcel, L9);
                return new k0.g(i23, i24, i25, str4, iBinder2, scopeArr, bundle2, account2, dVarArr2, dVarArr3, z15, i26, z16, str5);
            case 9:
                parcel.getClass();
                x4.e eVar = new x4.e();
                eVar.f11121a = -1L;
                eVar.f11124m = -1L;
                x4.d dVar = x4.d.f11088b;
                eVar.f11127p = dVar;
                eVar.H = -1;
                eVar.f11121a = parcel.readLong();
                eVar.f11122b = parcel.readString();
                eVar.f11123l = parcel.readString();
                eVar.f11124m = parcel.readLong();
                eVar.f11125n = parcel.readString();
                eVar.f11126o = parcel.readString();
                int readInt10 = parcel.readInt();
                if (readInt10 == 0) {
                    eVar.f11127p = x4.d.f11087a;
                } else if (readInt10 != 1) {
                    eVar.f11127p = x4.d.f11089l;
                } else {
                    eVar.f11127p = dVar;
                }
                eVar.f11128q = parcel.readInt();
                eVar.f11129r = parcel.readInt();
                eVar.f11130s = parcel.readInt();
                eVar.f11131t = parcel.readInt();
                eVar.f11132u = parcel.readString();
                eVar.v = parcel.readInt();
                eVar.f11133w = parcel.readLong();
                eVar.f11134x = parcel.readLong();
                eVar.f11135y = parcel.readInt();
                eVar.f11136z = parcel.readString();
                eVar.A = parcel.readLong();
                eVar.B = parcel.readString();
                eVar.C = parcel.readInt();
                eVar.F = parcel.readLong();
                eVar.G = parcel.readInt();
                eVar.K = parcel.readInt() == 1;
                return eVar;
            case 10:
                parcel.getClass();
                return new x4.g(parcel);
            case 11:
                parcel.getClass();
                x4.j jVar = new x4.j((int) (0 == true ? 1 : 0), (String) null, 7);
                jVar.f11224a = parcel.readInt();
                jVar.f11225b = parcel.readString();
                jVar.f11226l = parcel.readString();
                jVar.f11227m = parcel.readInt() == 1;
                jVar.f11228n = parcel.readInt() == 1;
                jVar.f11229o = parcel.readInt();
                jVar.f11230p = parcel.readInt();
                jVar.f11231q = parcel.createTypedArrayList(x4.j.CREATOR);
                return jVar;
            case 12:
                parcel.getClass();
                x4.r rVar = new x4.r();
                rVar.f11354a = -1;
                rVar.f11357m = 1;
                rVar.f11358n = -1L;
                rVar.f11361q = -1L;
                rVar.f11369z = -1L;
                rVar.C = -1L;
                rVar.D = -1L;
                rVar.F = new ArrayList();
                rVar.f11354a = parcel.readInt();
                rVar.f11355b = parcel.readString();
                rVar.f11356l = parcel.readInt();
                rVar.f11357m = parcel.readInt();
                rVar.f11358n = parcel.readLong();
                rVar.f11359o = parcel.readString();
                rVar.f11360p = parcel.readInt();
                rVar.f11361q = parcel.readLong();
                rVar.f11362r = parcel.readInt();
                rVar.f11363s = parcel.readString();
                rVar.f11364t = parcel.readString();
                rVar.f11365u = parcel.readInt();
                rVar.v = parcel.readString();
                rVar.f11366w = parcel.readString();
                rVar.f11367x = parcel.readLong();
                rVar.f11368y = parcel.createStringArrayList();
                parcel.readTypedList(rVar.F, j0.CREATOR);
                rVar.f11369z = parcel.readLong();
                rVar.A = parcel.readInt();
                rVar.B = parcel.readInt();
                return rVar;
            case 13:
                parcel.getClass();
                j0 j0Var = new j0();
                j0Var.f11233a = -1L;
                j0Var.f11234b = -1L;
                j0Var.f11235l = -1L;
                j0Var.f11237n = -1L;
                j0Var.f11233a = parcel.readLong();
                j0Var.f11234b = parcel.readLong();
                j0Var.f11235l = parcel.readLong();
                j0Var.f11236m = parcel.readString();
                j0Var.f11237n = parcel.readLong();
                j0Var.f11238o = parcel.readLong();
                j0Var.f11239p = parcel.readString();
                j0Var.f11240q = parcel.readString();
                j0Var.f11241r = parcel.readInt();
                j0Var.f11242s = parcel.readLong();
                return j0Var;
            case 14:
                parcel.getClass();
                k0 k0Var = new k0();
                k0Var.f11252a = -1;
                k0Var.f11255m = 1;
                k0Var.f11252a = parcel.readInt();
                k0Var.f11253b = parcel.readLong();
                k0Var.f11254l = parcel.readString();
                k0Var.f11255m = parcel.readInt();
                return k0Var;
            case 15:
                parcel.getClass();
                d1 d1Var = new d1();
                d1Var.f11091a = parcel.readLong();
                d1Var.f11092b = parcel.readString();
                d1Var.f11093l = parcel.readLong();
                d1Var.f11094m = parcel.readString();
                d1Var.f11095n = parcel.readInt();
                d1Var.f11096o = parcel.readString();
                d1Var.f11097p = parcel.readInt();
                d1Var.f11098q = parcel.readString();
                d1Var.f11099r = parcel.readString();
                d1Var.f11100s = parcel.readString();
                d1Var.f11101t = parcel.readLong();
                d1Var.f11102u = parcel.readString();
                d1Var.v = parcel.readInt();
                d1Var.f11103w = parcel.readString();
                d1Var.f11104x = parcel.readLong();
                d1Var.f11105y = parcel.readString();
                d1Var.f11106z = parcel.readString();
                d1Var.A = parcel.readLong();
                d1Var.B = parcel.readLong();
                d1Var.C = parcel.readString();
                d1Var.D = parcel.readString();
                d1Var.E = parcel.readString();
                d1Var.F = parcel.readString();
                d1Var.G = parcel.readInt();
                return d1Var;
            case 16:
                parcel.getClass();
                t1 t1Var = new t1();
                t1Var.f11397b = -1L;
                t1Var.f11399m = -1L;
                t1Var.f11404r = new ArrayList();
                t1Var.f11396a = parcel.readString();
                t1Var.f11398l = parcel.readString();
                t1Var.f11399m = parcel.readLong();
                t1Var.f11400n = parcel.readString();
                t1Var.f11401o = parcel.readString();
                t1Var.f11402p = parcel.readString();
                t1Var.f11397b = parcel.readLong();
                return t1Var;
            case 17:
                parcel.getClass();
                y1 y1Var = new y1();
                y1Var.f11467a = parcel.readString();
                y1Var.f11468b = parcel.readInt();
                y1Var.f11469l = parcel.readInt();
                y1Var.f11470m = parcel.readString();
                y1Var.f11471n = parcel.readInt();
                return y1Var;
            case 18:
                parcel.getClass();
                d2 d2Var = new d2();
                d2Var.f11107a = parcel.readLong();
                d2Var.f11111n = parcel.readLong();
                d2Var.f11108b = parcel.readString();
                d2Var.f11109l = parcel.readString();
                d2Var.f11110m = parcel.readString();
                d2Var.f11112o = parcel.readString();
                d2Var.f11113p = parcel.readString();
                d2Var.f11114q = parcel.readInt();
                d2Var.f11115r = parcel.readInt();
                d2Var.f11116s = parcel.readInt();
                d2Var.f11117t = parcel.readString();
                d2Var.f11118u = parcel.readInt();
                return d2Var;
            case 19:
                parcel.getClass();
                k2 k2Var = new k2();
                k2Var.f11258a = parcel.readLong();
                k2Var.f11262n = parcel.readLong();
                k2Var.f11260l = parcel.readString();
                k2Var.f11259b = parcel.readString();
                k2Var.f11261m = parcel.readString();
                k2Var.f11263o = parcel.readString();
                k2Var.f11264p = parcel.readInt();
                k2Var.f11265q = parcel.readInt();
                k2Var.f11266r = parcel.readString();
                k2Var.f11267s = parcel.readInt();
                k2Var.f11268t = parcel.readInt();
                k2Var.f11269u = parcel.readString();
                k2Var.v = parcel.readInt();
                k2Var.f11270w = parcel.readString();
                k2Var.f11271x = parcel.readInt();
                return k2Var;
            case 20:
                parcel.getClass();
                l2 l2Var = new l2();
                l2Var.f11277a = parcel.readString();
                l2Var.f11278b = parcel.readInt();
                l2Var.f11279l = parcel.readInt();
                l2Var.f11280m = parcel.readInt();
                return l2Var;
            case 21:
                parcel.getClass();
                return new q2(parcel);
            case 22:
                parcel.getClass();
                w2 w2Var = new w2();
                w2Var.f11435n = -1L;
                w2Var.f11436o = "type0";
                w2Var.f11439r = -1;
                w2Var.f11431a = parcel.readString();
                w2Var.f11432b = parcel.readString();
                w2Var.f11433l = parcel.readString();
                w2Var.f11434m = parcel.readString();
                w2Var.v = parcel.readString();
                w2Var.f11436o = parcel.readString();
                w2Var.f11435n = parcel.readLong();
                w2Var.f11437p = parcel.readString();
                w2Var.f11443w = parcel.readInt() == 1;
                w2Var.f11438q = parcel.readInt();
                w2Var.f11442u = parcel.readString();
                w2Var.f11439r = parcel.readInt();
                w2Var.f11440s = parcel.readInt();
                w2Var.f11441t = parcel.readInt();
                w2Var.f11444x = parcel.readInt() == 1;
                w2Var.f11445y = parcel.readInt() == 1;
                return w2Var;
            case 23:
                parcel.getClass();
                x2 x2Var = new x2();
                x2Var.f11453a = parcel.readString();
                x2Var.f11454b = parcel.readInt();
                x2Var.f11455l = parcel.readInt();
                x2Var.f11456m = parcel.readInt();
                x2Var.f11457n = parcel.readInt();
                x2Var.f11458o = parcel.readInt();
                x2Var.f11459p = parcel.readInt();
                x2Var.f11460q = parcel.readInt();
                return x2Var;
            case 24:
                parcel.getClass();
                return new z2(parcel);
            case 25:
                parcel.getClass();
                b3 b3Var = new b3();
                b3Var.f11065a = parcel.readLong();
                b3Var.f11066b = parcel.readString();
                b3Var.f11068m = parcel.readInt();
                b3Var.f11069n = parcel.readInt();
                b3Var.f11067l = parcel.readInt();
                b3Var.f11070o = parcel.readInt();
                return b3Var;
            case 26:
                parcel.getClass();
                d3 d3Var = new d3();
                d3Var.f11119a = parcel.readString();
                d3Var.f11120b = parcel.readString();
                return d3Var;
            default:
                int L10 = t0.f.L(parcel);
                Bundle bundle3 = null;
                while (parcel.dataPosition() < L10) {
                    int readInt11 = parcel.readInt();
                    if (((char) readInt11) != 2) {
                        t0.f.H(parcel, readInt11);
                    } else {
                        bundle3 = t0.f.n(parcel, readInt11);
                    }
                }
                t0.f.t(parcel, L10);
                return new y2.r(bundle3);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f5622a) {
            case 0:
                return new Status[i];
            case 1:
                return new n[i];
            case 2:
                return new k0.j[i];
            case 3:
                return new r[i];
            case 4:
                return new s[i];
            case 5:
                return new m[i];
            case 6:
                return new g0[i];
            case 7:
                return new k0.f[i];
            case 8:
                return new k0.g[i];
            case 9:
                return new x4.e[i];
            case 10:
                return new x4.g[i];
            case 11:
                return new x4.j[i];
            case 12:
                return new x4.r[i];
            case 13:
                return new j0[i];
            case 14:
                return new k0[i];
            case 15:
                return new d1[i];
            case 16:
                return new t1[i];
            case 17:
                return new y1[i];
            case 18:
                return new d2[i];
            case 19:
                return new k2[i];
            case 20:
                return new l2[i];
            case 21:
                return new q2[i];
            case 22:
                return new w2[i];
            case 23:
                return new x2[i];
            case 24:
                return new z2[i];
            case 25:
                return new b3[i];
            case 26:
                return new d3[i];
            default:
                return new y2.r[i];
        }
    }
}
