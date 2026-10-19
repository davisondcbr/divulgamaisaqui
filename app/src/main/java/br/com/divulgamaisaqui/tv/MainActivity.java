package br.com.divulgamaisaqui.tv;
import android.app.Activity; import android.app.admin.DevicePolicyManager; import android.content.ComponentName;
import android.content.Context; import android.os.Bundle; import android.view.View; import android.view.WindowManager;
import android.webkit.WebChromeClient; import android.webkit.WebSettings; import android.webkit.WebView; import android.webkit.WebViewClient;
public class MainActivity extends Activity {
 private WebView web;
 private static final String TV_URL="https://davisondcbr.github.io/divulgamaisaqui/tv.html";
 @Override public void onCreate(Bundle state){super.onCreate(state);
  getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); immersive();
  web=new WebView(this);setContentView(web);
  WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
  s.setMediaPlaybackRequiresUserGesture(false); s.setAllowFileAccess(false); s.setAllowContentAccess(false);
  web.setWebViewClient(new WebViewClient(){@Override public void onPageFinished(WebView v,String u){ immersive(); }});
  web.setWebChromeClient(new WebChromeClient());
  web.loadUrl(TV_URL); enableManagedKioskIfAllowed();
 }
 private void immersive(){getWindow().getDecorView().setSystemUiVisibility(5894 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
 private void enableManagedKioskIfAllowed(){try{ DevicePolicyManager d=(DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
  ComponentName admin=new ComponentName(this,DeviceAdmin.class);
  if(d.isDeviceOwnerApp(getPackageName())){d.setLockTaskPackages(admin,new String[]{getPackageName()});startLockTask();}
 }catch(Exception ignored){}}
 @Override public void onBackPressed(){ /* reprodução protegida contra retorno acidental */ }
 @Override protected void onResume(){super.onResume();immersive();}
 @Override protected void onDestroy(){if(web!=null){web.destroy();}super.onDestroy();}
}
