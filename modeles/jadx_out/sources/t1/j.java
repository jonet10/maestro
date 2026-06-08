package t1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final j f9533a;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f9534b;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ j[] f9535l;

    static {
        j jVar = new j("INSTANCE", 0);
        f9533a = jVar;
        f9535l = new j[]{jVar};
        f9534b = new Handler(Looper.getMainLooper());
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f9535l.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f9534b.post(runnable);
    }
}
