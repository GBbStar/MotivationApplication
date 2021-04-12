package org.techtown.dobetterdomore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class DialogOfLockScreenSettings: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.dialog_lock_screen, container)

        var menus = resources.getStringArray(R.array.lock_screen_settings)

        val positiveButton = rootView.findViewById<Button>(R.id.settingsPositiveButton)
        val negativeButton = rootView.findViewById<Button>(R.id.settingsNegativeButton)

        val myListView = rootView.findViewById<ListView>(R.id.settingsListView)
        myListView!!.adapter = context?.let { ArrayAdapter<String>(it, R.layout.support_simple_spinner_dropdown_item, menus) }

        this.dialog?.setTitle("잠금화면 설정")
            
        myListView.setOnItemClickListener { adapterView, view, i, l ->
            when(i){
                0 -> Toast.makeText(context, "첫번째 선택", Toast.LENGTH_SHORT).show()
            }
        }

        positiveButton
        return rootView
    }
}