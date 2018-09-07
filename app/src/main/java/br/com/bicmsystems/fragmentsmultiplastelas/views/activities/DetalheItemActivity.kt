package br.com.bicmsystems.fragmentsmultiplastelas.views.activities


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.bicmsystems.fragmentsmultiplastelas.R
import br.com.bicmsystems.fragmentsmultiplastelas.models.Item
import br.com.bicmsystems.fragmentsmultiplastelas.views.fragments.DetalheItemFragment

class DetalheItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(R.layout.activity_detalhe_item)
        val item = intent.getSerializableExtra("item") as Item
        if (savedInstanceState == null) {
            val detalheItemFragment = DetalheItemFragment.newInstance(item)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, detalheItemFragment)
            ft.commit()
        }
    }
}

