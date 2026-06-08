package x4;

import android.database.Cursor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a2 {

    /* renamed from: c, reason: collision with root package name */
    public String f11044c;

    /* renamed from: a, reason: collision with root package name */
    public int f11042a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f11043b = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f11045d = -1;

    public final void a(Cursor cursor) {
        this.f11042a = cursor.getInt(0);
        this.f11043b = cursor.getLong(1);
        this.f11044c = cursor.getString(2);
        this.f11045d = cursor.getInt(3);
    }

    public final String toString() {
        return "{id=" + this.f11042a + ", appId=" + this.f11043b + ", deviceName=" + this.f11044c + ", downloadId=" + this.f11045d + "}";
    }
}
