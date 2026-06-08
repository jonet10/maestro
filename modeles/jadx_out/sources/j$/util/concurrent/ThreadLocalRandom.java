package j$.util.concurrent;

import androidx.core.location.LocationRequestCompat;
import j$.util.stream.IntStream;
import j$.util.stream.d0;
import j$.util.stream.h1;
import j$.util.stream.m1;
import j$.util.stream.y;
import j$.util.stream.y0;
import j$.util.stream.z6;
import j$.util.u1;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class ThreadLocalRandom extends Random {
    private static final long serialVersionUID = -5851777807851030925L;

    /* renamed from: a, reason: collision with root package name */
    public long f5991a;

    /* renamed from: b, reason: collision with root package name */
    public int f5992b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5993c;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f5989d = new ThreadLocal();

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f5990e = new AtomicInteger();
    public static final u f = new u();
    public static final AtomicLong g = new AtomicLong(f(System.currentTimeMillis()) ^ f(System.nanoTime()));

    public /* synthetic */ ThreadLocalRandom(int i) {
        this();
    }

    public static int e(long j) {
        long j6 = (j ^ (j >>> 33)) * (-49064778989728563L);
        return (int) (((j6 ^ (j6 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    public static long f(long j) {
        long j6 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j10 = (j6 ^ (j6 >>> 33)) * (-4265267296055464877L);
        return j10 ^ (j10 >>> 33);
    }

    private ThreadLocalRandom() {
        this.f5993c = true;
    }

    public static final void d() {
        int addAndGet = f5990e.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long f10 = f(g.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f.get();
        threadLocalRandom.f5991a = f10;
        threadLocalRandom.f5992b = addAndGet;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f.get();
        if (threadLocalRandom.f5992b == 0) {
            d();
        }
        return threadLocalRandom;
    }

    @Override // java.util.Random
    public final void setSeed(long j) {
        if (this.f5993c) {
            throw new UnsupportedOperationException();
        }
    }

    public final long g() {
        long j = this.f5991a - 7046029254386353131L;
        this.f5991a = j;
        return j;
    }

    @Override // java.util.Random
    public final int next(int i) {
        return nextInt() >>> (32 - i);
    }

    public final long c(long j, long j6) {
        long f10 = f(g());
        if (j >= j6) {
            return f10;
        }
        long j10 = j6 - j;
        long j11 = j10 - 1;
        if ((j10 & j11) == 0) {
            return (f10 & j11) + j;
        }
        if (j10 > 0) {
            while (true) {
                long j12 = f10 >>> 1;
                long j13 = j12 + j11;
                long j14 = j12 % j10;
                if (j13 - j14 >= 0) {
                    return j14 + j;
                }
                f10 = f(g());
            }
        } else {
            while (true) {
                if (f10 >= j && f10 < j6) {
                    return f10;
                }
                f10 = f(g());
            }
        }
    }

    public final int b(int i, int i6) {
        int e10 = e(g());
        if (i >= i6) {
            return e10;
        }
        int i10 = i6 - i;
        int i11 = i10 - 1;
        if ((i10 & i11) == 0) {
            return (e10 & i11) + i;
        }
        if (i10 > 0) {
            int i12 = e10 >>> 1;
            while (true) {
                int i13 = i12 + i11;
                int i14 = i12 % i10;
                if (i13 - i14 >= 0) {
                    return i14 + i;
                }
                i12 = e(g()) >>> 1;
            }
        } else {
            while (true) {
                if (e10 >= i && e10 < i6) {
                    return e10;
                }
                e10 = e(g());
            }
        }
    }

    public final double a(double d10, double d11) {
        double nextLong = (nextLong() >>> 11) * 1.1102230246251565E-16d;
        if (d10 >= d11) {
            return nextLong;
        }
        double d12 = ((d11 - d10) * nextLong) + d10;
        return d12 >= d11 ? Double.longBitsToDouble(Double.doubleToLongBits(d11) - 1) : d12;
    }

    @Override // java.util.Random
    public final int nextInt() {
        return e(g());
    }

    @Override // java.util.Random
    public final int nextInt(int i) {
        if (i <= 0) {
            j$.time.g.c("bound must be positive");
            return 0;
        }
        int e10 = e(g());
        int i6 = i - 1;
        if ((i & i6) == 0) {
            return e10 & i6;
        }
        while (true) {
            int i10 = e10 >>> 1;
            int i11 = i10 + i6;
            int i12 = i10 % i;
            if (i11 - i12 >= 0) {
                return i12;
            }
            e10 = e(g());
        }
    }

    public final int nextInt(int i, int i6) {
        if (i >= i6) {
            j$.time.g.c("bound must be greater than origin");
            return 0;
        }
        return b(i, i6);
    }

    @Override // java.util.Random
    public final long nextLong() {
        return f(g());
    }

    public final long nextLong(long j) {
        if (j <= 0) {
            j$.time.g.c("bound must be positive");
            return 0L;
        }
        long f10 = f(g());
        long j6 = j - 1;
        if ((j & j6) == 0) {
            return f10 & j6;
        }
        while (true) {
            long j10 = f10 >>> 1;
            long j11 = j10 + j6;
            long j12 = j10 % j;
            if (j11 - j12 >= 0) {
                return j12;
            }
            f10 = f(g());
        }
    }

    public final long nextLong(long j, long j6) {
        if (j >= j6) {
            j$.time.g.c("bound must be greater than origin");
            return 0L;
        }
        return c(j, j6);
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return (f(g()) >>> 11) * 1.1102230246251565E-16d;
    }

    public final double nextDouble(double d10) {
        if (d10 <= 0.0d) {
            j$.time.g.c("bound must be positive");
            return 0.0d;
        }
        double f10 = (f(g()) >>> 11) * 1.1102230246251565E-16d * d10;
        return f10 < d10 ? f10 : Double.longBitsToDouble(Double.doubleToLongBits(d10) - 1);
    }

    public final double nextDouble(double d10, double d11) {
        if (d10 >= d11) {
            j$.time.g.c("bound must be greater than origin");
            return 0.0d;
        }
        return a(d10, d11);
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return e(g()) < 0;
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return (e(g()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public final double nextGaussian() {
        ThreadLocal threadLocal = f5989d;
        Double d10 = (Double) threadLocal.get();
        if (d10 != null) {
            threadLocal.set(null);
            return d10.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d11 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d11 < 1.0d && d11 != 0.0d) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d11) * (-2.0d)) / d11);
                f5989d.set(Double.valueOf(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    @Override // java.util.Random
    public final IntStream ints(long j) {
        if (j >= 0) {
            w wVar = new w(0L, j, Integer.MAX_VALUE, 0);
            return IntStream.Wrapper.convert(new y0(wVar, z6.g(wVar), false));
        }
        j$.time.g.c("size must be non-negative");
        return null;
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints() {
        w wVar = new w(0L, LocationRequestCompat.PASSIVE_INTERVAL, Integer.MAX_VALUE, 0);
        return IntStream.Wrapper.convert(new y0(wVar, z6.g(wVar), false));
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(long j, int i, int i6) {
        if (j < 0) {
            j$.time.g.c("size must be non-negative");
            return null;
        }
        if (i < i6) {
            w wVar = new w(0L, j, i, i6);
            return IntStream.Wrapper.convert(new y0(wVar, z6.g(wVar), false));
        }
        j$.time.g.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(int i, int i6) {
        if (i < i6) {
            w wVar = new w(0L, LocationRequestCompat.PASSIVE_INTERVAL, i, i6);
            return IntStream.Wrapper.convert(new y0(wVar, z6.g(wVar), false));
        }
        j$.time.g.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final LongStream longs(long j) {
        if (j >= 0) {
            x xVar = new x(0L, j, LocationRequestCompat.PASSIVE_INTERVAL, 0L);
            return m1.g(new h1(xVar, z6.g(xVar), false));
        }
        j$.time.g.c("size must be non-negative");
        return null;
    }

    @Override // java.util.Random
    public final LongStream longs() {
        x xVar = new x(0L, LocationRequestCompat.PASSIVE_INTERVAL, LocationRequestCompat.PASSIVE_INTERVAL, 0L);
        return m1.g(new h1(xVar, z6.g(xVar), false));
    }

    @Override // java.util.Random
    public final LongStream longs(long j, long j6, long j10) {
        if (j < 0) {
            j$.time.g.c("size must be non-negative");
            return null;
        }
        if (j6 < j10) {
            x xVar = new x(0L, j, j6, j10);
            return m1.g(new h1(xVar, z6.g(xVar), false));
        }
        j$.time.g.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final LongStream longs(long j, long j6) {
        if (j < j6) {
            x xVar = new x(0L, LocationRequestCompat.PASSIVE_INTERVAL, j, j6);
            return m1.g(new h1(xVar, z6.g(xVar), false));
        }
        j$.time.g.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j) {
        if (j >= 0) {
            v vVar = new v(0L, j, Double.MAX_VALUE, 0.0d);
            return d0.g(new y(vVar, z6.g(vVar), false));
        }
        j$.time.g.c("size must be non-negative");
        return null;
    }

    @Override // java.util.Random
    public final DoubleStream doubles() {
        v vVar = new v(0L, LocationRequestCompat.PASSIVE_INTERVAL, Double.MAX_VALUE, 0.0d);
        return d0.g(new y(vVar, z6.g(vVar), false));
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j, double d10, double d11) {
        if (j < 0) {
            j$.time.g.c("size must be non-negative");
            return null;
        }
        if (d10 < d11) {
            v vVar = new v(0L, j, d10, d11);
            return d0.g(new y(vVar, z6.g(vVar), false));
        }
        j$.time.g.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final DoubleStream doubles(double d10, double d11) {
        if (d10 < d11) {
            v vVar = new v(0L, LocationRequestCompat.PASSIVE_INTERVAL, d10, d11);
            return d0.g(new y(vVar, z6.g(vVar), false));
        }
        j$.time.g.c("bound must be greater than origin");
        return null;
    }

    static {
        if (((Boolean) AccessController.doPrivileged(new u1(1))).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            long j = seed[0] & 255;
            for (int i = 1; i < 8; i++) {
                j = (j << 8) | (seed[i] & 255);
            }
            g.set(j);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("rnd", this.f5991a);
        putFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    private Object readResolve() {
        return current();
    }
}
