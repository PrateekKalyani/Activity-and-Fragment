package com.example.multipleviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multipleviewapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val itemList by lazy { mutableListOf<Any>() }
    private val viewTypeList by lazy { mutableListOf<Int>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        createItemList()
        setUp()
    }

    private fun setUp() {

        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerAdapter(
                this@MainActivity,
                itemList = itemList,
                viewTypeList = viewTypeList
            )
        }
    }

    private fun createItemList() {

        itemList.add(PostModel(resources.getString(R.string.post_text_one)))
        viewTypeList.add(ViewType.Post.viewType)

        itemList.add(PostModel(resources.getString(R.string.post_text_one)))
        viewTypeList.add(ViewType.Post.viewType)

        itemList.add(PostModel(resources.getString(R.string.post_text_one)))
        viewTypeList.add(ViewType.Post.viewType)

        itemList.add(PostModel(resources.getString(R.string.post_text_one)))
        viewTypeList.add(ViewType.Post.viewType)

        itemList.add(PostModel(resources.getString(R.string.post_text_one)))
        viewTypeList.add(ViewType.Post.viewType)

        itemList.add(ImageModel(imageUrl = resources.getString(R.string.image_url_one)))
        viewTypeList.add(ViewType.Image.viewType)

        itemList.add(ImageModel(imageUrl = resources.getString(R.string.image_url_one)))
        viewTypeList.add(ViewType.Image.viewType)

        itemList.add(ImageModel(imageUrl = resources.getString(R.string.image_url_one)))
        viewTypeList.add(ViewType.Image.viewType)
    }
}