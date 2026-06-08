package androidx.savedstate.serialization.serializers;

import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import b8.e;
import c8.c;
import d8.d;
import d8.q0;
import d8.x;
import f8.l;
import java.util.List;
import p6.f;
import z7.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class SparseArraySerializer$SparseArraySurrogate$$serializer<T> implements x {
    private final e descriptor;
    private final /* synthetic */ b typeSerial0;

    private SparseArraySerializer$SparseArraySurrogate$$serializer() {
        q0 q0Var = new q0("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", this, 2);
        q0Var.j("keys", false);
        q0Var.j("values", false);
        this.descriptor = q0Var;
    }

    private final /* synthetic */ b getTypeSerial0() {
        return this.typeSerial0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d8.x
    public final b[] childSerializers() {
        f[] fVarArr;
        fVarArr = SparseArraySerializer.SparseArraySurrogate.$childSerializers;
        return new b[]{fVarArr[0].getValue(), new d(this.typeSerial0)};
    }

    @Override // z7.a
    public final SparseArraySerializer.SparseArraySurrogate<T> deserialize(c8.e eVar) {
        f[] fVarArr;
        List list;
        List list2;
        int i;
        eVar.getClass();
        e eVar2 = this.descriptor;
        c beginStructure = eVar.beginStructure(eVar2);
        fVarArr = SparseArraySerializer.SparseArraySurrogate.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeSerializableElement(eVar2, 0, (z7.a) fVarArr[0].getValue(), null);
            list2 = (List) beginStructure.decodeSerializableElement(eVar2, 1, new d(this.typeSerial0), null);
            i = 3;
        } else {
            boolean z9 = true;
            int i6 = 0;
            List list3 = null;
            List list4 = null;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(eVar2);
                if (decodeElementIndex == -1) {
                    z9 = false;
                } else if (decodeElementIndex == 0) {
                    list3 = (List) beginStructure.decodeSerializableElement(eVar2, 0, (z7.a) fVarArr[0].getValue(), list3);
                    i6 |= 1;
                } else {
                    if (decodeElementIndex != 1) {
                        throw new l(decodeElementIndex);
                    }
                    list4 = (List) beginStructure.decodeSerializableElement(eVar2, 1, new d(this.typeSerial0), list4);
                    i6 |= 2;
                }
            }
            list = list3;
            list2 = list4;
            i = i6;
        }
        beginStructure.endStructure(eVar2);
        return new SparseArraySerializer.SparseArraySurrogate<>(i, list, list2, null);
    }

    @Override // z7.h, z7.a
    public final e getDescriptor() {
        return this.descriptor;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, SparseArraySerializer.SparseArraySurrogate<T> sparseArraySurrogate) {
        fVar.getClass();
        sparseArraySurrogate.getClass();
        e eVar = this.descriptor;
        c8.d beginStructure = fVar.beginStructure(eVar);
        SparseArraySerializer.SparseArraySurrogate.write$Self$savedstate(sparseArraySurrogate, beginStructure, eVar, this.typeSerial0);
        beginStructure.endStructure(eVar);
    }

    @Override // d8.x
    public final b[] typeParametersSerializers() {
        return new b[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparseArraySerializer$SparseArraySurrogate$$serializer(b bVar) {
        this();
        bVar.getClass();
        this.typeSerial0 = bVar;
    }
}
