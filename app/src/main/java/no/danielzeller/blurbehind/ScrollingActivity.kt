package no.danielzeller.blurbehind

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_scrolling.*
import no.danielzeller.blurbehindlib.renderers.BlurMode

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        blurBehindView.viewBehind = root

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                blurBehindView.setBlurRadius(progress.toFloat())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    fun gaussClick(view: View) {
        blurBehindView.setBlurType(BlurMode.GAUSS_1_PASS)
    }

    fun gauss2PassClick(view: View) {
        blurBehindView.setBlurType(BlurMode.GAUSS_2_PASS)
    }

    fun stackClick(view: View) {
        blurBehindView.setBlurType(BlurMode.STACK)
    }

    fun boxClick(view: View) {
        blurBehindView.setBlurType(BlurMode.BOX)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
