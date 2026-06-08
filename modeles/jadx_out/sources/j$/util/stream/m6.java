package j$.util.stream;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m6 extends a6 {

    /* renamed from: d, reason: collision with root package name */
    public Object[] f6289d;

    /* renamed from: e, reason: collision with root package name */
    public int f6290e;

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f6289d = new Object[(int) j];
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f6289d, 0, this.f6290e, this.f6135b);
        long j = this.f6290e;
        m5 m5Var = this.f6224a;
        m5Var.c(j);
        if (!this.f6136c) {
            while (i < this.f6290e) {
                m5Var.accept((m5) this.f6289d[i]);
                i++;
            }
        } else {
            while (i < this.f6290e && !m5Var.e()) {
                m5Var.accept((m5) this.f6289d[i]);
                i++;
            }
        }
        m5Var.end();
        this.f6289d = null;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Object[] objArr = this.f6289d;
        int i = this.f6290e;
        this.f6290e = i + 1;
        objArr[i] = obj;
    }
}
