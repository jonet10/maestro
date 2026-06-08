package androidx.work.impl.constraints.controllers;

import androidx.core.text.HtmlCompat;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import d0.b;
import d7.p;
import p6.x;
import q7.r;
import q7.s;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", l = {HtmlCompat.FROM_HTML_MODE_COMPACT}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BaseConstraintController$track$1 extends i implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseConstraintController<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseConstraintController$track$1(BaseConstraintController<T> baseConstraintController, c cVar) {
        super(2, cVar);
        this.this$0 = baseConstraintController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x invokeSuspend$lambda$0(BaseConstraintController baseConstraintController, BaseConstraintController$track$1$listener$1 baseConstraintController$track$1$listener$1) {
        ConstraintTracker constraintTracker;
        constraintTracker = baseConstraintController.tracker;
        constraintTracker.removeListener(baseConstraintController$track$1$listener$1);
        return x.f8463a;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        BaseConstraintController$track$1 baseConstraintController$track$1 = new BaseConstraintController$track$1(this.this$0, cVar);
        baseConstraintController$track$1.L$0 = obj;
        return baseConstraintController$track$1;
    }

    @Override // d7.p
    public final Object invoke(s sVar, c cVar) {
        return ((BaseConstraintController$track$1) create(sVar, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.work.impl.constraints.ConstraintListener, androidx.work.impl.constraints.controllers.BaseConstraintController$track$1$listener$1] */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        ConstraintTracker constraintTracker;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            final s sVar = (s) this.L$0;
            final BaseConstraintController<T> baseConstraintController = this.this$0;
            final ?? r02 = new ConstraintListener<T>() { // from class: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1$listener$1
                @Override // androidx.work.impl.constraints.ConstraintListener
                public void onConstraintChanged(T t9) {
                    Object constraintsNotMet = baseConstraintController.isConstrained(t9) ? new ConstraintsState.ConstraintsNotMet(baseConstraintController.getReason()) : ConstraintsState.ConstraintsMet.INSTANCE;
                    r rVar = (r) sVar;
                    rVar.getClass();
                    rVar.p(constraintsNotMet);
                }
            };
            constraintTracker = ((BaseConstraintController) this.this$0).tracker;
            constraintTracker.addListener(r02);
            final BaseConstraintController<T> baseConstraintController2 = this.this$0;
            d7.a aVar = new d7.a() { // from class: androidx.work.impl.constraints.controllers.a
                @Override // d7.a
                public final Object invoke() {
                    x invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = BaseConstraintController$track$1.invokeSuspend$lambda$0(BaseConstraintController.this, r02);
                    return invokeSuspend$lambda$0;
                }
            };
            this.label = 1;
            Object o10 = b.o(sVar, aVar, this);
            u6.a aVar2 = u6.a.f10762a;
            if (o10 == aVar2) {
                return aVar2;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
