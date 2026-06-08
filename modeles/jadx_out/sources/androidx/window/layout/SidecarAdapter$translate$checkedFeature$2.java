package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import d7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SidecarAdapter$translate$checkedFeature$2 extends m implements l {
    public static final SidecarAdapter$translate$checkedFeature$2 INSTANCE = new SidecarAdapter$translate$checkedFeature$2();

    public SidecarAdapter$translate$checkedFeature$2() {
        super(1);
    }

    @Override // d7.l
    public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
        sidecarDisplayFeature.getClass();
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
