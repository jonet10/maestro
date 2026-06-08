package j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class e implements Comparator, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6036a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Comparator f6037b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6038c;

    public /* synthetic */ e(f fVar, Comparator comparator) {
        this.f6038c = fVar;
        this.f6037b = comparator;
    }

    public /* synthetic */ e(Function function, Comparator comparator) {
        this.f6037b = comparator;
        this.f6038c = function;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f6036a) {
            case 0:
                f fVar = (f) this.f6038c;
                Comparator comparator = this.f6037b;
                int compare = fVar.compare(obj, obj2);
                return compare != 0 ? compare : comparator.compare(obj, obj2);
            default:
                Comparator comparator2 = this.f6037b;
                Function function = (Function) this.f6038c;
                return comparator2.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
