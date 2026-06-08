package androidx.window.layout;

import d7.l;
import kotlin.jvm.internal.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public /* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends k implements l {
    public WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    @Override // d7.l
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator) {
        windowMetricsCalculator.getClass();
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(windowMetricsCalculator);
    }
}
