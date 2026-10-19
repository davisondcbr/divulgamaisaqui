package br.com.divulgamaisaqui.tv;
import android.content.BroadcastReceiver; import android.content.Context; import android.content.Intent;
public class BootReceiver extends BroadcastReceiver {
 @Override public void onReceive(Context c, Intent i) {
  if (Intent.ACTION_BOOT_COMPLETED.equals(i.getAction())) {
   Intent launch = new Intent(c, MainActivity.class); launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
   try { c.startActivity(launch); } catch (Exception ignored) { /* Android may restrict boot launches */ }
  }
 }
}
