package study.talyrus.mybuttommenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM="item"

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottom_menu)
        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.favorites -> {
                    val favoritesFragment = FavoritesFragment()
                    replaceFrafment(favoritesFragment)
                }
                R.id.music -> {
                    val musicFragment = MusicFragment()
                    replaceFrafment(musicFragment)
                }
                R.id.places -> {
                    val placesFragment = PlacesFragment()
                    replaceFrafment(placesFragment)
                }
                R.id.news -> {
                    val newsFragment = NewsFragment()
                    replaceFrafment(newsFragment)
                }
            }
            true
        }
        bottomMenu.selectedItemId=if(savedInstanceState==null)R.id.favorites else savedInstanceState.getInt(
            LAST_SELECTED_ITEM)
    }

    private fun replaceFrafment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM,bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}