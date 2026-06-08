package x4;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class u0 {
    public final r a() {
        if (this instanceof t0) {
            return ((t0) this).f11395a;
        }
        if (this instanceof s0) {
            return ((s0) this).f11383a;
        }
        if (this instanceof r0) {
            return ((r0) this).f11370a;
        }
        if (this instanceof m0) {
            return ((m0) this).f11285a;
        }
        if (this instanceof q0) {
            return ((q0) this).f11339a;
        }
        return null;
    }

    public final String b() {
        if (this instanceof t0) {
            r rVar = ((t0) this).f11395a;
            if (rVar != null) {
                return rVar.f11355b;
            }
            return null;
        }
        if (this instanceof s0) {
            r rVar2 = ((s0) this).f11383a;
            if (rVar2 != null) {
                return rVar2.f11355b;
            }
            return null;
        }
        if (this instanceof r0) {
            r rVar3 = ((r0) this).f11370a;
            if (rVar3 != null) {
                return rVar3.f11355b;
            }
            return null;
        }
        if (this instanceof m0) {
            r rVar4 = ((m0) this).f11285a;
            if (rVar4 != null) {
                return rVar4.f11355b;
            }
            return null;
        }
        if (this instanceof q0) {
            r rVar5 = ((q0) this).f11339a;
            if (rVar5 != null) {
                return rVar5.f11355b;
            }
            return null;
        }
        if ((this instanceof p0) || equals(l0.f11273a) || equals(n0.f11293a) || equals(o0.f11305a)) {
            return null;
        }
        com.google.gson.internal.a.b();
        return null;
    }

    public final int c() {
        if (this instanceof r0) {
            return LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY;
        }
        if (equals(l0.f11273a)) {
            return 103;
        }
        if (equals(n0.f11293a)) {
            return LocationRequestCompat.QUALITY_LOW_POWER;
        }
        if (this instanceof p0) {
            return 105;
        }
        if (this instanceof m0) {
            return 106;
        }
        if (this instanceof t0) {
            return AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        }
        if (this instanceof s0) {
            return AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
        }
        if (equals(o0.f11305a)) {
            return 110;
        }
        if (this instanceof q0) {
            return 201;
        }
        com.google.gson.internal.a.b();
        return 0;
    }
}
