package dev.luischang.firebasedpa.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.luischang.firebasedpa.R

class MascotaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_mascota, container, false)

        val rvmascotas: RecyclerView = view.findViewById(R.id.rvMascota)

        rvmascotas.layoutManager = LinearLayoutManager(requireActivity())

        




        // Inflate the layout for this fragment
        return view
    }


}