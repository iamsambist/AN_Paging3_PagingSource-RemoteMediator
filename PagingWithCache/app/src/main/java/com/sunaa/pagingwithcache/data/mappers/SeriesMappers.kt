package com.sunaa.pagingwithcache.data.mappers

import com.sunaa.pagingwithcache.data.network.dto.Data
import com.sunaa.pagingwithcache.data.room.SeriesEntity

fun Data.toSeriesEntity(): SeriesEntity {
    return SeriesEntity(
        id = id,
        name = name,
        startDate = startDate,
        endDate = endDate,
        odi = odi,
        t20 = t20,
        test = test,
        squads = squads,
        matches = matches
    )
}

/*
* Data class
*
data class Data(
    val endDate: String,
    val id: String,
    val matches: Int,
    val name: String,
    val odi: Int,
    val squads: Int,
    val startDate: String,
    val t20: Int,
    val test: Int
)
*
* Series Entity
* @Entity(tableName = "series")
data class SeriesEntity (
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val name : String,
    val startDate : String,
    val endDate : String,
    val odi : Int,
    val t20 : Int,
    val test : Int,
    val squads : Int,
    val matches : Int
)
* */