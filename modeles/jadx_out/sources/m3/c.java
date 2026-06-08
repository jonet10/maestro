package m3;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final c f7275d = new c();

    @Override // m3.b
    public final String c(String str) {
        char[] cArr = str.length() % 8 > 0 ? new char[8 - (str.length() % 8)] : new char[0];
        Arrays.fill(cArr, '0');
        char[] cArr2 = (str.length() + cArr.length) % 6 > 0 ? new char[6 - ((str.length() + cArr.length) % 6)] : new char[0];
        Arrays.fill(cArr2, '0');
        return str + new String(cArr) + new String(cArr2);
    }
}
