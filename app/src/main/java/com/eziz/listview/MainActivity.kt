package com.eziz.listview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.planets_card.view.*

class MainActivity : AppCompatActivity() {
    var constList = ArrayList<Planets>()
    var adapter: PlanetsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constList.add(Planets("Yer", "Aciqlama", R.drawable.earth))
        constList.add(Planets("Uran", "Aciqlama", R.drawable.uranus))
        constList.add(Planets("Yupiter", "Aciqlama", R.drawable.jupiter))
        constList.add(Planets("Mars", "Aciqlama", R.drawable.mars))
        constList.add(Planets("Merkuri", "Aciqlama", R.drawable.mercury))
        constList.add(Planets("Neptun", "Aciqlama", R.drawable.neptune))
        constList.add(Planets("Pluton", "Aciqlama", R.drawable.pluto))
        constList.add(Planets("Venera", "Aciqlama", R.drawable.venus))
        constList.add(Planets("Saturn", "Aciqlama", R.drawable.saturn))
        adapter = PlanetsAdapter(constList, this)
        listView.adapter = adapter
    }

    class PlanetsAdapter : BaseAdapter {
        var constList = ArrayList<Planets>()
        var context: Context? = null


        constructor(constList: ArrayList<Planets>, context: Context?) : super() {
            this.constList = constList
            this.context = context
        }


        override fun getCount(): Int {
            return constList.size
        }

        override fun getItem(position: Int): Any {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posPlanets = constList[position]
            var inflator =
                context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var planetCard = inflator.inflate(R.layout.planets_card, null)
            planetCard.earth_card.setImageResource(posPlanets.constPicture!!)
            planetCard.earth_card_info.text = posPlanets.constInfo
            planetCard.earth_card_name.text = posPlanets.constName

            return planetCard
        }
    }
}