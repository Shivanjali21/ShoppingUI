package com.practice.shoppingapp.fragments.btmnavi.home.shophome.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.FragmentNotificationBinding
import com.practice.shoppingapp.models.homeshop.notiData.NotiData

class NotificationFragment : Fragment(R.layout.fragment_notification) {

    private val binding : FragmentNotificationBinding by  lazy {
       FragmentNotificationBinding.inflate(layoutInflater)
    }
    private lateinit var notiList : ArrayList<NotiData>
    private val notificationAdapter : NotificationAdapter by lazy {
        NotificationAdapter(notiList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {

            ivBackArrow.setOnClickListener {
                findNavController().popBackStack()
            }

            notiList = ArrayList()
            notiList.add(NotiData(R.drawable.fs_model_one, "New Outfit for you  show now ","3:00 pm"))
            notiList.add(NotiData(R.drawable.fs_model_two, "New Outfit for you  show now ","2:00 pm"))
            notiList.add(NotiData(R.drawable.fs_model_three, "New Outfit for you  show now ","8:30 am"))
            notiList.add(NotiData(R.drawable.fs_blouse, "New Outfit for you  show now ","9:00 pm"))
            notiList.add(NotiData(R.drawable.fs_model_four, "New Outfit for you  show now ","10:00 am"))

            rvNotification.apply {
               adapter = notificationAdapter
            }
        }

        return binding.nFragRoot
    }
}