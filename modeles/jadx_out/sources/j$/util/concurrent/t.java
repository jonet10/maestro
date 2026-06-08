package j$.util.concurrent;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.stream.a7;
import j$.util.stream.f8;
import j$.util.stream.i7;
import j$.util.stream.p1;
import j$.util.stream.t1;
import j$.util.stream.u1;
import j$.util.stream.v1;
import j$.util.stream.z6;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class t implements BiConsumer, BiFunction, Consumer, Supplier, f8 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6015a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6016b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6017c;

    public /* synthetic */ t(int i, Object obj, Object obj2) {
        this.f6015a = i;
        this.f6016b = obj;
        this.f6017c = obj2;
    }

    public /* synthetic */ t(BiFunction biFunction, Function function) {
        this.f6015a = 2;
        this.f6017c = biFunction;
        this.f6016b = function;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f6015a) {
        }
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return j$.com.android.tools.r8.a.c(this, function);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f6015a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        return ((Function) this.f6016b).apply(((BiFunction) this.f6017c).apply(obj, obj2));
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.f6015a) {
            case 0:
                ConcurrentMap concurrentMap = (ConcurrentMap) this.f6016b;
                BiFunction biFunction = (BiFunction) this.f6017c;
                while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
                }
            default:
                BiConsumer biConsumer = (BiConsumer) this.f6016b;
                BiConsumer biConsumer2 = (BiConsumer) this.f6017c;
                biConsumer.accept(obj, obj2);
                biConsumer2.accept(obj, obj2);
                break;
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        return new p1((u1) this.f6016b, (Predicate) this.f6017c);
    }

    public t(a7 a7Var, u1 u1Var, Supplier supplier) {
        this.f6015a = 6;
        this.f6016b = u1Var;
        this.f6017c = supplier;
    }

    @Override // j$.util.stream.f8
    public int f() {
        return z6.f6452u | z6.f6449r;
    }

    @Override // j$.util.stream.f8
    public Object a(j$.util.stream.a aVar, Spliterator spliterator) {
        t1 t1Var = (t1) ((Supplier) this.f6017c).get();
        aVar.Q(spliterator, t1Var);
        return Boolean.valueOf(t1Var.f6363b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.stream.f8
    public Object b(j$.util.stream.a aVar, Spliterator spliterator) {
        return (Boolean) new v1(this, aVar, spliterator).invoke();
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public void n(Object obj) {
        switch (this.f6015a) {
            case 3:
                Consumer consumer = (Consumer) this.f6016b;
                Consumer consumer2 = (Consumer) this.f6017c;
                consumer.n(obj);
                consumer2.n(obj);
                break;
            case 4:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f6016b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f6017c;
                if (obj != null) {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    break;
                } else {
                    atomicBoolean.set(true);
                    break;
                }
            case 5:
            case 6:
            default:
                i7 i7Var = (i7) this.f6016b;
                Consumer consumer3 = (Consumer) this.f6017c;
                if (i7Var.f6228b.putIfAbsent(obj != null ? obj : i7.f6226d, Boolean.TRUE) == null) {
                    consumer3.n(obj);
                    break;
                }
                break;
            case 7:
                ((BiConsumer) this.f6016b).accept(this.f6017c, obj);
                break;
        }
    }
}
