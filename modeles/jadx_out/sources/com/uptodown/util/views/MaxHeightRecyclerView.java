package com.uptodown.util.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: a, reason: collision with root package name */
    public int f3451a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        this.f3451a = (int) context.getResources().getDimension(2131166526);
    }

    public final int getMaxHeightPx() {
        return this.f3451a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i, int i6) {
        int i10 = this.f3451a;
        if (i10 > 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i6);
    }

    public final void setMaxHeightPx(int i) {
        this.f3451a = i;
    }

    public /* synthetic */ MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i, g gVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MaxHeightRecyclerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        context.getClass();
    }
}
