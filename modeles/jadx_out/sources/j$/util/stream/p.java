package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class p implements BinaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6317a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f6318b;

    public /* synthetic */ p(BiConsumer biConsumer, int i) {
        this.f6317a = i;
        this.f6318b = biConsumer;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f6317a) {
        }
        return j$.com.android.tools.r8.a.c(this, function);
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f6317a) {
            case 0:
                this.f6318b.accept(obj, obj2);
                break;
            case 1:
                this.f6318b.accept(obj, obj2);
                break;
            default:
                this.f6318b.accept(obj, obj2);
                break;
        }
        return obj;
    }
}
