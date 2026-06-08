package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r3 extends s3 {
    public final Object[] h;

    public r3(Spliterator spliterator, a aVar, Object[] objArr) {
        super(spliterator, aVar, objArr.length);
        this.h = objArr;
    }

    public r3(r3 r3Var, Spliterator spliterator, long j, long j6) {
        super(r3Var, spliterator, j, j6, r3Var.h.length);
        this.h = r3Var.h;
    }

    @Override // j$.util.stream.s3
    public final s3 a(Spliterator spliterator, long j, long j6) {
        return new r3(this, spliterator, j, j6);
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        Object[] objArr = this.h;
        this.f = i + 1;
        objArr[i] = obj;
    }
}
