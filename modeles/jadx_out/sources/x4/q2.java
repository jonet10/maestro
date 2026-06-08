package x4;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q2 implements Parcelable {
    public static Parcelable.Creator<q2> CREATOR = new i0.l(21);

    /* renamed from: a, reason: collision with root package name */
    public long f11343a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11344b;

    /* renamed from: l, reason: collision with root package name */
    public long f11345l;

    /* renamed from: m, reason: collision with root package name */
    public String f11346m;

    /* renamed from: n, reason: collision with root package name */
    public int f11347n;

    /* renamed from: o, reason: collision with root package name */
    public int f11348o;

    /* renamed from: p, reason: collision with root package name */
    public int f11349p;

    /* renamed from: q, reason: collision with root package name */
    public String f11350q;

    /* renamed from: r, reason: collision with root package name */
    public int f11351r;

    /* renamed from: s, reason: collision with root package name */
    public r f11352s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f11353t;

    public q2(Parcel parcel) {
        this.f11343a = -1L;
        this.f11345l = -1L;
        this.f11343a = parcel.readLong();
        String readString = parcel.readString();
        readString.getClass();
        this.f11344b = readString;
        this.f11345l = parcel.readLong();
        this.f11346m = parcel.readString();
        this.f11347n = parcel.readInt();
        this.f11348o = parcel.readInt();
        this.f11349p = parcel.readInt();
        this.f11350q = parcel.readString();
        this.f11351r = parcel.readInt();
        if (Build.VERSION.SDK_INT >= 34) {
            this.f11352s = (r) parcel.readParcelable(r.class.getClassLoader(), r.class);
        } else {
            this.f11352s = (r) parcel.readParcelable(r.class.getClassLoader());
        }
    }

    public final r a(Context context) {
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        r rVar = this.f11352s;
        if (rVar != null) {
            rVar.getClass();
            if (rVar.f11354a >= 0) {
                r rVar2 = this.f11352s;
                rVar2.getClass();
                this.f11352s = l10.J(rVar2.f11354a);
                l10.c();
                return this.f11352s;
            }
        }
        this.f11352s = l10.L(this.f11345l, this.f11344b);
        l10.c();
        return this.f11352s;
    }

    public final boolean b(q2 q2Var) {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z9 = this.f11345l == q2Var.f11345l;
        r rVar = this.f11352s;
        Integer num = null;
        Integer valueOf = (rVar == null || (arrayList2 = rVar.F) == null) ? null : Integer.valueOf(arrayList2.size());
        r rVar2 = q2Var.f11352s;
        if (rVar2 != null && (arrayList = rVar2.F) != null) {
            num = Integer.valueOf(arrayList.size());
        }
        boolean a8 = kotlin.jvm.internal.l.a(valueOf, num);
        boolean m02 = l7.u.m0(this.f11346m, q2Var.f11346m, true);
        if (z9 && a8 && m02) {
            if (this.f11352s != null && q2Var.f11352s != null) {
                ArrayList arrayList3 = new ArrayList();
                r rVar3 = this.f11352s;
                rVar3.getClass();
                arrayList3.addAll(rVar3.F);
                ArrayList arrayList4 = new ArrayList();
                r rVar4 = q2Var.f11352s;
                rVar4.getClass();
                arrayList4.addAll(rVar4.F);
                r rVar5 = this.f11352s;
                rVar5.getClass();
                Iterator it = rVar5.F.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    j0 j0Var = (j0) next;
                    r rVar6 = q2Var.f11352s;
                    rVar6.getClass();
                    Iterator it2 = rVar6.F.iterator();
                    it2.getClass();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next2 = it2.next();
                            next2.getClass();
                            j0 j0Var2 = (j0) next2;
                            if (j0Var2.f11235l == j0Var.f11235l) {
                                arrayList3.remove(j0Var);
                                arrayList4.remove(j0Var2);
                                break;
                            }
                        }
                    }
                }
                if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean c() {
        int i = this.f11348o;
        return i == 1 || i == 2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final String toString() {
        long j = this.f11343a;
        long j6 = this.f11345l;
        String str = this.f11346m;
        int i = this.f11347n;
        int i6 = this.f11348o;
        int i10 = this.f11349p;
        String str2 = this.f11350q;
        int i11 = this.f11351r;
        r rVar = this.f11352s;
        String rVar2 = rVar != null ? rVar.toString() : null;
        StringBuilder sb = new StringBuilder("{id=");
        sb.append(j);
        sb.append(", packagename='");
        sb.append(this.f11344b);
        sb.append("', versionCode=");
        sb.append(j6);
        sb.append(", versionName='");
        sb.append(str);
        sb.append("', notified=");
        sb.append(i);
        sb.append(", ignoreVersion=");
        sb.append(i6);
        sb.append(", isPartialUpdate=");
        sb.append(i10);
        sb.append(", newFeatures='");
        sb.append(str2);
        sb.append("', installationAttempts=");
        sb.append(i11);
        sb.append(", download=");
        return a4.x.n(sb, rVar2, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11343a);
        parcel.writeString(this.f11344b);
        parcel.writeLong(this.f11345l);
        parcel.writeString(this.f11346m);
        parcel.writeInt(this.f11347n);
        parcel.writeInt(this.f11348o);
        parcel.writeInt(this.f11349p);
        parcel.writeString(this.f11350q);
        parcel.writeInt(this.f11351r);
        parcel.writeParcelable(this.f11352s, i);
    }

    public q2(String str) {
        this.f11343a = -1L;
        this.f11345l = -1L;
        this.f11344b = str;
    }
}
