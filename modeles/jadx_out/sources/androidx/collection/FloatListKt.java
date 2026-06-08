package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FloatListKt {
    private static final FloatList EmptyFloatList = new MutableFloatList(0);

    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    public static final FloatList floatListOf(float... fArr) {
        fArr.getClass();
        MutableFloatList mutableFloatList = new MutableFloatList(fArr.length);
        mutableFloatList.plusAssign(fArr);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float f, float f10, float f11) {
        MutableFloatList mutableFloatList = new MutableFloatList(3);
        mutableFloatList.add(f);
        mutableFloatList.add(f10);
        mutableFloatList.add(f11);
        return mutableFloatList;
    }

    public static final FloatList floatListOf(float f) {
        return mutableFloatListOf(f);
    }

    public static final FloatList floatListOf(float f, float f10) {
        return mutableFloatListOf(f, f10);
    }

    public static final FloatList floatListOf(float f, float f10, float f11) {
        return mutableFloatListOf(f, f10, f11);
    }

    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float f) {
        MutableFloatList mutableFloatList = new MutableFloatList(1);
        mutableFloatList.add(f);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float f, float f10) {
        MutableFloatList mutableFloatList = new MutableFloatList(2);
        mutableFloatList.add(f);
        mutableFloatList.add(f10);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    public static final MutableFloatList mutableFloatListOf(float... fArr) {
        fArr.getClass();
        MutableFloatList mutableFloatList = new MutableFloatList(fArr.length);
        mutableFloatList.plusAssign(fArr);
        return mutableFloatList;
    }
}
