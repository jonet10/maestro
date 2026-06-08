package a4;

import java.io.PrintWriter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f159a;

    /* renamed from: b, reason: collision with root package name */
    public final int f160b;

    /* renamed from: c, reason: collision with root package name */
    public final long f161c;

    /* renamed from: d, reason: collision with root package name */
    public final long f162d;

    /* renamed from: e, reason: collision with root package name */
    public final long f163e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;

    /* renamed from: k, reason: collision with root package name */
    public final int f164k;

    /* renamed from: l, reason: collision with root package name */
    public final int f165l;

    /* renamed from: m, reason: collision with root package name */
    public final int f166m;

    /* renamed from: n, reason: collision with root package name */
    public final long f167n;

    public p0(int i, int i6, long j, long j6, long j10, long j11, long j12, long j13, long j14, long j15, int i10, int i11, int i12, long j16) {
        this.f159a = i;
        this.f160b = i6;
        this.f161c = j;
        this.f162d = j6;
        this.f163e = j10;
        this.f = j11;
        this.g = j12;
        this.h = j13;
        this.i = j14;
        this.j = j15;
        this.f164k = i10;
        this.f165l = i11;
        this.f166m = i12;
        this.f167n = j16;
    }

    public final void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f159a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f160b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((r1 / r0) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f161c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f162d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f164k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f163e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f165l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f166m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public final String toString() {
        return "StatsSnapshot{maxSize=" + this.f159a + ", size=" + this.f160b + ", cacheHits=" + this.f161c + ", cacheMisses=" + this.f162d + ", downloadCount=" + this.f164k + ", totalDownloadSize=" + this.f163e + ", averageDownloadSize=" + this.h + ", totalOriginalBitmapSize=" + this.f + ", totalTransformedBitmapSize=" + this.g + ", averageOriginalBitmapSize=" + this.i + ", averageTransformedBitmapSize=" + this.j + ", originalBitmapCount=" + this.f165l + ", transformedBitmapCount=" + this.f166m + ", timeStamp=" + this.f167n + '}';
    }
}
