package y1;

import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f11616a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f11617b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ f[] f11618l;

    /* JADX INFO: Fake field, exist only in values array */
    f EF0;

    static {
        f fVar = new f("X86_32", 0);
        f fVar2 = new f("X86_64", 1);
        f fVar3 = new f("ARM_UNKNOWN", 2);
        f fVar4 = new f("PPC", 3);
        f fVar5 = new f("PPC64", 4);
        f fVar6 = new f("ARMV6", 5);
        f fVar7 = new f("ARMV7", 6);
        f fVar8 = new f("UNKNOWN", 7);
        f11616a = fVar8;
        f fVar9 = new f("ARMV7S", 8);
        f fVar10 = new f("ARM64", 9);
        f11618l = new f[]{fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10};
        HashMap hashMap = new HashMap(4);
        f11617b = hashMap;
        hashMap.put("armeabi-v7a", fVar7);
        hashMap.put("armeabi", fVar6);
        hashMap.put("arm64-v8a", fVar10);
        hashMap.put("x86", fVar);
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f11618l.clone();
    }
}
