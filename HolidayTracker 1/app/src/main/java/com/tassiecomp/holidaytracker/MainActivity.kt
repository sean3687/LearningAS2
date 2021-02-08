package com.tassiecomp.holidaytracker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import com.google.android.gms.ads.AdRequest;


class MainActivity : AppCompatActivity() {
    var displayListDate = mutableListOf<Long>()
    var displayListName = mutableListOf<String>()
    var displayDaysLeft = mutableListOf<Long>()

    //recycler view contents
    var displayDaysLeft_sub = mutableListOf<String>()
    var displayMDformat_sub = mutableListOf<String>()
    var displayIcon_sub = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Google ad Initilize
        MobileAds.initialize(this,"ca-app-pub-8358259317968297/2871421759")

        adView.loadAd(AdRequest.Builder().build())

        val displayIcon = intArrayOf(
            R.drawable.newyear,
            R.drawable.martin,
            R.drawable.memorial,
            R.drawable.independence,
            R.drawable.labor,
            R.drawable.veterans,
            R.drawable.thanks,
            R.drawable.christmas,
            R.drawable.newyear,
            R.drawable.newyear,
            R.drawable.martin,
            R.drawable.memorial,
            R.drawable.independence,
            R.drawable.labor,
            R.drawable.veterans,
            R.drawable.thanks,
            R.drawable.christmas,
            R.drawable.newyear
        )


        val HolidaysList_sub = arrayOf(
            "Sat Jan 1",
            "Mon Jan 18",
            "Mon May 31",
            "Mon Jul 05",
            "Tue Sep 07",
            "Thu Nov 11",
            "Thu Nov 25",
            "Mon Dec 24",
            "Fri Dec 31",
            "Sat Jan 1",
            "Mon Jan 17",
            "Mon May 30",
            "Mon Jul 04",
            "Tue Sep 05",
            "Thu Nov 11",
            "Thu Nov 24",
            "Mon Dec 26",
            "Sat Dec 31"

        )
        val holidaysList_date = arrayOf(
            "01-01-2021 00:00:00",
            "18-01-2021 00:00:00",
            "31-05-2021 00:00:00",
            "05-07-2021 00:00:00",
            "07-09-2021 00:00:00",
            "11-11-2021 00:00:00",
            "25-11-2021 00:00:00",
            "24-12-2021 00:00:00",
            "31-12-2021 00:00:00",
            "01-01-2022 00:00:00",
            "17-01-2022 00:00:00",
            "30-05-2022 00:00:00",
            "04-07-2022 00:00:00",
            "05-09-2022 00:00:00",
            "11-11-2022 00:00:00",
            "24-11-2022 00:00:00",
            "26-12-2022 00:00:00",
            "31-12-2022 00:00:00"
        )
        val holidayList_name = arrayOf(
            "New Year's Day",
            "MLK Jr.Day",
            "Memorial Day",
            "Independence Day",
            "Labor Day",
            "Veterans Day",
            "Thanksgiving",
            "Christmas Day",
            "New Year's Day",
            "New Year's Day",
            "MLK Jr.Day",
            "Memorial Day",
            "Independence Day",
            "Labor Day",
            "Veterans Day",
            "Thanksgiving",
            "Christmas Day",
            "New Year's Day"
        )

//making list

//        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
//        var countDate = ""   //""05-01-2022 00:00:00"
//        val now = Date()
//        Log.d("string", "1. $now") //1. Wed Feb 03 00:36:25 GMT 2021


        for (i in 0..17) {
            val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            val holidaysList = sdf.parse(holidaysList_date[i]).getTime()
            val currentTime = Date()
            val currentDate = currentTime.getTime()




            if (holidaysList > currentDate) {

                displayListDate.add(holidaysList)
                displayListName.add(holidayList_name[i])
                displayMDformat_sub.add(HolidaysList_sub[i])
                displayIcon_sub.add(displayIcon[i])

            } else {

            }
        }
        //making days difference List
        for (i in displayListDate.indices){
            val StartCountDown = displayListDate[i] - Date().getTime()
            val startCountDown_sub = "D-${((displayListDate[i] - Date().getTime())*1.1574E-8).toInt()}"
            displayDaysLeft.add(StartCountDown)
            displayDaysLeft_sub.add(startCountDown_sub)

        }


        Log.d("TAG", "$displayDaysLeft_sub")
        // title count down


        try {
            daysleft_title_main.start(displayDaysLeft[0]) // start count down number
            holiday_title_main.setText(displayListName[0])
            holiday_image_main.setImageResource(displayIcon_sub[0] as Int)
//            holder.iconSub.setImageResource(icon[position] as Int)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

//make recyclerView
        recycler_sub_main.layoutManager = LinearLayoutManager(this)
        recycler_sub_main.adapter = RecyclerAdapter(displayDaysLeft_sub, displayListName, displayMDformat_sub, displayIcon_sub)



    }


}







