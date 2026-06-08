package x4;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements Parcelable {
    public static Parcelable.Creator<e> CREATOR = new i0.l(9);
    public long A;
    public String B;
    public int C;
    public w1 D;
    public boolean E;
    public long F;
    public int G;
    public ArrayList I;
    public ArrayList J;
    public boolean K;

    /* renamed from: b, reason: collision with root package name */
    public String f11122b;

    /* renamed from: l, reason: collision with root package name */
    public String f11123l;

    /* renamed from: n, reason: collision with root package name */
    public String f11125n;

    /* renamed from: o, reason: collision with root package name */
    public String f11126o;

    /* renamed from: q, reason: collision with root package name */
    public int f11128q;

    /* renamed from: r, reason: collision with root package name */
    public int f11129r;

    /* renamed from: s, reason: collision with root package name */
    public int f11130s;

    /* renamed from: t, reason: collision with root package name */
    public int f11131t;

    /* renamed from: u, reason: collision with root package name */
    public String f11132u;
    public int v;

    /* renamed from: w, reason: collision with root package name */
    public long f11133w;

    /* renamed from: x, reason: collision with root package name */
    public long f11134x;

    /* renamed from: y, reason: collision with root package name */
    public int f11135y;

    /* renamed from: z, reason: collision with root package name */
    public String f11136z;

    /* renamed from: a, reason: collision with root package name */
    public long f11121a = -1;

    /* renamed from: m, reason: collision with root package name */
    public long f11124m = -1;

    /* renamed from: p, reason: collision with root package name */
    public d f11127p = d.f11088b;
    public int H = -1;

    public static void a(String str, ArrayList arrayList, j5.g gVar, e eVar, ArrayList arrayList2) {
        arrayList2.getClass();
        e1 e1Var = new e1();
        e1Var.f11139b = new File(str).length();
        e1Var.f11140c = str;
        Iterator it = arrayList.iterator();
        int i = -1;
        int i6 = 0;
        while (it.hasNext()) {
            int i10 = i6 + 1;
            e1 e1Var2 = (e1) it.next();
            if (l7.u.m0(e1Var2.f11140c, e1Var.f11140c, false) && e1Var2.f11139b == e1Var.f11139b) {
                String str2 = e1Var2.f11138a;
                if (str2 != null) {
                    e1Var.f11138a = str2;
                }
                i = i6;
            }
            i6 = i10;
        }
        if (i != -1) {
            arrayList.remove(i);
            arrayList2.add(e1Var);
            return;
        }
        long j = eVar.f11121a;
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", String.valueOf(j));
        contentValues.put("sha256", e1Var.f11138a);
        contentValues.put("size", String.valueOf(e1Var.f11139b));
        contentValues.put("path", e1Var.f11140c);
        SQLiteDatabase sQLiteDatabase = gVar.f6673a;
        sQLiteDatabase.getClass();
        if (sQLiteDatabase.insert("app_files", null, contentValues) >= 0) {
            arrayList2.add(e1Var);
        }
    }

    public final boolean b(Context context) {
        context.getClass();
        if (this.f11123l == null) {
            return false;
        }
        if (d()) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("show_system_services")) {
                    return sharedPreferences.getBoolean("show_system_services", false);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        if (!c()) {
            return true;
        }
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences2.contains("show_system_apps")) {
                return sharedPreferences2.getBoolean("show_system_apps", false);
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public final boolean c() {
        return this.f11128q == 1;
    }

    public final boolean d() {
        return this.f11129r == 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final void e(j5.g gVar) {
        this.J = new ArrayList();
        String str = this.f11123l;
        str.getClass();
        ArrayList B = a.a.B(str);
        if (B.isEmpty()) {
            return;
        }
        String str2 = this.f11123l;
        str2.getClass();
        e B2 = gVar.B(str2);
        if (B2 != null) {
            ArrayList C = gVar.C(B2.f11121a);
            Iterator it = B.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = (File) next;
                if (file.isFile()) {
                    String name = file.getName();
                    name.getClass();
                    if (l7.u.k0(name, ".obb", false)) {
                        String absolutePath = file.getAbsolutePath();
                        absolutePath.getClass();
                        ArrayList arrayList = this.J;
                        arrayList.getClass();
                        a(absolutePath, C, gVar, B2, arrayList);
                    }
                }
            }
        }
    }

    public final void f(ApplicationInfo applicationInfo, j5.g gVar) {
        applicationInfo.getClass();
        this.I = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            String str = this.f11123l;
            str.getClass();
            e B = gVar.B(str);
            if (B != null) {
                ArrayList C = gVar.C(B.f11121a);
                int i = 0;
                while (i < strArr.length) {
                    int i6 = i + 1;
                    try {
                        String str2 = strArr[i];
                        str2.getClass();
                        if (l7.u.k0(str2, ".apk", false)) {
                            ArrayList arrayList = this.I;
                            arrayList.getClass();
                            a(str2, C, gVar, B, arrayList);
                        }
                        i = i6;
                    } catch (ArrayIndexOutOfBoundsException e10) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.s(e10.getMessage());
                        return;
                    }
                }
                if (C.isEmpty()) {
                    return;
                }
                Iterator it = C.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    gVar.h((e1) next);
                }
            }
        }
    }

    public final void g(boolean z9, boolean z10) {
        if (c()) {
            if (z9) {
                this.f11135y = 0;
            } else {
                this.f11135y = 1;
            }
        }
        if (d()) {
            if (z10) {
                this.f11135y = 0;
            } else {
                this.f11135y = 1;
            }
        }
    }

    public final String toString() {
        return "{id='" + this.f11121a + "', name='" + this.f11122b + "', packagename='" + this.f11123l + "', versionCode=" + this.f11124m + ", versionName='" + this.f11125n + "', urlFicha='" + this.f11126o + "', status=" + this.f11127p + ", isSystemApp=" + this.f11128q + ", isSystemService=" + this.f11129r + ", minSdkVersion=" + this.f11130s + ", targetSdkVersion=" + this.f11131t + ", md5signature='" + this.f11132u + "', exclude=" + this.v + ", size=" + this.f11133w + ", lastUpdateTime=" + this.f11134x + ", excludeFromTracking=" + this.f11135y + ", defaultName='" + this.f11136z + "', firstInstallTime=" + this.A + ", sha256='" + this.B + "', appID=" + this.F + ", hasOldVersions=" + this.G + ", trackInfoRegistered=" + this.H + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11121a);
        parcel.writeString(this.f11122b);
        parcel.writeString(this.f11123l);
        parcel.writeLong(this.f11124m);
        parcel.writeString(this.f11125n);
        parcel.writeString(this.f11126o);
        int ordinal = this.f11127p.ordinal();
        if (ordinal == 0) {
            parcel.writeInt(0);
        } else if (ordinal != 1) {
            parcel.writeInt(2);
        } else {
            parcel.writeInt(1);
        }
        parcel.writeInt(this.f11128q);
        parcel.writeInt(this.f11129r);
        parcel.writeInt(this.f11130s);
        parcel.writeInt(this.f11131t);
        parcel.writeString(this.f11132u);
        parcel.writeInt(this.v);
        parcel.writeLong(this.f11133w);
        parcel.writeLong(this.f11134x);
        parcel.writeInt(this.f11135y);
        parcel.writeString(this.f11136z);
        parcel.writeLong(this.A);
        parcel.writeString(this.B);
        parcel.writeInt(this.C);
        parcel.writeLong(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.K ? 1 : 0);
    }
}
