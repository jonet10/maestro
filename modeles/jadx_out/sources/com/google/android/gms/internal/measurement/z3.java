package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.activities.MainActivity;
import java.io.Closeable;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class z3 {

    /* renamed from: b, reason: collision with root package name */
    public static e2.d f2927b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f2928c;

    /* renamed from: d, reason: collision with root package name */
    public static int f2929d;

    /* renamed from: e, reason: collision with root package name */
    public static int f2930e;
    public static boolean f;
    public static String g;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2931a;

    public /* synthetic */ z3(int i) {
        this.f2931a = i;
    }

    public static boolean B(Context context, String str) {
        try {
            return context.getSharedPreferences("SettingsPreferences", 0).contains(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean C(int i, MainActivity mainActivity) {
        return p(mainActivity, "wizard_step_" + i + "_shown", false);
    }

    public static String D(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = String.format("0%s", Arrays.copyOf(new Object[]{bigInteger}, 1));
            }
            return bigInteger;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String E(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            com.google.gson.internal.a.p("Invalid input received");
            return null;
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static ArrayList F(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        try {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                optJSONObject.getClass();
                arrayList.add(f(optJSONObject));
            }
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }

    public static x4.y2 G(JSONObject jSONObject) {
        return new x4.y2(!jSONObject.isNull("name") ? jSONObject.optString("name") : null, !jSONObject.isNull("packagename") ? jSONObject.optString("packagename") : null, !jSONObject.isNull("lastUpdate") ? jSONObject.optLong("lastUpdate") : -1L, jSONObject.isNull("icon") ? null : jSONObject.optString("icon"), !jSONObject.isNull("appAvailable") ? jSONObject.optInt("appAvailable") : 1);
    }

    public static void H(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    public static boolean I(android.content.Context r28, java.io.File r29, java.lang.String r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.z3.I(android.content.Context, java.io.File, java.lang.String, boolean):boolean");
    }

    public static final void J(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), 2131231146));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), 2131100824));
    }

    public static final void K(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), 2131231156));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), 2131099713));
        textView.setAlpha(1.0f);
    }

    public static final void L(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), 2131231156));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), 2131099713));
        textView.setAlpha(0.4f);
    }

    public static void M(Context context, String str, boolean z9) {
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z9);
        edit.apply();
    }

    public static final void N(TextView textView) {
        textView.getClass();
        textView.setVisibility(0);
        textView.setBackground(ContextCompat.getDrawable(textView.getContext(), 2131231154));
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), 2131100824));
    }

    public static void O(Context context, int i, String str) {
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void P(Context context, String str) {
        str.getClass();
        R(context, "Language", str);
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("CoreSettings", 0).edit();
            edit.putString("language", str);
            edit.apply();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void Q(long j, Context context, String str) {
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void R(Context context, String str, String str2) {
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static int S(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int T(int i) {
        int[] iArr = {1, 2, 3};
        for (int i6 = 0; i6 < 3; i6++) {
            int i10 = iArr[i6];
            int i11 = i10 - 1;
            if (i10 == 0) {
                throw null;
            }
            if (i11 == i) {
                return i10;
            }
        }
        return 1;
    }

    public static n U(Object obj) {
        if (obj == null) {
            return n.f2718d;
        }
        if (obj instanceof String) {
            return new q((String) obj);
        }
        if (obj instanceof Double) {
            return new g((Double) obj);
        }
        if (obj instanceof Long) {
            return new g(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new g(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new e((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                com.google.gson.internal.a.p("Invalid value type");
                return null;
            }
            d dVar = new d();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                dVar.q(dVar.o(), U(it.next()));
            }
            return dVar;
        }
        k kVar = new k();
        Map map = (Map) obj;
        for (Object obj2 : map.keySet()) {
            n U = U(map.get(obj2));
            if (obj2 != null) {
                if (!(obj2 instanceof String)) {
                    obj2 = obj2.toString();
                }
                kVar.d((String) obj2, U);
            }
        }
        return kVar;
    }

    public static String V(String str, Object... objArr) {
        int length;
        int indexOf;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i = 0;
        int i6 = 0;
        while (true) {
            length = objArr.length;
            if (i >= length || (indexOf = str.indexOf("%s", i6)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i6, indexOf);
            sb.append(Y(objArr[i]));
            i6 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) str, i6, str.length());
        if (i < length) {
            String str2 = " [";
            while (i < objArr.length) {
                sb.append(str2);
                sb.append(Y(objArr[i]));
                i++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static synchronized void W(e2.d dVar) {
        synchronized (z3.class) {
            if (f2927b != null) {
                throw new IllegalStateException("init() already called");
            }
            f2927b = dVar;
        }
    }

    public static n X(w3 w3Var) {
        if (w3Var == null) {
            return n.f2717c;
        }
        int w2 = w3Var.w() - 1;
        if (w2 == 1) {
            return w3Var.q() ? new q(w3Var.r()) : n.j;
        }
        if (w2 == 2) {
            return w3Var.u() ? new g(Double.valueOf(w3Var.v())) : new g(null);
        }
        if (w2 == 3) {
            return w3Var.s() ? new e(Boolean.valueOf(w3Var.t())) : new e(null);
        }
        if (w2 != 4) {
            com.google.gson.internal.a.p("Unknown type found. Cannot convert entity");
            return null;
        }
        List o10 = w3Var.o();
        ArrayList arrayList = new ArrayList();
        Iterator it = o10.iterator();
        while (it.hasNext()) {
            arrayList.add(X((w3) it.next()));
        }
        return new o(w3Var.p(), arrayList);
    }

    public static String Y(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e10) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            String o10 = a4.x.o(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(o10), (Throwable) e10);
            String name2 = e10.getClass().getName();
            StringBuilder sb = new StringBuilder(o10.length() + 8 + name2.length() + 1);
            a4.x.B(sb, "<", o10, " threw ", name2);
            sb.append(">");
            return sb.toString();
        }
    }

    public static String a(int i, String str) {
        if (i != str.length()) {
            throw new w5.e(kotlin.jvm.internal.l.g(": invalid bit length for language", "h.i"));
        }
        int length = str.length() / 2;
        i7.d K = t0.f.K(0, length);
        K.getClass();
        int b7 = b2.t1.b(length, K.isEmpty() ? "" : str.substring(K.f5695a, K.f5696b + 1)) + 65;
        i7.d K2 = t0.f.K(length, str.length());
        K2.getClass();
        int b10 = b2.t1.b(length, K2.isEmpty() ? "" : str.substring(K2.f5695a, K2.f5696b + 1)) + 65;
        StringBuilder sb = new StringBuilder();
        sb.append((char) b7);
        sb.append((char) b10);
        return sb.toString();
    }

    public static u5.g b(String str) {
        str.getClass();
        List G0 = l7.m.G0(str, new String[]{"-"});
        if (G0.size() != 2) {
            throw new w5.e("f.k: TCModelError, hash: ".concat(str));
        }
        int parseInt = Integer.parseInt((String) G0.get(0));
        int parseInt2 = Integer.parseInt((String) G0.get(1));
        return new u5.g(parseInt, parseInt2 != 1 ? parseInt2 != 2 ? u5.i.NOT_ALLOWED : u5.i.REQUIRE_LI : u5.i.REQUIRE_CONSENT);
    }

    public static Object c(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void d(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public static x4.d1 e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        x4.d1 d1Var = new x4.d1();
        if (!jSONObject.isNull("eventID")) {
            d1Var.f11091a = jSONObject.optLong("eventID");
        }
        if (!jSONObject.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
            d1Var.f11092b = jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        }
        if (!jSONObject.isNull("header") && (optJSONObject3 = jSONObject.optJSONObject("header")) != null) {
            if (!optJSONObject3.isNull("userID")) {
                d1Var.f11093l = optJSONObject3.optLong("userID");
            }
            if (!optJSONObject3.isNull("username")) {
                d1Var.f11094m = optJSONObject3.optString("username");
            }
            if (!optJSONObject3.isNull("languageID")) {
                d1Var.f11095n = optJSONObject3.optInt("languageID");
            }
            if (!optJSONObject3.isNull("action")) {
                d1Var.f11096o = optJSONObject3.optString("action");
            }
            if (!optJSONObject3.isNull("isTurbo")) {
                d1Var.f11097p = optJSONObject3.optInt("isTurbo");
            }
            if (!optJSONObject3.isNull("avatarURL")) {
                d1Var.f11098q = optJSONObject3.optString("avatarURL");
            }
            if (!optJSONObject3.isNull("timeAgo")) {
                d1Var.f11099r = optJSONObject3.optString("timeAgo");
            }
            if (!optJSONObject3.isNull("usernameFormat")) {
                d1Var.f11100s = optJSONObject3.optString("usernameFormat");
            }
        }
        if (!jSONObject.isNull("content") && (optJSONObject = jSONObject.optJSONObject("content")) != null) {
            if (!optJSONObject.isNull("userID")) {
                d1Var.f11101t = optJSONObject.optLong("userID");
            }
            if (!optJSONObject.isNull("shortDescription")) {
                d1Var.f11103w = optJSONObject.optString("shortDescription");
            }
            if (!optJSONObject.isNull("text")) {
                d1Var.f11102u = optJSONObject.optString("text");
            }
            if (!optJSONObject.isNull("rating")) {
                d1Var.v = optJSONObject.optInt("rating");
            }
            if (!optJSONObject.isNull("userListID")) {
                d1Var.f11104x = optJSONObject.optLong("userListID");
            }
            if (!optJSONObject.isNull("targetName")) {
                d1Var.f11105y = optJSONObject.optString("targetName");
            }
            if (!optJSONObject.isNull("targetURL")) {
                d1Var.f11106z = optJSONObject.optString("targetURL");
            }
            if (!optJSONObject.isNull("targetID")) {
                d1Var.A = optJSONObject.optLong("targetID");
            }
            if (!optJSONObject.isNull("likes")) {
                d1Var.G = optJSONObject.optInt("likes");
            }
            if (!optJSONObject.isNull("app") && (optJSONObject2 = optJSONObject.optJSONObject("app")) != null) {
                if (!optJSONObject2.isNull("appID")) {
                    d1Var.B = optJSONObject2.optLong("appID");
                }
                if (!optJSONObject2.isNull("name")) {
                    d1Var.C = optJSONObject2.optString("name");
                }
                if (!optJSONObject2.isNull("appURL")) {
                    d1Var.D = optJSONObject2.optString("appURL");
                }
                if (!optJSONObject2.isNull("shortDescription")) {
                    d1Var.E = optJSONObject2.optString("shortDescription");
                }
                if (!optJSONObject2.isNull("iconURL")) {
                    d1Var.F = optJSONObject2.optString("iconURL");
                }
            }
        }
        return d1Var;
    }

    public static x4.z2 f(JSONObject jSONObject) {
        x4.z2 z2Var = new x4.z2();
        if (!jSONObject.isNull("id")) {
            z2Var.f11481a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("identifier")) {
            z2Var.f11482b = jSONObject.optString("identifier");
        }
        if (!jSONObject.isNull("name")) {
            z2Var.f11483l = jSONObject.optString("name");
        }
        if (!jSONObject.isNull("platformID")) {
            int optInt = jSONObject.optInt("platformID");
            z2Var.f11486o = optInt;
            if (optInt == 1) {
                z2Var.f11487p = "Windows";
            } else if (optInt == 3) {
                z2Var.f11487p = "Mac";
            } else if (optInt == 13) {
                z2Var.f11487p = "Android";
            } else if (optInt == 14) {
                z2Var.f11487p = "iOS";
            }
        }
        if (!jSONObject.isNull("lastUpdate")) {
            z2Var.f11488q = jSONObject.optLong("lastUpdate");
        }
        return z2Var;
    }

    public static r6.i g(r6.i iVar) {
        r6.f fVar = iVar.f8948a;
        fVar.c();
        return fVar.f8940r > 0 ? iVar : r6.i.f8947b;
    }

    public static boolean h(Context context) {
        context.getClass();
        return f ? z(context, "updates_wifi", "auto").equalsIgnoreCase("auto") : z(context, "updates_mobile_data", "notify").equalsIgnoreCase("auto");
    }

    public static final void i(int i, String str) {
        if (str.charAt(i) == '-') {
            return;
        }
        StringBuilder p10 = a4.x.p(i, "Expected '-' (hyphen) at index ", ", but was '");
        p10.append(str.charAt(i));
        p10.append('\'');
        throw new IllegalArgumentException(p10.toString().toString());
    }

    public static final void k(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                p6.a.a(th, th2);
            }
        }
    }

    public static void l(ArrayList arrayList) {
        HashMap hashMap = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            s1.a aVar = (s1.a) obj;
            s1.g gVar = new s1.g(aVar);
            for (s1.r rVar : aVar.f9114b) {
                boolean z9 = aVar.f9117e == 0;
                s1.h hVar = new s1.h(rVar, !z9);
                if (!hashMap.containsKey(hVar)) {
                    hashMap.put(hVar, new HashSet());
                }
                Set set = (Set) hashMap.get(hVar);
                if (!set.isEmpty() && z9) {
                    androidx.core.view.contentcapture.a.h(rVar, "Multiple components provide ", ".");
                    return;
                }
                set.add(gVar);
            }
        }
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            for (s1.g gVar2 : (Set) it.next()) {
                for (s1.i iVar : gVar2.f9129a.f9115c) {
                    if (iVar.f9136c == 0) {
                        Set<s1.g> set2 = (Set) hashMap.get(new s1.h(iVar.f9134a, iVar.f9135b == 2));
                        if (set2 != null) {
                            for (s1.g gVar3 : set2) {
                                gVar2.f9130b.add(gVar3);
                                gVar3.f9131c.add(gVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = hashMap.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            s1.g gVar4 = (s1.g) it3.next();
            if (gVar4.f9131c.isEmpty()) {
                hashSet2.add(gVar4);
            }
        }
        while (!hashSet2.isEmpty()) {
            s1.g gVar5 = (s1.g) hashSet2.iterator().next();
            hashSet2.remove(gVar5);
            i++;
            Iterator it4 = gVar5.f9130b.iterator();
            while (it4.hasNext()) {
                s1.g gVar6 = (s1.g) it4.next();
                gVar6.f9131c.remove(gVar5);
                if (gVar6.f9131c.isEmpty()) {
                    hashSet2.add(gVar6);
                }
            }
        }
        if (i == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            s1.g gVar7 = (s1.g) it5.next();
            if (!gVar7.f9131c.isEmpty() && !gVar7.f9130b.isEmpty()) {
                arrayList2.add(gVar7.f9129a);
            }
        }
        throw new s1.j("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
    }

    public static w8.k m(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(l7.a.f7151a);
        bytes.getClass();
        w8.k kVar = new w8.k(bytes);
        kVar.f10973l = str;
        return kVar;
    }

    public static final void n(long j, byte[] bArr, int i, int i6, int i10) {
        int i11 = 7 - i6;
        int i12 = 8 - i10;
        if (i12 > i11) {
            return;
        }
        while (true) {
            int i13 = l7.c.f7157a[(int) ((j >> (i11 << 3)) & 255)];
            int i14 = i + 1;
            bArr[i] = (byte) (i13 >> 8);
            i += 2;
            bArr[i14] = (byte) i13;
            if (i11 == i12) {
                return;
            } else {
                i11--;
            }
        }
    }

    public static boolean p(Context context, String str, boolean z9) {
        context.getClass();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getBoolean(str, z9);
            }
        } catch (Exception unused) {
        }
        return z9;
    }

    public static void r(m1.b bVar) {
        boolean z9 = false;
        if (!bVar.isDone()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i(b2.t1.F("Future was expected to be done: %s", bVar));
            return;
        }
        while (true) {
            try {
                bVar.get();
                break;
            } catch (InterruptedException unused) {
                z9 = true;
            } catch (Throwable th) {
                if (z9) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z9) {
            Thread.currentThread().interrupt();
        }
    }

    public static int s(Context context, int i, String str) {
        context.getClass();
        return context.getSharedPreferences("SettingsPreferences", 0).getInt(str, i);
    }

    public static long t(long j, Context context, String str) {
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        try {
            return sharedPreferences.getLong(str, j);
        } catch (ClassCastException unused) {
            try {
                long j6 = sharedPreferences.getInt(str, -1);
                Q(j6, context, str);
                return j6;
            } catch (ClassCastException unused2) {
                return j;
            }
        }
    }

    public static String u(Context context) {
        context.getClass();
        String z9 = z(context, "notifications_frecuency", "1");
        if (!z9.equals("0")) {
            return z9;
        }
        R(context, "notifications_frecuency", "1");
        return "1";
    }

    public static String w(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b7 : digest) {
                d0.b.v(16);
                String num = Integer.toString((b7 & 255) + 256, 16);
                num.getClass();
                sb.append(num.substring(1));
            }
            return sb.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String x(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                while (bigInteger.length() < 64) {
                    bigInteger = "0" + bigInteger;
                }
                return bigInteger;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public static String y(Context context, String str) {
        context.getClass();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getString(str, null);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String z(Context context, String str, String str2) {
        context.getClass();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains(str)) {
                String string = sharedPreferences.getString(str, str2);
                string.getClass();
                return string;
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public abstract boolean A(Class cls);

    public int hashCode() {
        switch (this.f2931a) {
            case 3:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public abstract List j(String str, List list);

    public abstract Method o(Class cls, Field field);

    public abstract Constructor q(Class cls);

    public String toString() {
        switch (this.f2931a) {
            case 3:
                String c9 = kotlin.jvm.internal.y.a(getClass()).c();
                c9.getClass();
                return c9;
            default:
                return super.toString();
        }
    }

    public abstract String[] v(Class cls);
}
