package $package$

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.widget.TextView

class MainActivity extends ActionBarActivity {
  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)
    findView(TR.textview).foreach(_.setText("hello, world!"))
  }
}
