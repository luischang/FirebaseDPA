package dev.luischang.firebasedpa.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.luischang.firebasedpa.R
import dev.luischang.firebasedpa.ui.fragments.adapter.MascotaAdapter
import dev.luischang.firebasedpa.ui.fragments.client.MascotaClient
import dev.luischang.firebasedpa.ui.fragments.model.MascotaModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MascotaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_mascota, container, false)

        val rvmascotas: RecyclerView = view.findViewById(R.id.rvMascota)

        rvmascotas.layoutManager = LinearLayoutManager(requireActivity())

        val call: Call<List<MascotaModel>> = MascotaClient
                .retrofitService.listarMascota()
        call.enqueue(object: Callback<List<MascotaModel>>{
            override fun onResponse(
                call: Call<List<MascotaModel>>,
                response: Response<List<MascotaModel>>
            ) {
                Log.d("onResponse",response.body().toString())
                rvmascotas.adapter = MascotaAdapter(response.body()!!)
            }

            override fun onFailure(call: Call<List<MascotaModel>>, t: Throwable) {
                Log.d("OnFailure","Ocurrió un error en retrofitService.listarMascota()")
            }


        })



        // Inflate the layout for this fragment
        return view
    }


}