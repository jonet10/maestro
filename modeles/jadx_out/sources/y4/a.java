package y4;

import a5.d;
import android.app.NotificationManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.t1;
import com.uptodown.core.activities.InstallerActivity;
import d0.b;
import f4.c;
import g4.n0;
import j5.g;
import kotlin.jvm.internal.x;
import o7.c0;
import r7.o0;
import x4.e;
import x4.l1;
import x4.q2;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {
    public static void a(Context context, String str, long j, long j6, String str2, Integer num, int i) {
        String str3;
        long j10;
        String str4;
        boolean z9;
        r L;
        String str5 = (i & 16) != 0 ? null : str2;
        Integer num2 = (i & 32) != 0 ? null : num;
        boolean z10 = false;
        boolean z11 = (i & 64) == 0;
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(255);
        x xVar = new x();
        if (z11) {
            xVar.f7024a = "Timeout";
        } else {
            if (num2 != null) {
                if (num2.intValue() == 3) {
                    str3 = "STATUS_FAILURE_ABORTED";
                } else if (num2.intValue() == 2) {
                    str3 = "STATUS_FAILURE_BLOCKED";
                } else if (num2.intValue() == 5) {
                    str3 = "STATUS_FAILURE_CONFLICT";
                } else if (num2.intValue() == 7) {
                    str3 = "STATUS_FAILURE_INCOMPATIBLE";
                } else if (num2.intValue() == 4) {
                    str3 = "STATUS_FAILURE_INVALID";
                } else if (num2.intValue() == 6) {
                    str3 = "STATUS_FAILURE_STORAGE";
                } else if (num2.intValue() == 1) {
                    str3 = "STATUS_FAILURE";
                }
                xVar.f7024a = str3;
            }
            str3 = null;
            xVar.f7024a = str3;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error", (String) xVar.f7024a);
        if (str5 != null) {
            bundle.putString("extraError", str5);
        }
        if (z11) {
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "timeout");
        } else {
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "failed");
        }
        if (str != null) {
            bundle.putString("packagename", str);
            e h = j5.a.h(context, str);
            g l10 = g.D.l(context);
            l10.b();
            q2 Y = l10.Y(str);
            j10 = 0;
            if (Y != null) {
                if (Y.f11348o == 0) {
                    Y.f11348o = 2;
                    l10.p0(Y);
                    r rVar = Y.f11352s;
                    if (rVar != null) {
                        rVar.t(context);
                    }
                }
                bundle.putInt("update", 1);
                str4 = h != null ? h.f11122b : null;
                z9 = true;
            } else {
                bundle.putInt("update", 0);
                str4 = null;
                z9 = false;
            }
            if (j > 0 && (L = l10.L(j, str)) != null) {
                long j11 = L.f11361q;
                if (j11 > 0) {
                    bundle.putString("appId", String.valueOf(j11));
                }
                z10 = L.A == 1;
            }
            l10.c();
            t1.i(context, str, bundle, z10);
            b.M(context, h, bundle);
            if (z9) {
                bundle.putString("updateOrigin", a5.e.a(str));
            }
            a5.e.f205a.remove(str);
        } else {
            j10 = 0;
            str4 = null;
        }
        if (j6 > j10) {
            String str6 = "<10MB";
            if (j6 >= 10485760) {
                if (j6 < 104857600) {
                    str6 = "<100MB";
                } else if (j6 < 524288000) {
                    str6 = "<500MB";
                } else if (j6 < 1073741824) {
                    str6 = "<1GB";
                } else if (j6 < 10737418240L) {
                    str6 = "<10GB";
                }
            }
            bundle.putString("size", str6);
        }
        String string = context.getString(2131951977);
        string.getClass();
        if (string.length() > 0) {
            bundle.putString("dpi", string);
        }
        new android.support.v4.media.g(context, 20).E(bundle, "install");
        o0 o0Var = d.f201a;
        d.a(new l1(str, str4, (String) xVar.f7024a));
        ComponentCallbacks2 componentCallbacks2 = c.f4875o;
        if (componentCallbacks2 instanceof InstallerActivity) {
            c0.s(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) componentCallbacks2), null, null, new n0(xVar, (InstallerActivity) componentCallbacks2, null), 3);
        }
    }
}
