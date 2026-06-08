package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewKt$allViews$1 extends v6.h implements d7.p {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, t6.c cVar) {
        super(2, cVar);
        this.$this_allViews = view;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, cVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // d7.p
    public final Object invoke(k7.h hVar, t6.c cVar) {
        return ((ViewKt$allViews$1) create(hVar, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i = this.label;
        Object obj3 = u6.a.f10762a;
        if (i == 0) {
            p6.a.e(obj);
            k7.h hVar = (k7.h) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = hVar;
            this.label = 1;
            hVar.a(view, this);
            return obj3;
        }
        Object obj4 = x.f8463a;
        if (i != 1) {
            if (i == 2) {
                p6.a.e(obj);
                return obj4;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        k7.h hVar2 = (k7.h) this.L$0;
        p6.a.e(obj);
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            k7.f descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            hVar2.getClass();
            Iterator it = descendants.iterator();
            k7.g gVar = (k7.g) hVar2;
            if (it.hasNext()) {
                gVar.f6999l = it;
                gVar.f6997a = 2;
                gVar.f7000m = this;
                obj2 = obj3;
            } else {
                obj2 = obj4;
            }
            if (obj2 != obj3) {
                obj2 = obj4;
            }
            if (obj2 == obj3) {
                return obj3;
            }
        }
        return obj4;
    }
}
