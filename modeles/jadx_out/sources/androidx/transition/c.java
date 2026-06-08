package androidx.transition;

import androidx.transition.Transition;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements Transition.TransitionNotification {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f522a;

    public static /* synthetic */ void a(Object obj, String str) {
        throw new RuntimeException(str + obj);
    }

    @Override // androidx.transition.Transition.TransitionNotification
    public void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z9) {
        switch (this.f522a) {
            case 0:
                transitionListener.onTransitionStart(transition, z9);
                break;
            case 1:
                transitionListener.onTransitionEnd(transition, z9);
                break;
            case 2:
                transitionListener.onTransitionCancel(transition);
                break;
            case 3:
                transitionListener.onTransitionPause(transition);
                break;
            default:
                transitionListener.onTransitionResume(transition);
                break;
        }
    }
}
