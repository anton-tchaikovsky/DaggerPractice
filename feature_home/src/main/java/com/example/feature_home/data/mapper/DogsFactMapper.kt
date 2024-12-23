package com.example.feature_home.data.mapper

import com.example.core.data_entity.DogsFact
import com.example.feature_home.data.dto.DogsFactDto
import javax.inject.Inject

class DogsFactMapper @Inject constructor() : DataEntityToDtoMapper<DogsFactDto, DogsFact> {
    override fun mapToDto(entity: DogsFact): DogsFactDto =
        DogsFactDto(entity.data.first().attributes.body)
}
