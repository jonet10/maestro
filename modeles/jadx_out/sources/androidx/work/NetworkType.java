package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import t0.f;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkType {
    private static final /* synthetic */ w6.a $ENTRIES;
    private static final /* synthetic */ NetworkType[] $VALUES;
    public static final NetworkType NOT_REQUIRED = new NetworkType("NOT_REQUIRED", 0);
    public static final NetworkType CONNECTED = new NetworkType("CONNECTED", 1);
    public static final NetworkType UNMETERED = new NetworkType("UNMETERED", 2);
    public static final NetworkType NOT_ROAMING = new NetworkType("NOT_ROAMING", 3);
    public static final NetworkType METERED = new NetworkType("METERED", 4);

    @RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
    public static final NetworkType TEMPORARILY_UNMETERED = new NetworkType("TEMPORARILY_UNMETERED", 5);

    private static final /* synthetic */ NetworkType[] $values() {
        return new NetworkType[]{NOT_REQUIRED, CONNECTED, UNMETERED, NOT_ROAMING, METERED, TEMPORARILY_UNMETERED};
    }

    static {
        NetworkType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = f.u($values);
    }

    private NetworkType(String str, int i) {
    }

    public static w6.a getEntries() {
        return $ENTRIES;
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }
}
