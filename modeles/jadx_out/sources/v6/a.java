package v6;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements t6.c, d, Serializable {
    private final t6.c completion;

    public a(t6.c cVar) {
        this.completion = cVar;
    }

    public t6.c create(t6.c cVar) {
        cVar.getClass();
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        t6.c cVar = this.completion;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    public final t6.c getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int i;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str2 = null;
        if (eVar == null) {
            return null;
        }
        int v = eVar.v();
        if (v > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            i = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            i = -1;
        }
        int i6 = i >= 0 ? eVar.l()[i] : -1;
        u8.c cVar = f.f10857b;
        u8.c cVar2 = f.f10856a;
        if (cVar == null) {
            try {
                u8.c cVar3 = new u8.c(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                f.f10857b = cVar3;
                cVar = cVar3;
            } catch (Exception unused2) {
                f.f10857b = cVar2;
                cVar = cVar2;
            }
        }
        if (cVar != cVar2 && (method = cVar.f10772a) != null && (invoke = method.invoke(getClass(), null)) != null && (method2 = cVar.f10773b) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
            Method method3 = cVar.f10774c;
            Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
            if (invoke3 instanceof String) {
                str2 = (String) invoke3;
            }
        }
        if (str2 == null) {
            str = eVar.c();
        } else {
            str = str2 + '/' + eVar.c();
        }
        return new StackTraceElement(str, eVar.m(), eVar.f(), i6);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // t6.c
    public final void resumeWith(Object obj) {
        t6.c cVar = this;
        while (true) {
            a aVar = (a) cVar;
            t6.c cVar2 = aVar.completion;
            cVar2.getClass();
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == u6.a.f10762a) {
                    return;
                }
            } catch (Throwable th) {
                obj = new j(th);
            }
            aVar.releaseIntercepted();
            if (!(cVar2 instanceof a)) {
                cVar2.resumeWith(obj);
                return;
            }
            cVar = cVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public t6.c create(Object obj, t6.c cVar) {
        cVar.getClass();
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
