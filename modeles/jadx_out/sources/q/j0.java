package q;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f8593a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ j0[] f8594b;

    static {
        j0 j0Var = new j0("DEFAULT", 0);
        f8593a = j0Var;
        j0 j0Var2 = new j0("UNMETERED_ONLY", 1);
        j0 j0Var3 = new j0("UNMETERED_OR_DAILY", 2);
        j0 j0Var4 = new j0("FAST_IF_RADIO_AWAKE", 3);
        j0 j0Var5 = new j0("NEVER", 4);
        j0 j0Var6 = new j0("UNRECOGNIZED", 5);
        f8594b = new j0[]{j0Var, j0Var2, j0Var3, j0Var4, j0Var5, j0Var6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, j0Var);
        sparseArray.put(1, j0Var2);
        sparseArray.put(2, j0Var3);
        sparseArray.put(3, j0Var4);
        sparseArray.put(4, j0Var5);
        sparseArray.put(-1, j0Var6);
    }

    public static j0 valueOf(String str) {
        return (j0) Enum.valueOf(j0.class, str);
    }

    public static j0[] values() {
        return (j0[]) f8594b.clone();
    }
}
