package com.google.gson;

import com.google.gson.internal.o;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d {
    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            k3.b bVar = new k3.b(new o(sb));
            bVar.f6972q = 1;
            com.google.gson.internal.bind.e.f3211z.c(bVar, this);
            return sb.toString();
        } catch (IOException e10) {
            s1.o.j(e10);
            return null;
        }
    }
}
