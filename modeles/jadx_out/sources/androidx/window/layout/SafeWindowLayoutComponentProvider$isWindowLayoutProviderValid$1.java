package androidx.window.layout;

import java.lang.reflect.Method;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1 extends m implements d7.a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @Override // d7.a
    public final Boolean invoke() {
        Class windowExtensionsProviderClass;
        Class windowExtensionsClass;
        boolean doesReturn;
        boolean z9;
        boolean isPublic;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        windowExtensionsProviderClass = safeWindowLayoutComponentProvider.windowExtensionsProviderClass(this.$classLoader);
        Method declaredMethod = windowExtensionsProviderClass.getDeclaredMethod("getWindowExtensions", null);
        windowExtensionsClass = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader);
        declaredMethod.getClass();
        windowExtensionsClass.getClass();
        doesReturn = safeWindowLayoutComponentProvider.doesReturn(declaredMethod, (Class<?>) windowExtensionsClass);
        if (doesReturn) {
            isPublic = safeWindowLayoutComponentProvider.isPublic(declaredMethod);
            if (isPublic) {
                z9 = true;
                return Boolean.valueOf(z9);
            }
        }
        z9 = false;
        return Boolean.valueOf(z9);
    }
}
