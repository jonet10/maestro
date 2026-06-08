package e1;

import android.os.Bundle;
import j$.util.Objects;
import java.util.EnumMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {
    public static final o f = new o((Boolean) null, 100, (Boolean) null, (String) null);

    /* renamed from: a, reason: collision with root package name */
    public final int f4167a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4168b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f4169c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4170d;

    /* renamed from: e, reason: collision with root package name */
    public final EnumMap f4171e;

    public o(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(i2.class);
        this.f4171e = enumMap;
        enumMap.put((EnumMap) i2.AD_USER_DATA, (i2) (bool == null ? g2.UNINITIALIZED : bool.booleanValue() ? g2.GRANTED : g2.DENIED));
        this.f4167a = i;
        this.f4168b = d();
        this.f4169c = bool2;
        this.f4170d = str;
    }

    public static o b(String str) {
        if (str == null || str.length() <= 0) {
            return f;
        }
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(i2.class);
        i2[] i2VarArr = h2.DMA.f4020a;
        int length = i2VarArr.length;
        int i = 1;
        int i6 = 0;
        while (i6 < length) {
            enumMap.put((EnumMap) i2VarArr[i6], (i2) j2.e(split[i].charAt(0)));
            i6++;
            i++;
        }
        return new o(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public static o c(int i, Bundle bundle) {
        if (bundle == null) {
            return new o((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(i2.class);
        for (i2 i2Var : h2.DMA.f4020a) {
            enumMap.put((EnumMap) i2Var, (i2) j2.d(bundle.getString(i2Var.f4038a)));
        }
        return new o(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public final g2 a() {
        g2 g2Var = (g2) this.f4171e.get(i2.AD_USER_DATA);
        return g2Var == null ? g2.UNINITIALIZED : g2Var;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4167a);
        for (i2 i2Var : h2.DMA.f4020a) {
            sb.append(":");
            sb.append(j2.h((g2) this.f4171e.get(i2Var)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f4168b.equalsIgnoreCase(oVar.f4168b) && Objects.equals(this.f4169c, oVar.f4169c)) {
            return Objects.equals(this.f4170d, oVar.f4170d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f4169c;
        int i = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f4170d;
        return ((str == null ? 17 : str.hashCode()) * 137) + this.f4168b.hashCode() + (i * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(j2.a(this.f4167a));
        for (i2 i2Var : h2.DMA.f4020a) {
            sb.append(",");
            sb.append(i2Var.f4038a);
            sb.append("=");
            g2 g2Var = (g2) this.f4171e.get(i2Var);
            if (g2Var == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = g2Var.ordinal();
                if (ordinal == 0) {
                    sb.append("uninitialized");
                } else if (ordinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (ordinal == 2) {
                    sb.append("denied");
                } else if (ordinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f4169c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f4170d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public o(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(i2.class);
        this.f4171e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f4167a = i;
        this.f4168b = d();
        this.f4169c = bool;
        this.f4170d = str;
    }
}
