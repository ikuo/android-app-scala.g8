package $package$

import android.os.Bundle
import android.app.Activity
import android.widget.TextView

class MainActivity extends Activity with TypedActivity {
  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)
    findView(TR.textview).setText("hello, world!"))
  }
}
