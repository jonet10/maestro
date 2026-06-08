package m3;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7271a;

    public /* synthetic */ Function andThen(Function function) {
        int i = this.f7271a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7271a) {
            case 0:
                return (Integer) ((Object[]) obj)[1];
            case 1:
                return obj.toString();
            default:
                return (String) s3.b.f9158b.get((Integer) obj);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.f7271a;
        return Function$CC.$default$compose(this, function);
    }
}
