package j$.util.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6284b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6285c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.f6284b = i;
        this.f6285c = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(m5 m5Var) {
        super(m5Var);
        this.f6284b = 0;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public void end() {
        switch (this.f6284b) {
            case 0:
                this.f6285c = null;
                this.f6224a.end();
                break;
            default:
                super.end();
                break;
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public void c(long j) {
        switch (this.f6284b) {
            case 0:
                this.f6285c = new HashSet();
                this.f6224a.c(-1L);
                break;
            case 1:
            default:
                super.c(j);
                break;
            case 2:
                this.f6224a.c(-1L);
                break;
        }
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6284b) {
            case 0:
                if (!((Set) this.f6285c).contains(obj)) {
                    ((Set) this.f6285c).add(obj);
                    this.f6224a.accept((m5) obj);
                    break;
                }
                break;
            case 1:
                ((Consumer) ((r) this.f6285c).f6336m).accept(obj);
                this.f6224a.accept((m5) obj);
                break;
            case 2:
                if (((Predicate) ((r) this.f6285c).f6336m).test(obj)) {
                    this.f6224a.accept((m5) obj);
                    break;
                }
                break;
            case 3:
                this.f6224a.accept((m5) ((Function) ((r) this.f6285c).f6336m).apply(obj));
                break;
            case 4:
                this.f6224a.accept(((ToIntFunction) ((v0) this.f6285c).f6395m).applyAsInt(obj));
                break;
            case 5:
                this.f6224a.accept(((ToLongFunction) ((g1) this.f6285c).f6201m).applyAsLong(obj));
                break;
            default:
                this.f6224a.accept(((ToDoubleFunction) ((x) this.f6285c).f6420m).applyAsDouble(obj));
                break;
        }
    }
}
