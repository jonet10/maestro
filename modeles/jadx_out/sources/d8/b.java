package d8;

import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b implements z7.b {
    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        Object obj;
        eVar.getClass();
        z7.e eVar2 = (z7.e) this;
        b8.e descriptor = eVar2.getDescriptor();
        c8.c beginStructure = eVar.beginStructure(descriptor);
        if (beginStructure.decodeSequentially()) {
            obj = beginStructure.decodeSerializableElement(eVar2.getDescriptor(), 1, i5.t(this, beginStructure, beginStructure.decodeStringElement(eVar2.getDescriptor(), 0)), null);
        } else {
            Object obj2 = null;
            String str = null;
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(eVar2.getDescriptor());
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex == 0) {
                        str = beginStructure.decodeStringElement(eVar2.getDescriptor(), decodeElementIndex);
                    } else {
                        if (decodeElementIndex != 1) {
                            StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(decodeElementIndex);
                            throw new z7.g(sb.toString());
                        }
                        if (str == null) {
                            com.google.gson.internal.a.p("Cannot read polymorphic value before its type token");
                            return null;
                        }
                        obj2 = beginStructure.decodeSerializableElement(eVar2.getDescriptor(), decodeElementIndex, i5.t(this, beginStructure, str), null);
                    }
                } else {
                    if (obj2 == null) {
                        s1.o.o(a4.x.j("Polymorphic value has not been read for class ", str));
                        return null;
                    }
                    obj = obj2;
                }
            }
        }
        beginStructure.endStructure(descriptor);
        return obj;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        obj.getClass();
        z7.h u7 = i5.u(this, (c8.b) fVar, obj);
        z7.e eVar = (z7.e) this;
        b8.e descriptor = eVar.getDescriptor();
        c8.d beginStructure = fVar.beginStructure(descriptor);
        beginStructure.encodeStringElement(eVar.getDescriptor(), 0, u7.getDescriptor().a());
        beginStructure.encodeSerializableElement(eVar.getDescriptor(), 1, u7, obj);
        beginStructure.endStructure(descriptor);
    }
}
