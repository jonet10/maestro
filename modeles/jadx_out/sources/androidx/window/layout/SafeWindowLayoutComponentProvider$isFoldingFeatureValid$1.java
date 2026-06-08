package androidx.window.layout;

import android.graphics.Rect;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends m implements d7.a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @Override // d7.a
    public final Boolean invoke() {
        Class foldingFeatureClass;
        boolean doesReturn;
        boolean z9;
        boolean isPublic;
        boolean doesReturn2;
        boolean isPublic2;
        boolean doesReturn3;
        boolean isPublic3;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        foldingFeatureClass = safeWindowLayoutComponentProvider.foldingFeatureClass(this.$classLoader);
        Method method = foldingFeatureClass.getMethod("getBounds", null);
        Method method2 = foldingFeatureClass.getMethod("getType", null);
        Method method3 = foldingFeatureClass.getMethod("getState", null);
        method.getClass();
        doesReturn = safeWindowLayoutComponentProvider.doesReturn(method, y.a(Rect.class));
        if (doesReturn) {
            isPublic = safeWindowLayoutComponentProvider.isPublic(method);
            if (isPublic) {
                method2.getClass();
                Class cls = Integer.TYPE;
                doesReturn2 = safeWindowLayoutComponentProvider.doesReturn(method2, y.a(cls));
                if (doesReturn2) {
                    isPublic2 = safeWindowLayoutComponentProvider.isPublic(method2);
                    if (isPublic2) {
                        method3.getClass();
                        doesReturn3 = safeWindowLayoutComponentProvider.doesReturn(method3, y.a(cls));
                        if (doesReturn3) {
                            isPublic3 = safeWindowLayoutComponentProvider.isPublic(method3);
                            if (isPublic3) {
                                z9 = true;
                                return Boolean.valueOf(z9);
                            }
                        }
                    }
                }
            }
        }
        z9 = false;
        return Boolean.valueOf(z9);
    }
}
