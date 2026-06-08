package com.uptodown.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class InstantAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstantAutoCompleteTextView(Context context) {
        super(context);
        context.getClass();
    }

    @Override // android.widget.AutoCompleteTextView
    public final boolean enoughToFilter() {
        return true;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z9, int i, Rect rect) {
        super.onFocusChanged(z9, i, rect);
        if (!z9 || getAdapter() == null) {
            return;
        }
        performFiltering(getText(), 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
    }
}
