package f8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends c8.b {

    /* renamed from: a, reason: collision with root package name */
    public final a2.i f4986a;

    /* renamed from: b, reason: collision with root package name */
    public final e8.b f4987b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f4988c;

    /* renamed from: d, reason: collision with root package name */
    public final y[] f4989d;

    /* renamed from: e, reason: collision with root package name */
    public final g8.f f4990e;
    public final e8.h f;
    public boolean g;
    public String h;
    public String i;

    public y(a2.i iVar, e8.b bVar, c0 c0Var, y[] yVarArr) {
        iVar.getClass();
        this.f4986a = iVar;
        this.f4987b = bVar;
        this.f4988c = c0Var;
        this.f4989d = yVarArr;
        this.f4990e = bVar.f4762b;
        this.f = bVar.f4761a;
        int ordinal = c0Var.ordinal();
        if (yVarArr != null) {
            y yVar = yVarArr[ordinal];
            if (yVar == null && yVar == this) {
                return;
            }
            yVarArr[ordinal] = this;
        }
    }

    @Override // c8.b, c8.f
    public final c8.d beginStructure(b8.e eVar) {
        y yVar;
        eVar.getClass();
        e8.b bVar = this.f4987b;
        c0 n10 = m.n(eVar, bVar);
        char c9 = n10.f4947a;
        a2.i iVar = this.f4986a;
        iVar.d(c9);
        iVar.f22a = true;
        String str = this.h;
        if (str != null) {
            String str2 = this.i;
            if (str2 == null) {
                str2 = eVar.a();
            }
            iVar.b();
            iVar.h(str);
            iVar.d(':');
            encodeString(str2);
            this.h = null;
            this.i = null;
        }
        if (this.f4988c == n10) {
            return this;
        }
        y[] yVarArr = this.f4989d;
        return (yVarArr == null || (yVar = yVarArr[n10.ordinal()]) == null) ? new y(iVar, bVar, n10, yVarArr) : yVar;
    }

    @Override // c8.b, c8.f
    public final void encodeBoolean(boolean z9) {
        if (this.g) {
            encodeString(String.valueOf(z9));
        } else {
            ((q) this.f4986a.f23b).i(String.valueOf(z9));
        }
    }

    @Override // c8.b, c8.f
    public final void encodeByte(byte b7) {
        if (this.g) {
            encodeString(String.valueOf((int) b7));
        } else {
            this.f4986a.c(b7);
        }
    }

    @Override // c8.b, c8.f
    public final void encodeChar(char c9) {
        encodeString(String.valueOf(c9));
    }

    @Override // c8.b, c8.f
    public final void encodeDouble(double d10) {
        boolean z9 = this.g;
        a2.i iVar = this.f4986a;
        if (z9) {
            encodeString(String.valueOf(d10));
        } else {
            ((q) iVar.f23b).i(String.valueOf(d10));
        }
        this.f.getClass();
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            throw m.b(Double.valueOf(d10), ((q) iVar.f23b).toString());
        }
    }

    @Override // c8.b
    public final boolean encodeElement(b8.e eVar, int i) {
        eVar.getClass();
        int ordinal = this.f4988c.ordinal();
        a2.i iVar = this.f4986a;
        if (ordinal == 1) {
            if (!iVar.f22a) {
                iVar.d(',');
            }
            iVar.b();
            return true;
        }
        boolean z9 = false;
        if (ordinal == 2) {
            if (iVar.f22a) {
                this.g = true;
                iVar.b();
                return true;
            }
            if (i % 2 == 0) {
                iVar.d(',');
                iVar.b();
                z9 = true;
            } else {
                iVar.d(':');
                iVar.i();
            }
            this.g = z9;
            return true;
        }
        if (ordinal == 3) {
            if (i == 0) {
                this.g = true;
            }
            if (i == 1) {
                iVar.d(',');
                iVar.i();
                this.g = false;
            }
            return true;
        }
        if (!iVar.f22a) {
            iVar.d(',');
        }
        iVar.b();
        m.l(eVar, this.f4987b);
        encodeString(eVar.f(i));
        iVar.d(':');
        iVar.i();
        return true;
    }

    @Override // c8.b, c8.f
    public final void encodeFloat(float f) {
        boolean z9 = this.g;
        a2.i iVar = this.f4986a;
        if (z9) {
            encodeString(String.valueOf(f));
        } else {
            ((q) iVar.f23b).i(String.valueOf(f));
        }
        this.f.getClass();
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw m.b(Float.valueOf(f), ((q) iVar.f23b).toString());
        }
    }

    @Override // c8.b, c8.f
    public final c8.f encodeInline(b8.e eVar) {
        eVar.getClass();
        boolean a8 = z.a(eVar);
        c0 c0Var = this.f4988c;
        e8.b bVar = this.f4987b;
        a2.i iVar = this.f4986a;
        if (a8) {
            if (!(iVar instanceof f)) {
                iVar = new f((q) iVar.f23b, this.g);
            }
            return new y(iVar, bVar, c0Var, null);
        }
        if (eVar.isInline() && eVar.equals(e8.l.f4775a)) {
            if (!(iVar instanceof e)) {
                iVar = new e((q) iVar.f23b, this.g);
            }
            return new y(iVar, bVar, c0Var, null);
        }
        if (this.h == null) {
            return super.encodeInline(eVar);
        }
        this.i = eVar.a();
        return this;
    }

    @Override // c8.b, c8.f
    public final void encodeInt(int i) {
        if (this.g) {
            encodeString(String.valueOf(i));
        } else {
            this.f4986a.e(i);
        }
    }

    @Override // c8.b, c8.f
    public final void encodeLong(long j) {
        if (this.g) {
            encodeString(String.valueOf(j));
        } else {
            this.f4986a.f(j);
        }
    }

    @Override // c8.f
    public final void encodeNull() {
        a2.i iVar = this.f4986a;
        iVar.getClass();
        ((q) iVar.f23b).i("null");
    }

    @Override // c8.b, c8.d
    public final void encodeNullableSerializableElement(b8.e eVar, int i, z7.h hVar, Object obj) {
        eVar.getClass();
        hVar.getClass();
        if (obj != null || this.f.f4770a) {
            super.encodeNullableSerializableElement(eVar, i, hVar, obj);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x003c, code lost:
    
        if (kotlin.jvm.internal.l.a(r1, b8.i.f1118k) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r1 != e8.a.f4757a) goto L20;
     */
    @Override // c8.b, c8.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void encodeSerializableValue(z7.h r5, java.lang.Object r6) {
        /*
            r4 = this;
            r5.getClass()
            e8.b r0 = r4.f4987b
            e8.h r1 = r0.f4761a
            r1.getClass()
            boolean r2 = r5 instanceof d8.b
            e8.a r1 = r1.f4774e
            if (r2 == 0) goto L15
            e8.a r3 = e8.a.f4757a
            if (r1 == r3) goto L47
            goto L3e
        L15:
            int r1 = r1.ordinal()
            if (r1 == 0) goto L47
            r3 = 1
            if (r1 == r3) goto L26
            r0 = 2
            if (r1 != r0) goto L22
            goto L47
        L22:
            com.google.gson.internal.a.b()
            return
        L26:
            b8.e r1 = r5.getDescriptor()
            com.google.android.gms.internal.measurement.z3 r1 = r1.getKind()
            b8.i r3 = b8.i.h
            boolean r3 = kotlin.jvm.internal.l.a(r1, r3)
            if (r3 != 0) goto L3e
            b8.i r3 = b8.i.f1118k
            boolean r1 = kotlin.jvm.internal.l.a(r1, r3)
            if (r1 == 0) goto L47
        L3e:
            b8.e r1 = r5.getDescriptor()
            java.lang.String r0 = f8.m.h(r1, r0)
            goto L48
        L47:
            r0 = 0
        L48:
            if (r2 == 0) goto La9
            r1 = r5
            d8.b r1 = (d8.b) r1
            if (r6 == 0) goto L9b
            z7.h r1 = com.google.android.gms.internal.measurement.i5.u(r1, r4, r6)
            if (r0 == 0) goto L70
            boolean r5 = r5 instanceof z7.f
            if (r5 != 0) goto L5a
            goto L70
        L5a:
            b8.e r5 = r1.getDescriptor()
            r5.getClass()
            java.util.Set r5 = d8.o0.b(r5)
            boolean r5 = r5.contains(r0)
            if (r5 != 0) goto L6c
            goto L70
        L6c:
            com.google.gson.internal.a.o()
            return
        L70:
            b8.e r5 = r1.getDescriptor()
            com.google.android.gms.internal.measurement.z3 r5 = r5.getKind()
            r5.getClass()
            boolean r2 = r5 instanceof b8.h
            if (r2 != 0) goto L95
            boolean r2 = r5 instanceof b8.d
            if (r2 != 0) goto L8f
            boolean r5 = r5 instanceof b8.c
            if (r5 != 0) goto L89
            r5 = r1
            goto La9
        L89:
            java.lang.String r5 = "Actual serializer for polymorphic cannot be polymorphic itself"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            return
        L8f:
            java.lang.String r5 = "Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            return
        L95:
            java.lang.String r5 = "Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            return
        L9b:
            z7.e r1 = (z7.e) r1
            b8.e r5 = r1.getDescriptor()
            java.lang.String r6 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            java.lang.String r0 = "Value for serializer "
            androidx.core.view.contentcapture.a.q(r5, r0, r6)
            return
        La9:
            if (r0 == 0) goto Lb7
            b8.e r1 = r5.getDescriptor()
            java.lang.String r1 = r1.a()
            r4.h = r0
            r4.i = r1
        Lb7:
            r5.serialize(r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.y.encodeSerializableValue(z7.h, java.lang.Object):void");
    }

    @Override // c8.b, c8.f
    public final void encodeShort(short s6) {
        if (this.g) {
            encodeString(String.valueOf((int) s6));
        } else {
            this.f4986a.g(s6);
        }
    }

    @Override // c8.b, c8.f
    public final void encodeString(String str) {
        str.getClass();
        this.f4986a.h(str);
    }

    @Override // c8.b, c8.d
    public final void endStructure(b8.e eVar) {
        eVar.getClass();
        a2.i iVar = this.f4986a;
        iVar.getClass();
        iVar.f22a = false;
        iVar.d(this.f4988c.f4948b);
    }

    @Override // c8.f
    public final g8.f getSerializersModule() {
        return this.f4990e;
    }

    @Override // c8.b, c8.d
    public final boolean shouldEncodeElementDefault(b8.e eVar, int i) {
        eVar.getClass();
        this.f.getClass();
        return false;
    }
}
