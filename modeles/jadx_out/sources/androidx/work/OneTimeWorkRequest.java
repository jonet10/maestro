package androidx.work;

import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import q6.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {
    public static final Companion Companion = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneTimeWorkRequest(Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        builder.getClass();
    }

    public static final OneTimeWorkRequest from(Class<? extends ListenableWorker> cls) {
        return Companion.from(cls);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> list) {
            list.getClass();
            List<? extends Class<? extends ListenableWorker>> list2 = list;
            ArrayList arrayList = new ArrayList(n.i0(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new Builder((Class<? extends ListenableWorker>) it.next()).build());
            }
            return arrayList;
        }

        private Companion() {
        }

        public final OneTimeWorkRequest from(Class<? extends ListenableWorker> cls) {
            cls.getClass();
            return new Builder(cls).build();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(j7.c cVar) {
            this((Class<? extends ListenableWorker>) d0.b.F(cVar));
            cVar.getClass();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            if (!getBackoffCriteriaSet$work_runtime_release() || !getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                return new OneTimeWorkRequest(this);
            }
            com.google.gson.internal.a.p("Cannot set backoff criteria on an idle mode job");
            return null;
        }

        public final Builder setInputMerger(Class<? extends InputMerger> cls) {
            cls.getClass();
            getWorkSpec$work_runtime_release().inputMergerClassName = cls.getName();
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls) {
            super(cls);
            cls.getClass();
        }
    }

    public static final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> list) {
        return Companion.from(list);
    }
}
