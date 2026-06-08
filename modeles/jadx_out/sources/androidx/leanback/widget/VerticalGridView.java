package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class VerticalGridView extends BaseGridView {
    public VerticalGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLayoutManager.setOrientation(1);
        initAttributes(context, attributeSet);
    }

    @SuppressLint({"CustomViewStyleable"})
    public void initAttributes(Context context, AttributeSet attributeSet) {
        initBaseGridViewAttributes(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbVerticalGridView);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.lbVerticalGridView, attributeSet, obtainStyledAttributes, 0, 0);
        setColumnWidth(obtainStyledAttributes);
        setNumColumns(obtainStyledAttributes.getInt(R.styleable.lbVerticalGridView_numberOfColumns, 1));
        obtainStyledAttributes.recycle();
    }

    public void setColumnWidth(TypedArray typedArray) {
        if (typedArray.peekValue(R.styleable.lbVerticalGridView_columnWidth) != null) {
            setColumnWidth(typedArray.getLayoutDimension(R.styleable.lbVerticalGridView_columnWidth, 0));
        }
    }

    public void setNumColumns(int i) {
        this.mLayoutManager.setNumRows(i);
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalGridView(Context context) {
        this(context, null);
    }

    public void setColumnWidth(int i) {
        this.mLayoutManager.setRowHeight(i);
        requestLayout();
    }
}
