package o2;

import androidx.work.WorkInfo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements l2.e {
    public static final Charset f = Charset.forName("UTF-8");
    public static final l2.c g = new l2.c("key", k.j(k.i(e.class, new a(1))));
    public static final l2.c h = new l2.c("value", k.j(k.i(e.class, new a(2))));
    public static final n2.a i = new n2.a(1);

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f8138a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f8139b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f8140c;

    /* renamed from: d, reason: collision with root package name */
    public final l2.d f8141d;

    /* renamed from: e, reason: collision with root package name */
    public final h f8142e = new h(this);

    public f(ByteArrayOutputStream byteArrayOutputStream, HashMap hashMap, HashMap hashMap2, l2.d dVar) {
        this.f8138a = byteArrayOutputStream;
        this.f8139b = hashMap;
        this.f8140c = hashMap2;
        this.f8141d = dVar;
    }

    public static int k(l2.c cVar) {
        e eVar = (e) ((Annotation) cVar.f7090b.get(e.class));
        if (eVar != null) {
            return eVar.tag();
        }
        throw new l2.b("Field has no @Protobuf config");
    }

    @Override // l2.e
    public final l2.e a(l2.c cVar, Object obj) {
        i(cVar, obj, true);
        return this;
    }

    public final void b(l2.c cVar, double d10, boolean z9) {
        if (z9 && d10 == 0.0d) {
            return;
        }
        l((k(cVar) << 3) | 1);
        this.f8138a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d10).array());
    }

    public final void c(l2.c cVar, int i6, boolean z9) {
        if (z9 && i6 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f7090b.get(e.class));
        if (eVar == null) {
            throw new l2.b("Field has no @Protobuf config");
        }
        int ordinal = eVar.intEncoding().ordinal();
        if (ordinal == 0) {
            l(eVar.tag() << 3);
            l(i6);
        } else if (ordinal == 1) {
            l(eVar.tag() << 3);
            l((i6 << 1) ^ (i6 >> 31));
        } else {
            if (ordinal != 2) {
                return;
            }
            l((eVar.tag() << 3) | 5);
            this.f8138a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i6).array());
        }
    }

    @Override // l2.e
    public final l2.e d(l2.c cVar, boolean z9) {
        c(cVar, z9 ? 1 : 0, true);
        return this;
    }

    @Override // l2.e
    public final l2.e e(l2.c cVar, int i6) {
        c(cVar, i6, true);
        return this;
    }

    @Override // l2.e
    public final l2.e f(l2.c cVar, long j) {
        h(cVar, j, true);
        return this;
    }

    @Override // l2.e
    public final l2.e g(l2.c cVar, double d10) {
        b(cVar, d10, true);
        return this;
    }

    public final void h(l2.c cVar, long j, boolean z9) {
        if (z9 && j == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f7090b.get(e.class));
        if (eVar == null) {
            throw new l2.b("Field has no @Protobuf config");
        }
        int ordinal = eVar.intEncoding().ordinal();
        if (ordinal == 0) {
            l(eVar.tag() << 3);
            m(j);
        } else if (ordinal == 1) {
            l(eVar.tag() << 3);
            m((j >> 63) ^ (j << 1));
        } else {
            if (ordinal != 2) {
                return;
            }
            l((eVar.tag() << 3) | 1);
            this.f8138a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array());
        }
    }

    public final void i(l2.c cVar, Object obj, boolean z9) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z9 && charSequence.length() == 0) {
                return;
            }
            l((k(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            l(bytes.length);
            this.f8138a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                i(cVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                j(i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            b(cVar, ((Double) obj).doubleValue(), z9);
            return;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (z9 && floatValue == 0.0f) {
                return;
            }
            l((k(cVar) << 3) | 5);
            this.f8138a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
            return;
        }
        if (obj instanceof Number) {
            h(cVar, ((Number) obj).longValue(), z9);
            return;
        }
        if (obj instanceof Boolean) {
            c(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z9);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z9 && bArr.length == 0) {
                return;
            }
            l((k(cVar) << 3) | 2);
            l(bArr.length);
            this.f8138a.write(bArr);
            return;
        }
        l2.d dVar = (l2.d) this.f8139b.get(obj.getClass());
        if (dVar != null) {
            j(dVar, cVar, obj, z9);
            return;
        }
        l2.f fVar = (l2.f) this.f8140c.get(obj.getClass());
        if (fVar != null) {
            h hVar = this.f8142e;
            hVar.f8144a = false;
            hVar.f8146c = cVar;
            hVar.f8145b = z9;
            fVar.a(obj, hVar);
            return;
        }
        if (obj instanceof c) {
            c(cVar, ((c) obj).getNumber(), true);
        } else if (obj instanceof Enum) {
            c(cVar, ((Enum) obj).ordinal(), true);
        } else {
            j(this.f8141d, cVar, obj, z9);
        }
    }

    public final void j(l2.d dVar, l2.c cVar, Object obj, boolean z9) {
        b bVar = new b();
        bVar.f8135a = 0L;
        try {
            OutputStream outputStream = this.f8138a;
            this.f8138a = bVar;
            try {
                dVar.a(obj, this);
                this.f8138a = outputStream;
                long j = bVar.f8135a;
                bVar.close();
                if (z9 && j == 0) {
                    return;
                }
                l((k(cVar) << 3) | 2);
                m(j);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f8138a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void l(int i6) {
        while (true) {
            long j = i6 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            OutputStream outputStream = this.f8138a;
            if (j == 0) {
                outputStream.write(i6 & 127);
                return;
            } else {
                outputStream.write((i6 & 127) | 128);
                i6 >>>= 7;
            }
        }
    }

    public final void m(long j) {
        while (true) {
            long j6 = (-128) & j;
            OutputStream outputStream = this.f8138a;
            if (j6 == 0) {
                outputStream.write(((int) j) & 127);
                return;
            } else {
                outputStream.write((((int) j) & 127) | 128);
                j >>>= 7;
            }
        }
    }
}
