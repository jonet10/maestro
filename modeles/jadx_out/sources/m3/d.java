package m3;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final d f7276d = new d();

    @Override // m3.b
    public final String c(String str) {
        if (str.length() % 24 <= 0) {
            return str;
        }
        char[] cArr = new char[24 - (str.length() % 24)];
        Arrays.fill(cArr, '0');
        return str.concat(new String(cArr));
    }
}
