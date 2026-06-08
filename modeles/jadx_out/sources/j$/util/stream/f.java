package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class f implements BaseStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f6187a;

    public /* synthetic */ f(g gVar) {
        this.f6187a = gVar;
    }

    public static /* synthetic */ BaseStream g(g gVar) {
        if (gVar == null) {
            return null;
        }
        return gVar instanceof e ? ((e) gVar).f6177a : gVar instanceof e0 ? d0.g((e0) gVar) : gVar instanceof IntStream ? IntStream.Wrapper.convert((IntStream) gVar) : gVar instanceof n1 ? m1.g((n1) gVar) : gVar instanceof Stream ? Stream.Wrapper.convert((Stream) gVar) : new f(gVar);
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f6187a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        g gVar = this.f6187a;
        if (obj instanceof f) {
            obj = ((f) obj).f6187a;
        }
        return gVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f6187a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.f6187a.isParallel();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Iterator iterator() {
        return this.f6187a.iterator();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return g(this.f6187a.onClose(runnable));
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return g(this.f6187a.parallel());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return g(this.f6187a.sequential());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(this.f6187a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return g(this.f6187a.unordered());
    }
}
