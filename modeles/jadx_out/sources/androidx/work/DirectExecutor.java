package androidx.work;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import t0.f;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DirectExecutor implements Executor {
    private static final /* synthetic */ w6.a $ENTRIES;
    private static final /* synthetic */ DirectExecutor[] $VALUES;
    public static final DirectExecutor INSTANCE = new DirectExecutor("INSTANCE", 0);

    private static final /* synthetic */ DirectExecutor[] $values() {
        return new DirectExecutor[]{INSTANCE};
    }

    static {
        DirectExecutor[] $values = $values();
        $VALUES = $values;
        $ENTRIES = f.u($values);
    }

    private DirectExecutor(String str, int i) {
    }

    public static w6.a getEntries() {
        return $ENTRIES;
    }

    public static DirectExecutor valueOf(String str) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, str);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.getClass();
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
