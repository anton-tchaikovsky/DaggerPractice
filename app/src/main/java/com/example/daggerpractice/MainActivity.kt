package com.example.daggerpractice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.core.api.CatsFactApi
import com.example.core.di.CATS_FACT_API_STRING_KEY
import com.example.feature_home.presentation.FactsFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity :  AppCompatActivity(), HasAndroidInjector{

    @Inject
    lateinit var retrofit: Map<String, Retrofit>

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initView()
        initTestRepository()
    }

    private fun initView() {
        findViewById<Button>(R.id.go_button).setOnClickListener { showFactsFragment() }
    }

    private fun showFactsFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.main, FactsFragment.newInstance())
            .addToBackStack("")
            .commit()
    }

    private fun initTestRepository() {
        lifecycleScope.launch {
            val facts =
                retrofit[CATS_FACT_API_STRING_KEY]?.create(CatsFactApi::class.java)?.getFact()
                    ?: throw IllegalStateException()
            Log.d("@@@", "From MainActivity: ${facts.fact}")
        }
    }
}