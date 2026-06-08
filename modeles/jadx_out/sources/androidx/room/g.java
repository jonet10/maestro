package androidx.room;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.coroutines.AndroidSQLiteDriverConnectionPool;
import androidx.room.coroutines.AndroidSQLiteDriverPooledConnection;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.PruneWorkRunnableKt;
import b5.m;
import c3.i1;
import c4.k0;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.ContactUsActivity;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.InformationActivity;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.views.FullWidthImageView;
import g4.u;
import g4.v;
import java.util.UUID;
import p6.x;
import r.h;
import t4.w;
import t4.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class g implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f489a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f490b;

    public /* synthetic */ g(Object obj, int i) {
        this.f489a = i;
        this.f490b = obj;
    }

    private final Object a() {
        MoreInfo moreInfo = (MoreInfo) this.f490b;
        int i = MoreInfo.V;
        View inflate = moreInfo.getLayoutInflater().inflate(2131558704, (ViewGroup) null, false);
        int i6 = 2131362286;
        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362286)) != null) {
            i6 = 2131362289;
            if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362289)) != null) {
                i6 = 2131362298;
                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362298)) != null) {
                    i6 = 2131362320;
                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362320)) != null) {
                        i6 = 2131362333;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362333);
                        if (imageView != null) {
                            i6 = 2131362334;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362334);
                            if (imageView2 != null) {
                                i6 = 2131362335;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362335);
                                if (imageView3 != null) {
                                    i6 = 2131362338;
                                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362338)) != null) {
                                        i6 = 2131362343;
                                        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362343)) != null) {
                                            i6 = 2131362347;
                                            if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362347)) != null) {
                                                i6 = 2131362360;
                                                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362360)) != null) {
                                                    i6 = 2131362400;
                                                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362400)) != null) {
                                                        i6 = 2131362401;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362401);
                                                        if (imageView4 != null) {
                                                            i6 = 2131362403;
                                                            if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362403)) != null) {
                                                                i6 = 2131362443;
                                                                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362443)) != null) {
                                                                    i6 = 2131362446;
                                                                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362446)) != null) {
                                                                        i6 = 2131362448;
                                                                        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362448)) != null) {
                                                                            i6 = 2131362452;
                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362452);
                                                                            if (imageView5 != null) {
                                                                                i6 = 2131362455;
                                                                                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362455)) != null) {
                                                                                    i6 = 2131362462;
                                                                                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362462)) != null) {
                                                                                        i6 = 2131362473;
                                                                                        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362473)) != null) {
                                                                                            i6 = 2131362477;
                                                                                            if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362477)) != null) {
                                                                                                i6 = 2131362479;
                                                                                                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362479)) != null) {
                                                                                                    i6 = 2131362546;
                                                                                                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362546)) != null) {
                                                                                                        i6 = 2131362550;
                                                                                                        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362550)) != null) {
                                                                                                            i6 = 2131362638;
                                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362638);
                                                                                                            if (linearLayout != null) {
                                                                                                                i6 = 2131362676;
                                                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362676);
                                                                                                                if (linearLayout2 != null) {
                                                                                                                    i6 = 2131362685;
                                                                                                                    if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362685)) != null) {
                                                                                                                        i6 = 2131362704;
                                                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362704);
                                                                                                                        if (linearLayout3 != null) {
                                                                                                                            i6 = 2131362708;
                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362708);
                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                i6 = 2131362800;
                                                                                                                                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362800);
                                                                                                                                if (findChildViewById != null) {
                                                                                                                                    i6 = 2131363101;
                                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363101);
                                                                                                                                    if (relativeLayout != null) {
                                                                                                                                        i6 = 2131363107;
                                                                                                                                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363107)) != null) {
                                                                                                                                            i6 = 2131363118;
                                                                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363118);
                                                                                                                                            if (relativeLayout2 != null) {
                                                                                                                                                i6 = 2131363140;
                                                                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363140);
                                                                                                                                                if (relativeLayout3 != null) {
                                                                                                                                                    i6 = 2131363159;
                                                                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363159);
                                                                                                                                                    if (relativeLayout4 != null) {
                                                                                                                                                        i6 = 2131363164;
                                                                                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363164);
                                                                                                                                                        if (relativeLayout5 != null) {
                                                                                                                                                            i6 = 2131363170;
                                                                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363170);
                                                                                                                                                            if (relativeLayout6 != null) {
                                                                                                                                                                i6 = 2131363177;
                                                                                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363177);
                                                                                                                                                                if (relativeLayout7 != null) {
                                                                                                                                                                    i6 = 2131363206;
                                                                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363206);
                                                                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                                                                        i6 = 2131363208;
                                                                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363208);
                                                                                                                                                                        if (relativeLayout9 != null) {
                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) inflate;
                                                                                                                                                                            i6 = 2131363240;
                                                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363240);
                                                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                                                i6 = 2131363242;
                                                                                                                                                                                RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363242);
                                                                                                                                                                                if (relativeLayout12 != null) {
                                                                                                                                                                                    i6 = 2131363244;
                                                                                                                                                                                    RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363244);
                                                                                                                                                                                    if (relativeLayout13 != null) {
                                                                                                                                                                                        i6 = 2131363246;
                                                                                                                                                                                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363246)) != null) {
                                                                                                                                                                                            i6 = 2131363251;
                                                                                                                                                                                            RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363251);
                                                                                                                                                                                            if (relativeLayout14 != null) {
                                                                                                                                                                                                i6 = 2131363255;
                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363255);
                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                    i6 = 2131363259;
                                                                                                                                                                                                    RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363259);
                                                                                                                                                                                                    if (relativeLayout16 != null) {
                                                                                                                                                                                                        i6 = 2131363262;
                                                                                                                                                                                                        RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363262);
                                                                                                                                                                                                        if (relativeLayout17 != null) {
                                                                                                                                                                                                            i6 = 2131363291;
                                                                                                                                                                                                            RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363291);
                                                                                                                                                                                                            if (relativeLayout18 != null) {
                                                                                                                                                                                                                i6 = 2131363298;
                                                                                                                                                                                                                if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363298)) != null) {
                                                                                                                                                                                                                    i6 = 2131363481;
                                                                                                                                                                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(inflate, 2131363481);
                                                                                                                                                                                                                    if (scrollView != null) {
                                                                                                                                                                                                                        i6 = 2131363549;
                                                                                                                                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363549);
                                                                                                                                                                                                                        if (toolbar != null) {
                                                                                                                                                                                                                            i6 = 2131363599;
                                                                                                                                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363599);
                                                                                                                                                                                                                            if (textView != null) {
                                                                                                                                                                                                                                i6 = 2131363600;
                                                                                                                                                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363600);
                                                                                                                                                                                                                                if (textView2 != null) {
                                                                                                                                                                                                                                    i6 = 2131363627;
                                                                                                                                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363627);
                                                                                                                                                                                                                                    if (textView3 != null) {
                                                                                                                                                                                                                                        i6 = 2131363628;
                                                                                                                                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131363628);
                                                                                                                                                                                                                                        if (textView4 != null) {
                                                                                                                                                                                                                                            i6 = 2131363644;
                                                                                                                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131363644);
                                                                                                                                                                                                                                            if (textView5 != null) {
                                                                                                                                                                                                                                                i6 = 2131363663;
                                                                                                                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131363663);
                                                                                                                                                                                                                                                if (textView6 != null) {
                                                                                                                                                                                                                                                    i6 = 2131363664;
                                                                                                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate, 2131363664);
                                                                                                                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                                                                                                                        i6 = 2131363677;
                                                                                                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate, 2131363677);
                                                                                                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                                                                                                            i6 = 2131363706;
                                                                                                                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate, 2131363706);
                                                                                                                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                                                                                                                i6 = 2131363707;
                                                                                                                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate, 2131363707);
                                                                                                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                                                                                                    i6 = 2131363736;
                                                                                                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(inflate, 2131363736);
                                                                                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                                                                                        i6 = 2131363748;
                                                                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(inflate, 2131363748);
                                                                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                                                                            i6 = 2131363749;
                                                                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(inflate, 2131363749);
                                                                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                                                                i6 = 2131363805;
                                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(inflate, 2131363805);
                                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                                    i6 = 2131363806;
                                                                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(inflate, 2131363806);
                                                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                                                        i6 = 2131363838;
                                                                                                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(inflate, 2131363838);
                                                                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                                                                            i6 = 2131363843;
                                                                                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(inflate, 2131363843);
                                                                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                                                                i6 = 2131363845;
                                                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(inflate, 2131363845);
                                                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                                                    i6 = 2131363874;
                                                                                                                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(inflate, 2131363874);
                                                                                                                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                                                                                                                        i6 = 2131363875;
                                                                                                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(inflate, 2131363875);
                                                                                                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                                                                                                            i6 = 2131363937;
                                                                                                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(inflate, 2131363937);
                                                                                                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                i6 = 2131363938;
                                                                                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(inflate, 2131363938);
                                                                                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                    i6 = 2131363958;
                                                                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(inflate, 2131363958);
                                                                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                        i6 = 2131363959;
                                                                                                                                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(inflate, 2131363959);
                                                                                                                                                                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                            i6 = 2131364078;
                                                                                                                                                                                                                                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(inflate, 2131364078);
                                                                                                                                                                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                i6 = 2131364134;
                                                                                                                                                                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(inflate, 2131364134);
                                                                                                                                                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                    i6 = 2131364139;
                                                                                                                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(inflate, 2131364139);
                                                                                                                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                        i6 = 2131364140;
                                                                                                                                                                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(inflate, 2131364140);
                                                                                                                                                                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                            i6 = 2131364152;
                                                                                                                                                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(inflate, 2131364152);
                                                                                                                                                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                i6 = 2131364153;
                                                                                                                                                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(inflate, 2131364153);
                                                                                                                                                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                    i6 = 2131364165;
                                                                                                                                                                                                                                                                                                                                                    TextView textView31 = (TextView) ViewBindings.findChildViewById(inflate, 2131364165);
                                                                                                                                                                                                                                                                                                                                                    if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                        i6 = 2131364166;
                                                                                                                                                                                                                                                                                                                                                        TextView textView32 = (TextView) ViewBindings.findChildViewById(inflate, 2131364166);
                                                                                                                                                                                                                                                                                                                                                        if (textView32 != null) {
                                                                                                                                                                                                                                                                                                                                                            i6 = 2131364200;
                                                                                                                                                                                                                                                                                                                                                            TextView textView33 = (TextView) ViewBindings.findChildViewById(inflate, 2131364200);
                                                                                                                                                                                                                                                                                                                                                            if (textView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                i6 = 2131364201;
                                                                                                                                                                                                                                                                                                                                                                TextView textView34 = (TextView) ViewBindings.findChildViewById(inflate, 2131364201);
                                                                                                                                                                                                                                                                                                                                                                if (textView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i6 = 2131364234;
                                                                                                                                                                                                                                                                                                                                                                    TextView textView35 = (TextView) ViewBindings.findChildViewById(inflate, 2131364234);
                                                                                                                                                                                                                                                                                                                                                                    if (textView35 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i6 = 2131364235;
                                                                                                                                                                                                                                                                                                                                                                        TextView textView36 = (TextView) ViewBindings.findChildViewById(inflate, 2131364235);
                                                                                                                                                                                                                                                                                                                                                                        if (textView36 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i6 = 2131364260;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView37 = (TextView) ViewBindings.findChildViewById(inflate, 2131364260);
                                                                                                                                                                                                                                                                                                                                                                            if (textView37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i6 = 2131364277;
                                                                                                                                                                                                                                                                                                                                                                                TextView textView38 = (TextView) ViewBindings.findChildViewById(inflate, 2131364277);
                                                                                                                                                                                                                                                                                                                                                                                if (textView38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i6 = 2131364279;
                                                                                                                                                                                                                                                                                                                                                                                    TextView textView39 = (TextView) ViewBindings.findChildViewById(inflate, 2131364279);
                                                                                                                                                                                                                                                                                                                                                                                    if (textView39 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i6 = 2131364293;
                                                                                                                                                                                                                                                                                                                                                                                        TextView textView40 = (TextView) ViewBindings.findChildViewById(inflate, 2131364293);
                                                                                                                                                                                                                                                                                                                                                                                        if (textView40 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i6 = 2131364295;
                                                                                                                                                                                                                                                                                                                                                                                            TextView textView41 = (TextView) ViewBindings.findChildViewById(inflate, 2131364295);
                                                                                                                                                                                                                                                                                                                                                                                            if (textView41 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i6 = 2131364310;
                                                                                                                                                                                                                                                                                                                                                                                                TextView textView42 = (TextView) ViewBindings.findChildViewById(inflate, 2131364310);
                                                                                                                                                                                                                                                                                                                                                                                                if (textView42 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i6 = 2131364311;
                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView43 = (TextView) ViewBindings.findChildViewById(inflate, 2131364311);
                                                                                                                                                                                                                                                                                                                                                                                                    if (textView43 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i6 = 2131364355;
                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView44 = (TextView) ViewBindings.findChildViewById(inflate, 2131364355);
                                                                                                                                                                                                                                                                                                                                                                                                        if (textView44 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i6 = 2131364481;
                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView45 = (TextView) ViewBindings.findChildViewById(inflate, 2131364481);
                                                                                                                                                                                                                                                                                                                                                                                                            if (textView45 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i6 = 2131364570;
                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView46 = (TextView) ViewBindings.findChildViewById(inflate, 2131364570);
                                                                                                                                                                                                                                                                                                                                                                                                                if (textView46 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i6 = 2131364571;
                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView47 = (TextView) ViewBindings.findChildViewById(inflate, 2131364571);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView47 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i6 = 2131364638;
                                                                                                                                                                                                                                                                                                                                                                                                                        View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131364638);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (findChildViewById2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            return new w(relativeLayout10, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout, linearLayout2, linearLayout3, linearLayout4, findChildViewById, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11, relativeLayout12, relativeLayout13, relativeLayout14, relativeLayout15, relativeLayout16, relativeLayout17, relativeLayout18, scrollView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView39, textView40, textView41, textView42, textView43, textView44, textView45, textView46, textView47, findChildViewById2);
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }

    private final Object b() {
        MyStatsActivity myStatsActivity = (MyStatsActivity) this.f490b;
        int i = MyStatsActivity.R;
        View inflate = myStatsActivity.getLayoutInflater().inflate(2131558740, (ViewGroup) null, false);
        int i6 = 2131362538;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362538);
        if (imageView != null) {
            i6 = 2131362660;
            if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362660)) != null) {
                i6 = 2131362674;
                if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362674)) != null) {
                    i6 = 2131362803;
                    View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362803);
                    if (findChildViewById != null) {
                        i6 = 2131362946;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(inflate, 2131362946);
                        if (nestedScrollView != null) {
                            i6 = 2131363551;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363551);
                            if (toolbar != null) {
                                i6 = 2131363737;
                                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363737);
                                if (textView != null) {
                                    i6 = 2131363914;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363914);
                                    if (textView2 != null) {
                                        i6 = 2131363915;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363915);
                                        if (textView3 != null) {
                                            i6 = 2131363961;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131363961);
                                            if (textView4 != null) {
                                                i6 = 2131363962;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131363962);
                                                if (textView5 != null) {
                                                    i6 = 2131363963;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131363963);
                                                    if (textView6 != null) {
                                                        i6 = 2131363964;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate, 2131363964);
                                                        if (textView7 != null) {
                                                            i6 = 2131364179;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate, 2131364179);
                                                            if (textView8 != null) {
                                                                i6 = 2131364180;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate, 2131364180);
                                                                if (textView9 != null) {
                                                                    i6 = 2131364227;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate, 2131364227);
                                                                    if (textView10 != null) {
                                                                        i6 = 2131364228;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(inflate, 2131364228);
                                                                        if (textView11 != null) {
                                                                            i6 = 2131364229;
                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(inflate, 2131364229);
                                                                            if (textView12 != null) {
                                                                                i6 = 2131364230;
                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(inflate, 2131364230);
                                                                                if (textView13 != null) {
                                                                                    i6 = 2131364248;
                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(inflate, 2131364248);
                                                                                    if (textView14 != null) {
                                                                                        i6 = 2131364253;
                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(inflate, 2131364253);
                                                                                        if (textView15 != null) {
                                                                                            i6 = 2131364361;
                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(inflate, 2131364361);
                                                                                            if (textView16 != null) {
                                                                                                i6 = 2131364438;
                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(inflate, 2131364438);
                                                                                                if (textView17 != null) {
                                                                                                    i6 = 2131364471;
                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(inflate, 2131364471);
                                                                                                    if (textView18 != null) {
                                                                                                        i6 = 2131364472;
                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(inflate, 2131364472);
                                                                                                        if (textView19 != null) {
                                                                                                            i6 = 2131364505;
                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(inflate, 2131364505);
                                                                                                            if (textView20 != null) {
                                                                                                                i6 = 2131364511;
                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(inflate, 2131364511);
                                                                                                                if (textView21 != null) {
                                                                                                                    i6 = 2131364535;
                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(inflate, 2131364535);
                                                                                                                    if (textView22 != null) {
                                                                                                                        i6 = 2131364630;
                                                                                                                        View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131364630);
                                                                                                                        if (findChildViewById2 != null) {
                                                                                                                            return new z((RelativeLayout) inflate, imageView, findChildViewById, nestedScrollView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, findChildViewById2);
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }

    @Override // d7.a
    public final Object invoke() {
        SupportSQLiteStatement createNewStatement;
        AndroidSQLiteDriverPooledConnection androidConnection_delegate$lambda$0;
        x create$lambda$0;
        FrameworkSQLiteOpenHelper.OpenHelper lazyDelegate$lambda$0;
        x lambda$enqueue$0;
        x pruneWork$lambda$0;
        int i = this.f489a;
        x xVar = x.f8463a;
        Object obj = this.f490b;
        switch (i) {
            case 0:
                createNewStatement = ((SharedSQLiteStatement) obj).createNewStatement();
                break;
            case 1:
                androidConnection_delegate$lambda$0 = AndroidSQLiteDriverConnectionPool.androidConnection_delegate$lambda$0((AndroidSQLiteDriverConnectionPool) obj);
                break;
            case 2:
                create$lambda$0 = SavedStateRegistryController.Companion.create$lambda$0((SavedStateRegistryOwner) obj);
                break;
            case 3:
                lazyDelegate$lambda$0 = FrameworkSQLiteOpenHelper.lazyDelegate$lambda$0((FrameworkSQLiteOpenHelper) obj);
                break;
            case 4:
                lambda$enqueue$0 = ((WorkContinuationImpl) obj).lambda$enqueue$0();
                break;
            case 5:
                break;
            case 6:
                pruneWork$lambda$0 = PruneWorkRunnableKt.pruneWork$lambda$0((WorkDatabase) obj);
                break;
            case 7:
                b8.f fVar = (b8.f) obj;
                break;
            case 8:
                ((i1) obj).getClass();
                UUID randomUUID = UUID.randomUUID();
                randomUUID.getClass();
                String uuid = randomUUID.toString();
                uuid.getClass();
                break;
            case 9:
                int i6 = AppFilesActivity.S;
                View inflate = ((AppFilesActivity) obj).getLayoutInflater().inflate(2131558435, (ViewGroup) null, false);
                int i10 = 2131362410;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362410);
                if (imageView != null) {
                    i10 = 2131362785;
                    View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362785);
                    if (findChildViewById != null) {
                        i10 = 2131363186;
                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363186)) != null) {
                            i10 = 2131363313;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363313);
                            if (recyclerView != null) {
                                i10 = 2131363531;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363531);
                                if (toolbar != null) {
                                    i10 = 2131363638;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363638);
                                    if (textView != null) {
                                        i10 = 2131363742;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363742);
                                        if (textView2 != null) {
                                            i10 = 2131364071;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364071);
                                            if (textView3 != null) {
                                                i10 = 2131364443;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364443);
                                                if (textView4 != null) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
                break;
            case 10:
                int i11 = AppInstalledDetailsActivity.f3300e0;
                View inflate2 = ((AppInstalledDetailsActivity) obj).getLayoutInflater().inflate(2131558442, (ViewGroup) null, false);
                int i12 = 2131362297;
                if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362297)) != null) {
                    i12 = 2131362337;
                    if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362337)) != null) {
                        i12 = 2131362402;
                        if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362402)) != null) {
                            i12 = 2131362411;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate2, 2131362411);
                            if (imageView2 != null) {
                                i12 = 2131362429;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate2, 2131362429);
                                if (imageView3 != null) {
                                    i12 = 2131362442;
                                    if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362442)) != null) {
                                        i12 = 2131362447;
                                        if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362447)) != null) {
                                            i12 = 2131362451;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(inflate2, 2131362451);
                                            if (imageView4 != null) {
                                                i12 = 2131362461;
                                                if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362461)) != null) {
                                                    i12 = 2131362472;
                                                    if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362472)) != null) {
                                                        i12 = 2131362476;
                                                        if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362476)) != null) {
                                                            i12 = 2131362478;
                                                            if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362478)) != null) {
                                                                i12 = 2131362533;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(inflate2, 2131362533);
                                                                if (imageView5 != null) {
                                                                    i12 = 2131362534;
                                                                    if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362534)) != null) {
                                                                        i12 = 2131362544;
                                                                        if (((ImageView) ViewBindings.findChildViewById(inflate2, 2131362544)) != null) {
                                                                            i12 = 2131362630;
                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131362630);
                                                                            if (relativeLayout != null) {
                                                                                i12 = 2131362647;
                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate2, 2131362647);
                                                                                if (linearLayout != null) {
                                                                                    i12 = 2131362666;
                                                                                    if (((LinearLayout) ViewBindings.findChildViewById(inflate2, 2131362666)) != null) {
                                                                                        i12 = 2131362707;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(inflate2, 2131362707);
                                                                                        if (linearLayout2 != null) {
                                                                                            i12 = 2131362786;
                                                                                            View findChildViewById2 = ViewBindings.findChildViewById(inflate2, 2131362786);
                                                                                            if (findChildViewById2 != null) {
                                                                                                i12 = 2131363004;
                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(inflate2, 2131363004);
                                                                                                if (progressBar != null) {
                                                                                                    i12 = 2131363117;
                                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363117);
                                                                                                    if (relativeLayout2 != null) {
                                                                                                        i12 = 2131363158;
                                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363158);
                                                                                                        if (relativeLayout3 != null) {
                                                                                                            i12 = 2131363207;
                                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363207);
                                                                                                            if (relativeLayout4 != null) {
                                                                                                                i12 = 2131363215;
                                                                                                                if (((RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363215)) != null) {
                                                                                                                    i12 = 2131363239;
                                                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363239);
                                                                                                                    if (relativeLayout5 != null) {
                                                                                                                        i12 = 2131363243;
                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363243);
                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                            i12 = 2131363250;
                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363250);
                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                i12 = 2131363254;
                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363254);
                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                    i12 = 2131363258;
                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363258);
                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                        i12 = 2131363261;
                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363261);
                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                            i12 = 2131363267;
                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363267);
                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                i12 = 2131363279;
                                                                                                                                                RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363279);
                                                                                                                                                if (relativeLayout12 != null) {
                                                                                                                                                    i12 = 2131363289;
                                                                                                                                                    RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(inflate2, 2131363289);
                                                                                                                                                    if (relativeLayout13 != null) {
                                                                                                                                                        i12 = 2131363477;
                                                                                                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(inflate2, 2131363477);
                                                                                                                                                        if (scrollView != null) {
                                                                                                                                                            i12 = 2131363532;
                                                                                                                                                            Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(inflate2, 2131363532);
                                                                                                                                                            if (toolbar2 != null) {
                                                                                                                                                                i12 = 2131363635;
                                                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363635);
                                                                                                                                                                if (textView5 != null) {
                                                                                                                                                                    i12 = 2131363639;
                                                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363639);
                                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                                        i12 = 2131363648;
                                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363648);
                                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                                            i12 = 2131363659;
                                                                                                                                                                            if (((TextView) ViewBindings.findChildViewById(inflate2, 2131363659)) != null) {
                                                                                                                                                                                i12 = 2131363662;
                                                                                                                                                                                if (((TextView) ViewBindings.findChildViewById(inflate2, 2131363662)) != null) {
                                                                                                                                                                                    i12 = 2131363689;
                                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363689);
                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                        i12 = 2131363743;
                                                                                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363743);
                                                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                                                            i12 = 2131363747;
                                                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363747);
                                                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                                                i12 = 2131363951;
                                                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363951);
                                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                                    i12 = 2131363952;
                                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363952);
                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                        i12 = 2131364072;
                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364072);
                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                            i12 = 2131364119;
                                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364119);
                                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                                i12 = 2131364136;
                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364136);
                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                    i12 = 2131364138;
                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364138);
                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                        i12 = 2131364163;
                                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364163);
                                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                                            i12 = 2131364164;
                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364164);
                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                i12 = 2131364185;
                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364185);
                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                    i12 = 2131364232;
                                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364232);
                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                        i12 = 2131364233;
                                                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364233);
                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                            i12 = 2131364262;
                                                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364262);
                                                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                                                i12 = 2131364263;
                                                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364263);
                                                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                                                    i12 = 2131364275;
                                                                                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364275);
                                                                                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                                                                                        i12 = 2131364276;
                                                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364276);
                                                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                                                            i12 = 2131364285;
                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364285);
                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                i12 = 2131364291;
                                                                                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364291);
                                                                                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                                                                                    i12 = 2131364292;
                                                                                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364292);
                                                                                                                                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                                                                                                                                        i12 = 2131364298;
                                                                                                                                                                                                                                                                        TextView textView29 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364298);
                                                                                                                                                                                                                                                                        if (textView29 != null) {
                                                                                                                                                                                                                                                                            i12 = 2131364308;
                                                                                                                                                                                                                                                                            TextView textView30 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364308);
                                                                                                                                                                                                                                                                            if (textView30 != null) {
                                                                                                                                                                                                                                                                                i12 = 2131364329;
                                                                                                                                                                                                                                                                                TextView textView31 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364329);
                                                                                                                                                                                                                                                                                if (textView31 != null) {
                                                                                                                                                                                                                                                                                    i12 = 2131364444;
                                                                                                                                                                                                                                                                                    TextView textView32 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364444);
                                                                                                                                                                                                                                                                                    if (textView32 != null) {
                                                                                                                                                                                                                                                                                        i12 = 2131364482;
                                                                                                                                                                                                                                                                                        TextView textView33 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364482);
                                                                                                                                                                                                                                                                                        if (textView33 != null) {
                                                                                                                                                                                                                                                                                            i12 = 2131364493;
                                                                                                                                                                                                                                                                                            TextView textView34 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364493);
                                                                                                                                                                                                                                                                                            if (textView34 != null) {
                                                                                                                                                                                                                                                                                                i12 = 2131364494;
                                                                                                                                                                                                                                                                                                TextView textView35 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364494);
                                                                                                                                                                                                                                                                                                if (textView35 != null) {
                                                                                                                                                                                                                                                                                                    i12 = 2131364495;
                                                                                                                                                                                                                                                                                                    TextView textView36 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364495);
                                                                                                                                                                                                                                                                                                    if (textView36 != null) {
                                                                                                                                                                                                                                                                                                        i12 = 2131364540;
                                                                                                                                                                                                                                                                                                        TextView textView37 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364540);
                                                                                                                                                                                                                                                                                                        if (textView37 != null) {
                                                                                                                                                                                                                                                                                                            i12 = 2131364557;
                                                                                                                                                                                                                                                                                                            TextView textView38 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364557);
                                                                                                                                                                                                                                                                                                            if (textView38 != null) {
                                                                                                                                                                                                                                                                                                                i12 = 2131364580;
                                                                                                                                                                                                                                                                                                                TextView textView39 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364580);
                                                                                                                                                                                                                                                                                                                if (textView39 != null) {
                                                                                                                                                                                                                                                                                                                    i12 = 2131364581;
                                                                                                                                                                                                                                                                                                                    TextView textView40 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364581);
                                                                                                                                                                                                                                                                                                                    if (textView40 != null) {
                                                                                                                                                                                                                                                                                                                        i12 = 2131364582;
                                                                                                                                                                                                                                                                                                                        TextView textView41 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364582);
                                                                                                                                                                                                                                                                                                                        if (textView41 != null) {
                                                                                                                                                                                                                                                                                                                            i12 = 2131364637;
                                                                                                                                                                                                                                                                                                                            if (ViewBindings.findChildViewById(inflate2, 2131364637) != null) {
                                                                                                                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i12)));
                break;
            case 11:
                ((k0) obj).w0();
                break;
            case 12:
                int i13 = ContactUsActivity.Q;
                View inflate3 = ((ContactUsActivity) obj).getLayoutInflater().inflate(2131558459, (ViewGroup) null, false);
                int i14 = 2131362150;
                EditText editText = (EditText) ViewBindings.findChildViewById(inflate3, 2131362150);
                if (editText != null) {
                    i14 = 2131362153;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(inflate3, 2131362153);
                    if (editText2 != null) {
                        i14 = 2131362789;
                        View findChildViewById3 = ViewBindings.findChildViewById(inflate3, 2131362789);
                        if (findChildViewById3 != null) {
                            i14 = 2131363535;
                            Toolbar toolbar3 = (Toolbar) ViewBindings.findChildViewById(inflate3, 2131363535);
                            if (toolbar3 != null) {
                                i14 = 2131364267;
                                TextView textView42 = (TextView) ViewBindings.findChildViewById(inflate3, 2131364267);
                                if (textView42 != null) {
                                    i14 = 2131364371;
                                    TextView textView43 = (TextView) ViewBindings.findChildViewById(inflate3, 2131364371);
                                    if (textView43 != null) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate3.getResources().getResourceName(i14)));
                break;
            case 13:
                int i15 = FeedActivity.S;
                View inflate4 = ((FeedActivity) obj).getLayoutInflater().inflate(2131558546, (ViewGroup) null, false);
                int i16 = 2131362790;
                View findChildViewById4 = ViewBindings.findChildViewById(inflate4, 2131362790);
                if (findChildViewById4 != null) {
                    i16 = 2131363321;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(inflate4, 2131363321);
                    if (recyclerView2 != null) {
                        i16 = 2131363538;
                        Toolbar toolbar4 = (Toolbar) ViewBindings.findChildViewById(inflate4, 2131363538);
                        if (toolbar4 != null) {
                            i16 = 2131364074;
                            TextView textView44 = (TextView) ViewBindings.findChildViewById(inflate4, 2131364074);
                            if (textView44 != null) {
                                i16 = 2131364436;
                                TextView textView45 = (TextView) ViewBindings.findChildViewById(inflate4, 2131364436);
                                if (textView45 != null) {
                                    break;
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate4.getResources().getResourceName(i16)));
                break;
            case 14:
                int i17 = FollowListActivity.S;
                View inflate5 = ((FollowListActivity) obj).getLayoutInflater().inflate(2131558557, (ViewGroup) null, false);
                int i18 = 2131362791;
                View findChildViewById5 = ViewBindings.findChildViewById(inflate5, 2131362791);
                if (findChildViewById5 != null) {
                    i18 = 2131363323;
                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(inflate5, 2131363323);
                    if (recyclerView3 != null) {
                        i18 = 2131363539;
                        Toolbar toolbar5 = (Toolbar) ViewBindings.findChildViewById(inflate5, 2131363539);
                        if (toolbar5 != null) {
                            i18 = 2131364075;
                            TextView textView46 = (TextView) ViewBindings.findChildViewById(inflate5, 2131364075);
                            if (textView46 != null) {
                                i18 = 2131364437;
                                TextView textView47 = (TextView) ViewBindings.findChildViewById(inflate5, 2131364437);
                                if (textView47 != null) {
                                    break;
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate5.getResources().getResourceName(i18)));
                break;
            case 15:
                int i19 = FreeUpSpaceActivity.T;
                View inflate6 = ((FreeUpSpaceActivity) obj).getLayoutInflater().inflate(2131558560, (ViewGroup) null, false);
                int i20 = 2131362240;
                View findChildViewById6 = ViewBindings.findChildViewById(inflate6, 2131362240);
                if (findChildViewById6 != null) {
                    v a8 = v.a(findChildViewById6);
                    i20 = 2131362792;
                    View findChildViewById7 = ViewBindings.findChildViewById(inflate6, 2131362792);
                    if (findChildViewById7 != null) {
                        i20 = 2131363324;
                        RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(inflate6, 2131363324);
                        if (recyclerView4 != null) {
                            i20 = 2131363540;
                            Toolbar toolbar6 = (Toolbar) ViewBindings.findChildViewById(inflate6, 2131363540);
                            if (toolbar6 != null) {
                                i20 = 2131364447;
                                TextView textView48 = (TextView) ViewBindings.findChildViewById(inflate6, 2131364447);
                                if (textView48 != null) {
                                    break;
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate6.getResources().getResourceName(i20)));
                break;
            case 16:
                int i21 = Gallery.R;
                View inflate7 = ((Gallery) obj).getLayoutInflater().inflate(2131558561, (ViewGroup) null, false);
                int i22 = 2131362308;
                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(inflate7, 2131362308);
                if (imageView6 != null) {
                    i22 = 2131363541;
                    RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(inflate7, 2131363541);
                    if (relativeLayout14 != null) {
                        i22 = 2131363921;
                        TextView textView49 = (TextView) ViewBindings.findChildViewById(inflate7, 2131363921);
                        if (textView49 != null) {
                            i22 = 2131364663;
                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(inflate7, 2131364663);
                            if (viewPager2 != null) {
                                break;
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate7.getResources().getResourceName(i22)));
                break;
            case 17:
                int i23 = GdprPrivacySettings.P;
                View inflate8 = ((GdprPrivacySettings) obj).getLayoutInflater().inflate(2131558895, (ViewGroup) null, false);
                int i24 = 2131362433;
                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(inflate8, 2131362433);
                if (imageView7 != null) {
                    i24 = 2131362629;
                    if (((LinearLayout) ViewBindings.findChildViewById(inflate8, 2131362629)) != null) {
                        i24 = 2131363108;
                        RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(inflate8, 2131363108);
                        if (relativeLayout15 != null) {
                            i24 = 2131363109;
                            if (((RelativeLayout) ViewBindings.findChildViewById(inflate8, 2131363109)) != null) {
                                i24 = 2131363157;
                                if (((LinearLayout) ViewBindings.findChildViewById(inflate8, 2131363157)) != null) {
                                    i24 = 2131363163;
                                    if (((RelativeLayout) ViewBindings.findChildViewById(inflate8, 2131363163)) != null) {
                                        i24 = 2131363173;
                                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate8, 2131363173)) != null) {
                                            i24 = 2131363179;
                                            RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(inflate8, 2131363179);
                                            if (relativeLayout16 != null) {
                                                i24 = 2131363191;
                                                if (((RelativeLayout) ViewBindings.findChildViewById(inflate8, 2131363191)) != null) {
                                                    i24 = 2131363364;
                                                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(inflate8, 2131363364);
                                                    if (switchCompat != null) {
                                                        i24 = 2131363366;
                                                        SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(inflate8, 2131363366);
                                                        if (switchCompat2 != null) {
                                                            i24 = 2131363367;
                                                            SwitchCompat switchCompat3 = (SwitchCompat) ViewBindings.findChildViewById(inflate8, 2131363367);
                                                            if (switchCompat3 != null) {
                                                                i24 = 2131363603;
                                                                TextView textView50 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363603);
                                                                if (textView50 != null) {
                                                                    i24 = 2131363724;
                                                                    TextView textView51 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363724);
                                                                    if (textView51 != null) {
                                                                        i24 = 2131363754;
                                                                        TextView textView52 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363754);
                                                                        if (textView52 != null) {
                                                                            i24 = 2131363784;
                                                                            TextView textView53 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363784);
                                                                            if (textView53 != null) {
                                                                                i24 = 2131363785;
                                                                                TextView textView54 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363785);
                                                                                if (textView54 != null) {
                                                                                    i24 = 2131363786;
                                                                                    TextView textView55 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363786);
                                                                                    if (textView55 != null) {
                                                                                        i24 = 2131363791;
                                                                                        TextView textView56 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363791);
                                                                                        if (textView56 != null) {
                                                                                            i24 = 2131363792;
                                                                                            TextView textView57 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363792);
                                                                                            if (textView57 != null) {
                                                                                                i24 = 2131363897;
                                                                                                TextView textView58 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363897);
                                                                                                if (textView58 != null) {
                                                                                                    i24 = 2131364364;
                                                                                                    TextView textView59 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364364);
                                                                                                    if (textView59 != null) {
                                                                                                        i24 = 2131364365;
                                                                                                        TextView textView60 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364365);
                                                                                                        if (textView60 != null) {
                                                                                                            i24 = 2131364377;
                                                                                                            TextView textView61 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364377);
                                                                                                            if (textView61 != null) {
                                                                                                                i24 = 2131364396;
                                                                                                                TextView textView62 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364396);
                                                                                                                if (textView62 != null) {
                                                                                                                    i24 = 2131364398;
                                                                                                                    TextView textView63 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364398);
                                                                                                                    if (textView63 != null) {
                                                                                                                        i24 = 2131364428;
                                                                                                                        TextView textView64 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364428);
                                                                                                                        if (textView64 != null) {
                                                                                                                            i24 = 2131364604;
                                                                                                                            TextView textView65 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364604);
                                                                                                                            if (textView65 != null) {
                                                                                                                                break;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate8.getResources().getResourceName(i24)));
                break;
            case 18:
                int i25 = InformationActivity.P;
                View inflate9 = ((InformationActivity) obj).getLayoutInflater().inflate(2131558581, (ViewGroup) null, false);
                int i26 = 2131362640;
                if (((LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362640)) != null) {
                    i26 = 2131363502;
                    Toolbar toolbar7 = (Toolbar) ViewBindings.findChildViewById(inflate9, 2131363502);
                    if (toolbar7 != null) {
                        i26 = 2131363674;
                        TextView textView66 = (TextView) ViewBindings.findChildViewById(inflate9, 2131363674);
                        if (textView66 != null) {
                            i26 = 2131363793;
                            TextView textView67 = (TextView) ViewBindings.findChildViewById(inflate9, 2131363793);
                            if (textView67 != null) {
                                i26 = 2131363878;
                                TextView textView68 = (TextView) ViewBindings.findChildViewById(inflate9, 2131363878);
                                if (textView68 != null) {
                                    i26 = 2131364002;
                                    TextView textView69 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364002);
                                    if (textView69 != null) {
                                        i26 = 2131364259;
                                        TextView textView70 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364259);
                                        if (textView70 != null) {
                                            i26 = 2131364359;
                                            TextView textView71 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364359);
                                            if (textView71 != null) {
                                                i26 = 2131364404;
                                                TextView textView72 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364404);
                                                if (textView72 != null) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate9.getResources().getResourceName(i26)));
                break;
            case 19:
                int i27 = LanguageSettingsActivity.S;
                View inflate10 = ((LanguageSettingsActivity) obj).getLayoutInflater().inflate(2131558589, (ViewGroup) null, false);
                int i28 = 2131362795;
                View findChildViewById8 = ViewBindings.findChildViewById(inflate10, 2131362795);
                if (findChildViewById8 != null) {
                    i28 = 2131363329;
                    RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(inflate10, 2131363329);
                    if (recyclerView5 != null) {
                        i28 = 2131363543;
                        Toolbar toolbar8 = (Toolbar) ViewBindings.findChildViewById(inflate10, 2131363543);
                        if (toolbar8 != null) {
                            i28 = 2131364405;
                            TextView textView73 = (TextView) ViewBindings.findChildViewById(inflate10, 2131364405);
                            if (textView73 != null) {
                                break;
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate10.getResources().getResourceName(i28)));
                break;
            case 20:
                int i29 = ListsActivity.S;
                View inflate11 = ((ListsActivity) obj).getLayoutInflater().inflate(2131558673, (ViewGroup) null, false);
                int i30 = 2131362185;
                if (((FrameLayout) ViewBindings.findChildViewById(inflate11, 2131362185)) != null) {
                    i30 = 2131362657;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(inflate11, 2131362657);
                    if (linearLayout3 != null) {
                        i30 = 2131362679;
                        if (((LinearLayout) ViewBindings.findChildViewById(inflate11, 2131362679)) != null) {
                            i30 = 2131362710;
                            View findChildViewById9 = ViewBindings.findChildViewById(inflate11, 2131362710);
                            if (findChildViewById9 != null) {
                                e2.d c9 = e2.d.c(findChildViewById9);
                                i30 = 2131362720;
                                View findChildViewById10 = ViewBindings.findChildViewById(inflate11, 2131362720);
                                if (findChildViewById10 != null) {
                                    e2.d c10 = e2.d.c(findChildViewById10);
                                    i30 = 2131362782;
                                    View findChildViewById11 = ViewBindings.findChildViewById(inflate11, 2131362782);
                                    if (findChildViewById11 != null) {
                                        e2.d c11 = e2.d.c(findChildViewById11);
                                        i30 = 2131362797;
                                        View findChildViewById12 = ViewBindings.findChildViewById(inflate11, 2131362797);
                                        if (findChildViewById12 != null) {
                                            i30 = 2131363544;
                                            Toolbar toolbar9 = (Toolbar) ViewBindings.findChildViewById(inflate11, 2131363544);
                                            if (toolbar9 != null) {
                                                i30 = 2131364406;
                                                TextView textView74 = (TextView) ViewBindings.findChildViewById(inflate11, 2131364406);
                                                if (textView74 != null) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate11.getResources().getResourceName(i30)));
                break;
            case 21:
                int i31 = LoginActivity.W;
                View inflate12 = ((LoginActivity) obj).getLayoutInflater().inflate(2131558677, (ViewGroup) null, false);
                int i32 = 2131362798;
                View findChildViewById13 = ViewBindings.findChildViewById(inflate12, 2131362798);
                if (findChildViewById13 != null) {
                    i32 = 2131362827;
                    View findChildViewById14 = ViewBindings.findChildViewById(inflate12, 2131362827);
                    if (findChildViewById14 != null) {
                        int i33 = 2131362154;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(findChildViewById14, 2131362154);
                        if (editText3 != null) {
                            i33 = 2131362159;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(findChildViewById14, 2131362159);
                            if (editText4 != null) {
                                i33 = 2131362364;
                                if (((ImageView) ViewBindings.findChildViewById(findChildViewById14, 2131362364)) != null) {
                                    LinearLayout linearLayout4 = (LinearLayout) findChildViewById14;
                                    RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById14, 2131363183);
                                    if (relativeLayout17 != null) {
                                        TextView textView75 = (TextView) ViewBindings.findChildViewById(findChildViewById14, 2131363728);
                                        if (textView75 != null) {
                                            int i34 = 2131363971;
                                            TextView textView76 = (TextView) ViewBindings.findChildViewById(findChildViewById14, 2131363971);
                                            if (textView76 != null) {
                                                i34 = 2131363977;
                                                TextView textView77 = (TextView) ViewBindings.findChildViewById(findChildViewById14, 2131363977);
                                                if (textView77 != null) {
                                                    int i35 = 2131364020;
                                                    TextView textView78 = (TextView) ViewBindings.findChildViewById(findChildViewById14, 2131364020);
                                                    if (textView78 != null) {
                                                        i35 = 2131364144;
                                                        if (((TextView) ViewBindings.findChildViewById(findChildViewById14, 2131364144)) != null) {
                                                            u uVar = new u(linearLayout4, editText3, editText4, relativeLayout17, textView75, textView76, textView77, textView78);
                                                            View findChildViewById15 = ViewBindings.findChildViewById(inflate12, 2131363430);
                                                            if (findChildViewById15 != null) {
                                                                int i36 = 2131362002;
                                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(findChildViewById15, 2131362002);
                                                                if (checkBox != null) {
                                                                    i36 = 2131362152;
                                                                    EditText editText5 = (EditText) ViewBindings.findChildViewById(findChildViewById15, 2131362152);
                                                                    if (editText5 != null) {
                                                                        i36 = 2131362155;
                                                                        EditText editText6 = (EditText) ViewBindings.findChildViewById(findChildViewById15, 2131362155);
                                                                        if (editText6 != null) {
                                                                            i36 = 2131362160;
                                                                            EditText editText7 = (EditText) ViewBindings.findChildViewById(findChildViewById15, 2131362160);
                                                                            if (editText7 != null) {
                                                                                if (((ImageView) ViewBindings.findChildViewById(findChildViewById15, 2131362364)) != null) {
                                                                                    LinearLayout linearLayout5 = (LinearLayout) findChildViewById15;
                                                                                    RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById15, 2131363183);
                                                                                    if (relativeLayout18 != null) {
                                                                                        i33 = 2131363629;
                                                                                        TextView textView79 = (TextView) ViewBindings.findChildViewById(findChildViewById15, 2131363629);
                                                                                        if (textView79 != null) {
                                                                                            TextView textView80 = (TextView) ViewBindings.findChildViewById(findChildViewById15, 2131363728);
                                                                                            if (textView80 != null) {
                                                                                                TextView textView81 = (TextView) ViewBindings.findChildViewById(findChildViewById15, 2131363977);
                                                                                                if (textView81 != null) {
                                                                                                    i33 = 2131364290;
                                                                                                    TextView textView82 = (TextView) ViewBindings.findChildViewById(findChildViewById15, 2131364290);
                                                                                                    if (textView82 != null) {
                                                                                                        h hVar = new h(linearLayout5, checkBox, editText5, editText6, editText7, relativeLayout18, textView79, textView80, textView81, textView82, 2);
                                                                                                        i32 = 2131363545;
                                                                                                        Toolbar toolbar10 = (Toolbar) ViewBindings.findChildViewById(inflate12, 2131363545);
                                                                                                        if (toolbar10 != null) {
                                                                                                            i32 = 2131364417;
                                                                                                            TextView textView83 = (TextView) ViewBindings.findChildViewById(inflate12, 2131364417);
                                                                                                            if (textView83 != null) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    i33 = 2131363977;
                                                                                                }
                                                                                            } else {
                                                                                                i33 = 2131363728;
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        i33 = 2131363183;
                                                                                    }
                                                                                }
                                                                                com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById15.getResources().getResourceName(i33)));
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                i33 = i36;
                                                                com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById15.getResources().getResourceName(i33)));
                                                            } else {
                                                                i32 = 2131363430;
                                                            }
                                                        }
                                                    }
                                                    i33 = i35;
                                                }
                                            }
                                            i33 = i34;
                                        } else {
                                            i33 = 2131363728;
                                        }
                                    } else {
                                        i33 = 2131363183;
                                    }
                                }
                            }
                        }
                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById14.getResources().getResourceName(i33)));
                        break;
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate12.getResources().getResourceName(i32)));
                break;
            case 22:
                MainActivity mainActivity = (MainActivity) obj;
                mainActivity.f3307e0 = null;
                mainActivity.Q0();
                break;
            case 23:
                break;
            case 24:
                int i37 = MyApps.f3328g0;
                View inflate13 = ((MyApps) obj).getLayoutInflater().inflate(2131558737, (ViewGroup) null, false);
                int i38 = 2131362701;
                View findChildViewById16 = ViewBindings.findChildViewById(inflate13, 2131362701);
                if (findChildViewById16 != null) {
                    m w2 = m.w(findChildViewById16);
                    i38 = 2131362801;
                    View findChildViewById17 = ViewBindings.findChildViewById(inflate13, 2131362801);
                    if (findChildViewById17 != null) {
                        i38 = 2131362944;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(inflate13, 2131362944);
                        if (nestedScrollView != null) {
                            i38 = 2131363331;
                            RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(inflate13, 2131363331);
                            if (recyclerView6 != null) {
                                i38 = 2131363401;
                                SearchView searchView = (SearchView) ViewBindings.findChildViewById(inflate13, 2131363401);
                                if (searchView != null) {
                                    i38 = 2131363550;
                                    Toolbar toolbar11 = (Toolbar) ViewBindings.findChildViewById(inflate13, 2131363550);
                                    if (toolbar11 != null) {
                                        i38 = 2131364085;
                                        TextView textView84 = (TextView) ViewBindings.findChildViewById(inflate13, 2131364085);
                                        if (textView84 != null) {
                                            i38 = 2131364448;
                                            TextView textView85 = (TextView) ViewBindings.findChildViewById(inflate13, 2131364448);
                                            if (textView85 != null) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate13.getResources().getResourceName(i38)));
                break;
            case 25:
                break;
            case 26:
                int i39 = NotificationsRegistryActivity.T;
                View inflate14 = ((NotificationsRegistryActivity) obj).getLayoutInflater().inflate(2131558758, (ViewGroup) null, false);
                int i40 = 2131362804;
                View findChildViewById18 = ViewBindings.findChildViewById(inflate14, 2131362804);
                if (findChildViewById18 != null) {
                    i40 = 2131363332;
                    RecyclerView recyclerView7 = (RecyclerView) ViewBindings.findChildViewById(inflate14, 2131363332);
                    if (recyclerView7 != null) {
                        i40 = 2131363552;
                        Toolbar toolbar12 = (Toolbar) ViewBindings.findChildViewById(inflate14, 2131363552);
                        if (toolbar12 != null) {
                            i40 = 2131364079;
                            TextView textView86 = (TextView) ViewBindings.findChildViewById(inflate14, 2131364079);
                            if (textView86 != null) {
                                i40 = 2131364407;
                                TextView textView87 = (TextView) ViewBindings.findChildViewById(inflate14, 2131364407);
                                if (textView87 != null) {
                                    break;
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate14.getResources().getResourceName(i40)));
                break;
            case 27:
                int i41 = OldVersionsActivity.S;
                View inflate15 = ((OldVersionsActivity) obj).getLayoutInflater().inflate(2131558760, (ViewGroup) null, false);
                int i42 = 2131362805;
                View findChildViewById19 = ViewBindings.findChildViewById(inflate15, 2131362805);
                if (findChildViewById19 != null) {
                    i42 = 2131363333;
                    RecyclerView recyclerView8 = (RecyclerView) ViewBindings.findChildViewById(inflate15, 2131363333);
                    if (recyclerView8 != null) {
                        i42 = 2131363553;
                        if (((Toolbar) ViewBindings.findChildViewById(inflate15, 2131363553)) != null) {
                            i42 = 2131364080;
                            TextView textView88 = (TextView) ViewBindings.findChildViewById(inflate15, 2131364080);
                            if (textView88 != null) {
                                i42 = 2131364439;
                                if (((TextView) ViewBindings.findChildViewById(inflate15, 2131364439)) != null) {
                                    break;
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate15.getResources().getResourceName(i42)));
                break;
            default:
                int i43 = OrganizationActivity.R;
                View inflate16 = ((OrganizationActivity) obj).getLayoutInflater().inflate(2131558761, (ViewGroup) null, false);
                int i44 = 2131362357;
                FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(inflate16, 2131362357);
                if (fullWidthImageView != null) {
                    i44 = 2131362397;
                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(inflate16, 2131362397);
                    if (imageView8 != null) {
                        i44 = 2131362428;
                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(inflate16, 2131362428);
                        if (imageView9 != null) {
                            i44 = 2131362515;
                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(inflate16, 2131362515);
                            if (imageView10 != null) {
                                i44 = 2131362530;
                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(inflate16, 2131362530);
                                if (imageView11 != null) {
                                    i44 = 2131362806;
                                    View findChildViewById20 = ViewBindings.findChildViewById(inflate16, 2131362806);
                                    if (findChildViewById20 != null) {
                                        i44 = 2131363161;
                                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate16, 2131363161)) != null) {
                                            i44 = 2131363162;
                                            RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(inflate16, 2131363162);
                                            if (relativeLayout19 != null) {
                                                i44 = 2131363334;
                                                RecyclerView recyclerView9 = (RecyclerView) ViewBindings.findChildViewById(inflate16, 2131363334);
                                                if (recyclerView9 != null) {
                                                    i44 = 2131363482;
                                                    ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(inflate16, 2131363482);
                                                    if (scrollView2 != null) {
                                                        i44 = 2131363554;
                                                        Toolbar toolbar13 = (Toolbar) ViewBindings.findChildViewById(inflate16, 2131363554);
                                                        if (toolbar13 != null) {
                                                            i44 = 2131363794;
                                                            TextView textView89 = (TextView) ViewBindings.findChildViewById(inflate16, 2131363794);
                                                            if (textView89 != null) {
                                                                i44 = 2131364052;
                                                                TextView textView90 = (TextView) ViewBindings.findChildViewById(inflate16, 2131364052);
                                                                if (textView90 != null) {
                                                                    i44 = 2131364209;
                                                                    TextView textView91 = (TextView) ViewBindings.findChildViewById(inflate16, 2131364209);
                                                                    if (textView91 != null) {
                                                                        i44 = 2131364449;
                                                                        TextView textView92 = (TextView) ViewBindings.findChildViewById(inflate16, 2131364449);
                                                                        if (textView92 != null) {
                                                                            i44 = 2131364605;
                                                                            TextView textView93 = (TextView) ViewBindings.findChildViewById(inflate16, 2131364605);
                                                                            if (textView93 != null) {
                                                                                i44 = 2131364631;
                                                                                View findChildViewById21 = ViewBindings.findChildViewById(inflate16, 2131364631);
                                                                                if (findChildViewById21 != null) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate16.getResources().getResourceName(i44)));
                break;
        }
        return null;
    }
}
