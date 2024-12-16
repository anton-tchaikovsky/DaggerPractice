package com.example.feature_home.di

import android.content.Context
import com.example.feature_home.di.dependencies.FeatureHomeDependenciesProvider
import com.example.feature_home.presentation.FactsFragment
import dagger.Component
import javax.inject.Scope

@FeatureHomeScope
@Component(
    modules = [FactsRepositoryModule::class],
    dependencies = [FeatureHomeDependenciesProvider::class]
)
interface FeatureHomeComponent {
    fun inject(fragment: FactsFragment)

    @Component.Builder
    interface Builder {
        fun dependenciesProvider(dependenciesProvider: FeatureHomeDependenciesProvider): Builder

        fun build(): FeatureHomeComponent
    }

    companion object {
        private var component: FeatureHomeComponent? = null

        fun init(applicationContext: Context): FeatureHomeComponent {
            val dependenciesProvider =
                applicationContext as FeatureHomeDependenciesProvider
            return component ?: DaggerFeatureHomeComponent.builder()
                .dependenciesProvider(dependenciesProvider).build().also { component = it }
        }

        internal fun clearComponent() {
            component = null
        }
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureHomeScope