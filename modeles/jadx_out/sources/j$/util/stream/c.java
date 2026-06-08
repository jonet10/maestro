package j$.util.stream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f6151a;

    /* renamed from: b, reason: collision with root package name */
    public int f6152b;

    /* renamed from: c, reason: collision with root package name */
    public int f6153c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f6154d;

    public abstract void clear();

    public c() {
        this.f6151a = 4;
    }

    public c(int i) {
        if (i < 0) {
            j$.time.g.i("Illegal Capacity: ", i);
            throw null;
        }
        this.f6151a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public final long count() {
        int i = this.f6153c;
        if (i == 0) {
            return this.f6152b;
        }
        return this.f6154d[i] + this.f6152b;
    }
}
