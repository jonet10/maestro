package j$.util.stream;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class c6 extends y5 {

    /* renamed from: c, reason: collision with root package name */
    public r6 f6164c;

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j) {
        r6 r6Var;
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return;
        }
        if (j <= 0) {
            r6Var = new r6();
        } else {
            r6Var = new r6((int) j);
        }
        this.f6164c = r6Var;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void end() {
        int[] iArr = (int[]) this.f6164c.b();
        Arrays.sort(iArr);
        long length = iArr.length;
        m5 m5Var = this.f6205a;
        m5Var.c(length);
        int i = 0;
        if (!this.f6431b) {
            int length2 = iArr.length;
            while (i < length2) {
                m5Var.accept(iArr[i]);
                i++;
            }
        } else {
            int length3 = iArr.length;
            while (i < length3) {
                int i6 = iArr[i];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(i6);
                i++;
            }
        }
        m5Var.end();
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i) {
        this.f6164c.accept(i);
    }
}
