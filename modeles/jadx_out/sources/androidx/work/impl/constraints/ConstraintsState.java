package androidx.work.impl.constraints;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class ConstraintsState {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ConstraintsMet extends ConstraintsState {
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();

        private ConstraintsMet() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ConstraintsNotMet extends ConstraintsState {
        private final int reason;

        public ConstraintsNotMet(int i) {
            super(null);
            this.reason = i;
        }

        public static /* synthetic */ ConstraintsNotMet copy$default(ConstraintsNotMet constraintsNotMet, int i, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = constraintsNotMet.reason;
            }
            return constraintsNotMet.copy(i);
        }

        public final int component1() {
            return this.reason;
        }

        public final ConstraintsNotMet copy(int i) {
            return new ConstraintsNotMet(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.reason == ((ConstraintsNotMet) obj).reason;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason;
        }

        public String toString() {
            return "ConstraintsNotMet(reason=" + this.reason + ')';
        }
    }

    public /* synthetic */ ConstraintsState(g gVar) {
        this();
    }

    private ConstraintsState() {
    }
}
