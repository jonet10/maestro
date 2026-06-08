package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.util.Base64;
import android.util.JsonReader;
import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.ListenableWorker;
import androidx.work.impl.model.WorkSpec;
import c2.b;
import java.util.List;
import java.util.NoSuchElementException;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver, Function, b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f461a;

    public /* synthetic */ a(int i) {
        this.f461a = i;
    }

    public static /* bridge */ /* synthetic */ Topic e(Object obj) {
        return (Topic) obj;
    }

    public static /* bridge */ /* synthetic */ TopicsManager f(Object obj) {
        return (TopicsManager) obj;
    }

    public static /* synthetic */ void g(Object obj, Object obj2, Object obj3, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(obj3);
        throw new IllegalStateException(sb.toString(), th);
    }

    public static /* synthetic */ void h(Object obj, String str) {
        throw new RuntimeException(str + obj);
    }

    public static /* synthetic */ void i(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void j(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void k(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalStateException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void l(String str, Object obj, Throwable th) {
        throw new RuntimeException(str + obj, th);
    }

    public static /* synthetic */ void m(String str, Throwable th) {
        throw new RuntimeException(str, th);
    }

    public static /* bridge */ /* synthetic */ Class q() {
        return TopicsManager.class;
    }

    public static /* synthetic */ void r(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void s(String str) {
        throw new NoSuchElementException(str);
    }

    public static /* synthetic */ void t(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    @Override // c2.b
    public Object a(JsonReader jsonReader) {
        switch (this.f461a) {
            case 28:
                jsonReader.beginObject();
                String str = null;
                String str2 = null;
                String str3 = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    nextName.getClass();
                    switch (nextName) {
                        case "libraryName":
                            str2 = jsonReader.nextString();
                            if (str2 == null) {
                                com.google.gson.internal.a.i("Null libraryName");
                                break;
                            } else {
                                break;
                            }
                        case "arch":
                            str = jsonReader.nextString();
                            if (str == null) {
                                com.google.gson.internal.a.i("Null arch");
                                break;
                            } else {
                                break;
                            }
                        case "buildId":
                            str3 = jsonReader.nextString();
                            if (str3 == null) {
                                com.google.gson.internal.a.i("Null buildId");
                                break;
                            } else {
                                break;
                            }
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                if (str != null && str2 != null && str3 != null) {
                    break;
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (str == null) {
                        sb.append(" arch");
                    }
                    if (str2 == null) {
                        sb.append(" libraryName");
                    }
                    if (str3 == null) {
                        sb.append(" buildId");
                    }
                    i(k.h("Missing required properties:", sb));
                    break;
                }
            default:
                jsonReader.beginObject();
                String str4 = null;
                byte[] bArr = null;
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    nextName2.getClass();
                    if (!nextName2.equals("filename")) {
                        if (nextName2.equals("contents")) {
                            bArr = Base64.decode(jsonReader.nextString(), 2);
                            if (bArr == null) {
                                com.google.gson.internal.a.i("Null contents");
                                break;
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        str4 = jsonReader.nextString();
                        if (str4 == null) {
                            com.google.gson.internal.a.i("Null filename");
                            break;
                        }
                    }
                }
                jsonReader.endObject();
                if (str4 != null && bArr != null) {
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    if (str4 == null) {
                        sb2.append(" filename");
                    }
                    if (bArr == null) {
                        sb2.append(" contents");
                    }
                    i(k.h("Missing required properties:", sb2));
                    break;
                }
        }
        return null;
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        List WORK_INFO_MAPPER$lambda$1;
        WORK_INFO_MAPPER$lambda$1 = WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
        return WORK_INFO_MAPPER$lambda$1;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        Object lambda$getForegroundInfoAsync$0;
        lambda$getForegroundInfoAsync$0 = ListenableWorker.lambda$getForegroundInfoAsync$0(completer);
        return lambda$getForegroundInfoAsync$0;
    }
}
