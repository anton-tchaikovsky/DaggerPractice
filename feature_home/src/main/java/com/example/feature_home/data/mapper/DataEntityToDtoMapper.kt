package com.example.feature_home.data.mapper

import com.example.core.data_entity.DataEntity
import com.example.feature_home.data.dto.Dto

interface DataEntityToDtoMapper<out T: Dto, in E: DataEntity> {
    fun mapToDto(entity: E): T
}