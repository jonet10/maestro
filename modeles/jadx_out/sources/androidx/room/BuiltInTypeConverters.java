package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Target({})
@Retention(RetentionPolicy.CLASS)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public @interface BuiltInTypeConverters {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class State {
        private static final /* synthetic */ w6.a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State ENABLED = new State("ENABLED", 0);
        public static final State DISABLED = new State("DISABLED", 1);
        public static final State INHERITED = new State("INHERITED", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{ENABLED, DISABLED, INHERITED};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = t0.f.u($values);
        }

        private State(String str, int i) {
        }

        public static w6.a getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    State byteBuffer() default State.INHERITED;

    State enums() default State.INHERITED;

    State uuid() default State.INHERITED;
}
