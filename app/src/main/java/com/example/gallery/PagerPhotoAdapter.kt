package com.example.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery.databinding.PagerPhotoViewBinding

class PagerPhotoAdapter(private val activity: AppCompatActivity) : PagingDataAdapter<PhotoItem, PagerPhotoViewHolder>(
    object : DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean { //实现成员
            return oldItem.photoId == newItem.photoId   //判断Item是否相同
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {  //实现成员
            return oldItem == newItem   //判断内容是否相同
        }
    }
) {
    override fun onBindViewHolder(holder: PagerPhotoViewHolder, position: Int) {
        holder.viewBinding.apply {
            shimmerLayout.apply {
                setShimmerColor(0x55FFFFFF)
                setShimmerAngle(30)
                startShimmerAnimation()
            }
            imageView.load(getItem(position)?.fullURL) {
                placeholder(R.drawable.photo_placeholder)
                listener { _, _ ->
                    shimmerLayout.stopShimmerAnimation()
                }
            }
            ImageGesture(
                imageView,
                DragCloseHelper(mContext = activity, parentV = root, childV = imageView)
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerPhotoViewHolder {
        return PagerPhotoViewHolder(
            PagerPhotoViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

class PagerPhotoViewHolder(val viewBinding: PagerPhotoViewBinding) : RecyclerView.ViewHolder(viewBinding.root)