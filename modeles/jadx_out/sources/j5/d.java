package j5;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.uptodown.activities.LoginActivity;
import com.uptodown.services.AuthenticatorService;
import org.json.JSONObject;
import x4.g2;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends AbstractAccountAuthenticator {

    /* renamed from: a, reason: collision with root package name */
    public final AuthenticatorService f6665a;

    public d(AuthenticatorService authenticatorService) {
        super(authenticatorService);
        this.f6665a = authenticatorService;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        Intent intent = new Intent(this.f6665a, (Class<?>) LoginActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        bundle.getClass();
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        accountAuthenticatorResponse.getClass();
        str.getClass();
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
            u2.c(this.f6665a);
        }
        accountRemovalAllowed.getClass();
        return accountRemovalAllowed;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        String password;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        accountAuthenticatorResponse.getClass();
        account.getClass();
        str.getClass();
        bundle.getClass();
        AuthenticatorService authenticatorService = this.f6665a;
        AccountManager accountManager = AccountManager.get(authenticatorService);
        String peekAuthToken = accountManager.peekAuthToken(account, str);
        if (TextUtils.isEmpty(peekAuthToken) && (password = accountManager.getPassword(account)) != null) {
            String str2 = account.name;
            str2.getClass();
            g2 D = new v(authenticatorService).D(str2, password);
            if (!D.b() && (jSONObject = D.f11206d) != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                w2 w2Var = new w2();
                w2Var.b(authenticatorService, optJSONObject);
                String str3 = w2Var.f11431a;
                if (str3 != null && str3.length() > 0) {
                    w2Var.e(authenticatorService);
                }
                String str4 = null;
                try {
                    SharedPreferences sharedPreferences = authenticatorService.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("UTOKEN")) {
                        str4 = sharedPreferences.getString("UTOKEN", null);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (str4 == null || str4.length() == 0) {
                    u2.c(authenticatorService);
                }
            }
        }
        if (TextUtils.isEmpty(peekAuthToken)) {
            Intent intent = new Intent(authenticatorService, (Class<?>) LoginActivity.class);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("intent", intent);
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("authAccount", account.name);
        bundle3.putString("accountType", account.type);
        bundle3.putString("authtoken", peekAuthToken);
        return bundle3;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final String getAuthTokenLabel(String str) {
        str.getClass();
        return "Uptodown login";
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        strArr.getClass();
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        accountAuthenticatorResponse.getClass();
        account.getClass();
        str.getClass();
        bundle.getClass();
        return null;
    }
}
