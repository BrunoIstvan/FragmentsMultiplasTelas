package br.com.bicmsystems.fragmentsmultiplastelas.views.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import br.com.bicmsystems.fragmentsmultiplastelas.R
import br.com.bicmsystems.fragmentsmultiplastelas.models.Item
import br.com.bicmsystems.fragmentsmultiplastelas.views.listeners.OnItemSelectedListener

class ListaItensFragment : Fragment() {

    private var adapterItems: ArrayAdapter<Item>? = null
    private var lvItems: ListView? = null
    private var listener: OnItemSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val myActivity: Activity
        if (context is Activity) {
            myActivity = context
            if (myActivity is OnItemSelectedListener) {
                listener = myActivity
            } else {
                throw ClassCastException(activity.toString() + " must implement ItemsListFragment.OnItemSelectedListener")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = Item.preencheTudo()
        adapterItems = ArrayAdapter(activity,
                android.R.layout.simple_list_item_activated_1, items)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_itens, container, false)
        lvItems = view.findViewById(R.id.lvItens)
        lvItems?.adapter = adapterItems
        lvItems?.onItemClickListener = AdapterView.OnItemClickListener { adapterView,
                                                                         item, position, rowId ->
            val i = adapterItems!!.getItem(position)
            listener?.onItemSelected(i)
        }
        return view
    }
}