package dev.luischang.firebasedpa.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.luischang.firebasedpa.databinding.ItemMascotaBinding
import dev.luischang.firebasedpa.ui.fragments.model.MascotaModel

class MascotaAdapter (private var lstMascotas: List<MascotaModel>):
        RecyclerView.Adapter<MascotaAdapter.ViewHolder>()
{
    inner class ViewHolder(val binding: ItemMascotaBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMascotaBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            with(holder){
                with(lstMascotas[position]){
                    binding.tvnommascota.text = nommascota
                    binding.tvcontacto.text = contacto
                    binding.tvfechaperdida.text = fechaperdida
                    binding.tvlugar.text = lugar
                    Glide.with(itemView.context)
                        .load(urlimagen)
                        .into(binding.ivmascota)
                }
            }
    }

    override fun getItemCount() = lstMascotas.size


}