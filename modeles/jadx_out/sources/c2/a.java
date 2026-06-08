package c2;

import a4.d0;
import android.text.Editable;
import android.util.Base64;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import b2.d1;
import b2.f1;
import b2.n2;
import b2.s0;
import b2.v0;
import c3.l;
import c3.o;
import c3.o0;
import c3.p0;
import c3.r;
import com.google.android.gms.internal.measurement.t5;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;
import com.google.gson.internal.m;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import k0.k;
import o.e;
import s1.d;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements b, e, d, OnApplyWindowInsetsListener, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter, m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1183a;

    public /* synthetic */ a(l lVar) {
        this.f1183a = 4;
    }

    public static /* synthetic */ void e(int i, int i6) {
        StringBuilder sb = new StringBuilder(i);
        sb.append((Object) "serialized size must be non-negative, was ");
        sb.append(i6);
        throw new IllegalStateException(sb.toString());
    }

    public static /* synthetic */ void f(int i, int i6, Object obj, String str) {
        throw new IllegalArgumentException(str + i + obj + i6);
    }

    public static /* synthetic */ void g(int i, Object obj, int i6, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(i);
        sb.append((Object) " parameters found ");
        sb.append(i6);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void h(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void i(String str) {
        throw new t5(str);
    }

    public static /* synthetic */ void j(Object obj, String str) {
        throw new com.google.gson.e(str + ((Object) obj.toString()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c2.b
    public Object a(JsonReader jsonReader) {
        char c9;
        char c10;
        char c11;
        int i = 3;
        switch (this.f1183a) {
            case 0:
                d1 d1Var = new d1();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    nextName.getClass();
                    switch (nextName.hashCode()) {
                        case -1536268810:
                            if (nextName.equals("parameterKey")) {
                                c9 = 0;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case -1027290370:
                            if (nextName.equals("templateVersion")) {
                                c9 = 1;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 1098747284:
                            if (nextName.equals("rolloutVariant")) {
                                c9 = 2;
                                break;
                            }
                            c9 = 65535;
                            break;
                        case 1124454216:
                            if (nextName.equals("parameterValue")) {
                                c9 = 3;
                                break;
                            }
                            c9 = 65535;
                            break;
                        default:
                            c9 = 65535;
                            break;
                    }
                    switch (c9) {
                        case 0:
                            String nextString = jsonReader.nextString();
                            if (nextString == null) {
                                com.google.gson.internal.a.i("Null parameterKey");
                                return null;
                            }
                            d1Var.f768b = nextString;
                            break;
                        case 1:
                            d1Var.f770d = jsonReader.nextLong();
                            d1Var.f771e = (byte) (d1Var.f771e | 1);
                            break;
                        case 2:
                            jsonReader.beginObject();
                            String str = null;
                            String str2 = null;
                            while (jsonReader.hasNext()) {
                                String nextName2 = jsonReader.nextName();
                                nextName2.getClass();
                                if (nextName2.equals("variantId")) {
                                    str2 = jsonReader.nextString();
                                    if (str2 == null) {
                                        com.google.gson.internal.a.i("Null variantId");
                                        return null;
                                    }
                                } else if (nextName2.equals("rolloutId")) {
                                    str = jsonReader.nextString();
                                    if (str == null) {
                                        com.google.gson.internal.a.i("Null rolloutId");
                                        return null;
                                    }
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            if (str != null && str2 != null) {
                                d1Var.f767a = new f1(str, str2);
                                break;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                if (str == null) {
                                    sb.append(" rolloutId");
                                }
                                if (str2 == null) {
                                    sb.append(" variantId");
                                }
                                androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb));
                                return null;
                            }
                            break;
                        case 3:
                            String nextString2 = jsonReader.nextString();
                            if (nextString2 == null) {
                                com.google.gson.internal.a.i("Null parameterValue");
                                return null;
                            }
                            d1Var.f769c = nextString2;
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                return d1Var.a();
            case 1:
                jsonReader.beginObject();
                byte b7 = 0;
                int i6 = 0;
                String str3 = null;
                List list = null;
                while (jsonReader.hasNext()) {
                    String nextName3 = jsonReader.nextName();
                    nextName3.getClass();
                    switch (nextName3.hashCode()) {
                        case -1266514778:
                            if (nextName3.equals("frames")) {
                                c10 = 0;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 3373707:
                            if (nextName3.equals("name")) {
                                c10 = 1;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 2125650548:
                            if (nextName3.equals("importance")) {
                                c10 = 2;
                                break;
                            }
                            c10 = 65535;
                            break;
                        default:
                            c10 = 65535;
                            break;
                    }
                    switch (c10) {
                        case 0:
                            list = c.d(jsonReader, new a(i));
                            if (list == null) {
                                com.google.gson.internal.a.i("Null frames");
                                return null;
                            }
                            continue;
                        case 1:
                            str3 = jsonReader.nextString();
                            if (str3 == null) {
                                com.google.gson.internal.a.i("Null name");
                                return null;
                            }
                            break;
                        case 2:
                            i6 = jsonReader.nextInt();
                            b7 = (byte) (b7 | 1);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                if (b7 == 1 && str3 != null && list != null) {
                    return new v0(str3, i6, list);
                }
                StringBuilder sb2 = new StringBuilder();
                if (str3 == null) {
                    sb2.append(" name");
                }
                if ((b7 & 1) == 0) {
                    sb2.append(" importance");
                }
                if (list == null) {
                    sb2.append(" frames");
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb2));
                return null;
            case 2:
                jsonReader.beginObject();
                byte b10 = 0;
                String str4 = null;
                String str5 = null;
                long j = 0;
                long j6 = 0;
                while (jsonReader.hasNext()) {
                    String nextName4 = jsonReader.nextName();
                    nextName4.getClass();
                    switch (nextName4.hashCode()) {
                        case 3373707:
                            if (nextName4.equals("name")) {
                                c11 = 0;
                                break;
                            }
                            c11 = 65535;
                            break;
                        case 3530753:
                            if (nextName4.equals("size")) {
                                c11 = 1;
                                break;
                            }
                            c11 = 65535;
                            break;
                        case 3601339:
                            if (nextName4.equals("uuid")) {
                                c11 = 2;
                                break;
                            }
                            c11 = 65535;
                            break;
                        case 1153765347:
                            if (nextName4.equals("baseAddress")) {
                                c11 = 3;
                                break;
                            }
                            c11 = 65535;
                            break;
                        default:
                            c11 = 65535;
                            break;
                    }
                    switch (c11) {
                        case 0:
                            str4 = jsonReader.nextString();
                            if (str4 == null) {
                                com.google.gson.internal.a.i("Null name");
                                return null;
                            }
                            break;
                        case 1:
                            b10 = (byte) (b10 | 2);
                            j6 = jsonReader.nextLong();
                            break;
                        case 2:
                            str5 = new String(Base64.decode(jsonReader.nextString(), 2), n2.f887a);
                            break;
                        case 3:
                            b10 = (byte) (b10 | 1);
                            j = jsonReader.nextLong();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                if (b10 == 3 && str4 != null) {
                    return new s0(j, j6, str4, str5);
                }
                StringBuilder sb3 = new StringBuilder();
                if ((b10 & 1) == 0) {
                    sb3.append(" baseAddress");
                }
                if ((b10 & 2) == 0) {
                    sb3.append(" size");
                }
                if (str4 == null) {
                    sb3.append(" name");
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb3));
                return null;
            default:
                return c.a(jsonReader);
        }
    }

    @Override // o.e
    public Object apply(Object obj) {
        String z9 = p0.f1301b.z((o0) obj);
        z9.getClass();
        Log.d("FirebaseSessions", "Session Event Type: SESSION_START");
        byte[] bytes = z9.getBytes(l7.a.f7151a);
        bytes.getClass();
        return bytes;
    }

    @Override // s1.d
    public Object c(d0 d0Var) {
        o components$lambda$0;
        r components$lambda$1;
        switch (this.f1183a) {
            case 6:
                components$lambda$0 = FirebaseSessionsRegistrar.getComponents$lambda$0(d0Var);
                return components$lambda$0;
            default:
                components$lambda$1 = FirebaseSessionsRegistrar.getComponents$lambda$1(d0Var);
                return components$lambda$1;
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        int lambda$new$0;
        lambda$new$0 = TextInputLayout.lambda$new$0(editable);
        return lambda$new$0;
    }

    @Override // com.google.gson.internal.m
    public Object d() {
        switch (this.f1183a) {
            case 24:
                return new com.google.gson.internal.l(true);
            case 25:
                return new LinkedHashMap();
            case 26:
                return new TreeMap();
            case 27:
                return new ConcurrentHashMap();
            case 28:
                return new ConcurrentSkipListMap();
            default:
                return new ArrayList();
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        view.getClass();
        windowInsetsCompat.getClass();
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        insets.getClass();
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    public /* synthetic */ a(int i) {
        this.f1183a = i;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize cornerSize) {
        CornerSize lambda$setShapeAppearanceModel$0;
        lambda$setShapeAppearanceModel$0 = MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
        return lambda$setShapeAppearanceModel$0;
    }
}
