package androidx.leanback.widget;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import java.lang.ref.WeakReference;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class FullWidthDetailsOverviewSharedElementHelper extends FullWidthDetailsOverviewRowPresenter.Listener {
    static final boolean DEBUG = false;
    private static final long DEFAULT_TIMEOUT = 5000;
    static final String TAG = "DetailsTransitionHelper";
    Activity mActivityToRunTransition;
    String mSharedElementName;
    private boolean mStartedPostpone;
    WeakReference<FullWidthDetailsOverviewRowPresenter.ViewHolder> mViewHolder = new WeakReference<>(null);
    private boolean mAutoStartSharedElementTransition = true;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class TransitionTimeOutRunnable implements Runnable {
        final WeakReference<FullWidthDetailsOverviewSharedElementHelper> mHelperRef;

        public TransitionTimeOutRunnable(FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper) {
            this.mHelperRef = new WeakReference<>(fullWidthDetailsOverviewSharedElementHelper);
        }

        @Override // java.lang.Runnable
        public void run() {
            FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = this.mHelperRef.get();
            if (fullWidthDetailsOverviewSharedElementHelper == null) {
                return;
            }
            fullWidthDetailsOverviewSharedElementHelper.startPostponedEnterTransition();
        }
    }

    public boolean getAutoStartSharedElementTransition() {
        return this.mAutoStartSharedElementTransition;
    }

    @Override // androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.Listener
    public void onBindLogo(FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        WeakReference<FullWidthDetailsOverviewRowPresenter.ViewHolder> weakReference = new WeakReference<>(viewHolder);
        this.mViewHolder = weakReference;
        if (this.mAutoStartSharedElementTransition) {
            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2 = weakReference.get();
            if (viewHolder2 != null) {
                ViewCompat.setTransitionName(viewHolder2.getLogoViewHolder().view, null);
            }
            viewHolder.getDetailsDescriptionFrame().postOnAnimation(new Runnable() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder3 = FullWidthDetailsOverviewSharedElementHelper.this.mViewHolder.get();
                    if (viewHolder3 == null) {
                        return;
                    }
                    ViewCompat.setTransitionName(viewHolder3.getLogoViewHolder().view, FullWidthDetailsOverviewSharedElementHelper.this.mSharedElementName);
                    Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(FullWidthDetailsOverviewSharedElementHelper.this.mActivityToRunTransition.getWindow());
                    if (sharedElementEnterTransition != null) {
                        TransitionHelper.addTransitionListener(sharedElementEnterTransition, new TransitionListener() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper.1.1
                            @Override // androidx.leanback.transition.TransitionListener
                            public void onTransitionEnd(Object obj) {
                                FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder4 = FullWidthDetailsOverviewSharedElementHelper.this.mViewHolder.get();
                                if (viewHolder4 != null && viewHolder4.getActionsRow().isFocused()) {
                                    viewHolder4.getActionsRow().requestFocus();
                                }
                                TransitionHelper.removeTransitionListener(obj, this);
                            }
                        });
                    }
                    FullWidthDetailsOverviewSharedElementHelper.this.startPostponedEnterTransitionInternal();
                }
            });
        }
    }

    public void setAutoStartSharedElementTransition(boolean z9) {
        this.mAutoStartSharedElementTransition = z9;
    }

    public void setSharedElementEnterTransition(Activity activity, String str, long j) {
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            o.n();
            return;
        }
        if (activity == this.mActivityToRunTransition && TextUtils.equals(str, this.mSharedElementName)) {
            return;
        }
        this.mActivityToRunTransition = activity;
        this.mSharedElementName = str;
        setAutoStartSharedElementTransition(TransitionHelper.getSharedElementEnterTransition(activity.getWindow()) != null);
        ActivityCompat.postponeEnterTransition(this.mActivityToRunTransition);
        if (j > 0) {
            new Handler().postDelayed(new TransitionTimeOutRunnable(this), j);
        }
    }

    public void startPostponedEnterTransition() {
        new Handler().post(new Runnable() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper.2
            @Override // java.lang.Runnable
            public void run() {
                FullWidthDetailsOverviewSharedElementHelper.this.startPostponedEnterTransitionInternal();
            }
        });
    }

    public void startPostponedEnterTransitionInternal() {
        if (this.mStartedPostpone || this.mViewHolder.get() == null) {
            return;
        }
        ActivityCompat.startPostponedEnterTransition(this.mActivityToRunTransition);
        this.mStartedPostpone = true;
    }

    public void setSharedElementEnterTransition(Activity activity, String str) {
        setSharedElementEnterTransition(activity, str, 5000L);
    }
}
