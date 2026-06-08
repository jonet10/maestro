package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface StartStopTokens {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean contains(WorkGenerationalId workGenerationalId);

    StartStopToken remove(WorkGenerationalId workGenerationalId);

    StartStopToken remove(WorkSpec workSpec);

    List<StartStopToken> remove(String str);

    StartStopToken tokenFor(WorkGenerationalId workGenerationalId);

    StartStopToken tokenFor(WorkSpec workSpec);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ StartStopTokens create$default(Companion companion, boolean z9, int i, Object obj) {
            if ((i & 1) != 0) {
                z9 = true;
            }
            return companion.create(z9);
        }

        public final StartStopTokens create(boolean z9) {
            StartStopTokensImpl startStopTokensImpl = new StartStopTokensImpl();
            return z9 ? new SynchronizedStartStopTokensImpl(startStopTokensImpl) : startStopTokensImpl;
        }

        public final StartStopTokens create() {
            return create$default(this, false, 1, null);
        }
    }
}
