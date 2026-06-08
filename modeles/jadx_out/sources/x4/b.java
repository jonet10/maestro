package x4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f11051a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11052b;

    /* renamed from: c, reason: collision with root package name */
    public int f11053c;

    /* renamed from: d, reason: collision with root package name */
    public int f11054d;

    /* renamed from: e, reason: collision with root package name */
    public a f11055e;

    public b(String str, long j) {
        str.getClass();
        this.f11051a = str;
        this.f11052b = j;
        this.f11053c = -1;
        this.f11054d = -1;
        this.f11055e = a.f11038a;
    }

    public final b a(Context context) {
        b z9;
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        int i = this.f11054d;
        if (i != -1) {
            z9 = l10.y(i);
        } else {
            int i6 = this.f11053c;
            if (i6 != -1) {
                z9 = l10.A(i6);
            } else {
                z9 = l10.z(this.f11052b, this.f11051a);
            }
        }
        l10.c();
        return z9;
    }

    public final void b(Context context) {
        b A;
        context.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        int i = this.f11054d;
        long j = this.f11052b;
        String str = this.f11051a;
        if (i != -1) {
            A = l10.y(i);
        } else {
            int i6 = this.f11053c;
            A = i6 != -1 ? l10.A(i6) : l10.z(j, str);
        }
        if (A != null) {
            String[] strArr = {String.valueOf(this.f11053c)};
            ContentValues contentValues = new ContentValues();
            contentValues.put("notificationId", Integer.valueOf(this.f11054d));
            contentValues.put("packagename", str);
            contentValues.put("versioncode", Long.valueOf(j));
            contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.f11055e.ordinal()));
            SQLiteDatabase sQLiteDatabase = l10.f6673a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.update("active_notifications", contentValues, "id=?", strArr);
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("notificationId", Integer.valueOf(this.f11054d));
            contentValues2.put("packagename", str);
            contentValues2.put("versioncode", Long.valueOf(j));
            contentValues2.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.f11055e.ordinal()));
            SQLiteDatabase sQLiteDatabase2 = l10.f6673a;
            sQLiteDatabase2.getClass();
            sQLiteDatabase2.insert("active_notifications", null, contentValues2);
        }
        l10.c();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.f11051a, bVar.f11051a) && this.f11052b == bVar.f11052b;
    }

    public final int hashCode() {
        int hashCode = this.f11051a.hashCode() * 31;
        long j = this.f11052b;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "ActiveNotification(packageName=" + this.f11051a + ", versionCode=" + this.f11052b + ")";
    }
}
