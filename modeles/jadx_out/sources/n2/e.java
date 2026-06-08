package n2;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l2.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements l2.e, g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7931a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f7932b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f7933c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f7934d;

    /* renamed from: e, reason: collision with root package name */
    public final l2.d f7935e;
    public final boolean f;

    public e(Writer writer, HashMap hashMap, HashMap hashMap2, a aVar, boolean z9) {
        this.f7932b = new JsonWriter(writer);
        this.f7933c = hashMap;
        this.f7934d = hashMap2;
        this.f7935e = aVar;
        this.f = z9;
    }

    @Override // l2.e
    public final l2.e a(l2.c cVar, Object obj) {
        i(obj, cVar.f7089a);
        return this;
    }

    @Override // l2.g
    public final g b(String str) {
        j();
        this.f7932b.value(str);
        return this;
    }

    @Override // l2.g
    public final g c(boolean z9) {
        j();
        this.f7932b.value(z9);
        return this;
    }

    @Override // l2.e
    public final l2.e d(l2.c cVar, boolean z9) {
        String str = cVar.f7089a;
        j();
        JsonWriter jsonWriter = this.f7932b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(z9);
        return this;
    }

    @Override // l2.e
    public final l2.e e(l2.c cVar, int i) {
        String str = cVar.f7089a;
        j();
        JsonWriter jsonWriter = this.f7932b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(i);
        return this;
    }

    @Override // l2.e
    public final l2.e f(l2.c cVar, long j) {
        String str = cVar.f7089a;
        j();
        JsonWriter jsonWriter = this.f7932b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(j);
        return this;
    }

    @Override // l2.e
    public final l2.e g(l2.c cVar, double d10) {
        String str = cVar.f7089a;
        j();
        JsonWriter jsonWriter = this.f7932b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(d10);
        return this;
    }

    public final e h(Object obj) {
        JsonWriter jsonWriter = this.f7932b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        int i = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        i(entry.getValue(), (String) key);
                    } catch (ClassCastException e10) {
                        throw new l2.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            l2.d dVar = (l2.d) this.f7933c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            l2.f fVar = (l2.f) this.f7934d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.f7935e.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            if (obj instanceof f) {
                int number = ((f) obj).getNumber();
                j();
                jsonWriter.value(number);
                return this;
            }
            String name = ((Enum) obj).name();
            j();
            jsonWriter.value(name);
            return this;
        }
        if (obj instanceof byte[]) {
            j();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                jsonWriter.value(r7[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                j();
                jsonWriter.value(j);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                jsonWriter.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                jsonWriter.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i < length5) {
                h(numberArr[i]);
                i++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i < length6) {
                h(objArr[i]);
                i++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final e i(Object obj, String str) {
        boolean z9 = this.f;
        JsonWriter jsonWriter = this.f7932b;
        if (z9) {
            if (obj == null) {
                return this;
            }
            j();
            jsonWriter.name(str);
            h(obj);
            return this;
        }
        j();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        h(obj);
        return this;
    }

    public final void j() {
        if (this.f7931a) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Parent context used since this context was created. Cannot use this context anymore.");
    }
}
