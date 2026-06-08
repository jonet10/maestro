package a3;

import a4.d0;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.Person;
import android.window.OnBackInvokedDispatcher;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements s1.d, Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58a;

    public /* synthetic */ b(int i) {
        this.f58a = i;
    }

    public static /* bridge */ /* synthetic */ NotificationChannel d(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* bridge */ /* synthetic */ NotificationChannelGroup e(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    public static /* bridge */ /* synthetic */ Person f(Object obj) {
        return (Person) obj;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher h(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    public static /* synthetic */ void i() {
        throw new ConcurrentModificationException();
    }

    public static /* synthetic */ void j(int i, int i6, int i10) {
        throw new IndexOutOfBoundsException("Start (" + i + ((Object) ") and end (") + i6 + ((Object) ") must be in 0..") + i10);
    }

    public static /* synthetic */ void l(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void m(Object obj, String str, Object obj2) {
        throw new NoSuchElementException(str + obj + obj2);
    }

    public static /* synthetic */ void n(String str) {
        throw new RuntimeException(str);
    }

    public static /* synthetic */ void o(String str, float f, Object obj) {
        throw new IllegalArgumentException(str + f + obj);
    }

    public static /* synthetic */ void q(Object obj, String str, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void r(String str) {
        throw new UnsupportedOperationException(str);
    }

    @Override // s1.d
    public Object c(d0 d0Var) {
        Set p10 = d0Var.p(a.class);
        d dVar = d.f61l;
        if (dVar == null) {
            synchronized (d.class) {
                try {
                    dVar = d.f61l;
                    if (dVar == null) {
                        dVar = new d(0);
                        d.f61l = dVar;
                    }
                } finally {
                }
            }
        }
        return new c(p10, dVar);
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        float lambda$getInterpolator$1;
        float lambda$getInterpolator$2;
        float lambda$getInterpolator$3;
        float lambda$getInterpolator$4;
        float lambda$getInterpolator$5;
        float lambda$getInterpolator$6;
        float lambda$getInterpolator$7;
        switch (this.f58a) {
            case 16:
                lambda$getInterpolator$1 = Transition.lambda$getInterpolator$1(f);
                return lambda$getInterpolator$1;
            case 17:
                lambda$getInterpolator$2 = Transition.lambda$getInterpolator$2(f);
                return lambda$getInterpolator$2;
            case 18:
                lambda$getInterpolator$3 = Transition.lambda$getInterpolator$3(f);
                return lambda$getInterpolator$3;
            case 19:
                lambda$getInterpolator$4 = Transition.lambda$getInterpolator$4(f);
                return lambda$getInterpolator$4;
            case 20:
                lambda$getInterpolator$5 = Transition.lambda$getInterpolator$5(f);
                return lambda$getInterpolator$5;
            case 21:
                lambda$getInterpolator$6 = Transition.lambda$getInterpolator$6(f);
                return lambda$getInterpolator$6;
            default:
                lambda$getInterpolator$7 = Transition.lambda$getInterpolator$7(f);
                return lambda$getInterpolator$7;
        }
    }
}
