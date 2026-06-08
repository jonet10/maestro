package androidx.savedstate.serialization;

import b8.e;
import d8.b0;
import d8.b1;
import d8.c;
import d8.c0;
import d8.f;
import d8.h0;
import d8.m;
import d8.q;
import d8.u0;
import d8.v;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SavedStateCodecUtilsKt {
    private static final e booleanArrayDescriptor;
    private static final e charArrayDescriptor;
    private static final e doubleArrayDescriptor;
    private static final e floatArrayDescriptor;
    private static final e intArrayDescriptor;
    private static final e intListDescriptor;
    private static final e longArrayDescriptor;
    private static final e stringArrayDescriptor;
    private static final e stringListDescriptor;

    static {
        c0 c0Var = c0.f3624a;
        u0 u0Var = c0.f3625b;
        u0Var.getClass();
        intListDescriptor = new c(u0Var, 1);
        b1 b1Var = b1.f3621a;
        u0 u0Var2 = b1.f3622b;
        u0Var2.getClass();
        stringListDescriptor = new c(u0Var2, 1);
        booleanArrayDescriptor = f.f3640c.f3710b;
        charArrayDescriptor = m.f3673c.f3710b;
        doubleArrayDescriptor = q.f3693c.f3710b;
        floatArrayDescriptor = v.f3715c.f3710b;
        intArrayDescriptor = b0.f3620c.f3710b;
        longArrayDescriptor = h0.f3651c.f3710b;
        y.a(String.class);
        e descriptor = b1Var.getDescriptor();
        descriptor.getClass();
        stringArrayDescriptor = new c(descriptor, 0);
    }

    public static final e getBooleanArrayDescriptor() {
        return booleanArrayDescriptor;
    }

    public static final e getCharArrayDescriptor() {
        return charArrayDescriptor;
    }

    public static final e getDoubleArrayDescriptor() {
        return doubleArrayDescriptor;
    }

    public static final e getFloatArrayDescriptor() {
        return floatArrayDescriptor;
    }

    public static final e getIntArrayDescriptor() {
        return intArrayDescriptor;
    }

    public static final e getIntListDescriptor() {
        return intListDescriptor;
    }

    public static final e getLongArrayDescriptor() {
        return longArrayDescriptor;
    }

    public static final e getStringArrayDescriptor() {
        return stringArrayDescriptor;
    }

    public static final e getStringListDescriptor() {
        return stringListDescriptor;
    }

    public static /* synthetic */ void getStringArrayDescriptor$annotations() {
    }
}
