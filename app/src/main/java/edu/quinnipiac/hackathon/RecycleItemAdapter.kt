/*package edu.quinnipiac.hackathon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
class RecycleItemAdapter(val context: Context, var navController: NavController) : RecyclerView.Adapter<RecycleItemAdapter.RecycleItemViewHolder>() {

    override fun getItemCount() = data.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song,parent,false)
            return RecycleItemViewHolder(view, context, navController)
        }

        override fun onBindViewHolder(holder: RecycleItemViewHolder, position: Int) {
            //val item = songs[position]
            holder.bind(position)
        }
        class RecycleItemViewHolder(itemView: View, private val context: Context, var navController: NavController)
            : RecyclerView.ViewHolder(itemView){

        }

        }*/


