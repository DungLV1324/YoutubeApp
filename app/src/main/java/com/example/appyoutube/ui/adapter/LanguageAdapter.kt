package com.example.appyoutube.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.appyoutube.R
import com.example.appyoutube.data.model.Language
import com.example.appyoutube.databinding.FragmentLanguageBinding
import com.example.appyoutube.databinding.ItemLanguageBinding
import com.example.appyoutube.ui.base.BaseBindingAdapter
import com.example.appyoutube.utils.extention.setOnSafeClick

class LanguageAdapter : BaseBindingAdapter<Language, ItemLanguageBinding>(
    object : DiffUtil.ItemCallback<Language>() {
        override fun areItemsTheSame(oldItem: Language, newItem: Language): Boolean =
            oldItem.code == newItem.code

        override fun areContentsTheSame(oldItem: Language, newItem: Language): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onBindViewHolderBase(holder: BaseHolder<ItemLanguageBinding>, position: Int) {
        with(getItem(holder.adapterPosition)) {
            holder.apply {
                with(binding) {
//                    itemView.context
                    tvLanguage.text = name
                    Glide.with(imAvatar.context)
                        .load(image)
                        .into(imAvatar)
                }
                itemView.setOnSafeClick {

                }

            }
        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_language
}