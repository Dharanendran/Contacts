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


private var userTouchedPositionInAllContactsPage:Int? = null  //static, because i want to access the subItemLayout to change the visibility
private var selectedLayoutInAllContactsPage:LinearLayout? = null

private var userTouchedPositionInFavouritePage:Int? = null
private var selectedLayoutInFavouritePage:LinearLayout? = null

private var userTouchedPositionInRecentPage:Int? = null
private var selectedLayoutInRecentPage:LinearLayout? = null

private const val TAG = "ViewPageRvAdapter"

class ViewPageRvAdapter(val contacts: MutableList<Contact> , val pageType:PageType) : RecyclerView.Adapter<ViewPageRvAdapter.ViewHolder>()
{

    private lateinit var parent: ViewGroup
    private lateinit var itemTextView: TextView

    enum class PageType{ ALLCONTACTS , FAVOURITES , RECENTSEARCH }

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

                    when(pageType){
                       PageType.ALLCONTACTS -> { selectedLayoutInAllContactsPage?.visibility = View.GONE
                                                selectedLayoutInAllContactsPage = subItemLayout
                                                userTouchedPositionInAllContactsPage = currentPosition  }

                        PageType.FAVOURITES -> { selectedLayoutInFavouritePage?.visibility = View.GONE
                                                  selectedLayoutInFavouritePage = subItemLayout
                                                  userTouchedPositionInFavouritePage = currentPosition }

                        PageType.RECENTSEARCH -> { selectedLayoutInRecentPage?.visibility = View.GONE
                                                   selectedLayoutInRecentPage = subItemLayout
                                                   userTouchedPositionInRecentPage = currentPosition }
                    }
                }
                else
                {
                    subItemLayout.visibility = View.GONE

                    when(pageType){
                        PageType.ALLCONTACTS -> { userTouchedPositionInAllContactsPage = null
                                                 selectedLayoutInAllContactsPage = null }

                        PageType.FAVOURITES -> { userTouchedPositionInFavouritePage = null
                                                  selectedLayoutInFavouritePage = null }

                        PageType.RECENTSEARCH -> { userTouchedPositionInRecentPage = null
                                                   selectedLayoutInRecentPage = null }
                    }
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

            if( position != when(pageType)
                           { PageType.ALLCONTACTS -> userTouchedPositionInAllContactsPage
                             PageType.FAVOURITES -> userTouchedPositionInFavouritePage
                             PageType.RECENTSEARCH -> userTouchedPositionInRecentPage } )

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