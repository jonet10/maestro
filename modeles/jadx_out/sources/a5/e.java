package a5;

import java.util.LinkedHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f205a = new LinkedHashMap();

    public static String a(String str) {
        str.getClass();
        return (String) f205a.get(str);
    }

    public static void b(String str, String str2) {
        str.getClass();
        str2.getClass();
        f205a.put(str, str2);
    }
}
