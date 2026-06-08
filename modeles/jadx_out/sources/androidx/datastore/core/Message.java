package androidx.datastore.core;

import d7.p;
import kotlin.jvm.internal.g;
import o7.q;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class Message<T> {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Read<T> extends Message<T> {
        private final State<T> lastState;

        public Read(State<T> state) {
            super(null);
            this.lastState = state;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Update<T> extends Message<T> {
        private final q ack;
        private final h callerContext;
        private final State<T> lastState;
        private final p transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(p pVar, q qVar, State<T> state, h hVar) {
            super(null);
            pVar.getClass();
            qVar.getClass();
            hVar.getClass();
            this.transform = pVar;
            this.ack = qVar;
            this.lastState = state;
            this.callerContext = hVar;
        }

        public final q getAck() {
            return this.ack;
        }

        public final h getCallerContext() {
            return this.callerContext;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }

        public final p getTransform() {
            return this.transform;
        }
    }

    public /* synthetic */ Message(g gVar) {
        this();
    }

    public abstract State<T> getLastState();

    private Message() {
    }
}
