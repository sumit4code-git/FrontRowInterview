package com.example.frontrowinterview.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.frontrowinterview.R
import com.example.frontrowinterview.fragment.StartFragmentDirections
import com.example.frontrowinterview.models.UsersItem
import kotlinx.android.synthetic.main.users_items.view.*


class VPAdapter(private val parentFragment: Fragment?):RecyclerView.Adapter<VPAdapter.VPViewHolder>()  {

    private val differCallback = object : DiffUtil.ItemCallback<UsersItem>() {
        override fun areItemsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
            return oldItem === newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class VPViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VPViewHolder {
        return VPViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.users_items, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VPViewHolder, position: Int) {
        val item=differ.currentList[position]
        holder.itemView.apply {
            this.findViewById<TextView>(R.id.name).text=item.name
            this.findViewById<TextView>(R.id.user_name).text=item.username
            this.findViewById<TextView>(R.id.email).text=item.email
            this.findViewById<TextView>(R.id.phone).text=item.phone
            this.findViewById<TextView>(R.id.website).text=item.website
        }
        holder.itemView.phone.setOnClickListener {
            val num=it.findViewById<TextView>(R.id.phone).text.subSequence(0,13)
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:<$num>")
            parentFragment?.startActivity(intent)
        }
        holder.itemView.email.setOnClickListener {
            val mail=it.findViewById<TextView>(R.id.email).text
            val recipients = arrayOf(mail.toString())
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.type = "text/html"
            intent.setPackage("com.google.android.gm")
            parentFragment?.startActivity(Intent.createChooser(intent, "Send mail"))
        }
        holder.itemView.website.setOnClickListener {
            val website=it.findViewById<TextView>(R.id.website).text
            val action = StartFragmentDirections.actionStartFragmentToWebsite(website.toString())
            NavHostFragment.findNavController(parentFragment!!).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    fun submitList(list: List<UsersItem>) {
        differ.submitList(list)
    }


}