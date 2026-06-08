package androidx.graphics.shapes;

import d7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FeatureMappingKt$featureMapper$2$1$2 extends m implements l {
    final /* synthetic */ int $N;
    final /* synthetic */ DoubleMapper $dm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureMappingKt$featureMapper$2$1$2(DoubleMapper doubleMapper, int i) {
        super(1);
        this.$dm = doubleMapper;
        this.$N = i;
    }

    public final CharSequence invoke(int i) {
        return Format_jvmKt.toStringWithLessPrecision(this.$dm.mapBack(i / this.$N));
    }

    @Override // d7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
