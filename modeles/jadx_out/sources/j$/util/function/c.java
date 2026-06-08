package j$.util.function;

import j$.time.g;
import j$.util.Objects;
import j$.util.stream.Collectors;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class c implements Function, BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6050a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function f6051b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function f6052c;

    public /* synthetic */ c(Function function, Function function2, int i) {
        this.f6050a = i;
        this.f6051b = function;
        this.f6052c = function2;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ Function andThen(Function function) {
        switch (this.f6050a) {
        }
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        switch (this.f6050a) {
        }
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (this.f6050a) {
            case 0:
                return this.f6052c.apply(this.f6051b.apply(obj));
            default:
                return this.f6051b.apply(this.f6052c.apply(obj));
        }
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        Set set = Collectors.f6120a;
        Object apply = this.f6051b.apply(obj2);
        Object requireNonNull = Objects.requireNonNull(this.f6052c.apply(obj2));
        Object t9 = j$.util.c.t((Map) obj, apply, requireNonNull);
        if (t9 == null) {
            return;
        }
        g.g("Duplicate key %s (attempted merging values %s and %s)", new Object[]{apply, t9, requireNonNull});
    }
}
