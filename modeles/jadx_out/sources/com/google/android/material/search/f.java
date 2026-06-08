package com.google.android.material.search;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3026a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3027b;

    public /* synthetic */ f(Object obj, int i) {
        this.f3026a = i;
        this.f3027b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3026a) {
            case 0:
                ((SearchViewAnimationHelper) this.f3027b).hide();
                break;
            case 1:
                ((SearchViewAnimationHelper) this.f3027b).lambda$startShowAnimationExpand$0();
                break;
            case 2:
                ((SearchViewAnimationHelper) this.f3027b).lambda$startShowAnimationTranslate$1();
                break;
            default:
                ((SearchBar) this.f3027b).lambda$startOnLoadAnimation$0();
                break;
        }
    }
}
