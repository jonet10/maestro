package androidx.leanback.app;

import android.animation.PropertyValuesHolder;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.leanback.R;
import androidx.leanback.graphics.FitWidthBitmapDrawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.DetailsParallaxDrawable;
import androidx.leanback.widget.ParallaxTarget;
import androidx.privacysandbox.ads.adservices.customaudience.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DetailsFragmentBackgroundController {
    Bitmap mCoverBitmap;
    final DetailsFragment mFragment;
    private Fragment mLastVideoFragmentForGlueHost;
    DetailsParallaxDrawable mParallaxDrawable;
    int mParallaxDrawableMaxOffset;
    PlaybackGlue mPlaybackGlue;
    int mSolidColor;
    DetailsBackgroundVideoHelper mVideoHelper;
    boolean mCanUseHost = false;
    boolean mInitialControlVisible = false;

    public DetailsFragmentBackgroundController(DetailsFragment detailsFragment) {
        if (detailsFragment.mDetailsBackgroundController != null) {
            a.i("Each DetailsFragment is allowed to initialize DetailsFragmentBackgroundController once");
            throw null;
        }
        detailsFragment.mDetailsBackgroundController = this;
        this.mFragment = detailsFragment;
    }

    public boolean canNavigateToVideoFragment() {
        return this.mPlaybackGlue != null;
    }

    public PlaybackGlueHost createGlueHost() {
        PlaybackGlueHost onCreateGlueHost = onCreateGlueHost();
        if (this.mInitialControlVisible) {
            onCreateGlueHost.showControlsOverlay(false);
            return onCreateGlueHost;
        }
        onCreateGlueHost.hideControlsOverlay(false);
        return onCreateGlueHost;
    }

    public boolean disableVideoParallax() {
        DetailsBackgroundVideoHelper detailsBackgroundVideoHelper = this.mVideoHelper;
        if (detailsBackgroundVideoHelper == null) {
            return false;
        }
        detailsBackgroundVideoHelper.stopParallax();
        return this.mVideoHelper.isVideoVisible();
    }

    public void enableParallax(Drawable drawable, Drawable drawable2, ParallaxTarget.PropertyValuesHolderTarget propertyValuesHolderTarget) {
        if (this.mParallaxDrawable != null) {
            return;
        }
        Bitmap bitmap = this.mCoverBitmap;
        if (bitmap != null && (drawable instanceof FitWidthBitmapDrawable)) {
            ((FitWidthBitmapDrawable) drawable).setBitmap(bitmap);
        }
        int i = this.mSolidColor;
        if (i != 0 && (drawable2 instanceof ColorDrawable)) {
            ((ColorDrawable) drawable2).setColor(i);
        }
        if (this.mPlaybackGlue != null) {
            a.i("enableParallaxDrawable must be called before enableVideoPlayback");
            return;
        }
        DetailsParallaxDrawable detailsParallaxDrawable = new DetailsParallaxDrawable(FragmentUtil.getContext(this.mFragment), this.mFragment.getParallax(), drawable, drawable2, propertyValuesHolderTarget);
        this.mParallaxDrawable = detailsParallaxDrawable;
        this.mFragment.setBackgroundDrawable(detailsParallaxDrawable);
        this.mVideoHelper = new DetailsBackgroundVideoHelper(null, this.mFragment.getParallax(), this.mParallaxDrawable.getCoverDrawable());
    }

    public final Fragment findOrCreateVideoFragment() {
        return this.mFragment.findOrCreateVideoFragment();
    }

    public final Drawable getBottomDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.mParallaxDrawable;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getBottomDrawable();
    }

    public final Bitmap getCoverBitmap() {
        return this.mCoverBitmap;
    }

    public final Drawable getCoverDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.mParallaxDrawable;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getCoverDrawable();
    }

    public final int getParallaxDrawableMaxOffset() {
        return this.mParallaxDrawableMaxOffset;
    }

    public final PlaybackGlue getPlaybackGlue() {
        return this.mPlaybackGlue;
    }

    @ColorInt
    public final int getSolidColor() {
        return this.mSolidColor;
    }

    public PlaybackGlueHost onCreateGlueHost() {
        return new VideoFragmentGlueHost((VideoFragment) findOrCreateVideoFragment());
    }

    public Fragment onCreateVideoFragment() {
        return new VideoFragment();
    }

    public void onStart() {
        if (!this.mCanUseHost) {
            this.mCanUseHost = true;
            PlaybackGlue playbackGlue = this.mPlaybackGlue;
            if (playbackGlue != null) {
                playbackGlue.setHost(createGlueHost());
                this.mLastVideoFragmentForGlueHost = findOrCreateVideoFragment();
            }
        }
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 == null || !playbackGlue2.isPrepared()) {
            return;
        }
        this.mPlaybackGlue.play();
    }

    public void onStop() {
        PlaybackGlue playbackGlue = this.mPlaybackGlue;
        if (playbackGlue != null) {
            playbackGlue.pause();
        }
    }

    public final void setCoverBitmap(Bitmap bitmap) {
        this.mCoverBitmap = bitmap;
        Drawable coverDrawable = getCoverDrawable();
        if (coverDrawable instanceof FitWidthBitmapDrawable) {
            ((FitWidthBitmapDrawable) coverDrawable).setBitmap(this.mCoverBitmap);
        }
    }

    public final void setParallaxDrawableMaxOffset(int i) {
        if (this.mParallaxDrawable == null) {
            this.mParallaxDrawableMaxOffset = i;
        } else {
            a.i("enableParallax already called");
        }
    }

    public final void setSolidColor(@ColorInt int i) {
        this.mSolidColor = i;
        Drawable bottomDrawable = getBottomDrawable();
        if (bottomDrawable instanceof ColorDrawable) {
            ((ColorDrawable) bottomDrawable).setColor(i);
        }
    }

    public void setupVideoPlayback(PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 == playbackGlue) {
            return;
        }
        PlaybackGlueHost playbackGlueHost = null;
        if (playbackGlue2 != null) {
            PlaybackGlueHost host = playbackGlue2.getHost();
            this.mPlaybackGlue.setHost(null);
            playbackGlueHost = host;
        }
        this.mPlaybackGlue = playbackGlue;
        this.mVideoHelper.setPlaybackGlue(playbackGlue);
        if (!this.mCanUseHost || this.mPlaybackGlue == null) {
            return;
        }
        if (playbackGlueHost != null && this.mLastVideoFragmentForGlueHost == findOrCreateVideoFragment()) {
            this.mPlaybackGlue.setHost(playbackGlueHost);
        } else {
            this.mPlaybackGlue.setHost(createGlueHost());
            this.mLastVideoFragmentForGlueHost = findOrCreateVideoFragment();
        }
    }

    public final void switchToRows() {
        this.mFragment.switchToRows();
    }

    public final void switchToVideo() {
        this.mFragment.switchToVideo();
    }

    public void switchToVideoBeforeCreate() {
        this.mVideoHelper.crossFadeBackgroundToVideo(true, true);
        this.mInitialControlVisible = true;
    }

    public void enableParallax() {
        int i = this.mParallaxDrawableMaxOffset;
        if (i == 0) {
            i = FragmentUtil.getContext(this.mFragment).getResources().getDimensionPixelSize(R.dimen.lb_details_cover_drawable_parallax_movement);
        }
        FitWidthBitmapDrawable fitWidthBitmapDrawable = new FitWidthBitmapDrawable();
        enableParallax(fitWidthBitmapDrawable, new ColorDrawable(), new ParallaxTarget.PropertyValuesHolderTarget(fitWidthBitmapDrawable, PropertyValuesHolder.ofInt(FitWidthBitmapDrawable.PROPERTY_VERTICAL_OFFSET, 0, -i)));
    }
}
