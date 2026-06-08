package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new Parcelable.Creator<BackStackRecordState>() { // from class: androidx.fragment.app.BackStackRecordState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackRecordState[] newArray(int i) {
            return new BackStackRecordState[i];
        }
    };
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    public BackStackRecordState(BackStackRecord backStackRecord) {
        int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 6];
        if (!backStackRecord.mAddToBackStack) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Not on back stack");
            throw null;
        }
        this.mFragmentWhos = new ArrayList<>(size);
        this.mOldMaxLifecycleStates = new int[size];
        this.mCurrentMaxLifecycleStates = new int[size];
        int i = 0;
        for (int i6 = 0; i6 < size; i6++) {
            FragmentTransaction.Op op = backStackRecord.mOps.get(i6);
            int i10 = i + 1;
            this.mOps[i] = op.mCmd;
            ArrayList<String> arrayList = this.mFragmentWhos;
            Fragment fragment = op.mFragment;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.mOps;
            iArr[i10] = op.mFromExpandedOp ? 1 : 0;
            iArr[i + 2] = op.mEnterAnim;
            iArr[i + 3] = op.mExitAnim;
            int i11 = i + 5;
            iArr[i + 4] = op.mPopEnterAnim;
            i += 6;
            iArr[i11] = op.mPopExitAnim;
            this.mOldMaxLifecycleStates[i6] = op.mOldMaxState.ordinal();
            this.mCurrentMaxLifecycleStates[i6] = op.mCurrentMaxState.ordinal();
        }
        this.mTransition = backStackRecord.mTransition;
        this.mName = backStackRecord.mName;
        this.mIndex = backStackRecord.mIndex;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
        this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
        this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
    }

    private void fillInBackStackRecord(@NonNull BackStackRecord backStackRecord) {
        int i = 0;
        int i6 = 0;
        while (true) {
            boolean z9 = true;
            if (i >= this.mOps.length) {
                backStackRecord.mTransition = this.mTransition;
                backStackRecord.mName = this.mName;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
                backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
                return;
            }
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i10 = i + 1;
            op.mCmd = this.mOps[i];
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i6 + " base fragment #" + this.mOps[i10]);
            }
            op.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i6]];
            op.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i6]];
            int[] iArr = this.mOps;
            int i11 = i + 2;
            if (iArr[i10] == 0) {
                z9 = false;
            }
            op.mFromExpandedOp = z9;
            int i12 = iArr[i11];
            op.mEnterAnim = i12;
            int i13 = iArr[i + 3];
            op.mExitAnim = i13;
            int i14 = i + 5;
            int i15 = iArr[i + 4];
            op.mPopEnterAnim = i15;
            i += 6;
            int i16 = iArr[i14];
            op.mPopExitAnim = i16;
            backStackRecord.mEnterAnim = i12;
            backStackRecord.mExitAnim = i13;
            backStackRecord.mPopEnterAnim = i15;
            backStackRecord.mPopExitAnim = i16;
            backStackRecord.addOp(op);
            i6++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager fragmentManager, @NonNull Map<String, Fragment> map) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        fillInBackStackRecord(backStackRecord);
        for (int i = 0; i < this.mFragmentWhos.size(); i++) {
            String str = this.mFragmentWhos.get(i);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment == null) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.k("Restoring FragmentTransaction ", this.mName, " failed due to missing saved state for Fragment (", str, ")");
                    return null;
                }
                backStackRecord.mOps.get(i).mFragment = fragment;
            }
        }
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        fillInBackStackRecord(backStackRecord);
        backStackRecord.mIndex = this.mIndex;
        for (int i = 0; i < this.mFragmentWhos.size(); i++) {
            String str = this.mFragmentWhos.get(i);
            if (str != null) {
                backStackRecord.mOps.get(i).mFragment = fragmentManager.findActiveFragment(str);
            }
        }
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    public BackStackRecordState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mBreadCrumbTitleText = (CharSequence) creator.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) creator.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }
}
