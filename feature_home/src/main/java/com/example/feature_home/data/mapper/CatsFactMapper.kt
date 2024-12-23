package com.example.feature_home.data.mapper

import com.example.core.data_entity.CatsFact
import com.example.feature_home.data.dto.CatsFactDto
import javax.inject.Inject

class CatsFactMapper @Inject constructor() : DataEntityToDtoMapper<CatsFactDto, CatsFact> {
    override fun mapToDto(entity: CatsFact): CatsFactDto = CatsFactDto(entity.fact)
}
