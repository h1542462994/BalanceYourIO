package tty.balanceyourio.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import tty.balanceyourio.page.AnalysisFragment
import tty.balanceyourio.page.DataFragment
import tty.balanceyourio.page.UserFragment

class MainFragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private var pages: ArrayList<Fragment> = ArrayList()

    init {
        pages.add(DataFragment())
        pages.add(AnalysisFragment())
        pages.add(UserFragment())
    }
    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(p0: Int): Fragment? {
        return pages[p0]
    }

}