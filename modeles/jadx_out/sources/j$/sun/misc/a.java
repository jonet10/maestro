package j$.sun.misc;

import j$.util.concurrent.l;
import j$.util.concurrent.q;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5726b;

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f5727a;

    static {
        Field g = g();
        g.setAccessible(true);
        try {
            f5726b = new a((Unsafe) g.get(null));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("Couldn't get the Unsafe", e10);
        }
    }

    public a(Unsafe unsafe) {
        this.f5727a = unsafe;
    }

    public static Field g() {
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e10) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new AssertionError("Couldn't find the Unsafe", e10);
        }
    }

    public final int e(q qVar, long j) {
        while (true) {
            int intVolatile = this.f5727a.getIntVolatile(qVar, j);
            q qVar2 = qVar;
            long j6 = j;
            if (this.f5727a.compareAndSwapInt(qVar2, j6, intVolatile, intVolatile - 4)) {
                return intVolatile;
            }
            qVar = qVar2;
            j = j6;
        }
    }

    public final long i(Field field) {
        return this.f5727a.objectFieldOffset(field);
    }

    public final long h(Class cls, String str) {
        try {
            return i(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e10) {
            throw new AssertionError("Cannot find field:", e10);
        }
    }

    public final int a(Class cls) {
        return this.f5727a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f5727a.arrayIndexScale(cls);
    }

    public final Object f(Object obj, long j) {
        return this.f5727a.getObjectVolatile(obj, j);
    }

    public final void j(Object obj, long j, l lVar) {
        this.f5727a.putObjectVolatile(obj, j, lVar);
    }

    public final boolean c(Object obj, long j, int i, int i6) {
        return this.f5727a.compareAndSwapInt(obj, j, i, i6);
    }

    public final boolean d(Object obj, long j, long j6, long j10) {
        return this.f5727a.compareAndSwapLong(obj, j, j6, j10);
    }
}
