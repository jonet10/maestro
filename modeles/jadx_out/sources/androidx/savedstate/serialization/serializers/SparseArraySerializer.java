package androidx.savedstate.serialization.serializers;

import android.util.SparseArray;
import b8.e;
import c8.f;
import d8.c0;
import d8.d;
import d8.o0;
import d8.q0;
import d8.x0;
import java.util.ArrayList;
import java.util.List;
import p6.g;
import z7.b;
import z7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SparseArraySerializer<T> implements b {
    private final e descriptor;
    private final b surrogateSerializer;

    public SparseArraySerializer(b bVar) {
        bVar.getClass();
        b serializer = SparseArraySurrogate.Companion.serializer(bVar);
        this.surrogateSerializer = serializer;
        this.descriptor = serializer.getDescriptor();
    }

    @Override // z7.a
    public SparseArray<T> deserialize(c8.e eVar) {
        eVar.getClass();
        SparseArraySurrogate sparseArraySurrogate = (SparseArraySurrogate) eVar.decodeSerializableValue(this.surrogateSerializer);
        if (sparseArraySurrogate.getKeys().size() != sparseArraySurrogate.getValues().size()) {
            com.google.gson.internal.a.p("Failed requirement.");
            return null;
        }
        SparseArray<T> sparseArray = new SparseArray<>(sparseArraySurrogate.getKeys().size());
        int size = sparseArraySurrogate.getKeys().size();
        for (int i = 0; i < size; i++) {
            sparseArray.append(sparseArraySurrogate.getKeys().get(i).intValue(), sparseArraySurrogate.getValues().get(i));
        }
        return sparseArray;
    }

    @Override // z7.h, z7.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // z7.h
    public void serialize(f fVar, SparseArray<T> sparseArray) {
        fVar.getClass();
        sparseArray.getClass();
        int size = sparseArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i)));
        }
        int size2 = sparseArray.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i6 = 0; i6 < size2; i6++) {
            arrayList2.add(sparseArray.valueAt(i6));
        }
        fVar.encodeSerializableValue(this.surrogateSerializer, new SparseArraySurrogate(arrayList, arrayList2));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SparseArraySurrogate<T> {
        private static final e $cachedDescriptor;
        private final List<Integer> keys;
        private final List<T> values;
        public static final Companion Companion = new Companion(null);
        private static final p6.f[] $childSerializers = {p6.a.c(g.f8438a, new a()), null};

        static {
            q0 q0Var = new q0("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", null, 2);
            q0Var.j("keys", false);
            q0Var.j("values", false);
            $cachedDescriptor = q0Var;
        }

        public /* synthetic */ SparseArraySurrogate(int i, List list, List list2, x0 x0Var) {
            if (3 != (i & 3)) {
                o0.e($cachedDescriptor, i, 3);
                throw null;
            }
            this.keys = list;
            this.values = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new d(c0.f3624a);
        }

        public static final /* synthetic */ void write$Self$savedstate(SparseArraySurrogate sparseArraySurrogate, c8.d dVar, e eVar, b bVar) {
            dVar.encodeSerializableElement(eVar, 0, (h) $childSerializers[0].getValue(), sparseArraySurrogate.keys);
            dVar.encodeSerializableElement(eVar, 1, new d(bVar), sparseArraySurrogate.values);
        }

        public final List<Integer> getKeys() {
            return this.keys;
        }

        public final List<T> getValues() {
            return this.values;
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            private Companion() {
            }

            public final <T> b serializer(b bVar) {
                bVar.getClass();
                return new SparseArraySerializer$SparseArraySurrogate$$serializer(bVar);
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SparseArraySurrogate(List<Integer> list, List<? extends T> list2) {
            list.getClass();
            list2.getClass();
            this.keys = list;
            this.values = list2;
        }
    }
}
