package com.korn.memoria.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.korn.memoria.R


public enum class TabTypes {
    ACTIVE, ARCHIVED, SETTINGS
}
public data class TAB(val title: Int = -1, val type: TabTypes)

private val tabs = arrayOf(
    TAB( R.string.tab_text_active, TabTypes.ACTIVE),
    TAB( R.string.tab_text_archived, TabTypes.ARCHIVED),
    TAB( R.string.tab_text_settings, TabTypes.SETTINGS)
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PageFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(tabs[position].title)
    }

    override fun getCount(): Int {
        return tabs.size
    }
}