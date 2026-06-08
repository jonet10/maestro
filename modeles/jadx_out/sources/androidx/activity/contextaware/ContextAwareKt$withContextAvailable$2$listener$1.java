package androidx.activity.contextaware;

import android.content.Context;
import d7.l;
import o7.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ j $co;
    final /* synthetic */ l $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(j jVar, l lVar) {
        this.$co = jVar;
        this.$onContextAvailable = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object jVar;
        context.getClass();
        j jVar2 = this.$co;
        try {
            jVar = this.$onContextAvailable.invoke(context);
        } catch (Throwable th) {
            jVar = new p6.j(th);
        }
        jVar2.resumeWith(jVar);
    }
}
