package com.google.gson.internal.bind;

import androidx.lifecycle.l;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class NumberTypeAdapter extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final j f3152b = d(2);

    /* renamed from: a, reason: collision with root package name */
    public final int f3153a;

    public NumberTypeAdapter(int i) {
        this.f3153a = i;
    }

    public static j d(int i) {
        return new j() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                if (typeToken.f3266a == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        int H = aVar.H();
        int c9 = c.j.c(H);
        if (c9 == 5 || c9 == 6) {
            return l.f(this.f3153a, aVar);
        }
        if (c9 == 8) {
            aVar.D();
            return null;
        }
        throw new com.google.gson.e("Expecting number, got: " + k.m(H) + "; at path " + aVar.j(false));
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        bVar.B((Number) obj);
    }
}
