package androidx.work;

import android.annotation.SuppressLint;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.g;
import q6.j;
import q6.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkQuery {
    public static final Companion Companion = new Companion(null);
    private final List<UUID> ids;
    private final List<WorkInfo.State> states;
    private final List<String> tags;
    private final List<String> uniqueWorkNames;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ WorkQuery(java.util.List r2, java.util.List r3, java.util.List r4, java.util.List r5, int r6, kotlin.jvm.internal.g r7) {
        /*
            r1 = this;
            r7 = r6 & 1
            q6.t r0 = q6.t.f8724a
            if (r7 == 0) goto L7
            r2 = r0
        L7:
            r7 = r6 & 2
            if (r7 == 0) goto Lc
            r3 = r0
        Lc:
            r7 = r6 & 4
            if (r7 == 0) goto L11
            r4 = r0
        L11:
            r6 = r6 & 8
            if (r6 == 0) goto L16
            r5 = r0
        L16:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkQuery.<init>(java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.g):void");
    }

    public static final WorkQuery fromIds(List<UUID> list) {
        return Companion.fromIds(list);
    }

    public static final WorkQuery fromStates(List<? extends WorkInfo.State> list) {
        return Companion.fromStates(list);
    }

    public static final WorkQuery fromTags(List<String> list) {
        return Companion.fromTags(list);
    }

    public static final WorkQuery fromUniqueWorkNames(List<String> list) {
        return Companion.fromUniqueWorkNames(list);
    }

    public final List<UUID> getIds() {
        return this.ids;
    }

    public final List<WorkInfo.State> getStates() {
        return this.states;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final List<String> getUniqueWorkNames() {
        return this.uniqueWorkNames;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        private final List<UUID> ids;
        private final List<WorkInfo.State> states;
        private final List<String> tags;
        private final List<String> uniqueWorkNames;

        private Builder() {
            this.ids = new ArrayList();
            this.uniqueWorkNames = new ArrayList();
            this.tags = new ArrayList();
            this.states = new ArrayList();
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromIds(List<UUID> list) {
            return Companion.fromIds(list);
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromStates(List<? extends WorkInfo.State> list) {
            return Companion.fromStates(list);
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromTags(List<String> list) {
            return Companion.fromTags(list);
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromUniqueWorkNames(List<String> list) {
            return Companion.fromUniqueWorkNames(list);
        }

        public final Builder addIds(List<UUID> list) {
            list.getClass();
            r.k0(list, this.ids);
            return this;
        }

        public final Builder addStates(List<? extends WorkInfo.State> list) {
            list.getClass();
            r.k0(list, this.states);
            return this;
        }

        public final Builder addTags(List<String> list) {
            list.getClass();
            r.k0(list, this.tags);
            return this;
        }

        public final Builder addUniqueWorkNames(List<String> list) {
            list.getClass();
            r.k0(list, this.uniqueWorkNames);
            return this;
        }

        public final WorkQuery build() {
            if (!this.ids.isEmpty() || !this.uniqueWorkNames.isEmpty() || !this.tags.isEmpty() || !this.states.isEmpty()) {
                return new WorkQuery(this.ids, this.uniqueWorkNames, this.tags, this.states);
            }
            com.google.gson.internal.a.p("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
            return null;
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromIds(List<UUID> list) {
                list.getClass();
                Builder builder = new Builder(null);
                builder.addIds(list);
                return builder;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromStates(List<? extends WorkInfo.State> list) {
                list.getClass();
                Builder builder = new Builder(null);
                builder.addStates(list);
                return builder;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromTags(List<String> list) {
                list.getClass();
                Builder builder = new Builder(null);
                builder.addTags(list);
                return builder;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromUniqueWorkNames(List<String> list) {
                list.getClass();
                Builder builder = new Builder(null);
                builder.addUniqueWorkNames(list);
                return builder;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Builder(g gVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WorkQuery fromIds(UUID... uuidArr) {
            uuidArr.getClass();
            return new WorkQuery(j.m0(uuidArr), null, null, null, 14, null);
        }

        public final WorkQuery fromStates(WorkInfo.State... stateArr) {
            stateArr.getClass();
            return new WorkQuery(null, null, null, j.m0(stateArr), 7, null);
        }

        public final WorkQuery fromTags(String... strArr) {
            strArr.getClass();
            return new WorkQuery(null, null, j.m0(strArr), null, 11, null);
        }

        public final WorkQuery fromUniqueWorkNames(String... strArr) {
            strArr.getClass();
            return new WorkQuery(null, j.m0(strArr), null, null, 13, null);
        }

        private Companion() {
        }

        public final WorkQuery fromStates(List<? extends WorkInfo.State> list) {
            list.getClass();
            return new WorkQuery(null, null, null, list, 7, null);
        }

        public final WorkQuery fromIds(List<UUID> list) {
            list.getClass();
            return new WorkQuery(list, null, null, null, 14, null);
        }

        public final WorkQuery fromTags(List<String> list) {
            list.getClass();
            return new WorkQuery(null, null, list, null, 11, null);
        }

        public final WorkQuery fromUniqueWorkNames(List<String> list) {
            list.getClass();
            return new WorkQuery(null, list, null, null, 13, null);
        }
    }

    public static final WorkQuery fromIds(UUID... uuidArr) {
        return Companion.fromIds(uuidArr);
    }

    public static final WorkQuery fromStates(WorkInfo.State... stateArr) {
        return Companion.fromStates(stateArr);
    }

    public static final WorkQuery fromTags(String... strArr) {
        return Companion.fromTags(strArr);
    }

    public static final WorkQuery fromUniqueWorkNames(String... strArr) {
        return Companion.fromUniqueWorkNames(strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkQuery(List<UUID> list, List<String> list2, List<String> list3, List<? extends WorkInfo.State> list4) {
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        this.ids = list;
        this.uniqueWorkNames = list2;
        this.tags = list3;
        this.states = list4;
    }

    public WorkQuery() {
        this(null, null, null, null, 15, null);
    }
}
