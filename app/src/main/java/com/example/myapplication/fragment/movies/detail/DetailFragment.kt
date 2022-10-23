package com.example.myapplication.fragment.movies.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.agrument.VideoDetailArgument
import com.example.myapplication.common.*
import com.example.myapplication.common.view.LoadingDialog
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.dto.image.ImageRelated
import com.example.myapplication.dto.image.ResponseImages
import com.example.myapplication.dto.moviedetail.MovieDetail
import com.example.myapplication.dto.trailer.ResponseTrailerList
import com.example.myapplication.dto.trailer.TrailerItem
import com.example.myapplication.network.RetrofitInstance
import com.example.myapplication.network.Service
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var retrofitBuilder = RetrofitInstance.getRetrofitInstance().create(Service::class.java)
    companion object {
        const val TAG = "Detail"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        setDetailContent(createDummyDataDetailMovie(), "3.5", false)
        setImages(createDummyDataImageRelated())
        setTrailers(createDummyDataTrailers())
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item: VideoDetailArgument = arguments?.getSerializable(Argument.VIDEO_DETAIL) as VideoDetailArgument
//        getVideoDetail(item)
//        getImages(item.id)
//        getTrailers(item.id)
        settingGoBackEvent()
    }

    private fun settingGoBackEvent () {
        binding.detailInfo.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getVideoDetail(item: VideoDetailArgument) {
        retrofitBuilder.getMovieDetail( item.id).enqueue(object : Callback<MovieDetail?> {
                override fun onResponse(
                    call: Call<MovieDetail?>,
                    response: Response<MovieDetail?>
                ) {
                    val responseData = response.body() !!
                    setDetailContent(responseData, item.rating)
                }

                override fun onFailure(call: Call<MovieDetail?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

    private fun setDetailContent(item:MovieDetail, rating: String, isLoadBackground: Boolean? = true ) {
        //set loading image poster
        val detailInfo = binding.detailInfo
        Picasso.get().load(item.image.url)
            .fit()
            .centerCrop()
            .noFade()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.loading_animation)
            .into(detailInfo.avatar)
        // background layout
        if (isLoadBackground == true) {
            setBackGround(item.image.url)
        }
        // set name film
        detailInfo.itemName.text = item.title
        //set film info
        detailInfo.itemType.text = item.titleType

        detailInfo.itemYearCrete.text =item.year.toString()

        detailInfo.rank.text = calculatorDuration(item.runningTimeInMinutes)
        //set rating bar
        detailInfo.ratingbar.rating = rating.toFloat()
    }

    private fun setBackGround(url: String) {
        val image = ImageView(context)
        Picasso.get()
            .load(url)
            .error(R.drawable.loading_animation)
            .into(image,object : com.squareup.picasso.Callback {
            override fun onSuccess() {
                val drawable = image.drawable
                drawable.alpha = 25
                binding.detailInfo.infoContainer.background = drawable
            }

            override fun onError(e: Exception?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun calculatorDuration(duration: Int): String {
        val hour: Int = duration/60
        val minute: Int = if (hour > 0) {
            duration - (hour*60)
        } else {
            duration
        }
        val text: String = if (hour > 0) {
            "${hour}h ${minute}m"
        } else {
            "${minute}m"
        }
        return text
    }

    private fun getImages(id:String) {
        retrofitBuilder.getImages(id).enqueue(object : Callback<ResponseImages?> {
            override fun onResponse(
                call: Call<ResponseImages?>,
                response: Response<ResponseImages?>
            ) {
                val responseData = response.body() !!
                val data: List<ImageRelated> = responseData.images
                setImages(data)
            }

            override fun onFailure(call: Call<ResponseImages?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun setImages(data: List<ImageRelated>) {
        val adapter = ImageAdapter(data)
        val recyclerView = binding.imageList.listImage
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    private fun getTrailers (id: String) {
        retrofitBuilder.getTrailers(id).enqueue(object : Callback<ResponseTrailerList?> {
            override fun onResponse(
                call: Call<ResponseTrailerList?>,
                response: Response<ResponseTrailerList?>
            ) {
                val responseData = response.body() !!
                val data: List<TrailerItem> = responseData.resource.videos
                setTrailers(data)
            }

            override fun onFailure(call: Call<ResponseTrailerList?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private  fun setTrailers (data: List<TrailerItem>) {
        val adapter = TrailerAdapter(data)
        val recyclerView = binding.trailerList.trailerList
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }
}