package androidx.work.impl.constraints;

import android.os.Build;
import androidx.room.f;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import d7.q;
import java.util.ArrayList;
import java.util.List;
import o7.t1;
import p6.x;
import q6.j;
import q6.l;
import q6.n;
import r7.h;
import r7.k0;
import s7.g;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkConstraintsTracker {
    private final List<ConstraintController> controllers;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(Trackers trackers) {
        this(j.h0(new ConstraintController[]{new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker()), Build.VERSION.SDK_INT >= 28 ? WorkConstraintsTrackerKt.NetworkRequestConstraintController(trackers.getContext()) : null}));
        trackers.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence areAllConstraintsMet$lambda$5(ConstraintController constraintController) {
        constraintController.getClass();
        return constraintController.getClass().getSimpleName();
    }

    public final boolean areAllConstraintsMet(WorkSpec workSpec) {
        String str;
        workSpec.getClass();
        List<ConstraintController> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).isCurrentlyConstrained(workSpec)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger logger = Logger.get();
            str = WorkConstraintsTrackerKt.TAG;
            logger.debug(str, "Work " + workSpec.id + " constrained by " + l.x0(arrayList, null, null, null, new f(6), 31));
        }
        return arrayList.isEmpty();
    }

    public final h track(WorkSpec workSpec) {
        workSpec.getClass();
        List<ConstraintController> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).hasConstraint(workSpec)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(n.i0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((ConstraintController) obj2).track(workSpec.constraints));
        }
        final h[] hVarArr = (h[]) l.G0(arrayList2).toArray(new h[0]);
        return k0.h(new h() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1

            /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
            @e(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {288}, m = "invokeSuspend")
            /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3, reason: invalid class name */
            public static final class AnonymousClass3 extends i implements q {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(t6.c cVar) {
                    super(3, cVar);
                }

                @Override // d7.q
                public final Object invoke(r7.i iVar, ConstraintsState[] constraintsStateArr, t6.c cVar) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(cVar);
                    anonymousClass3.L$0 = iVar;
                    anonymousClass3.L$1 = constraintsStateArr;
                    return anonymousClass3.invokeSuspend(x.f8463a);
                }

                @Override // v6.a
                public final Object invokeSuspend(Object obj) {
                    ConstraintsState constraintsState;
                    int i = this.label;
                    if (i == 0) {
                        p6.a.e(obj);
                        r7.i iVar = (r7.i) this.L$0;
                        ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                        int length = constraintsStateArr.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                constraintsState = null;
                                break;
                            }
                            constraintsState = constraintsStateArr[i6];
                            if (!kotlin.jvm.internal.l.a(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                                break;
                            }
                            i6++;
                        }
                        if (constraintsState == null) {
                            constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                        }
                        this.label = 1;
                        Object emit = iVar.emit(constraintsState, this);
                        u6.a aVar = u6.a.f10762a;
                        if (emit == aVar) {
                            return aVar;
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

            /* JADX WARN: Type inference failed for: r2v0, types: [androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$2] */
            @Override // r7.h
            public Object collect(r7.i iVar, t6.c cVar) {
                final h[] hVarArr2 = hVarArr;
                g gVar = new g(hVarArr2, new d7.a() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1.2
                    @Override // d7.a
                    public final ConstraintsState[] invoke() {
                        return new ConstraintsState[hVarArr2.length];
                    }
                }, new AnonymousClass3(null), iVar, null);
                t1 t1Var = new t1(cVar.getContext(), cVar, 1);
                Object J = t0.f.J(t1Var, t1Var, gVar);
                x xVar = x.f8463a;
                u6.a aVar = u6.a.f10762a;
                if (J != aVar) {
                    J = xVar;
                }
                return J == aVar ? J : xVar;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkConstraintsTracker(List<? extends ConstraintController> list) {
        list.getClass();
        this.controllers = list;
    }
}
