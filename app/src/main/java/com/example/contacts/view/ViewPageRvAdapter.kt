package com.example.contacts.view


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.models.Contact


private var userTouchedPosition:Int? = null  //static, because i want to access the subItemLayout to change the visibility
private var selectedLayout:LinearLayout? = null
private const val TAG = "ViewPageRvAdapter"

class ViewPageRvAdapter(val contacts: MutableList<Contact>) : RecyclerView.Adapter<ViewPageRvAdapter.ViewHolder>()
{

    private lateinit var parent: ViewGroup
    private lateinit var itemTextView: TextView


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var profileLayout: LinearLayout
        private lateinit var subItemLayout: LinearLayout
        private  var currentPosition:Int? = null
        private lateinit var callIcon:ImageButton
        private lateinit var msgIcon:ImageButton
        private lateinit var infoIcon:ImageButton

        init{

            profileLayout = itemView.findViewById(R.id.profile_ll)
            subItemLayout = itemView.findViewById(R.id.icon_ll)

            profileLayout.setOnClickListener {
                Log.v(TAG,"clicked")
                if(subItemLayout.visibility == View.GONE )
                {
                    Log.v(TAG,"entered")
                    subItemLayout.visibility = View.VISIBLE
                    selectedLayout?.visibility = View.GONE
                    selectedLayout = subItemLayout
                    userTouchedPosition = currentPosition
                }
                else
                {
                    subItemLayout.visibility = View.GONE
                    userTouchedPosition= null
                    selectedLayout = null
                }
            }
        }

        fun bindItems(position:Int) {
            itemTextView = itemView.findViewById(R.id.tvName)
            itemTextView.text = "${contacts[position].firstName} ${contacts[position].lastName}"

            callIcon = itemView.findViewById(R.id.btncall)
            msgIcon = itemView.findViewById(R.id.btnmessage)
            infoIcon = itemView.findViewById(R.id.btninfo)

            this.currentPosition = position
            subItemLayout = itemView.findViewById(R.id.icon_ll)

            if(position != userTouchedPosition)
                subItemLayout.visibility = View.GONE
            else
                subItemLayout.visibility = View.VISIBLE

            callIcon.setOnClickListener{

            }

            msgIcon.setOnClickListener {

            }

            infoIcon.setOnClickListener {

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.parent = parent
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(position)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}