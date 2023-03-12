package ru.artbez.shopapptest.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import ru.artbez.shopapptest.MAIN
import ru.artbez.shopapptest.R
import ru.artbez.shopapptest.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var mfrbinding: FragmentMainBinding? = null
    private val binding get() = mfrbinding!!
    lateinit var navController2: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mfrbinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController2 = Navigation.findNavController(MAIN, R.id.nav_host2)
        initial()
    }

    private fun initial() {

        startIcons()
        var fragmentPosition = 0
        val bundle = Bundle()
        binding.tabbar.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        when(fragmentPosition) {
                            1 -> navController2.navigate(R.id.action_favoriteFragment_to_page1Fragment, bundle)
                            2 -> navController2.navigate(R.id.action_cartFragment_to_page1Fragment, bundle)
                            3 -> navController2.navigate(R.id.action_chatFragment_to_page1Fragment, bundle)
                            4 -> navController2.navigate(R.id.action_profileFragment_to_page1Fragment, bundle)
                        }
                        tab.icon?.setTint(ContextCompat.getColor(MAIN, R.color.black))
                        tab.icon?.alpha = 250
                        fragmentPosition = 0
                    }
                    1 -> {
                        when(fragmentPosition) {
                            0 -> navController2.navigate(R.id.action_page1Fragment_to_favoriteFragment, bundle)
                            2 -> navController2.navigate(R.id.action_cartFragment_to_favoriteFragment, bundle)
                            3 -> navController2.navigate(R.id.action_chatFragment_to_favoriteFragment, bundle)
                            4 -> navController2.navigate(R.id.action_profileFragment_to_favoriteFragment, bundle)
                        }
                        tab.icon?.setTint(ContextCompat.getColor(MAIN, R.color.black))
                        tab.icon?.alpha = 250
                        fragmentPosition = 1
                    }
                    2 -> {
                        when(fragmentPosition) {
                            0 -> navController2.navigate(R.id.action_page1Fragment_to_cartFragment, bundle)
                            1 -> navController2.navigate(R.id.action_favoriteFragment_to_cartFragment, bundle)
                            3 -> navController2.navigate(R.id.action_chatFragment_to_cartFragment, bundle)
                            4 -> navController2.navigate(R.id.action_profileFragment_to_cartFragment, bundle)
                        }
                        tab.icon?.setTint(ContextCompat.getColor(MAIN, R.color.black))
                        tab.icon?.alpha = 250
                        fragmentPosition = 2
                    }
                    3 -> {
                        when(fragmentPosition) {
                            0 -> navController2.navigate(R.id.action_page1Fragment_to_chatFragment, bundle)
                            1 -> navController2.navigate(R.id.action_favoriteFragment_to_chatFragment, bundle)
                            2 -> navController2.navigate(R.id.action_cartFragment_to_chatFragment, bundle)
                            4 -> navController2.navigate(R.id.action_profileFragment_to_chatFragment, bundle)
                        }
                        tab.icon?.setTint(ContextCompat.getColor(MAIN, R.color.black))
                        tab.icon?.alpha = 250
                        fragmentPosition = 3
                    }
                    4 -> {
                        when(fragmentPosition) {
                            0 -> navController2.navigate(R.id.action_page1Fragment_to_profileFragment, bundle)
                            1 -> navController2.navigate(R.id.action_favoriteFragment_to_profileFragment, bundle)
                            2 -> navController2.navigate(R.id.action_cartFragment_to_profileFragment, bundle)
                            3 -> navController2.navigate(R.id.action_chatFragment_to_profileFragment, bundle)
                        }
                        tab.icon?.setTint(ContextCompat.getColor(MAIN, R.color.black))
                        tab.icon?.alpha = 250
                        fragmentPosition = 4
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        tab.icon?.alpha = 70
                    }
                    1 -> {
                        tab.icon?.alpha = 70
                    }
                    2 -> {
                        tab.icon?.alpha = 70
                    }
                    3 -> {
                        tab.icon?.alpha = 70
                    }
                    4 -> {
                        tab.icon?.alpha = 70
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.icon?.setTint(ContextCompat.getColor(MAIN, R.color.black))
                tab?.icon?.alpha = 250
            }
        })
    }

    private fun startIcons() {
        val a = binding.tabbar.newTab().setIcon(R.drawable.baseline_home_24)
        val b = binding.tabbar.newTab().setIcon(R.drawable.baseline_favorite_border_24_2)
        val c = binding.tabbar.newTab().setIcon(R.drawable.baseline_shopping_cart_24)
        val d = binding.tabbar.newTab().setIcon(R.drawable.baseline_chat_bubble_outline_24)
        val e = binding.tabbar.newTab().setIcon(R.drawable.baseline_person_outline_24)

        binding.tabbar.addTab(a)
        binding.tabbar.addTab(b)
        binding.tabbar.addTab(c)
        binding.tabbar.addTab(d)
        binding.tabbar.addTab(e)

        b.icon?.alpha = 70
        c.icon?.alpha = 70
        d.icon?.alpha = 70
        e.icon?.alpha = 70
    }

    override fun onDestroy() {
        super.onDestroy()
        mfrbinding = null
    }
}