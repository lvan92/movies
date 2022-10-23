package com.example.myapplication.fragment.movies.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.agrument.VideoDetailArgument
import com.example.myapplication.common.Argument
import com.example.myapplication.common.createDummyDataMovies
import com.example.myapplication.databinding.FragmentMovieListBinding
import com.example.myapplication.dto.movies.MovieItem
import com.example.myapplication.dto.movies.ResponseMovieList
import com.example.myapplication.network.RetrofitInstance
import com.example.myapplication.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 */
class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        setPlaceHolderData()
//        showLoadingOverlay(true)
        return binding.root
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//          getMovies()
    }

    private fun setPlaceHolderData() {
        val dummyData = createDummyDataMovies(4)
        val adapter = ListAdapter(dummyData)
        val recyclerView: RecyclerView = binding.list
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter.setItemListener {
            onClick(it)
        }
    }

    private fun getMovies() {
        val retrofitBuilder = RetrofitInstance.getRetrofitInstance().create(Service::class.java)
        val retrofitData = retrofitBuilder.getVideos("spider")
        retrofitData.enqueue(object : Callback<ResponseMovieList?> {
            override fun onResponse(
                call: Call<ResponseMovieList?>,
                response: Response<ResponseMovieList?>
            ) {
                val responseData = response.body()!!
                val data: List<MovieItem> = responseData.result
                setMovieDataList(data)
            }

            override fun onFailure(call: Call<ResponseMovieList?>, t: Throwable) {
                Log.e("error", "$t")
            }
        })
    }

    private fun setMovieDataList(dataResponse: List<MovieItem>) {
        // Set the adapter
        val adapter = ListAdapter(dataResponse)
        val recyclerView: RecyclerView = binding.list
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter.setItemListener {
            onClick(it)
        }
    }

    private fun onClick(item: VideoDetailArgument) {
        val bundle = Bundle()
        bundle.putSerializable(Argument.VIDEO_DETAIL, item)
        val navigation = findNavController()
        navigation.navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }

}

