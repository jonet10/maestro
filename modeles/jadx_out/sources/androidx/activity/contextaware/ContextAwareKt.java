package androidx.activity.contextaware;

import android.content.Context;
import d0.b;
import d7.l;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, l lVar, c cVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        o7.l lVar2 = new o7.l(1, b.I(cVar));
        lVar2.s();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(lVar2, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        lVar2.u(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        return lVar2.r();
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, l lVar, c cVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        o7.l lVar2 = new o7.l(1, b.I(cVar));
        lVar2.s();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(lVar2, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        lVar2.u(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        return lVar2.r();
    }
}
