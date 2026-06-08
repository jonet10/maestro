package androidx.leanback.widget;

import android.text.TextUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class GuidedActionDiffCallback extends DiffCallback<GuidedAction> {
    static final GuidedActionDiffCallback sInstance = new GuidedActionDiffCallback();

    public static GuidedActionDiffCallback getInstance() {
        return sInstance;
    }

    @Override // androidx.leanback.widget.DiffCallback
    public boolean areContentsTheSame(GuidedAction guidedAction, GuidedAction guidedAction2) {
        return guidedAction == null ? guidedAction2 == null : guidedAction2 != null && guidedAction.getCheckSetId() == guidedAction2.getCheckSetId() && guidedAction.mActionFlags == guidedAction2.mActionFlags && TextUtils.equals(guidedAction.getTitle(), guidedAction2.getTitle()) && TextUtils.equals(guidedAction.getDescription(), guidedAction2.getDescription()) && guidedAction.getInputType() == guidedAction2.getInputType() && TextUtils.equals(guidedAction.getEditTitle(), guidedAction2.getEditTitle()) && TextUtils.equals(guidedAction.getEditDescription(), guidedAction2.getEditDescription()) && guidedAction.getEditInputType() == guidedAction2.getEditInputType() && guidedAction.getDescriptionEditInputType() == guidedAction2.getDescriptionEditInputType();
    }

    @Override // androidx.leanback.widget.DiffCallback
    public boolean areItemsTheSame(GuidedAction guidedAction, GuidedAction guidedAction2) {
        return guidedAction == null ? guidedAction2 == null : guidedAction2 != null && guidedAction.getId() == guidedAction2.getId();
    }
}
