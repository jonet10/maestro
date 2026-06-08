package x4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.activities.MyDownloads;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r implements Parcelable {
    public static Parcelable.Creator<r> CREATOR = new i0.l(12);
    public int A;
    public int B;
    public Drawable E;

    /* renamed from: b, reason: collision with root package name */
    public String f11355b;

    /* renamed from: l, reason: collision with root package name */
    public int f11356l;

    /* renamed from: o, reason: collision with root package name */
    public String f11359o;

    /* renamed from: p, reason: collision with root package name */
    public int f11360p;

    /* renamed from: r, reason: collision with root package name */
    public int f11362r;

    /* renamed from: s, reason: collision with root package name */
    public String f11363s;

    /* renamed from: t, reason: collision with root package name */
    public String f11364t;

    /* renamed from: u, reason: collision with root package name */
    public int f11365u;
    public String v;

    /* renamed from: w, reason: collision with root package name */
    public String f11366w;

    /* renamed from: x, reason: collision with root package name */
    public long f11367x;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f11368y;

    /* renamed from: a, reason: collision with root package name */
    public int f11354a = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f11357m = 1;

    /* renamed from: n, reason: collision with root package name */
    public long f11358n = -1;

    /* renamed from: q, reason: collision with root package name */
    public long f11361q = -1;

    /* renamed from: z, reason: collision with root package name */
    public long f11369z = -1;
    public long C = -1;
    public long D = -1;
    public ArrayList F = new ArrayList();

    public final void a(g gVar) {
        gVar.getClass();
        this.f11355b = gVar.F;
        this.f11361q = gVar.f11158a;
        this.f11366w = gVar.f11159b;
        if (this.f11363s == null) {
            this.f11363s = gVar.M;
        }
        if (gVar.F0.isEmpty()) {
            j0 j0Var = new j0();
            if (j0Var.f11239p == null) {
                j0Var.f11239p = gVar.P;
            }
            j0Var.f11235l = gVar.J;
            String str = gVar.f11177p;
            if (str != null && str.length() != 0) {
                try {
                    String str2 = gVar.f11177p;
                    str2.getClass();
                    j0Var.f11237n = Long.parseLong(str2);
                } catch (NumberFormatException e10) {
                    e10.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            this.F = arrayList;
            arrayList.add(j0Var);
        } else {
            this.F = gVar.F0;
        }
        this.v = gVar.h();
        this.f11368y = gVar.S;
        if (!z3.f) {
            this.f11362r = 1;
        }
        if (this.f11358n <= 0) {
            long j = gVar.K;
            if (j > 0) {
                this.f11358n = j;
            } else {
                long j6 = gVar.f11172m;
                if (j6 > 0) {
                    this.f11358n = j6;
                }
            }
        }
        this.f11359o = gVar.f11170l;
        this.f11364t = null;
        ArrayList arrayList2 = gVar.T;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            ArrayList arrayList3 = gVar.T;
            arrayList3.getClass();
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                String str3 = this.f11364t;
                ArrayList arrayList4 = gVar.T;
                if (str3 == null) {
                    arrayList4.getClass();
                    this.f11364t = (String) arrayList4.get(i);
                } else {
                    arrayList4.getClass();
                    this.f11364t = String.format("%s,%s", Arrays.copyOf(new Object[]{str3, arrayList4.get(i)}, 2));
                }
            }
        }
        String str4 = gVar.I;
        if (str4 != null) {
            try {
                this.f11365u = Integer.parseInt(str4);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void b(g gVar, t1 t1Var) {
        gVar.getClass();
        t1Var.getClass();
        this.f11355b = gVar.F;
        this.f11361q = gVar.f11158a;
        this.f11366w = gVar.f11159b;
        this.v = gVar.f11187u;
        this.f11363s = gVar.M;
        this.f11358n = t1Var.f11399m;
        this.f11359o = t1Var.f11396a;
        this.B = 1;
        if (!l7.u.m0(t1Var.f11401o, "apk", true)) {
            this.F = t1Var.f11404r;
            return;
        }
        this.F = new ArrayList();
        j0 j0Var = new j0();
        String str = t1Var.f11402p;
        str.getClass();
        j0Var.f11235l = Long.parseLong(str);
        j0Var.f11237n = t1Var.f11397b;
        this.F.add(j0Var);
    }

    public final boolean c() {
        return this.f11357m == 0;
    }

    public final void d() {
        if (this.F.isEmpty()) {
            return;
        }
        Iterator it = this.F.iterator();
        it.getClass();
        File file = null;
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            j0 j0Var = (j0) next;
            String str = j0Var.f11240q;
            if (str != null) {
                try {
                    File file2 = new File(str);
                    if (file2.exists()) {
                        file2.delete();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            String str2 = j0Var.f11240q;
            if (str2 != null && str2.length() != 0 && file == null) {
                String str3 = j0Var.f11240q;
                str3.getClass();
                file = new File(str3).getParentFile();
            }
        }
        if ((file != null ? file.getAbsolutePath() : null) != null && file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                file.delete();
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f11362r;
    }

    public final File f() {
        String str = !this.F.isEmpty() ? ((j0) this.F.get(0)).f11240q : null;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final File g() {
        if (this.F.size() == 1 && ((j0) this.F.get(0)).f11240q != null) {
            String str = ((j0) this.F.get(0)).f11240q;
            str.getClass();
            return new File(str);
        }
        if (this.F.size() <= 1 || ((j0) this.F.get(0)).f11240q == null) {
            return null;
        }
        String str2 = ((j0) this.F.get(0)).f11240q;
        str2.getClass();
        return new File(str2).getParentFile();
    }

    public final void h(MyDownloads myDownloads, File file) {
        if (this.f11355b != null) {
            long j = this.f11358n;
            if (j > 0) {
                this.C = j;
                q(myDownloads);
                return;
            }
            String name = file.getName();
            name.getClass();
            if (l7.u.k0(name, ".apk", false)) {
                try {
                    PackageManager packageManager = myDownloads.getPackageManager();
                    packageManager.getClass();
                    String absolutePath = file.getAbsolutePath();
                    absolutePath.getClass();
                    PackageInfo d10 = n4.i.d(packageManager, absolutePath, 128);
                    if (d10 != null) {
                        this.C = n4.d.d(d10);
                    }
                    if (d10 == null || !l7.u.m0(this.f11355b, d10.packageName, false)) {
                        return;
                    }
                    q(myDownloads);
                } catch (Exception unused) {
                }
            }
        }
    }

    public final int i() {
        long j;
        long j6;
        if (this.F.isEmpty()) {
            j = 0;
            j6 = 0;
        } else {
            Iterator it = this.F.iterator();
            it.getClass();
            j = 0;
            j6 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                j0 j0Var = (j0) next;
                j += j0Var.f11237n;
                j6 += j0Var.f11238o;
            }
        }
        if (j6 <= 0 || j <= 0) {
            return 0;
        }
        return (int) ((j6 * 100.0d) / j);
    }

    public final long j() {
        long j = 0;
        if (!this.F.isEmpty()) {
            Iterator it = this.F.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                j += ((j0) next).f11238o;
            }
        }
        return j;
    }

    public final long k() {
        long j = 0;
        if (!this.F.isEmpty()) {
            Iterator it = this.F.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                j += ((j0) next).f11237n;
            }
        }
        return j;
    }

    public final void l(Context context) {
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        this.f11360p++;
        this.f11367x = System.currentTimeMillis() + 1800000;
        l10.j(this);
        if (this.f11360p >= 4) {
            t(context);
        } else {
            l10.b0(this);
        }
        l10.c();
    }

    public final boolean m() {
        return this.f11355b != null && p() && !c() && this.f11363s != null && this.f11358n > 0 && this.f11360p < 4 && System.currentTimeMillis() > this.f11367x;
    }

    public final boolean n() {
        String str;
        l4.a c9 = f4.a.f4869a.c();
        return this.f11358n > 0 && (str = this.f11355b) != null && c9 != null && l7.u.m0(c9.f7095a, str, true) && c9.f7096b == this.f11358n;
    }

    public final int o() {
        return this.B;
    }

    public final boolean p() {
        return this.f11369z == -1;
    }

    public final void q(MyDownloads myDownloads) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = myDownloads.getPackageManager();
            if (packageManager != null) {
                String str = this.f11355b;
                str.getClass();
                packageInfo = n4.i.e(packageManager, str, 0);
            } else {
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.D = n4.d.d(packageInfo);
            }
        } catch (Exception unused) {
        }
    }

    public final int r(Context context) {
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        String str = this.f11355b;
        str.getClass();
        r L = l10.L(this.f11358n, str);
        if (L == null) {
            l10.b0(this);
            L = this;
        }
        l10.c();
        return L.f11354a;
    }

    public final void s(Context context) {
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        l10.j(this);
        l10.c();
    }

    public final void t(Context context) {
        File file;
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        this.f11357m = 1;
        l10.q0(this);
        if (this.F.isEmpty()) {
            file = null;
        } else {
            Iterator it = this.F.iterator();
            it.getClass();
            file = null;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                j0 j0Var = (j0) next;
                String str = j0Var.f11240q;
                if (str != null) {
                    try {
                        File file2 = new File(str);
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                String str2 = j0Var.f11240q;
                if (str2 != null && str2.length() != 0 && file == null) {
                    String str3 = j0Var.f11240q;
                    str3.getClass();
                    file = new File(str3).getParentFile();
                }
                if (this.f11369z > 0) {
                    j0Var.f11238o = 0L;
                    j0Var.f11241r = 0;
                    j0Var.f11242s = 0L;
                    l10.r0(j0Var);
                }
            }
        }
        l10.c();
        if ((file != null ? file.getAbsolutePath() : null) != null && file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                file.delete();
            }
        }
    }

    public final String toString() {
        int i = this.f11354a;
        String str = this.f11355b;
        int i6 = this.f11356l;
        int i10 = this.f11357m;
        long j = this.f11358n;
        String str2 = this.f11359o;
        int i11 = this.f11360p;
        long j6 = this.f11361q;
        int i12 = this.f11362r;
        String str3 = this.f11363s;
        String str4 = this.f11364t;
        int i13 = this.f11365u;
        String str5 = this.v;
        String str6 = this.f11366w;
        long j10 = this.C;
        long j11 = this.D;
        long j12 = this.f11367x;
        long j13 = this.f11369z;
        int i14 = this.A;
        int i15 = this.B;
        ArrayList arrayList = this.F;
        StringBuilder sb = new StringBuilder("{id='");
        sb.append(i);
        sb.append("', packagename='");
        sb.append(str);
        sb.append("', checkedByUser=");
        sb.append(i6);
        sb.append(", incomplete=");
        sb.append(i10);
        sb.append(", versioncode='");
        sb.append(j);
        sb.append("', versionname='");
        sb.append(str2);
        sb.append("', attempts=");
        sb.append(i11);
        sb.append(", appId=");
        sb.append(j6);
        sb.append(", downloadAnyway=");
        sb.append(i12);
        a4.x.B(sb, ", md5signature='", str3, "', supportedAbis='", str4);
        sb.append("', minsdk=");
        sb.append(i13);
        sb.append(", urlIcon='");
        sb.append(str5);
        sb.append("', appName='");
        sb.append(str6);
        sb.append("', versioncodeFile=");
        sb.append(j10);
        sb.append(", versioncodeInstalled=");
        sb.append(j11);
        sb.append(", nextAttemptTimeStamp=");
        sb.append(j12);
        sb.append(", updateId=");
        sb.append(j13);
        sb.append(", isDeepLink=");
        sb.append(i14);
        sb.append(", isRollback=");
        sb.append(i15);
        sb.append(", files=");
        sb.append(arrayList);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.f11354a);
        parcel.writeString(this.f11355b);
        parcel.writeInt(this.f11356l);
        parcel.writeInt(this.f11357m);
        parcel.writeLong(this.f11358n);
        parcel.writeString(this.f11359o);
        parcel.writeInt(this.f11360p);
        parcel.writeLong(this.f11361q);
        parcel.writeInt(this.f11362r);
        parcel.writeString(this.f11363s);
        parcel.writeString(this.f11364t);
        parcel.writeInt(this.f11365u);
        parcel.writeString(this.v);
        parcel.writeString(this.f11366w);
        parcel.writeLong(this.f11367x);
        parcel.writeStringList(this.f11368y);
        parcel.writeTypedList(this.F);
        parcel.writeLong(this.f11369z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
    }
}
