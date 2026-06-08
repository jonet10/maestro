package androidx.collection;

import d7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ObjectList$toString$1 extends m implements l {
    final /* synthetic */ ObjectList<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectList$toString$1(ObjectList<E> objectList) {
        super(1);
        this.this$0 = objectList;
    }

    @Override // d7.l
    public final CharSequence invoke(E e10) {
        return e10 == this.this$0 ? "(this)" : String.valueOf(e10);
    }

    @Override // d7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((ObjectList$toString$1) obj);
    }
}
