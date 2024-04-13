
package edu.quinnipiac.hackathon

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView

var messages: List<String> = ArrayList();
class RecycleItemAdapter(val context: Context, var navController: NavController) : RecyclerView.Adapter<RecycleItemAdapter.RecycleItemViewHolder>() {

    override fun getItemCount() = messages.size

    fun setMessages(new_messages: List<String>) {
        messages = new_messages
        notifyDataSetChanged()
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleItemViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_responses,parent,false)

            return RecycleItemViewHolder(view, context, navController)
        }

        override fun onBindViewHolder(holder: RecycleItemViewHolder, position: Int) {
            //val item = songs[position]
            holder.bind(position)
        }


        class RecycleItemViewHolder(itemView: View, private val context: Context, var navController: NavController)
            : RecyclerView.ViewHolder(itemView){

                val textField = itemView!!.findViewById<TextView>(R.id.response)

                var pos: Int = 0;

                fun bind(position: Int) {
                    pos = position;
                    textField.setText(messages.get(pos))
                }

        }

        }


