package s3;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final List f9157a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f9158b;

    static {
        HashMap hashMap = new HashMap();
        f9158b = hashMap;
        hashMap.put(2, "tcfeuv2");
        hashMap.put(5, "tcfcav1");
        hashMap.put(6, "uspv1");
        hashMap.put(7, "usnat");
        hashMap.put(8, "usca");
        hashMap.put(9, "usva");
        hashMap.put(10, "usco");
        hashMap.put(11, "usut");
        hashMap.put(12, "usct");
        hashMap.put(13, "usfl");
        hashMap.put(14, "usmt");
        hashMap.put(15, "usor");
        hashMap.put(16, "ustx");
        hashMap.put(17, "usde");
        hashMap.put(18, "usia");
        hashMap.put(19, "usne");
        hashMap.put(20, "usnh");
        hashMap.put(21, "usnj");
        hashMap.put(22, "ustn");
        hashMap.put(23, "usmn");
        f9157a = (List) Collection.EL.stream(new ArrayList(hashMap.keySet())).sorted().map(new m3.a(2)).collect(Collectors.toList());
    }
}
