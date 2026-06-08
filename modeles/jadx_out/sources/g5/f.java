package g5;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import b2.t1;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.Regulations;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import j$.util.Objects;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements a4.i, g8.h, j1.f, t.b, ViewBinding, w1.a, j1.h, j1.d, SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5308a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5309b;

    public f(int i) {
        this.f5308a = i;
        switch (i) {
            case 5:
                break;
            case 9:
                this.f5309b = new ArrayList(20);
                break;
            case 12:
                this.f5309b = new LinkedHashSet();
                break;
            default:
                this.f5309b = new j1.p();
                break;
        }
    }

    public static l8.k A(JSONObject jSONObject) {
        l8.k kVar = jSONObject == null ? null : new l8.k(jSONObject.optString("mspaJurisdiction"), jSONObject.optBoolean("isCoveredTransaction", false), jSONObject.optString("mspaSignalMode"), jSONObject.optBoolean("mspaAutoPopUp", false), d0.b.e(jSONObject, "mspaOptOutPurposeIds"), d0.b.e(jSONObject, "mspaSensitiveDataPurposeIds"));
        return kVar == null ? new l8.k() : kVar;
    }

    public static l8.p B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("themeMode");
        optString.getClass();
        ChoiceColor g = g(jSONObject.optJSONObject("lightModeColors"));
        ChoiceColor g3 = g(jSONObject.optJSONObject("darkModeColors"));
        JSONObject optJSONObject = jSONObject.optJSONObject("fonts");
        return new l8.p(optString, g, g3, optJSONObject != null ? new l8.e(u(optJSONObject.optJSONObject("title")), u(optJSONObject.optJSONObject("subtitle")), u(optJSONObject.optJSONObject("body")), u(optJSONObject.optJSONObject("button"))) : null);
    }

    public static l8.r N(JSONObject jSONObject) {
        l8.r rVar;
        if (jSONObject == null) {
            rVar = null;
        } else {
            String optString = jSONObject.optString("uspDnsTitle", "");
            ArrayList q9 = d0.b.q(jSONObject, "uspDnsText");
            boolean optBoolean = jSONObject.optBoolean("suppressCcpaLinks", false);
            String optString2 = jSONObject.optString("uspDeleteDataLinkText", "");
            String optString3 = jSONObject.optString("uspAccessDataLinkText", "");
            String optString4 = jSONObject.optString("uspPrivacyPolicyLinkText", "");
            String optString5 = jSONObject.optString("uspDeleteDataLink");
            String optString6 = jSONObject.optString("uspAccessDataLink");
            String optString7 = jSONObject.optString("uspPrivacyPolicyLink");
            optString4.getClass();
            optString2.getClass();
            optString3.getClass();
            optString.getClass();
            optString5.getClass();
            optString6.getClass();
            optString7.getClass();
            rVar = new l8.r(optBoolean, optString4, optString2, optString3, optString, q9, optString5, optString6, optString7, 1);
        }
        return rVar == null ? new l8.r(false, null, null, null, null, null, null, null, null, 1023) : rVar;
    }

    public static boolean O(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String R(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public static ChoiceColor g(JSONObject jSONObject) {
        Object jVar;
        Integer num;
        Object jVar2;
        Integer num2;
        Object jVar3;
        Integer num3;
        Object jVar4;
        Integer num4;
        Object jVar5;
        Integer num5;
        Object jVar6;
        Integer num6;
        Object jVar7;
        Integer num7;
        Object jVar8;
        Integer num8;
        Object jVar9;
        Integer num9;
        Object jVar10;
        Integer num10;
        Object jVar11;
        Integer num11;
        Object jVar12;
        Integer num12;
        Object jVar13;
        Integer num13;
        Object jVar14;
        Integer num14;
        Object jVar15;
        Integer num15;
        Object jVar16;
        Integer num16;
        if (jSONObject == null) {
            return null;
        }
        try {
            ChoiceColor choiceColor = new ChoiceColor();
            String optString = jSONObject.optString("dividerColor");
            optString.getClass();
            if (l7.m.z0(optString)) {
                optString = null;
            }
            if (optString == null) {
                num = null;
            } else {
                try {
                    jVar = Integer.valueOf(Color.parseColor(optString));
                } catch (Throwable th) {
                    jVar = new p6.j(th);
                }
                if (jVar instanceof p6.j) {
                    jVar = null;
                }
                num = (Integer) jVar;
            }
            choiceColor.setDividerColor(num);
            String optString2 = jSONObject.optString("tabBackgroundColor");
            optString2.getClass();
            if (l7.m.z0(optString2)) {
                optString2 = null;
            }
            if (optString2 == null) {
                num2 = null;
            } else {
                try {
                    jVar2 = Integer.valueOf(Color.parseColor(optString2));
                } catch (Throwable th2) {
                    jVar2 = new p6.j(th2);
                }
                if (jVar2 instanceof p6.j) {
                    jVar2 = null;
                }
                num2 = (Integer) jVar2;
            }
            choiceColor.setTabBackgroundColor(num2);
            String optString3 = jSONObject.optString("searchBarBackgroundColor");
            optString3.getClass();
            if (l7.m.z0(optString3)) {
                optString3 = null;
            }
            if (optString3 == null) {
                num3 = null;
            } else {
                try {
                    jVar3 = Integer.valueOf(Color.parseColor(optString3));
                } catch (Throwable th3) {
                    jVar3 = new p6.j(th3);
                }
                if (jVar3 instanceof p6.j) {
                    jVar3 = null;
                }
                num3 = (Integer) jVar3;
            }
            choiceColor.setSearchBarBackgroundColor(num3);
            String optString4 = jSONObject.optString("searchBarForegroundColor");
            optString4.getClass();
            if (l7.m.z0(optString4)) {
                optString4 = null;
            }
            if (optString4 == null) {
                num4 = null;
            } else {
                try {
                    jVar4 = Integer.valueOf(Color.parseColor(optString4));
                } catch (Throwable th4) {
                    jVar4 = new p6.j(th4);
                }
                if (jVar4 instanceof p6.j) {
                    jVar4 = null;
                }
                num4 = (Integer) jVar4;
            }
            choiceColor.setSearchBarForegroundColor(num4);
            String optString5 = jSONObject.optString("toggleActiveColor");
            optString5.getClass();
            if (l7.m.z0(optString5)) {
                optString5 = null;
            }
            if (optString5 == null) {
                num5 = null;
            } else {
                try {
                    jVar5 = Integer.valueOf(Color.parseColor(optString5));
                } catch (Throwable th5) {
                    jVar5 = new p6.j(th5);
                }
                if (jVar5 instanceof p6.j) {
                    jVar5 = null;
                }
                num5 = (Integer) jVar5;
            }
            choiceColor.setToggleActiveColor(num5);
            String optString6 = jSONObject.optString("toggleActiveColor");
            optString6.getClass();
            if (l7.m.z0(optString6)) {
                optString6 = null;
            }
            if (optString6 == null) {
                num6 = null;
            } else {
                try {
                    jVar6 = Integer.valueOf(Color.parseColor(optString6));
                } catch (Throwable th6) {
                    jVar6 = new p6.j(th6);
                }
                if (jVar6 instanceof p6.j) {
                    jVar6 = null;
                }
                num6 = (Integer) jVar6;
            }
            choiceColor.setToggleInactiveColor(num6);
            String optString7 = jSONObject.optString("globalBackgroundColor");
            optString7.getClass();
            if (l7.m.z0(optString7)) {
                optString7 = null;
            }
            if (optString7 == null) {
                num7 = null;
            } else {
                try {
                    jVar7 = Integer.valueOf(Color.parseColor(optString7));
                } catch (Throwable th7) {
                    jVar7 = new p6.j(th7);
                }
                if (jVar7 instanceof p6.j) {
                    jVar7 = null;
                }
                num7 = (Integer) jVar7;
            }
            choiceColor.setGlobalBackgroundColor(num7);
            String optString8 = jSONObject.optString("titleTextColor");
            optString8.getClass();
            if (l7.m.z0(optString8)) {
                optString8 = null;
            }
            if (optString8 == null) {
                num8 = null;
            } else {
                try {
                    jVar8 = Integer.valueOf(Color.parseColor(optString8));
                } catch (Throwable th8) {
                    jVar8 = new p6.j(th8);
                }
                if (jVar8 instanceof p6.j) {
                    jVar8 = null;
                }
                num8 = (Integer) jVar8;
            }
            choiceColor.setTitleTextColor(num8);
            String optString9 = jSONObject.optString("bodyTextColor");
            optString9.getClass();
            if (l7.m.z0(optString9)) {
                optString9 = null;
            }
            if (optString9 == null) {
                num9 = null;
            } else {
                try {
                    jVar9 = Integer.valueOf(Color.parseColor(optString9));
                } catch (Throwable th9) {
                    jVar9 = new p6.j(th9);
                }
                if (jVar9 instanceof p6.j) {
                    jVar9 = null;
                }
                num9 = (Integer) jVar9;
            }
            choiceColor.setBodyTextColor(num9);
            String optString10 = jSONObject.optString("tabTextColor");
            optString10.getClass();
            if (l7.m.z0(optString10)) {
                optString10 = null;
            }
            if (optString10 == null) {
                num10 = null;
            } else {
                try {
                    jVar10 = Integer.valueOf(Color.parseColor(optString10));
                } catch (Throwable th10) {
                    jVar10 = new p6.j(th10);
                }
                if (jVar10 instanceof p6.j) {
                    jVar10 = null;
                }
                num10 = (Integer) jVar10;
            }
            choiceColor.setTabTextColor(num10);
            String optString11 = jSONObject.optString("menuTextColor");
            optString11.getClass();
            if (l7.m.z0(optString11)) {
                optString11 = null;
            }
            if (optString11 == null) {
                num11 = null;
            } else {
                try {
                    jVar11 = Integer.valueOf(Color.parseColor(optString11));
                } catch (Throwable th11) {
                    jVar11 = new p6.j(th11);
                }
                if (jVar11 instanceof p6.j) {
                    jVar11 = null;
                }
                num11 = (Integer) jVar11;
            }
            choiceColor.setMenuTextColor(num11);
            String optString12 = jSONObject.optString("linkTextColor");
            optString12.getClass();
            if (l7.m.z0(optString12)) {
                optString12 = null;
            }
            if (optString12 == null) {
                num12 = null;
            } else {
                try {
                    jVar12 = Integer.valueOf(Color.parseColor(optString12));
                } catch (Throwable th12) {
                    jVar12 = new p6.j(th12);
                }
                if (jVar12 instanceof p6.j) {
                    jVar12 = null;
                }
                num12 = (Integer) jVar12;
            }
            choiceColor.setLinkTextColor(num12);
            String optString13 = jSONObject.optString("buttonTextColor");
            optString13.getClass();
            if (l7.m.z0(optString13)) {
                optString13 = null;
            }
            if (optString13 == null) {
                num13 = null;
            } else {
                try {
                    jVar13 = Integer.valueOf(Color.parseColor(optString13));
                } catch (Throwable th13) {
                    jVar13 = new p6.j(th13);
                }
                if (jVar13 instanceof p6.j) {
                    jVar13 = null;
                }
                num13 = (Integer) jVar13;
            }
            choiceColor.setButtonTextColor(num13);
            String optString14 = jSONObject.optString("buttonDisabledTextColor");
            optString14.getClass();
            if (l7.m.z0(optString14)) {
                optString14 = null;
            }
            if (optString14 == null) {
                num14 = null;
            } else {
                try {
                    jVar14 = Integer.valueOf(Color.parseColor(optString14));
                } catch (Throwable th14) {
                    jVar14 = new p6.j(th14);
                }
                if (jVar14 instanceof p6.j) {
                    jVar14 = null;
                }
                num14 = (Integer) jVar14;
            }
            choiceColor.setButtonDisabledTextColor(num14);
            String optString15 = jSONObject.optString("buttonBackgroundColor");
            optString15.getClass();
            if (l7.m.z0(optString15)) {
                optString15 = null;
            }
            if (optString15 == null) {
                num15 = null;
            } else {
                try {
                    jVar15 = Integer.valueOf(Color.parseColor(optString15));
                } catch (Throwable th15) {
                    jVar15 = new p6.j(th15);
                }
                if (jVar15 instanceof p6.j) {
                    jVar15 = null;
                }
                num15 = (Integer) jVar15;
            }
            choiceColor.setButtonBackgroundColor(num15);
            String optString16 = jSONObject.optString("buttonDisabledBackgroundColor");
            optString16.getClass();
            if (l7.m.z0(optString16)) {
                optString16 = null;
            }
            if (optString16 == null) {
                num16 = null;
            } else {
                try {
                    jVar16 = Integer.valueOf(Color.parseColor(optString16));
                } catch (Throwable th16) {
                    jVar16 = new p6.j(th16);
                }
                if (jVar16 instanceof p6.j) {
                    jVar16 = null;
                }
                num16 = (Integer) jVar16;
            }
            choiceColor.setButtonDisabledBackgroundColor(num16);
            return choiceColor;
        } catch (Exception e10) {
            a.a.h("Choice", kotlin.jvm.internal.l.g(e10.getMessage(), "Error parsing ChoiceColor: "), null, 4);
            return null;
        }
    }

    public static LinkedHashMap m(JSONObject jSONObject, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        keys.getClass();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                next.getClass();
                int optInt = optJSONObject.optInt("id");
                String optString = optJSONObject.optString("name");
                optString.getClass();
                String optString2 = optJSONObject.optString("description");
                optString2.getClass();
                linkedHashMap.put(next, new h8.b(optString, optString2, p(optJSONObject, i), optInt));
            }
        }
        return linkedHashMap;
    }

    public static String p(JSONObject jSONObject, int i) {
        String sb;
        if (i <= 2) {
            String optString = jSONObject.optString("descriptionLegal");
            optString.getClass();
            return optString;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("illustrations");
        if (optJSONArray == null) {
            sb = null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            int length = optJSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                sb2.append(String.format("* %s", Arrays.copyOf(new Object[]{optJSONArray.getString(i6)}, 1)));
                sb2.append('\n');
            }
            sb = sb2.toString();
        }
        return sb == null ? "" : sb;
    }

    public static l8.d r(JSONObject jSONObject) {
        if (jSONObject != null) {
            return new l8.d(Boolean.valueOf(jSONObject.optBoolean("visitEvents", false)), Boolean.valueOf(jSONObject.optBoolean("advancedCustomizations", false)), Boolean.valueOf(jSONObject.optBoolean("consentOrPay", false)), Boolean.valueOf(jSONObject.optBoolean("themeCustomizations", false)));
        }
        Boolean bool = Boolean.FALSE;
        return new l8.d(bool, bool, bool, bool);
    }

    public static LinkedHashMap t(JSONObject jSONObject, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        keys.getClass();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                next.getClass();
                int optInt = optJSONObject.optInt("id");
                String optString = optJSONObject.optString("name");
                optString.getClass();
                String optString2 = optJSONObject.optString("description");
                optString2.getClass();
                linkedHashMap.put(next, new h8.f(optString, optString2, p(optJSONObject, i), optInt));
            }
        }
        return linkedHashMap;
    }

    public static l8.f u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new l8.f(Integer.valueOf(jSONObject.optInt("fontSize")), jSONObject.optString("fontUrl", ""), jSONObject.optString("fontName", ""));
    }

    public static void v(String str, String str2) {
        if (str == null) {
            com.google.gson.internal.a.i("name == null");
            return;
        }
        if (str.isEmpty()) {
            com.google.gson.internal.a.p("name is empty");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                Object[] objArr = {Integer.valueOf(charAt), Integer.valueOf(i), str};
                byte[] bArr = n8.c.f8114a;
                com.google.gson.internal.a.p(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", objArr));
                return;
            }
        }
        if (str2 == null) {
            com.google.gson.internal.a.i(androidx.lifecycle.l.w("value for name ", str, " == null"));
            return;
        }
        int length2 = str2.length();
        for (int i6 = 0; i6 < length2; i6++) {
            char charAt2 = str2.charAt(i6);
            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                Object[] objArr2 = {Integer.valueOf(charAt2), Integer.valueOf(i6), str, str2};
                byte[] bArr2 = n8.c.f8114a;
                com.google.gson.internal.a.p(String.format(Locale.US, "Unexpected char %#04x at %d in %s value: %s", objArr2));
                return;
            }
        }
    }

    public static l8.h x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new l8.h();
        }
        int i = 0;
        boolean optBoolean = jSONObject.optBoolean("applicable", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("applicablePurposes");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            while (i < length) {
                int i6 = i + 1;
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("id");
                String optString = jSONObject2.optString("defaultValue");
                optString.getClass();
                arrayList.add(new l8.g(optInt, GBCConsentValue.valueOf(optString)));
                i = i6;
            }
        }
        return new l8.h(arrayList, optBoolean);
    }

    public static l8.i y(JSONObject jSONObject) {
        boolean z9;
        String str;
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        int i6;
        l8.j jVar;
        l8.j jVar2;
        l8.m mVar;
        boolean z10;
        boolean optBoolean;
        l8.m mVar2;
        boolean optBoolean2;
        l8.c cVar;
        if (jSONObject == null) {
            return new l8.i();
        }
        String optString = jSONObject.optString("gdprEncodingMode");
        boolean optBoolean3 = jSONObject.optBoolean("googleEnabled");
        String optString2 = jSONObject.optString("publisherLogo");
        optString2.getClass();
        int optInt = jSONObject.optInt("gvlVersion", 2);
        ArrayList e10 = d0.b.e(jSONObject, "stacks");
        int optInt2 = jSONObject.optInt("vendorListUpdateFreq");
        ArrayList e11 = d0.b.e(jSONObject, "vendorPurposeIds");
        ArrayList e12 = d0.b.e(jSONObject, "vendorFeaturesIds");
        ArrayList e13 = d0.b.e(jSONObject, "vendorPurposeLegitimateInterestIds");
        ArrayList e14 = d0.b.e(jSONObject, "vendorSpecialFeaturesIds");
        ArrayList e15 = d0.b.e(jSONObject, "vendorSpecialPurposesIds");
        ArrayList e16 = d0.b.e(jSONObject, "publisherPurposeIds");
        ArrayList e17 = d0.b.e(jSONObject, "publisherPurposeLegitimateInterestIds");
        ArrayList e18 = d0.b.e(jSONObject, "publisherSpecialPurposesIds");
        ArrayList e19 = d0.b.e(jSONObject, "publisherFeaturesIds");
        ArrayList e20 = d0.b.e(jSONObject, "publisherSpecialFeaturesIds");
        ArrayList e21 = d0.b.e(jSONObject, "publisherConsentRestrictionIds");
        ArrayList e22 = d0.b.e(jSONObject, "publisherLIRestrictionIds");
        JSONObject optJSONObject = jSONObject.optJSONObject("gdprUiLabels");
        if (optJSONObject == null) {
            z9 = optBoolean3;
            str = optString2;
            i = optInt;
            arrayList2 = e10;
            i6 = optInt2;
            jVar = null;
        } else {
            boolean optBoolean4 = optJSONObject.optBoolean("initScreenRejectButtonShowing");
            z9 = optBoolean3;
            String optString3 = optJSONObject.optString("initScreenRejectButton");
            optString3.getClass();
            str = optString2;
            JSONArray optJSONArray = optJSONObject.optJSONArray("initScreenCustomLinks");
            if (optJSONArray == null) {
                i = optInt;
                arrayList2 = e10;
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                i = optInt;
                int length = optJSONArray.length();
                arrayList2 = e10;
                int i10 = 0;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                    int i12 = length;
                    String optString4 = optJSONObject2.optString("label");
                    optString4.getClass();
                    String optString5 = optJSONObject2.optString("link");
                    optString5.getClass();
                    arrayList.add(new h9.q(optString4, optString5));
                    i10 = i11;
                    optJSONArray = optJSONArray;
                    length = i12;
                    optInt2 = optInt2;
                }
            }
            i6 = optInt2;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            jVar = new l8.j(optString3, arrayList, optBoolean4);
        }
        if (jVar == null) {
            jVar = new l8.j();
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("nonIabVendorsInfo");
        if (optJSONObject3 == null) {
            mVar = new l8.m();
            jVar2 = jVar;
        } else {
            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("nonIabVendorList");
            ArrayList arrayList3 = new ArrayList();
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                int i13 = 0;
                while (i13 < length2) {
                    int i14 = i13 + 1;
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i13);
                    int optInt3 = jSONObject2.optInt("vendorId");
                    String optString6 = jSONObject2.optString("pCode");
                    optString6.getClass();
                    String optString7 = jSONObject2.optString("name");
                    optString7.getClass();
                    String optString8 = jSONObject2.optString("description", "");
                    optString8.getClass();
                    String optString9 = jSONObject2.optString("privacyPolicyUrl", "");
                    optString9.getClass();
                    ArrayList e23 = d0.b.e(jSONObject2, "nonIabPurposeConsentIds");
                    ArrayList e24 = d0.b.e(jSONObject2, "nonIabPurposeLegitimateInterestIds");
                    String optString10 = jSONObject2.optString("legitimateInterestClaimUrl", "");
                    optString10.getClass();
                    arrayList3.add(new l8.l(optInt3, optString6, optString7, optString8, optString9, e23, e24, optString10));
                    i13 = i14;
                    jVar = jVar;
                    optJSONArray2 = optJSONArray2;
                }
            }
            jVar2 = jVar;
            String optString11 = optJSONObject3.optString("updateAt");
            optString11.getClass();
            String optString12 = optJSONObject3.optString("nonIabVendorsHash");
            optString12.getClass();
            mVar = new l8.m(optString11, optString12, arrayList3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("premiumProperties");
        l8.o oVar = optJSONObject4 != null ? new l8.o(d0.b.e(optJSONObject4, "vendorBlacklist"), d0.b.e(optJSONObject4, "vendorWhitelist"), d0.b.e(optJSONObject4, "googleWhitelist")) : null;
        if (oVar == null) {
            oVar = new l8.o();
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("consentOrPay");
        if (optJSONObject5 == null) {
            cVar = new l8.c();
            mVar2 = mVar;
        } else {
            JSONObject optJSONObject6 = optJSONObject5.optJSONObject("actionButtonSettings");
            ArrayList q9 = d0.b.q(optJSONObject5, "countries");
            if (optJSONObject6 == null) {
                optBoolean = false;
                z10 = false;
            } else {
                z10 = false;
                optBoolean = optJSONObject6.optBoolean("action1Enabled", false);
            }
            if (optJSONObject6 == null) {
                mVar2 = mVar;
                optBoolean2 = z10;
            } else {
                mVar2 = mVar;
                optBoolean2 = optJSONObject6.optBoolean("action2Enabled", z10);
            }
            cVar = new l8.c(q9, new l8.a(optBoolean, optBoolean2));
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("translationUrls");
        jSONObject3.getClass();
        return new l8.i(optString, z9, str, i, arrayList2, i6, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, jVar2, mVar2, oVar, cVar, new l8.q(jSONObject3.optString("common"), jSONObject3.optString("theme"), jSONObject3.optString("all")));
    }

    public String C(String str) {
        ArrayList arrayList = (ArrayList) this.f5309b;
        for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase((String) arrayList.get(size))) {
                return (String) arrayList.get(size + 1);
            }
        }
        return null;
    }

    public boolean D(String str) {
        String L = L(str);
        return "1".equals(L) || Boolean.parseBoolean(L);
    }

    public Integer E(String str) {
        String L = L(str);
        if (TextUtils.isEmpty(L)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(L));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + R(str) + "(" + L + ") into an int");
            return null;
        }
    }

    public JSONArray F(String str) {
        String L = L(str);
        if (TextUtils.isEmpty(L)) {
            return null;
        }
        try {
            return new JSONArray(L);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + R(str) + ": " + L + ", falling back to default");
            return null;
        }
    }

    public int[] G() {
        JSONArray F = F("gcm.n.light_settings");
        if (F == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (F.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            int parseColor = Color.parseColor(F.optString(0));
            if (parseColor == -16777216) {
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            iArr[0] = parseColor;
            iArr[1] = F.optInt(1);
            iArr[2] = F.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e10) {
            Log.w("NotificationParams", "LightSettings is invalid: " + F + ". " + e10.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + F + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Object[] H(String str) {
        JSONArray F = F(str.concat("_loc_args"));
        if (F == null) {
            return null;
        }
        int length = F.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = F.optString(i);
        }
        return strArr;
    }

    public String I(String str) {
        return L(str.concat("_loc_key"));
    }

    public Long J() {
        String L = L("gcm.n.event_time");
        if (TextUtils.isEmpty(L)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(L));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + R("gcm.n.event_time") + "(" + L + ") into a long");
            return null;
        }
    }

    public String K(Resources resources, String str, String str2) {
        String L = L(str2);
        if (!TextUtils.isEmpty(L)) {
            return L;
        }
        String I = I(str2);
        if (TextUtils.isEmpty(I)) {
            return null;
        }
        int identifier = resources.getIdentifier(I, TypedValues.Custom.S_STRING, str);
        if (identifier == 0) {
            Log.w("NotificationParams", R(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] H = H(str2);
        if (H == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, H);
        } catch (MissingFormatArgumentException e10) {
            Log.w("NotificationParams", "Missing format argument for " + R(str2) + ": " + Arrays.toString(H) + " Default value will be used.", e10);
            return null;
        }
    }

    public String L(String str) {
        Bundle bundle = (Bundle) this.f5309b;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String replace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(replace)) {
                str = replace;
            }
        }
        return bundle.getString(str);
    }

    public long[] M() {
        JSONArray F = F("gcm.n.vibrate_timings");
        if (F == null) {
            return null;
        }
        try {
            if (F.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = F.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = F.optLong(i);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + F + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    public Bundle P() {
        Bundle bundle = (Bundle) this.f5309b;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals(TypedValues.TransitionType.S_FROM)) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    public void Q(String str) {
        ArrayList arrayList = (ArrayList) this.f5309b;
        int i = 0;
        while (i < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }

    @Override // g8.h
    public void a(j7.c cVar, j7.c cVar2, z7.b bVar) {
        ((g8.g) this.f5309b).j(cVar, cVar2, bVar, true);
    }

    @Override // g8.h
    public void b(j7.c cVar, d7.l lVar) {
        cVar.getClass();
        ((g8.g) this.f5309b).k(cVar, new g8.b(lVar), true);
    }

    @Override // j1.f
    public void c(Object obj) {
        ((j1.i) ((g) this.f5309b).f5315b).f6539a.n();
    }

    @Override // g8.h
    public void d(j7.c cVar, z7.b bVar) {
        bVar.getClass();
        ((g8.g) this.f5309b).k(cVar, new g8.a(bVar), true);
    }

    @Override // g8.h
    public void e(j7.c cVar, d7.l lVar) {
        ((g8.g) this.f5309b).h(cVar, lVar, true);
    }

    @Override // g8.h
    public void f(j7.c cVar, d7.l lVar) {
        ((g8.g) this.f5309b).i(cVar, lVar, true);
    }

    @Override // m6.a
    public Object get() {
        return this.f5309b;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return (RelativeLayout) this.f5309b;
    }

    @Override // a4.i
    public void h(Exception exc) {
        int i = this.f5308a;
        exc.getClass();
    }

    @Override // w1.a
    public void i(Bundle bundle) {
        ((p1.b) ((p1.a) this.f5309b)).a("clx", "_ae", bundle);
    }

    public h8.c j(JSONObject jSONObject) {
        JSONObject jSONObject2;
        int i;
        String str;
        LinkedHashMap linkedHashMap;
        String str2;
        LinkedHashMap linkedHashMap2;
        String str3;
        g2.c cVar;
        h8.c cVar2 = new h8.c();
        cVar2.f5459a = jSONObject.optInt("gvlSpecificationVersion");
        cVar2.f5460b = Integer.valueOf(jSONObject.optInt("vendorListVersion"));
        cVar2.f5461c = Integer.valueOf(jSONObject.optInt("tcfPolicyVersion"));
        String optString = jSONObject.optString("lastUpdated");
        optString.getClass();
        Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", (Locale) this.f5309b).parse(optString);
        if (parse != null) {
            parse.getTime();
        }
        String str4 = "purposes";
        JSONObject jSONObject3 = jSONObject.getJSONObject("purposes");
        jSONObject3.getClass();
        cVar2.f5462d = t(jSONObject3, cVar2.f5459a);
        String str5 = "specialPurposes";
        JSONObject jSONObject4 = jSONObject.getJSONObject("specialPurposes");
        jSONObject4.getClass();
        cVar2.f5463e = t(jSONObject4, cVar2.f5459a);
        String str6 = "features";
        JSONObject jSONObject5 = jSONObject.getJSONObject("features");
        jSONObject5.getClass();
        cVar2.f = m(jSONObject5, cVar2.f5459a);
        JSONObject jSONObject6 = jSONObject.getJSONObject("specialFeatures");
        jSONObject6.getClass();
        cVar2.g = m(jSONObject6, cVar2.f5459a);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        JSONObject jSONObject7 = jSONObject.getJSONObject("stacks");
        Iterator<String> keys = jSONObject7.keys();
        keys.getClass();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject8 = jSONObject7.getJSONObject(next);
            next.getClass();
            int optInt = jSONObject8.optInt("id");
            String optString2 = jSONObject8.optString("name");
            optString2.getClass();
            String optString3 = jSONObject8.optString("description");
            optString3.getClass();
            linkedHashMap3.put(next, new h8.g(optInt, optString2, optString3, new ArrayList(d0.b.e(jSONObject8, "purposes")), new ArrayList(d0.b.e(jSONObject8, "specialFeatures"))));
        }
        cVar2.i = linkedHashMap3;
        JSONObject optJSONObject = jSONObject.optJSONObject("dataCategories");
        if (optJSONObject != null) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            Iterator<String> keys2 = optJSONObject.keys();
            keys2.getClass();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject jSONObject9 = optJSONObject.getJSONObject(next2);
                next2.getClass();
                int optInt2 = jSONObject9.optInt("id");
                JSONObject jSONObject10 = optJSONObject;
                String optString4 = jSONObject9.optString("name");
                optString4.getClass();
                jSONObject9.optString("description").getClass();
                linkedHashMap4.put(next2, new h8.a(optInt2, optString4));
                optJSONObject = jSONObject10;
            }
            cVar2.j = linkedHashMap4;
        }
        int i6 = cVar2.f5459a;
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("vendors");
        if (optJSONObject2 != null) {
            Iterator<String> keys3 = optJSONObject2.keys();
            keys3.getClass();
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next3);
                if (optJSONObject3 != null) {
                    next3.getClass();
                    int optInt3 = optJSONObject3.optInt("id");
                    String optString5 = optJSONObject3.optString("name");
                    Set I0 = q6.l.I0(d0.b.e(optJSONObject3, str4));
                    Set I02 = q6.l.I0(d0.b.e(optJSONObject3, "legIntPurposes"));
                    Set I03 = q6.l.I0(d0.b.e(optJSONObject3, "flexiblePurposes"));
                    Set I04 = q6.l.I0(d0.b.e(optJSONObject3, str5));
                    Set I05 = q6.l.I0(d0.b.e(optJSONObject3, str6));
                    Set I06 = q6.l.I0(d0.b.e(optJSONObject3, "specialFeatures"));
                    String optString6 = optJSONObject3.optString("policyUrl", "");
                    String optString7 = optJSONObject3.optString("deletedDate", "");
                    optString7.getClass();
                    LinkedHashSet linkedHashSet = null;
                    String str7 = optString7.length() == 0 ? null : optString7;
                    if (i6 > 2) {
                        optJSONObject3.optInt("overflow");
                    } else {
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("overflow");
                        if (optJSONObject4 != null) {
                            optJSONObject4.optInt("httpGetLimit");
                        }
                    }
                    int optInt4 = optJSONObject3.optInt("cookieMaxAgeSeconds");
                    optJSONObject3.optBoolean("useCookies", false);
                    optJSONObject3.optBoolean("cookieRefresh", false);
                    boolean optBoolean = optJSONObject3.optBoolean("usesNonCookieAccess", false);
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("dataRetention");
                    if (optJSONObject5 == null) {
                        jSONObject2 = optJSONObject2;
                        str = str4;
                        i = i6;
                        str3 = str5;
                        str2 = str6;
                        cVar = null;
                    } else {
                        jSONObject2 = optJSONObject2;
                        int optInt5 = optJSONObject5.optInt("stdRetention");
                        i = i6;
                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject(str4);
                        if (optJSONObject6 == null) {
                            str = str4;
                            linkedHashMap = null;
                        } else {
                            str = str4;
                            linkedHashMap = new LinkedHashMap();
                            Iterator<String> keys4 = optJSONObject6.keys();
                            keys4.getClass();
                            while (keys4.hasNext()) {
                                String str8 = str6;
                                String next4 = keys4.next();
                                next4.getClass();
                                linkedHashMap.put(next4, Integer.valueOf(optJSONObject6.optInt(next4)));
                                optJSONObject6 = optJSONObject6;
                                str6 = str8;
                            }
                        }
                        str2 = str6;
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        JSONObject optJSONObject7 = optJSONObject5.optJSONObject(str5);
                        if (optJSONObject7 == null) {
                            linkedHashMap2 = null;
                        } else {
                            linkedHashMap2 = new LinkedHashMap();
                            Iterator<String> keys5 = optJSONObject7.keys();
                            keys5.getClass();
                            while (keys5.hasNext()) {
                                String str9 = str5;
                                String next5 = keys5.next();
                                next5.getClass();
                                linkedHashMap2.put(next5, Integer.valueOf(optJSONObject7.optInt(next5)));
                                optJSONObject7 = optJSONObject7;
                                str5 = str9;
                            }
                        }
                        str3 = str5;
                        if (linkedHashMap2 == null) {
                            linkedHashMap2 = new LinkedHashMap();
                        }
                        cVar = new g2.c(optInt5, linkedHashMap, linkedHashMap2);
                    }
                    JSONArray optJSONArray = optJSONObject3.optJSONArray("urls");
                    if (optJSONArray != null) {
                        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                        int length = optJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            JSONObject jSONObject11 = optJSONArray.getJSONObject(i10);
                            JSONArray jSONArray = optJSONArray;
                            String optString8 = jSONObject11.optString("langId");
                            optString8.getClass();
                            int i11 = length;
                            String optString9 = jSONObject11.optString("privacy");
                            optString9.getClass();
                            String optString10 = jSONObject11.optString("legIntClaim");
                            optString10.getClass();
                            linkedHashSet2.add(new h8.h(optString8, optString9, optString10));
                            optJSONArray = jSONArray;
                            length = i11;
                        }
                        linkedHashSet = linkedHashSet2;
                    }
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    Set I07 = q6.l.I0(d0.b.e(optJSONObject3, "dataDeclaration"));
                    String optString11 = optJSONObject3.optString("deviceStorageDisclosureUrl");
                    optString5.getClass();
                    optString6.getClass();
                    Boolean valueOf = Boolean.valueOf(optBoolean);
                    optString11.getClass();
                    linkedHashMap5.put(next3, new h8.i(optInt3, optString5, null, I0, I02, I03, I04, I05, I06, optString6, str7, optInt4, valueOf, I07, cVar, linkedHashSet, optString11, 4));
                    optJSONObject2 = jSONObject2;
                    i6 = i;
                    str4 = str;
                    str6 = str2;
                    str5 = str3;
                }
            }
        }
        cVar2.h = linkedHashMap5;
        return cVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [q6.t] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public Object k(String str) {
        List arrayList;
        Regulations regulations;
        n6.a aVar;
        l8.b bVar;
        switch (this.f5308a) {
            case 5:
                str.getClass();
                try {
                    this.f5309b = new JSONArray(str);
                    LinkedHashMap l10 = l();
                    u5.d dVar = new u5.d();
                    dVar.f10710a = l10;
                    return dVar;
                } catch (JSONException unused) {
                    ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                    if (callback != null) {
                        callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
                    }
                    return new u5.d();
                }
            case 6:
                str.getClass();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray optJSONArray = jSONObject.optJSONArray("applicableRegulations");
                    if (optJSONArray == null) {
                        arrayList = 0;
                    } else {
                        arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        int i = 0;
                        while (i < length) {
                            int i6 = i + 1;
                            String string = optJSONArray.getString(i);
                            string.getClass();
                            Regulations[] values = Regulations.values();
                            int length2 = values.length;
                            int i10 = 0;
                            while (true) {
                                if (i10 < length2) {
                                    regulations = values[i10];
                                    i10++;
                                    if (l7.u.m0(regulations.name(), string, true)) {
                                    }
                                } else {
                                    regulations = null;
                                }
                            }
                            if (regulations == null) {
                                regulations = Regulations.NA;
                            }
                            arrayList.add(regulations);
                            i = i6;
                        }
                    }
                    if (arrayList == 0) {
                        arrayList = q6.t.f8724a;
                    }
                    String optString = jSONObject.optString("inmobiAccountId");
                    String optString2 = jSONObject.optString("hashCode");
                    String optString3 = jSONObject.optString("publisherCountryCode");
                    String optString4 = jSONObject.optString("publisherName");
                    String optString5 = jSONObject.optString("lang_");
                    String optString6 = jSONObject.optString("siteUuid");
                    String optString7 = jSONObject.optString("themeUuid");
                    String optString8 = jSONObject.optString("cmpVersion");
                    JSONObject optJSONObject = jSONObject.optJSONObject("geoIP");
                    if (optJSONObject == null) {
                        aVar = null;
                    } else {
                        String optString9 = optJSONObject.optString("country");
                        optString9.getClass();
                        String optString10 = optJSONObject.optString("region");
                        optString10.getClass();
                        aVar = new n6.a(4, optString9, optString10);
                    }
                    if (aVar == null) {
                        aVar = new n6.a(7, null, null);
                    }
                    n6.a aVar2 = aVar;
                    l8.i y9 = y(jSONObject.optJSONObject("gdprConfig"));
                    l8.k A = A(jSONObject.optJSONObject("mspaConfig"));
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("ccpaConfig");
                    if (optJSONObject2 == null) {
                        bVar = null;
                    } else {
                        String optString11 = optJSONObject2.optString("uspLspact");
                        optString11.getClass();
                        bVar = new l8.b(optString11);
                    }
                    if (bVar == null) {
                        bVar = new l8.b("");
                    }
                    l8.b bVar2 = bVar;
                    l8.h x3 = x(jSONObject.optJSONObject("gbcConfig"));
                    l8.r N = N(jSONObject.optJSONObject("uspPortalLabels"));
                    l8.d r9 = r(jSONObject.optJSONObject("features"));
                    l8.p B = B(jSONObject.optJSONObject("theme"));
                    String optString12 = jSONObject.optString("noRegulationMessage");
                    ArrayList q9 = d0.b.q(jSONObject, "supportedLanguages");
                    String optString13 = jSONObject.optString("inmobiBrandingLogoUrl");
                    boolean optBoolean = jSONObject.optBoolean("optOutFromAllEnabled", false);
                    optString.getClass();
                    optString2.getClass();
                    optString3.getClass();
                    optString4.getClass();
                    optString5.getClass();
                    optString12.getClass();
                    optString13.getClass();
                    return new l8.n(arrayList, optString, optString2, optString3, optString4, optString5, optString6, optString7, optString8, aVar2, r9, B, y9, A, bVar2, x3, N, optString12, q9, optBoolean, optString13, 4096);
                } catch (JSONException e10) {
                    a.a.h("Choice", kotlin.jvm.internal.l.g(e10.getMessage(), "Error parsing portal config: "), null, 4);
                    ChoiceCmpCallback choiceCmpCallback = (ChoiceCmpCallback) this.f5309b;
                    if (choiceCmpCallback != null) {
                        choiceCmpCallback.onCmpError(ChoiceError.UNKNOWN_CONFIG);
                    }
                    return new l8.n(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 4194303);
                }
            default:
                str.getClass();
                try {
                    return j(new JSONObject(str));
                } catch (JSONException unused2) {
                    ChoiceCmpCallback callback2 = ChoiceCmp.INSTANCE.getCallback();
                    if (callback2 != null) {
                        callback2.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
                    }
                    return new h8.c();
                }
        }
    }

    public LinkedHashMap l() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = (JSONArray) this.f5309b;
        if (jSONArray == null) {
            kotlin.jvm.internal.l.i("googleVendorsJson");
            throw null;
        }
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            int i6 = i + 1;
            JSONArray jSONArray2 = (JSONArray) this.f5309b;
            if (jSONArray2 == null) {
                kotlin.jvm.internal.l.i("googleVendorsJson");
                throw null;
            }
            String string = jSONArray2.getString(i);
            if (string == null) {
                string = "0";
            }
            JSONArray jSONArray3 = (JSONArray) this.f5309b;
            if (jSONArray3 == null) {
                kotlin.jvm.internal.l.i("googleVendorsJson");
                throw null;
            }
            JSONObject jSONObject = jSONArray3.getJSONObject(i);
            String string2 = jSONObject.getString("provider_id");
            string2.getClass();
            int parseInt = Integer.parseInt(string2);
            String string3 = jSONObject.getString("provider_name");
            string3.getClass();
            String string4 = jSONObject.getString("policy_url");
            string4.getClass();
            String string5 = jSONObject.getString("domains");
            string5.getClass();
            linkedHashMap.put(string, new u5.e(string3, string4, string5, parseInt));
            i = i6;
        }
        return linkedHashMap;
    }

    public void n(String str) {
        int indexOf = str.indexOf(":", 1);
        if (indexOf != -1) {
            o(str.substring(0, indexOf), str.substring(indexOf + 1));
        } else if (str.startsWith(":")) {
            o("", str.substring(1));
        } else {
            o("", str);
        }
    }

    public void o(String str, String str2) {
        ArrayList arrayList = (ArrayList) this.f5309b;
        arrayList.add(str);
        arrayList.add(str2.trim());
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        str.getClass();
        z5.c cVar = (z5.c) this.f5309b;
        c.h hVar = cVar.C;
        if (hVar == null) {
            kotlin.jvm.internal.l.i("switchAdapter");
            throw null;
        }
        z5.d dVar = cVar.B;
        if (dVar == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        ArrayList c9 = dVar.c(str);
        boolean z9 = str.length() > 0;
        hVar.f1155a = c9;
        if (!z9) {
            hVar.a();
        }
        hVar.notifyDataSetChanged();
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    @Override // a4.i
    public void onSuccess() {
        switch (this.f5308a) {
            case 0:
                TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f5309b;
                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(tvAppDetailFragment), null, null, new e(tvAppDetailFragment, null, 2), 3);
                break;
            default:
                ((n5.d) this.f5309b).f8080q = true;
                break;
        }
    }

    @Override // j1.h
    public j1.p q(Object obj) {
        g2.d dVar = (g2.d) obj;
        y1.l lVar = ((y1.j) this.f5309b).f11631e;
        if (dVar != null) {
            return t1.Q(Arrays.asList(y1.l.a(lVar), lVar.f11643m.o(null, lVar.f11640e.f11908a)));
        }
        Log.w("FirebaseCrashlytics", "Received null app settings, cannot send reports at crash time.", null);
        return t1.x(null);
    }

    @Override // j1.d
    public void s(j1.p pVar) {
        Exception f = pVar.f();
        if (f != null) {
            ((o7.l) this.f5309b).resumeWith(new p6.j(f));
            return;
        }
        boolean z9 = pVar.f6563d;
        o7.l lVar = (o7.l) this.f5309b;
        if (z9) {
            lVar.o(null);
        } else {
            lVar.resumeWith(pVar.g());
        }
    }

    public synchronized void w(m8.f0 f0Var) {
        ((LinkedHashSet) this.f5309b).remove(f0Var);
    }

    public String z(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            n2.d dVar = (n2.d) this.f5309b;
            n2.e eVar = new n2.e(stringWriter, dVar.f7927a, dVar.f7928b, dVar.f7929c, dVar.f7930d);
            eVar.h(obj);
            eVar.j();
            eVar.f7932b.flush();
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public /* synthetic */ f(Object obj, int i) {
        this.f5308a = i;
        this.f5309b = obj;
    }

    public f(f fVar, g gVar) {
        this.f5308a = 3;
        this.f5309b = gVar;
        Objects.requireNonNull(fVar);
    }

    public f(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.f5308a = 14;
        this.f5309b = relativeLayout;
    }

    public f(Bundle bundle) {
        this.f5308a = 18;
        if (bundle != null) {
            this.f5309b = new Bundle(bundle);
        } else {
            com.google.gson.internal.a.i("data");
            throw null;
        }
    }

    public f(y1.j jVar, String str) {
        this.f5308a = 17;
        this.f5309b = jVar;
    }
}
