package j$.util.stream;

import j$.util.Collection;
import j$.util.Objects;
import java.util.ArrayList;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class i6 extends a6 {

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f6225d;

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j) {
        if (j >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f6225d = j >= 0 ? new ArrayList((int) j) : new ArrayList();
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void end() {
        j$.util.c.u(this.f6225d, this.f6135b);
        long size = this.f6225d.size();
        m5 m5Var = this.f6224a;
        m5Var.c(size);
        boolean z9 = this.f6136c;
        ArrayList arrayList = this.f6225d;
        if (!z9) {
            Objects.requireNonNull(m5Var);
            Collection.EL.a(arrayList, new j$.util.q(8, m5Var));
        } else {
            int size2 = arrayList.size();
            int i = 0;
            while (i < size2) {
                Object obj = arrayList.get(i);
                i++;
                if (m5Var.e()) {
                    break;
                } else {
                    m5Var.n((m5) obj);
                }
            }
        }
        m5Var.end();
        this.f6225d = null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f6225d.add(obj);
    }
}
