package x4;

import android.database.Cursor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s1 {

    /* renamed from: a, reason: collision with root package name */
    public int f11384a = -1;

    /* renamed from: b, reason: collision with root package name */
    public String f11385b;

    /* renamed from: c, reason: collision with root package name */
    public String f11386c;

    /* renamed from: d, reason: collision with root package name */
    public String f11387d;

    /* renamed from: e, reason: collision with root package name */
    public String f11388e;
    public String f;

    public final void a(Cursor cursor) {
        this.f11384a = cursor.getInt(0);
        this.f11385b = cursor.getString(1);
        this.f11386c = cursor.getString(2);
        this.f11387d = cursor.getString(3);
        this.f11388e = cursor.getString(4);
        this.f = cursor.getString(5);
    }

    public final String toString() {
        int i = this.f11384a;
        String str = this.f11385b;
        String str2 = this.f11386c;
        String str3 = this.f11387d;
        String str4 = this.f11388e;
        String str5 = this.f;
        StringBuilder sb = new StringBuilder("{id=");
        sb.append(i);
        sb.append(", timestamp=");
        sb.append(str);
        sb.append(", title='");
        a4.x.B(sb, str2, "', msg='", str3, "', actions='");
        sb.append(str4);
        sb.append("', extraInfo='");
        sb.append(str5);
        sb.append("'}");
        return sb.toString();
    }
}
