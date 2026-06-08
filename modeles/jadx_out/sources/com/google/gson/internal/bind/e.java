package com.google.gson.internal.bind;

import a4.x;
import com.google.gson.i;
import com.google.gson.internal.f;
import com.google.gson.internal.h;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e {
    public static final j A;
    public static final j B;

    /* renamed from: a, reason: collision with root package name */
    public static final j f3192a = new TypeAdapters$29(Class.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$1
        @Override // com.google.gson.i
        public final Object b(k3.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee ".concat("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported")));
        }

        @Override // com.google.gson.i
        public final void c(k3.b bVar, Object obj) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }
    }.a());

    /* renamed from: b, reason: collision with root package name */
    public static final j f3193b = new TypeAdapters$29(BitSet.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$2
        @Override // com.google.gson.i
        public final Object b(k3.a aVar) {
            boolean z9;
            BitSet bitSet = new BitSet();
            aVar.b();
            int H = aVar.H();
            int i6 = 0;
            while (H != 2) {
                int c9 = c.j.c(H);
                if (c9 == 5 || c9 == 6) {
                    int z10 = aVar.z();
                    if (z10 == 0) {
                        z9 = false;
                    } else {
                        if (z10 != 1) {
                            StringBuilder p10 = x.p(z10, "Invalid bitset value ", ", expected 0 or 1; at path ");
                            p10.append(aVar.j(true));
                            throw new com.google.gson.e(p10.toString());
                        }
                        z9 = true;
                    }
                } else {
                    if (c9 != 7) {
                        throw new com.google.gson.e("Invalid bitset value type: " + k.m(H) + "; at path " + aVar.j(false));
                    }
                    z9 = aVar.u();
                }
                if (z9) {
                    bitSet.set(i6);
                }
                i6++;
                H = aVar.H();
            }
            aVar.f();
            return bitSet;
        }

        @Override // com.google.gson.i
        public final void c(k3.b bVar, Object obj) {
            BitSet bitSet = (BitSet) obj;
            bVar.c();
            int length = bitSet.length();
            for (int i6 = 0; i6 < length; i6++) {
                bVar.A(bitSet.get(i6) ? 1L : 0L);
            }
            bVar.f();
        }
    }.a());

    /* renamed from: c, reason: collision with root package name */
    public static final i f3194c;

    /* renamed from: d, reason: collision with root package name */
    public static final j f3195d;

    /* renamed from: e, reason: collision with root package name */
    public static final j f3196e;
    public static final j f;
    public static final j g;
    public static final j h;
    public static final j i;
    public static final j j;

    /* renamed from: k, reason: collision with root package name */
    public static final i f3197k;

    /* renamed from: l, reason: collision with root package name */
    public static final j f3198l;

    /* renamed from: m, reason: collision with root package name */
    public static final i f3199m;

    /* renamed from: n, reason: collision with root package name */
    public static final i f3200n;

    /* renamed from: o, reason: collision with root package name */
    public static final i f3201o;

    /* renamed from: p, reason: collision with root package name */
    public static final j f3202p;

    /* renamed from: q, reason: collision with root package name */
    public static final j f3203q;

    /* renamed from: r, reason: collision with root package name */
    public static final j f3204r;

    /* renamed from: s, reason: collision with root package name */
    public static final j f3205s;

    /* renamed from: t, reason: collision with root package name */
    public static final j f3206t;

    /* renamed from: u, reason: collision with root package name */
    public static final j f3207u;
    public static final j v;

    /* renamed from: w, reason: collision with root package name */
    public static final j f3208w;

    /* renamed from: x, reason: collision with root package name */
    public static final j f3209x;

    /* renamed from: y, reason: collision with root package name */
    public static final j f3210y;

    /* renamed from: z, reason: collision with root package name */
    public static final i f3211z;

    static {
        i iVar = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$3
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                int H = aVar.H();
                if (H != 9) {
                    return H == 6 ? Boolean.valueOf(Boolean.parseBoolean(aVar.F())) : Boolean.valueOf(aVar.u());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                Boolean bool = (Boolean) obj;
                if (bool == null) {
                    bVar.n();
                    return;
                }
                bVar.E();
                bVar.b();
                bVar.f6965a.write(bool.booleanValue() ? "true" : "false");
            }
        };
        f3194c = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$4
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return Boolean.valueOf(aVar.F());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                Boolean bool = (Boolean) obj;
                bVar.C(bool == null ? "null" : bool.toString());
            }
        };
        f3195d = new TypeAdapters$30(Boolean.TYPE, Boolean.class, iVar);
        f3196e = new TypeAdapters$30(Byte.TYPE, Byte.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$5
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                try {
                    int z9 = aVar.z();
                    if (z9 <= 255 && z9 >= -128) {
                        return Byte.valueOf((byte) z9);
                    }
                    StringBuilder p10 = x.p(z9, "Lossy conversion from ", " to byte; at path ");
                    p10.append(aVar.j(true));
                    throw new com.google.gson.e(p10.toString());
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.e(e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                if (((Number) obj) == null) {
                    bVar.n();
                } else {
                    bVar.A(r4.byteValue());
                }
            }
        });
        f = new TypeAdapters$30(Short.TYPE, Short.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$6
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                try {
                    int z9 = aVar.z();
                    if (z9 <= 65535 && z9 >= -32768) {
                        return Short.valueOf((short) z9);
                    }
                    StringBuilder p10 = x.p(z9, "Lossy conversion from ", " to short; at path ");
                    p10.append(aVar.j(true));
                    throw new com.google.gson.e(p10.toString());
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.e(e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                if (((Number) obj) == null) {
                    bVar.n();
                } else {
                    bVar.A(r4.shortValue());
                }
            }
        });
        g = new TypeAdapters$30(Integer.TYPE, Integer.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$7
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.z());
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.e(e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                if (((Number) obj) == null) {
                    bVar.n();
                } else {
                    bVar.A(r4.intValue());
                }
            }
        });
        h = new TypeAdapters$29(AtomicInteger.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$8
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                try {
                    return new AtomicInteger(aVar.z());
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.e(e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.A(((AtomicInteger) obj).get());
            }
        }.a());
        i = new TypeAdapters$29(AtomicBoolean.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$9
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                return new AtomicBoolean(aVar.u());
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.D(((AtomicBoolean) obj).get());
            }
        }.a());
        j = new TypeAdapters$29(AtomicIntegerArray.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$10
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                ArrayList arrayList = new ArrayList();
                aVar.b();
                while (aVar.n()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.z()));
                    } catch (NumberFormatException e10) {
                        throw new com.google.gson.e(e10);
                    }
                }
                aVar.f();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i6 = 0; i6 < size; i6++) {
                    atomicIntegerArray.set(i6, ((Integer) arrayList.get(i6)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.c();
                int length = ((AtomicIntegerArray) obj).length();
                for (int i6 = 0; i6 < length; i6++) {
                    bVar.A(r6.get(i6));
                }
                bVar.f();
            }
        }.a());
        f3197k = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$11
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.A());
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.e(e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                Number number = (Number) obj;
                if (number == null) {
                    bVar.n();
                } else {
                    bVar.A(number.longValue());
                }
            }
        };
        new i() { // from class: com.google.gson.internal.bind.TypeAdapters$12
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return Float.valueOf((float) aVar.y());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                Number number = (Number) obj;
                if (number == null) {
                    bVar.n();
                    return;
                }
                if (!(number instanceof Float)) {
                    number = Float.valueOf(number.floatValue());
                }
                bVar.B(number);
            }
        };
        new i() { // from class: com.google.gson.internal.bind.TypeAdapters$13
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return Double.valueOf(aVar.y());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                Number number = (Number) obj;
                if (number == null) {
                    bVar.n();
                } else {
                    bVar.z(number.doubleValue());
                }
            }
        };
        f3198l = new TypeAdapters$30(Character.TYPE, Character.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$14
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                String F = aVar.F();
                if (F.length() == 1) {
                    return Character.valueOf(F.charAt(0));
                }
                StringBuilder v9 = x.v("Expecting character, got: ", F, "; at ");
                v9.append(aVar.j(true));
                throw new com.google.gson.e(v9.toString());
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                Character ch = (Character) obj;
                bVar.C(ch == null ? null : String.valueOf(ch));
            }
        });
        i iVar2 = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$15
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                int H = aVar.H();
                if (H != 9) {
                    return H == 8 ? Boolean.toString(aVar.u()) : aVar.F();
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.C((String) obj);
            }
        };
        f3199m = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$16
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                String F = aVar.F();
                try {
                    return f.i(F);
                } catch (NumberFormatException e10) {
                    StringBuilder v9 = x.v("Failed parsing '", F, "' as BigDecimal; at path ");
                    v9.append(aVar.j(true));
                    throw new com.google.gson.e(v9.toString(), e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.B((BigDecimal) obj);
            }
        };
        f3200n = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$17
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                String F = aVar.F();
                try {
                    f.c(F);
                    return new BigInteger(F);
                } catch (NumberFormatException e10) {
                    StringBuilder v9 = x.v("Failed parsing '", F, "' as BigInteger; at path ");
                    v9.append(aVar.j(true));
                    throw new com.google.gson.e(v9.toString(), e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.B((BigInteger) obj);
            }
        };
        f3201o = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$18
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return new h(aVar.F());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.B((h) obj);
            }
        };
        f3202p = new TypeAdapters$29(String.class, iVar2);
        f3203q = new TypeAdapters$29(StringBuilder.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$19
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return new StringBuilder(aVar.F());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                StringBuilder sb = (StringBuilder) obj;
                bVar.C(sb == null ? null : sb.toString());
            }
        });
        f3204r = new TypeAdapters$29(StringBuffer.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$20
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return new StringBuffer(aVar.F());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                StringBuffer stringBuffer = (StringBuffer) obj;
                bVar.C(stringBuffer == null ? null : stringBuffer.toString());
            }
        });
        f3205s = new TypeAdapters$29(URL.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$21
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                String F = aVar.F();
                if (F.equals("null")) {
                    return null;
                }
                return new URL(F);
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                URL url = (URL) obj;
                bVar.C(url == null ? null : url.toExternalForm());
            }
        });
        f3206t = new TypeAdapters$29(URI.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$22
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                try {
                    String F = aVar.F();
                    if (F.equals("null")) {
                        return null;
                    }
                    return new URI(F);
                } catch (URISyntaxException e10) {
                    throw new com.google.gson.e(e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                URI uri = (URI) obj;
                bVar.C(uri == null ? null : uri.toASCIIString());
            }
        });
        final i iVar3 = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$23
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return InetAddress.getByName(aVar.F());
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                InetAddress inetAddress = (InetAddress) obj;
                bVar.C(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        final Class<InetAddress> cls = InetAddress.class;
        f3207u = new j() { // from class: com.google.gson.internal.bind.TypeAdapters$32
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                final Class<?> cls2 = typeToken.f3266a;
                if (cls.isAssignableFrom(cls2)) {
                    return new i() { // from class: com.google.gson.internal.bind.TypeAdapters$32.1
                        @Override // com.google.gson.i
                        public final Object b(k3.a aVar) {
                            Object b7 = iVar3.b(aVar);
                            if (b7 != null) {
                                Class cls3 = cls2;
                                if (!cls3.isInstance(b7)) {
                                    throw new com.google.gson.e("Expected a " + cls3.getName() + " but was " + b7.getClass().getName() + "; at path " + aVar.j(true));
                                }
                            }
                            return b7;
                        }

                        @Override // com.google.gson.i
                        public final void c(k3.b bVar2, Object obj) {
                            iVar3.c(bVar2, obj);
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + iVar3 + "]";
            }
        };
        v = new TypeAdapters$29(UUID.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$24
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                String F = aVar.F();
                try {
                    return UUID.fromString(F);
                } catch (IllegalArgumentException e10) {
                    StringBuilder v9 = x.v("Failed parsing '", F, "' as UUID; at path ");
                    v9.append(aVar.j(true));
                    throw new com.google.gson.e(v9.toString(), e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                UUID uuid = (UUID) obj;
                bVar.C(uuid == null ? null : uuid.toString());
            }
        });
        f3208w = new TypeAdapters$29(Currency.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$25
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                String F = aVar.F();
                try {
                    return Currency.getInstance(F);
                } catch (IllegalArgumentException e10) {
                    StringBuilder v9 = x.v("Failed parsing '", F, "' as Currency; at path ");
                    v9.append(aVar.j(true));
                    throw new com.google.gson.e(v9.toString(), e10);
                }
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                bVar.C(((Currency) obj).getCurrencyCode());
            }
        }.a());
        final i iVar4 = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$26
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x0041, code lost:
            
                if (r1.equals("month") == false) goto L11;
             */
            @Override // com.google.gson.i
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object b(k3.a r13) {
                /*
                    r12 = this;
                    int r0 = r13.H()
                    r1 = 9
                    if (r0 != r1) goto Ld
                    r13.D()
                    r13 = 0
                    return r13
                Ld:
                    r13.c()
                    r0 = 0
                    r2 = r0
                    r3 = r2
                    r4 = r3
                    r5 = r4
                    r6 = r5
                    r7 = r6
                L17:
                    int r1 = r13.H()
                    r8 = 4
                    if (r1 == r8) goto L7f
                    java.lang.String r1 = r13.B()
                    int r9 = r13.z()
                    int r10 = r1.hashCode()
                    r11 = -1
                    switch(r10) {
                        case -1181204563: goto L65;
                        case -1074026988: goto L5a;
                        case -906279820: goto L4f;
                        case 3704893: goto L44;
                        case 104080000: goto L3b;
                        case 985252545: goto L30;
                        default: goto L2e;
                    }
                L2e:
                    r8 = r11
                    goto L6f
                L30:
                    java.lang.String r8 = "hourOfDay"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L39
                    goto L2e
                L39:
                    r8 = 5
                    goto L6f
                L3b:
                    java.lang.String r10 = "month"
                    boolean r1 = r1.equals(r10)
                    if (r1 != 0) goto L6f
                    goto L2e
                L44:
                    java.lang.String r8 = "year"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L4d
                    goto L2e
                L4d:
                    r8 = 3
                    goto L6f
                L4f:
                    java.lang.String r8 = "second"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L58
                    goto L2e
                L58:
                    r8 = 2
                    goto L6f
                L5a:
                    java.lang.String r8 = "minute"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L63
                    goto L2e
                L63:
                    r8 = 1
                    goto L6f
                L65:
                    java.lang.String r8 = "dayOfMonth"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L6e
                    goto L2e
                L6e:
                    r8 = r0
                L6f:
                    switch(r8) {
                        case 0: goto L7d;
                        case 1: goto L7b;
                        case 2: goto L79;
                        case 3: goto L77;
                        case 4: goto L75;
                        case 5: goto L73;
                        default: goto L72;
                    }
                L72:
                    goto L17
                L73:
                    r5 = r9
                    goto L17
                L75:
                    r3 = r9
                    goto L17
                L77:
                    r2 = r9
                    goto L17
                L79:
                    r7 = r9
                    goto L17
                L7b:
                    r6 = r9
                    goto L17
                L7d:
                    r4 = r9
                    goto L17
                L7f:
                    r13.h()
                    java.util.GregorianCalendar r1 = new java.util.GregorianCalendar
                    r1.<init>(r2, r3, r4, r5, r6, r7)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters$26.b(k3.a):java.lang.Object");
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                if (((Calendar) obj) == null) {
                    bVar.n();
                    return;
                }
                bVar.d();
                bVar.i("year");
                bVar.A(r4.get(1));
                bVar.i("month");
                bVar.A(r4.get(2));
                bVar.i("dayOfMonth");
                bVar.A(r4.get(5));
                bVar.i("hourOfDay");
                bVar.A(r4.get(11));
                bVar.i("minute");
                bVar.A(r4.get(12));
                bVar.i("second");
                bVar.A(r4.get(13));
                bVar.h();
            }
        };
        f3209x = new j() { // from class: com.google.gson.internal.bind.TypeAdapters$31
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                Class cls2 = typeToken.f3266a;
                if (cls2 == Calendar.class || cls2 == GregorianCalendar.class) {
                    return i.this;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + i.this + "]";
            }
        };
        f3210y = new TypeAdapters$29(Locale.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$27
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() == 9) {
                    aVar.D();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.F(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                Locale locale = (Locale) obj;
                bVar.C(locale == null ? null : locale.toString());
            }
        });
        final JsonElementTypeAdapter jsonElementTypeAdapter = JsonElementTypeAdapter.f3147a;
        f3211z = jsonElementTypeAdapter;
        final Class<com.google.gson.d> cls2 = com.google.gson.d.class;
        A = new j() { // from class: com.google.gson.internal.bind.TypeAdapters$32
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                final Class cls22 = typeToken.f3266a;
                if (cls2.isAssignableFrom(cls22)) {
                    return new i() { // from class: com.google.gson.internal.bind.TypeAdapters$32.1
                        @Override // com.google.gson.i
                        public final Object b(k3.a aVar) {
                            Object b7 = jsonElementTypeAdapter.b(aVar);
                            if (b7 != null) {
                                Class cls3 = cls22;
                                if (!cls3.isInstance(b7)) {
                                    throw new com.google.gson.e("Expected a " + cls3.getName() + " but was " + b7.getClass().getName() + "; at path " + aVar.j(true));
                                }
                            }
                            return b7;
                        }

                        @Override // com.google.gson.i
                        public final void c(k3.b bVar2, Object obj) {
                            jsonElementTypeAdapter.c(bVar2, obj);
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls2.getName() + ",adapter=" + jsonElementTypeAdapter + "]";
            }
        };
        B = EnumTypeAdapter.f3140d;
    }

    public static j a(Class cls, i iVar) {
        return new TypeAdapters$29(cls, iVar);
    }

    public static j b(Class cls, Class cls2, i iVar) {
        return new TypeAdapters$30(cls, cls2, iVar);
    }
}
