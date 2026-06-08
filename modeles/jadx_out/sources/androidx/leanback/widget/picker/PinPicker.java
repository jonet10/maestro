package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class PinPicker extends Picker {
    private static final int DEFAULT_COLUMN_COUNT = 4;

    @SuppressLint({"CustomViewStyleable"})
    public PinPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbPinPicker, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.lbPinPicker, attributeSet, obtainStyledAttributes, i, 0);
        try {
            setSeparator(" ");
            setNumberOfColumns(obtainStyledAttributes.getInt(R.styleable.lbPinPicker_columnCount, 4));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.leanback.widget.picker.Picker, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 1 || keyCode < 7 || keyCode > 16) {
            return super.dispatchKeyEvent(keyEvent);
        }
        setColumnValue(getSelectedColumn(), keyCode - 7, false);
        performClick();
        return true;
    }

    public String getPin() {
        StringBuilder sb = new StringBuilder();
        int columnsCount = getColumnsCount();
        for (int i = 0; i < columnsCount; i++) {
            sb.append(Integer.toString(getColumnAt(i).getCurrentValue()));
        }
        return sb.toString();
    }

    @Override // android.view.View
    public boolean performClick() {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn == getColumnsCount() - 1) {
            return super.performClick();
        }
        setSelectedColumn(selectedColumn + 1);
        return false;
    }

    public void resetPin() {
        int columnsCount = getColumnsCount();
        for (int i = 0; i < columnsCount; i++) {
            setColumnValue(i, 0, false);
        }
        setSelectedColumn(0);
    }

    public void setNumberOfColumns(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i6 = 0; i6 < i; i6++) {
            PickerColumn pickerColumn = new PickerColumn();
            pickerColumn.setMinValue(0);
            pickerColumn.setMaxValue(9);
            pickerColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
            arrayList.add(pickerColumn);
        }
        setColumns(arrayList);
    }

    public PinPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinPickerStyle);
    }
}
