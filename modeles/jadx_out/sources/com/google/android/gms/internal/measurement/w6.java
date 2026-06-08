package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class w6 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f2886a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f2887b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f2888c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f2889d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f2890e;
    public static final long f;
    public static final boolean g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    static {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.w6.<clinit>():void");
    }

    public static void a(Class cls) {
        if (f2890e) {
            f2888c.f2841a.arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field field;
        Field field2;
        int i = u4.f2819a;
        try {
            field = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            field = null;
        }
        if (field != null) {
            return field;
        }
        try {
            field2 = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field2 = null;
        }
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    public static void c(Object obj, long j, byte b7) {
        Unsafe unsafe = f2888c.f2841a;
        long j6 = (-4) & j;
        int i = unsafe.getInt(obj, j6);
        int i6 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j6, ((255 & b7) << i6) | (i & (~(255 << i6))));
    }

    public static void d(Object obj, long j, byte b7) {
        Unsafe unsafe = f2888c.f2841a;
        long j6 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j6, ((255 & b7) << i) | (unsafe.getInt(obj, j6) & (~(255 << i))));
    }

    public static Object e(Class cls) {
        try {
            return f2886a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int f(Object obj, long j) {
        return f2888c.f2841a.getInt(obj, j);
    }

    public static void g(Object obj, long j, int i) {
        f2888c.f2841a.putInt(obj, j, i);
    }

    public static long h(Object obj, long j) {
        return f2888c.f2841a.getLong(obj, j);
    }

    public static void i(Object obj, long j, long j6) {
        f2888c.f2841a.putLong(obj, j, j6);
    }

    public static Object j(Object obj, long j) {
        return f2888c.f2841a.getObject(obj, j);
    }

    public static void k(long j, Object obj, Object obj2) {
        f2888c.f2841a.putObject(obj, j, obj2);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new s6());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean m(Class cls) {
        int i = u4.f2819a;
        try {
            Class cls2 = f2887b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean n(Object obj, long j) {
        return ((byte) ((f2888c.f2841a.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean o(Object obj, long j) {
        return ((byte) ((f2888c.f2841a.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static int p(Class cls) {
        if (f2890e) {
            return f2888c.f2841a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
