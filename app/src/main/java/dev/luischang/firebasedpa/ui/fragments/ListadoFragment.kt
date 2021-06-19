package dev.luischang.firebasedpa.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import dev.luischang.firebasedpa.R
import dev.luischang.firebasedpa.ui.fragments.adapter.CourseAdapter
import dev.luischang.firebasedpa.ui.fragments.model.CourseModel


class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


class ListadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_listado, container, false)
        val db = FirebaseFirestore.getInstance()

        val lstCourses : ArrayList<CourseModel> = ArrayList()
        val rvCourse: RecyclerView = view.findViewById(R.id.rvCourse)
        db.collection("courses")
            .addSnapshotListener {snapshots, e->

                if (e!=null){
                    Log.w("Firebase Warning","listen.error",e)
                    return@addSnapshotListener
                }

                for (dc in snapshots!!.documentChanges){
                    when (dc.type){
                        DocumentChange.Type.ADDED ->{
                            Log.w("Firebase Warning ADDED",dc.document.data["description"].toString())
                            //textView2.text(dc.document.data["description"].toString())
                            //textView2.text("asdasd")
                            lstCourses.add(CourseModel(dc.document.data["description"].toString(),dc.document.data["score"].toString()))
                            rvCourse.adapter = CourseAdapter(lstCourses)
                        }
                        DocumentChange.Type.MODIFIED ->{
                            lstCourses.add(CourseModel(dc.document.data["description"].toString(),dc.document.data["score"].toString()))
                            rvCourse.adapter = CourseAdapter(lstCourses)

                        }
                        DocumentChange.Type.REMOVED ->{
                            //lstCourses.add(CourseModel(dc.document.data["description"].toString(),dc.document.data["score"].toString()))

                        }

                    }
                }


                rvCourse.layoutManager = LinearLayoutManager(requireContext())
            }

        return view
    }
}

//private fun listSongLinkinPark(): List<CourseModel> {
//    val lstSong: ArrayList<CourseModel> = ArrayList()
//    lstSong.add(CourseModel("Matemática I","12"))
//    lstSong.add(CourseModel("Matemática II","11"))
//    lstSong.add(CourseModel("Matemática III","13"))
//    lstSong.add(CourseModel("Matemática IV","15"))
//    lstSong.add(CourseModel("Matemática V","18"))
//
//    return lstSong
//}