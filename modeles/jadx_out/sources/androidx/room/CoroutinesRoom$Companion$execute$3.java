package androidx.room;

import androidx.room.CoroutinesRoom;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.CoroutinesRoom$Companion", f = "CoroutinesRoom.android.kt", l = {64, 94}, m = "execute")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutinesRoom$Companion$execute$3<R> extends v6.c {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutinesRoom.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$3(CoroutinesRoom.Companion companion, t6.c cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, false, null, null, this);
    }
}
