package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.g;
import r6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class Feature {
    private final List<Cubic> cubics;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Edge extends Feature {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edge(List<? extends Cubic> list) {
            super(list);
            list.getClass();
        }

        public String toString() {
            return "Edge";
        }

        @Override // androidx.graphics.shapes.Feature
        public Edge transformed$graphics_shapes_release(PointTransformer pointTransformer) {
            pointTransformer.getClass();
            c t9 = a.a.t();
            int size = getCubics().size();
            for (int i = 0; i < size; i++) {
                t9.add(getCubics().get(i).transformed(pointTransformer));
            }
            return new Edge(a.a.m(t9));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Feature(List<? extends Cubic> list) {
        list.getClass();
        this.cubics = list;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public abstract Feature transformed$graphics_shapes_release(PointTransformer pointTransformer);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Corner extends Feature {
        private final boolean convex;
        private final long roundedCenter;
        private final long vertex;

        public /* synthetic */ Corner(List list, long j, long j6, boolean z9, int i, g gVar) {
            this(list, j, j6, (i & 8) != 0 ? true : z9, null);
        }

        public final boolean getConvex() {
            return this.convex;
        }

        /* renamed from: getRoundedCenter-1ufDz9w, reason: not valid java name */
        public final long m48getRoundedCenter1ufDz9w() {
            return this.roundedCenter;
        }

        /* renamed from: getVertex-1ufDz9w, reason: not valid java name */
        public final long m49getVertex1ufDz9w() {
            return this.vertex;
        }

        public String toString() {
            return "Corner: vertex=" + ((Object) FloatFloatPair.m16toStringimpl(this.vertex)) + ", center=" + ((Object) FloatFloatPair.m16toStringimpl(this.roundedCenter)) + ", convex=" + this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        public Feature transformed$graphics_shapes_release(PointTransformer pointTransformer) {
            pointTransformer.getClass();
            c t9 = a.a.t();
            int size = getCubics().size();
            for (int i = 0; i < size; i++) {
                t9.add(getCubics().get(i).transformed(pointTransformer));
            }
            return new Corner(a.a.m(t9), PointKt.m66transformedso9K2fw(this.vertex, pointTransformer), PointKt.m66transformedso9K2fw(this.roundedCenter, pointTransformer), this.convex, null);
        }

        public /* synthetic */ Corner(List list, long j, long j6, boolean z9, g gVar) {
            this(list, j, j6, z9);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Corner(List<? extends Cubic> list, long j, long j6, boolean z9) {
            super(list);
            list.getClass();
            this.vertex = j;
            this.roundedCenter = j6;
            this.convex = z9;
        }
    }
}
