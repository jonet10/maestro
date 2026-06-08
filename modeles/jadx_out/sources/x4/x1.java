package x4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x1 {

    /* renamed from: a, reason: collision with root package name */
    public long f11448a;

    /* renamed from: b, reason: collision with root package name */
    public String f11449b;

    /* renamed from: c, reason: collision with root package name */
    public String f11450c;

    /* renamed from: d, reason: collision with root package name */
    public String f11451d;

    /* renamed from: e, reason: collision with root package name */
    public int f11452e;

    public final void a(Cursor cursor) {
        this.f11448a = cursor.getLong(0);
        this.f11452e = cursor.getInt(1);
    }

    public final void b(Context context) {
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        String[] strArr = {String.valueOf(this.f11448a)};
        SQLiteDatabase sQLiteDatabase = l10.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("preregistrations", "appId=?", strArr);
        l10.c();
    }

    public final String toString() {
        long j = this.f11448a;
        String str = this.f11449b;
        String str2 = this.f11450c;
        String str3 = this.f11451d;
        int i = this.f11452e;
        StringBuilder sb = new StringBuilder("PreRegister(appID=");
        sb.append(j);
        sb.append(", name=");
        sb.append(str);
        a4.x.B(sb, ", icon=", str2, ", authorName=", str3);
        sb.append(", automaticDownload=");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }
}
