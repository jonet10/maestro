package androidx.window.layout;

import android.app.Activity;
import java.lang.reflect.Method;
import java.util.function.Consumer;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1 extends m implements d7.a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @Override // d7.a
    public final Boolean invoke() {
        Class windowLayoutComponentClass;
        boolean isPublic;
        boolean isPublic2;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
        boolean z9 = false;
        Method method = windowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", Activity.class, Consumer.class);
        Method method2 = windowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", Consumer.class);
        method.getClass();
        isPublic = safeWindowLayoutComponentProvider.isPublic(method);
        if (isPublic) {
            method2.getClass();
            isPublic2 = safeWindowLayoutComponentProvider.isPublic(method2);
            if (isPublic2) {
                z9 = true;
            }
        }
        return Boolean.valueOf(z9);
    }
}
