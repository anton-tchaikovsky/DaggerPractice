package com.example.feature_home.data

import android.util.Log
import com.example.feature_home.data.data_source.FactsRemoteDataSource
import com.example.feature_home.data.dto.CatsFactDto
import com.example.feature_home.data.dto.DogsFactDto
import com.example.feature_home.data.mapper.CatsFactMapper
import com.example.feature_home.data.mapper.DogsFactMapper
import com.example.feature_home.domain.FactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FactsRepositoryImpl @Inject constructor(
    private val remoteDataSource: FactsRemoteDataSource,
    private val catsFactMapper: CatsFactMapper,
    private val dogsFactMapper: DogsFactMapper
) : FactsRepository {

    init {
        Log.d("@@@", "initRepository")
    }

    override suspend fun getCatsFact(): CatsFactDto =
       withContext(Dispatchers.IO) {catsFactMapper.mapToDto(remoteDataSource.getCatsFact())}

    override suspend fun getDogsFact(): DogsFactDto =
        withContext(Dispatchers.IO) {dogsFactMapper.mapToDto(remoteDataSource.getDogsFact())}
}