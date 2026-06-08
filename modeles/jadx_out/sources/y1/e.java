package y1;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final String f11613b = g.h(UUID.randomUUID().toString() + System.currentTimeMillis());

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicLong f11614c = new AtomicLong(0);

    /* renamed from: a, reason: collision with root package name */
    public final String f11615a;

    public e() {
        long time = new Date().getTime();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) (time / 1000));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        byte[] array = allocate.array();
        byte b7 = array[0];
        byte b10 = array[1];
        byte b11 = array[2];
        byte b12 = array[3];
        byte[] a8 = a(time % 1000);
        byte b13 = a8[0];
        byte b14 = a8[1];
        byte[] a10 = a(f11614c.incrementAndGet());
        byte b15 = a10[0];
        byte b16 = a10[1];
        byte[] a11 = a(Integer.valueOf(Process.myPid()).shortValue());
        String e10 = g.e(new byte[]{b7, b10, b11, b12, b13, b14, b15, b16, a11[0], a11[1]});
        Locale locale = Locale.US;
        this.f11615a = String.format(locale, "%s%s%s%s", e10.substring(0, 12), e10.substring(12, 16), e10.subSequence(16, 20), f11613b.substring(0, 12)).toUpperCase(locale);
    }

    public static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public final String toString() {
        return this.f11615a;
    }
}
