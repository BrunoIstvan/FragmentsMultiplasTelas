package br.com.bicmsystems.fragmentsmultiplastelas.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.bicmsystems.fragmentsmultiplastelas.R
import br.com.bicmsystems.fragmentsmultiplastelas.models.Item

class DetalheItemFragment : android.support.v4.app.Fragment() {
    private var item: Item? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getSerializable("item") as Item
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detalhe_item,
                container, false)
        val tvTitle = view.findViewById(R.id.tvTitulo) as TextView
        val tvBody = view.findViewById(R.id.tvSubtitulo) as TextView
        tvTitle.text = item?.titulo
        tvBody.text = item?.subTitulo
        return view
    }
    companion object {
        fun newInstance(item: Item): DetalheItemFragment {
            val fragmentDemo = DetalheItemFragment()
            val args = Bundle()
            args.putSerializable("item", item)
            fragmentDemo.arguments = args
            return fragmentDemo
        }
    }
}