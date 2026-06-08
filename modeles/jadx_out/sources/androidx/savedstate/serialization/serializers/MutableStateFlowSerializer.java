package androidx.savedstate.serialization.serializers;

import b2.t1;
import b8.d;
import b8.e;
import b8.j;
import c8.f;
import com.google.android.gms.internal.measurement.z3;
import l7.m;
import r7.c0;
import r7.k0;
import r7.o0;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableStateFlowSerializer<T> implements b {
    private final e descriptor;
    private final b valueSerializer;

    public MutableStateFlowSerializer(b bVar) {
        e jVar;
        bVar.getClass();
        this.valueSerializer = bVar;
        z3 kind = bVar.getDescriptor().getKind();
        if (kind instanceof d) {
            jVar = t1.a("kotlinx.coroutines.flow.MutableStateFlow", (d) kind);
        } else {
            e descriptor = bVar.getDescriptor();
            descriptor.getClass();
            if (m.z0("kotlinx.coroutines.flow.MutableStateFlow")) {
                com.google.gson.internal.a.p("Blank serial names are prohibited");
                throw null;
            }
            if (descriptor.getKind() instanceof d) {
                com.google.gson.internal.a.p("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead");
                throw null;
            }
            if ("kotlinx.coroutines.flow.MutableStateFlow".equals(descriptor.a())) {
                throw new IllegalArgumentException(("The name of the wrapped descriptor (kotlinx.coroutines.flow.MutableStateFlow) cannot be the same as the name of the original descriptor (" + descriptor.a() + ')').toString());
            }
            jVar = new j(descriptor);
        }
        this.descriptor = jVar;
    }

    @Override // z7.a
    public c0 deserialize(c8.e eVar) {
        eVar.getClass();
        return k0.b(eVar.decodeSerializableValue(this.valueSerializer));
    }

    @Override // z7.h, z7.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // z7.h
    public void serialize(f fVar, c0 c0Var) {
        fVar.getClass();
        c0Var.getClass();
        fVar.encodeSerializableValue(this.valueSerializer, ((o0) c0Var).getValue());
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }
}
