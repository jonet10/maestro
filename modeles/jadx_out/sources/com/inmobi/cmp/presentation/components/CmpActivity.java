package com.inmobi.cmp.presentation.components;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.data.model.ThemeMode;
import d0.b;
import f9.c;
import f9.p;
import f9.q;
import java.util.UUID;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.x;
import l.g;
import l9.a;
import o7.c0;
import o7.m0;
import o7.z0;
import p9.d;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class CmpActivity extends AppCompatActivity {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3282b = 0;

    /* renamed from: a, reason: collision with root package name */
    public d f3283a;

    public final void h(f9.d dVar, boolean z9) {
        String str;
        c cVar;
        c cVar2;
        if (z9) {
            str = null;
        } else {
            d dVar2 = this.f3283a;
            if (dVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            str = b.d(dVar, dVar2.f8512a);
        }
        UUID uuid = q.f5065a;
        x xVar = new x();
        xVar.f7024a = dVar;
        x xVar2 = new x();
        c cVar3 = c.TCF_CHANGE_OF_CONSENT;
        xVar2.f7024a = cVar3;
        int ordinal = dVar.ordinal();
        if (ordinal == 0) {
            xVar2.f7024a = c.USP;
        } else if (ordinal == 1) {
            if (z9) {
                cVar3 = c.TCF_MANDATORY;
            }
            xVar2.f7024a = cVar3;
        } else if (ordinal == 2) {
            if (z9) {
                cVar = c.MSPA_MANDATORY;
            } else {
                a aVar = (a) m9.c.v.getValue();
                aVar.getClass();
                cVar = aVar.f7262a.getBoolean("MSPAShown", false) ? c.MSPA_CHANGE_OF_CONSENT : c.MSPA_OPT_OUT;
            }
            xVar2.f7024a = cVar;
        } else if (ordinal == 3) {
            if (g.f7044a) {
                a aVar2 = (a) m9.c.v.getValue();
                aVar2.getClass();
                cVar2 = aVar2.f7262a.getBoolean("GBCShown", false) ? c.GBC_CHANGE_OF_CONSENT : c.GBC;
            } else {
                cVar2 = c.NR;
            }
            xVar2.f7024a = cVar2;
        }
        q.f5066b.h("startOnPage", xVar.f7024a + "_1");
        q.f5065a = UUID.randomUUID();
        if (dVar == f9.d.GDPR) {
            ChoiceCmp.INSTANCE.setCurrentSessionId(q.f5065a);
        }
        e eVar = m0.f8288a;
        c0.s(z0.f8335a, v7.d.f10884a, null, new p(xVar, xVar2, str, z9, null), 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        ChoiceColor choiceColor;
        int i;
        ChoiceColor darkModeColors;
        super.onCreate(bundle);
        ThemeMode themeMode = m9.c.f7858b.getThemeMode();
        int i6 = themeMode == null ? -1 : p9.b.f8508a[themeMode.ordinal()];
        if (i6 == 1) {
            getDelegate().setLocalNightMode(1);
        } else if (i6 == 2) {
            getDelegate().setLocalNightMode(2);
        }
        a aVar = (a) m9.c.v.getValue();
        android.support.v4.media.g gVar = m9.c.f7862k;
        t6.c cVar = null;
        if (gVar == null) {
            l8.p pVar = m9.c.e().f7237l;
            if (pVar == null) {
                choiceColor = null;
            } else {
                String str = pVar.f7250a;
                choiceColor = pVar.f7252c;
                ChoiceColor choiceColor2 = pVar.f7251b;
                if (str.equals("LIGHT") || (!str.equals("DARK") && (choiceColor2 == null || choiceColor == null ? choiceColor2 != null : (i = getResources().getConfiguration().uiMode & 48) == 16 || i != 32))) {
                    choiceColor = choiceColor2;
                }
            }
            if (m9.c.f7858b.getThemeMode() == ThemeMode.LIGHT) {
                darkModeColors = m9.c.f7858b.getLightModeColors();
            } else if (m9.c.f7858b.getThemeMode() == ThemeMode.DARK) {
                darkModeColors = m9.c.f7858b.getDarkModeColors();
            } else if (m9.c.f7858b.getLightModeColors() == null || m9.c.f7858b.getDarkModeColors() == null) {
                if (m9.c.f7858b.getLightModeColors() == null) {
                    darkModeColors = m9.c.f7858b.getDarkModeColors();
                }
                darkModeColors = m9.c.f7858b.getLightModeColors();
            } else {
                int i10 = getResources().getConfiguration().uiMode & 48;
                if (i10 != 16) {
                    if (i10 == 32) {
                        darkModeColors = m9.c.f7858b.getDarkModeColors();
                    }
                    darkModeColors = m9.c.f7858b.getLightModeColors();
                } else {
                    darkModeColors = m9.c.f7858b.getLightModeColors();
                }
            }
            gVar = new android.support.v4.media.g(choiceColor, darkModeColors, new e1.c0(23));
            m9.c.f7862k = gVar;
        }
        this.f3283a = new d(aVar, gVar, m9.c.e());
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new p9.c(this, cVar, 0), 3);
    }
}
